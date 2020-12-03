package com.superK.init;

import com.superK.jetty.GenericServer;
import com.superK.jetty.JettyServer;


public class App {
	//private static final Logger LOGGER = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws Exception {
		try {
			launch();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

	private static void initialize() {
		try {
			//nothing
		} catch (Exception ex) {
			//LOGGER.error("Error in starting application", ex);
			throw ex;
		}
	}

	private static void startServer() throws Exception {
		int port = 9000;
		int idleTimeout = 10000;  //10 secs
		GenericServer server = new JettyServer(port, idleTimeout);
		server.start();
	}

	private static void launch() throws Exception {
		System.out.println("Launching...");
		initialize();
		startServer();
		System.out.println("Launched");
	}
}