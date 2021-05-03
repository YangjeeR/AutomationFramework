package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GoogleMap;
import pojo.Location;
import resource.APIResoources;
import resource.TestDataBuild;
import resource.Utils;

public class PlaceStepDefination extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild(); 
	 JsonPath js;
	static String place_id;
	
	@Given("Add place payload  with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException 
	{
	   
	     // resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	      res=given().spec(resSpec()).body(data.AddPlacePayload(name,language,address));
	}
	

	@When("user calls {string} with {string} http Request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResoources resourceAPI= APIResoources.valueOf(resource);
		if(method.equalsIgnoreCase("Post"))
		  response=res.when().post(resourceAPI.getResources());
				 
		else if(method.equalsIgnoreCase("Get"))
			response=res.when().get(resourceAPI.getResources());
					
		else if(method.equalsIgnoreCase("Delete"))
			response=res.when().delete(resourceAPI.getResources());
				
				 
	}
	@Then("the API call is success with status code {int}")
	
	public void the_api_call_is_success_with_status_code(Integer int1) {
	assertEquals(response.getStatusCode(),200);
	
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
     
      assertEquals(getJsonPath(response,keyValue),ExpectedValue);
	}

	@Then("verify place id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using_get_place_api(String expectedName,String resource) throws IOException {
		
		 place_id=getJsonPath(response,"place_id");
	    res=given().spec(resSpec()).queryParam("place_id", place_id);
	    user_calls_with_http_request(resource,"Get");
	    String actualName=getJsonPath(response,"name");
	    assertEquals(actualName,expectedName);
	}

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException 
	{
	   res= given().spec(resSpec()).body(data.deletePlacePayload(place_id));
	}

	
}
