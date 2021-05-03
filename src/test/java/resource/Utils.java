package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification reqspec;
	public RequestSpecification resSpec() throws IOException
	{
	
		if(reqspec==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
	  reqspec=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
    		 .setContentType(ContentType.JSON)
    		 .addQueryParam("key","qaclick123")
    		 .addFilter(RequestLoggingFilter.logRequestTo(log))
    		 .addFilter(ResponseLoggingFilter.logResponseTo(log))
    		  .build();
	  
	  return reqspec;
		}
		return reqspec;
	 
	}
     
	
	public static String getGlobalValue(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\workspace\\Automation\\src\\test\\java\\resource\\global.properties");
		prop.load(fs);
		return prop.getProperty(Key);
		
	}
	
	public String getJsonPath(Response response,String key)
	{
		 String response1=response.asString();
	      JsonPath js=new JsonPath(response1);
	      return js.get(key);
	}
}
