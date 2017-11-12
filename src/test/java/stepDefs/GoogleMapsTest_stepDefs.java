package stepDefs;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;

import apiModels.RequestBody;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utilities.Config;
import utilities.Driver;
import utilities.WebServiceRunner;

public class GoogleMapsTest_stepDefs {

	@Given("^user goes to \"([^\"]*)\"$")
	public void user_goes_to(String url) throws Throwable {
	    Driver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    Driver.getInstance().get(url);
	}

	@Then("^user enters origin location \"([^\"]*)\"$")
	public void user_enters_origin_location(String origin) throws Throwable {
		Driver.getInstance().findElement(By.id("searchbox-directions")).click();
	    Driver.getInstance().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[3]")).sendKeys(origin);
	    
	}

	@Then("^user enters destination \"([^\"]*)\" in mode as driving$")
	public void user_enters_destination_in_mode_as_driving(String destination) throws Throwable {
	    Driver.getInstance().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[4]")).sendKeys(destination);
	}

	@Then("^user hits googleMapsAPI with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_hits_googleMapsAPI_with_and(String origin, String destination) throws Throwable {
		String url = getUrl(origin, destination);
		WebServiceRunner.runGetRequest(url);
	}
	

	private String getUrl(String origin, String destination) {
		origin = origin.replace(",","");
		origin = origin.replace(" ", "+");
		destination = destination.replace(",", "");
		destination = destination.replace(" ", "+");
		String url = "?origin=" + origin + "&destination="+destination+"&key="+Config.getProperty("googleMapsKey");
		return url;
	}

	@Then("^user validates UI data to API data$")
	public void user_validates_UI_data_to_API_data() throws Throwable {
	   System.out.println(WebServiceRunner.getResponse().getRoutes().get(0).getLegs().get(0).getDistance().getText());
	   System.out.println(WebServiceRunner.getResponse().getRoutes().get(0).getLegs().get(0).getDuration().getText());
	}
}
