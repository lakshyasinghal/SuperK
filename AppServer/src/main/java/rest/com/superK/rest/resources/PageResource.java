package com.superK.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PageResource {

	@GET
	@Path("store-admin-dashboard")
	@Produces(MediaType.TEXT_HTML)
	public String storeAdminPage() throws Exception{
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" + 
				"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" + 
				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" + 
				"<style type=\"text/css\">\n" + 
				"    h1 {\n" + 
				"      text-align: center;\n" + 
				"    }\n" + 
				"    .dropdown {\n" + 
				"      display: inline-block;\n" + 
				"        margin-left: 100px;\n" + 
				"    }\n" + 
				"    #city {\n" + 
				"      display: inline-block;\n" + 
				"        margin-right: 100px;\n" + 
				"    }\n" + 
				"    .btn-container {\n" + 
				"      text-align: center;\n" + 
				"        margin-top: 40px;\n" + 
				"        display: inline-block;\n" + 
				"    }\n" + 
				"</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"  <h1>STORE ADMIN DASHBOARD</h1>\n" + 
				"  \n" + 
				"  <div>\n" + 
				"    <div class=\"dropdown\">\n" + 
				"      <button class=\"btn btn-warning dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Select Store\n" + 
				"      <span class=\"caret\"></span></button>\n" + 
				"      <ul class=\"dropdown-menu\">\n" + 
				"        <li class=\"storeOption\">Store1</li>\n" + 
				"        <li class=\"storeOption\">Store2</li>\n" + 
				"        <li class=\"storeOption\">Store3</li>\n" + 
				"        <li class=\"storeOption\">Store4</li>\n" + 
				"        <li class=\"storeOption\">Store5</li>\n" + 
				"        <li class=\"storeOption\">Store6</li>\n" + 
				"        <li class=\"storeOption\">Store7</li>\n" + 
				"        <li class=\"storeOption\">Store8</li>\n" + 
				"        <li class=\"storeOption\">Store9</li>\n" + 
				"        <li class=\"storeOption\">Store10</li>\n" + 
				"        <li class=\"storeOption\">Store11</li>\n" + 
				"        <li class=\"storeOption\">Store12</li>\n" + 
				"      </ul>\n" + 
				"    </div>\n" + 
				"    <input type=\"text\" name=\"city\" id=\"city\" class=\"form-control\" style=\"width:200px\">\n" + 
				"    <div class=\"btn-container\"><button id=\"infoBtn\" class=\"btn btn-danger\">Show Inventory</button></div>\n" + 
				"  </div>\n" + 
				"\n" + 
				"  <div style=\"margin-top:50px\">\n" + 
				"    <table id=\"info-table\" class=\"table\" style=\"max-width:60%\">\n" + 
				"      <thead>\n" + 
				"        <tr>\n" + 
				"          <th>Store Name</th>\n" + 
				"          <th>Store Address</th>\n" + 
				"          <th>Product Name</th>\n" + 
				"          <th>Quantity</th>\n" + 
				"          <th>City</th>\n" + 
				"        </tr>\n" + 
				"      </thead>\n" + 
				"      <tbody>\n" + 
				"      </tbody>\n" + 
				"    </table>\n" + 
				"  </div>\n" + 
				"  <script>\n" + 
				"    $(document).ready(function(){\n" + 
				"        $(\".storeOption\").click(function(e){\n" + 
				"          $(\"#city\").val(e.target.innerHTML);\n" + 
				"        });\n" + 
				"    \n" + 
				"        $(\"#infoBtn\").click(function(){\n" + 
				"          $(\"#info-table > tbody\").html(\"\");\n" + 
				"          var storeId = $(\"#city\").val().replace(\"Store\",\"\");\n" + 
				"          $.get(\"/api/v1/items-info/store/\"+storeId, function(data, status){\n" + 
				"            var list = data.list;\n" + 
				"            for(var i=0;i<list.length;i++){\n" + 
				"              $(\"#info-table > tbody\").append(\"<tr>\" + \n" + 
				"                \"<td>\" + list[i].StoreName + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].Address + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].ProductName + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].Quantity + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].City + \"</td>\" + \n" + 
				"                \"</tr>\");\n" + 
				"            }\n" + 
				"          });\n" + 
				"        });\n" + 
				"    });\n" + 
				"  </script>\n" + 
				"</body>\n" + 
				"</html>";
	}
	
	@GET
	@Path("city-admin-dashboard")
	@Produces(MediaType.TEXT_HTML)
	public String cityAdminPage() throws Exception {
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" + 
				"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" + 
				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" + 
				"<style type=\"text/css\">\n" + 
				"    h1 {\n" + 
				"      text-align: center;\n" + 
				"    }\n" + 
				"    .dropdown {\n" + 
				"      display: inline-block;\n" + 
				"        margin-left: 100px;\n" + 
				"    }\n" + 
				"    #city {\n" + 
				"      display: inline-block;\n" + 
				"        margin-right: 100px;\n" + 
				"    }\n" + 
				"    .btn-container {\n" + 
				"      text-align: center;\n" + 
				"        margin-top: 40px;\n" + 
				"        display: inline-block;\n" + 
				"    }\n" + 
				"</style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"  <h1>STORE ADMIN DASHBOARD</h1>\n" + 
				"  \n" + 
				"  <div>\n" + 
				"    <div class=\"dropdown\">\n" + 
				"      <button class=\"btn btn-warning dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Select City\n" + 
				"      <span class=\"caret\"></span></button>\n" + 
				"      <ul class=\"dropdown-menu\">\n" + 
				"        <li class=\"cityOption\">Bengaluru</li>\n" + 
				"        <li class=\"cityOption\">Mumbai</li>\n" + 
				"      </ul>\n" + 
				"    </div>\n" + 
				"    <input type=\"text\" name=\"city\" id=\"city\" class=\"form-control\" style=\"width:200px\">\n" + 
				"    <div class=\"btn-container\"><button id=\"infoBtn\" class=\"btn btn-danger\">Show Inventory</button></div>\n" + 
				"  </div>\n" + 
				"\n" + 
				"  <div style=\"margin-top:50px\">\n" + 
				"    <table id=\"info-table\" class=\"table\" style=\"max-width:60%\">\n" + 
				"      <thead>\n" + 
				"        <tr>\n" + 
				"          <th>Store Name</th>\n" + 
				"          <th>Store Address</th>\n" + 
				"          <th>Product Name</th>\n" + 
				"          <th>Quantity</th>\n" + 
				"          <th>City</th>\n" + 
				"        </tr>\n" + 
				"      </thead>\n" + 
				"      <tbody>\n" + 
				"      </tbody>\n" + 
				"    </table>\n" + 
				"  </div>\n" + 
				"  <script>\n" + 
				"    $(document).ready(function(){\n" + 
				"        $(\".cityOption\").click(function(e){\n" + 
				"          $(\"#city\").val(e.target.innerHTML);\n" + 
				"        });\n" + 
				"    \n" + 
				"        $(\"#infoBtn\").click(function(){\n" + 
				"          $(\"#info-table > tbody\").html(\"\");\n" + 
				"          var city = $(\"#city\").val();\n" + 
				"          $.get(\"/api/v1/items-info/city/\"+city, function(data, status){\n" + 
				"            var list = data.list;\n" + 
				"            list.sort(function(obj1,obj2){\n" + 
				"              var storeId1 = obj1.StoreName.replace(\"Store\",\"\");\n" + 
				"                var storeId2 = obj2.StoreName.replace(\"Store\",\"\");\n" + 
				"              return storeId1-storeId2;\n" + 
				"            });\n" + 
				"            for(var i=0;i<list.length;i++){\n" + 
				"              $(\"#info-table > tbody\").append(\"<tr>\" + \n" + 
				"                \"<td>\" + list[i].StoreName + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].Address + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].ProductName + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].Quantity + \"</td>\" + \n" + 
				"                \"<td>\" + list[i].City + \"</td>\" + \n" + 
				"                \"</tr>\");\n" + 
				"            }\n" + 
				"          });\n" + 
				"        });\n" + 
				"    });\n" + 
				"  </script>\n" + 
				"</body>\n" + 
				"</html>";
	}
}
