package stepDefination;
import static io.restassured.RestAssured.*;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefination {
	
	
	   @Given("^User is in landing page$")
	    public void user_is_in_landing_page() throws Throwable {
	      
		   System.out.println("User is in landing page");
	    }

	   @When("^user enters valid email \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void user_enters_valid_email_and_password(String StrA, String StrB) throws Throwable {
	    	System.out.println("user enters valid email and password");
	    	System.out.println(StrA);
	    	System.out.println(StrB);
	        
	    }

	    @Then("^user should redirect to Dashboard $")
	    public void user_should_redirect_to_dashboard() throws Throwable {
	    	System.out.println("user should redirect to Dashboard");
	    }

	    @And("^user can view different features$")
	    public void user_can_view_different_features() throws Throwable {
	    	System.out.println("user can view different features");
	    }

}
