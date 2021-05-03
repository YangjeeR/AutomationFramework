Feature: Validate Place API's
@AddPlace @Regression
Scenario Outline: Verify place is successfully added usind AddplaceAPI
	Given Add place payload  with "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "Post" http Request
	Then the API call is success with status code 200
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify place id created maps to "<name>" using "getPlaceAPI"

	
Examples:
 |name | language | address |
 |Renhang Rai | Newari | Thaiba, Godawari  | 
 |Yangjee Rai| English | Chapali, Narayanthan |
 
 @DeletePlace @Regression
 Scenario: Delete place function is working
 Given DeletePlace payload
 When user calls "deletePlaceAPI" with "Post" http Request
 Then the API call is success with status code 200
And "status" in response body is "OK" 
 
