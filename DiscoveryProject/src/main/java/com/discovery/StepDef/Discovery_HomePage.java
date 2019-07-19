package com.discovery.StepDef;



import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.discovery.Utility.Constant;
import com.discovery.Utility.LibraryFunction;
import com.discovery.Utility.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Discovery_HomePage {
	LibraryFunction library=new LibraryFunction();
	By recommendedVideoOne=By.xpath(PropertyReader.getLocatorValue("DISC_RECOMMENDE_VIDEO_1"));
	By btnAddToFav=By.xpath(PropertyReader.getLocatorValue("DISC_ADD_TO_FAV"));
	By scrollTillRecmmaneded=By.xpath(PropertyReader.getLocatorValue("DISC_TEXT_RECOMMENDED_FOR_YOU"));
	By recommendedVideoTwo=By.xpath(PropertyReader.getLocatorValue("DISC_RECOMMENDE_VIDEO_2"));
	By textNameFirstVideo=By.xpath(PropertyReader.getLocatorValue("DISC_FIRST_VIDEO_TEXT"));
	By textNameSecondVideo=By.xpath(PropertyReader.getLocatorValue("DISC_SECOND_VIDEO_TEXT"));
	By btnAddToFav_2=By.xpath(PropertyReader.getLocatorValue("DISC_ADD_TO_FAV_2"));
	By menuTabHomePage=By.xpath(PropertyReader.getLocatorValue("DISC_ADD_MENU_TAB"));
	By myVideoTab=By.xpath(PropertyReader.getLocatorValue("DISC_MENU_MYVIDEOS"));
	
	/*---------------------------------------------------------------------------------------
	 * Function name:setUpBrowser
	 * Description 	: to launch the browser and enters url
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Given("^I launch the browser and enter the url$")
	public void setUpBrowser(){
		library.setUPBrowserAndURL();
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:storeFirstTextName
	 * Description 	: to store the values in list
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@When("^I store the name of first video$")
	public void storeFirstTextName() {
		library.getWebElementText(textNameFirstVideo);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name: storeSecondTextName
	 * Description 	: to store the second video name
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@When("^I store the name of second video$")
	public void storeSecondTextName() {
		library.getWebElementText(textNameSecondVideo);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:clickMenuTab
	 * Description 	: to click on menu tab
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@When("^I click on menu tab in homepage$")
	public void clickMenuTab() {
		library.buttonClick(menuTabHomePage);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:scrollPageTilElementView
	 * Description 	: to scroll the view
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I scroll the page till recommanded videos$")
	public void scrollPageTilElementView() {
		library.scrollToElementView(scrollTillRecmmaneded);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:movetoFirstVideo
	 * Description 	: to move to the first video
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I move to first video$")
	public void movetoFirstVideo() {
		library.moveToElement(recommendedVideoOne);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:selectVideosfromRecommandeList
	 * Description 	: to select the video from the list
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I select the video and adding to favorite list$")
	public void selectVideosfromRecommandeList() {
		library.buttonClick(btnAddToFav);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:movetoSecond
	 * Description 	: to move to the second video
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I move to second video$")
	public void movetoSecond() {
		library.moveToElement(recommendedVideoTwo);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:selectSecondVideos
	 * Description 	: to select second video
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I select second video and adding to favorite list$")
	public void selectSecondVideos() {
		library.buttonClick(btnAddToFav_2);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:selectedVideos
	 * Description 	: to click the my videos tab
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I click my videos tab from menu$")
	public void selectedVideos() throws InterruptedException {
		library.waitByTime(Constant.minTime);
		library.buttonClick(myVideoTab);
	}
	
	/*---------------------------------------------------------------------------------------
	 * Function name:verifyVideoNames
	 * Description 	: to verify the stored video names
	 * Parameters  	:<none>
	 * --------------------------------------------------------------------------------------*/
	@Then("^I verify videos added correctly in my videos tab$")
	public void verifyVideoNames() throws InterruptedException, AWTException {		
		library.scrollDownPage();
		library.moveToElement(recommendedVideoOne);
		String firstVideoName=library.getWebElementText(textNameFirstVideo);
		Assert.assertEquals(Constant.listShows.get(0),firstVideoName);
		library.moveToElement(recommendedVideoTwo);
		String secondVideoName=library.getWebElementText(textNameSecondVideo);
		Assert.assertEquals(Constant.listShows.get(1),secondVideoName);
	}
}
