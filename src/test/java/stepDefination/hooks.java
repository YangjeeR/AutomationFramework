package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {

	@Before("@DeletePlace")
	public void beforAnnotation() throws IOException 
	{
	
		PlaceStepDefination s=new PlaceStepDefination();
		
		if(s.place_id==null)
		{
		s.add_place_payload_with("Yangjee","French","Thaiba");
		s.user_calls_with_http_request("addPlaceAPI","Post");
		s.verify_place_id_created_maps_to_using_get_place_api("Yangjee","getPlaceAPI");
		}
	}
}
