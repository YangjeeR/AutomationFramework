package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.GoogleMap;
import pojo.Location;

public class TestDataBuild {
	
	public GoogleMap AddPlacePayload(String name, String language, String address)
	{
		GoogleMap map = new GoogleMap();
	     map.setAccuracy(50);
	     map.setAddress(address);
	     map.setLanguage(language);
	     map.setName(name);
	     map.setPhone_number("+6713333333");
	     map.setWebsite("https://rahulshettyacademy.com/#/practice-project");
	     List<String> mylist=new ArrayList<String>();
	     mylist.add("shoe");
	     mylist.add("park");
	     map.setTypes(mylist);
	     
	     Location loc=new Location();
	     loc.setLat(33.427362);
	     loc.setLng(-38.383494);
	     map.setLocation(loc);
	     return map;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{ \r\n" + 
				"\"place_id\":\""+placeId+"\"\r\n" + 
				"}";
	}

}
