package resource;
//enum is special class in java which has collection of constants and methods
public enum APIResoources {

	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	updatePlaceAPI1("/maps/api/place/update/json");
	private String resource;

	APIResoources(String resource)
	{
	
		this.resource =resource;
	}
	
	public String getResources()
	{
		return resource;
	}
}

