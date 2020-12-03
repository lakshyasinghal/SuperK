package com.superK.jetty;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.superK.rest.jersey.JerseyResourceConfig;

public class JettyServer implements GenericServer {
	//private static final Logger LOGGER = Logger.getLogger(JettyServer.class.getName());
	private Server server;
	private final int port;
	private final int idleTimeout;
	private ServerStatus status;
	
	
	public JettyServer(int port,int idleTimeout){
		this.port = port;
		this.idleTimeout = idleTimeout;
	}
	
	
	public void start() throws Exception {
		//LOGGER.info("Starting server");
		status = ServerStatus.STARTING;
		ServletContainer container = new ServletContainer(new JerseyResourceConfig());
		ServletHolder sh = new ServletHolder(container);
	    
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS | ServletContextHandler.NO_SECURITY);
		context.setContextPath("/");
		context.addServlet(sh, "/*");
		
		//adding authentication filter class
		context.addFilter(com.superK.jetty.AuthenticationFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
		
		server = new Server();
		
		server.addBean(new CustomErrorHandler());
		
		HttpConfiguration httpConfiguration = new HttpConfiguration();
		ServerConnector httpConnector = new ServerConnector(server, new HttpConnectionFactory(httpConfiguration));
		httpConnector.setPort(port);
		httpConnector.setIdleTimeout(idleTimeout); 
		Connector[] connectors = new Connector[] { httpConnector };
		

		server.setConnectors(connectors);
		server.setHandler(context);
		server.start();
		status = ServerStatus.STARTED;
		//LOGGER.info("Server started on port "+port);
		//server.join();
	}
	
	@Override
	public void stop() throws Exception {
		status = ServerStatus.STOPPING;
		server.stop();
		status = ServerStatus.STOPPED;
		//logger.info("Jetty server has stopped");
	}

	@Override
	public int port() {
		return port;
	}

	@Override
	public ServerStatus status() {
		// TODO Auto-generated method stub
		return status;
	}
}
