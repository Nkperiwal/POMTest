package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	public static HomePage oHomePage;
	public static LoginPage oLoginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialize();
		oLoginPage = new LoginPage();
		oHomePage = oLoginPage.login(freeCRMUserName,freeCRMPassword);
		 WebDriverWait wait1 = new WebDriverWait(oBaseUtil.getDriver(), 50);
		    wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainpanel")));
		    System.out.println("1");
		//oBaseUtil.switchToFrame("mainpanel");

	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String sActualLoginPageTitle = oHomePage.validateHomePageTitle();
		String expectedLoginPageTitle = "CRMPRO";
		//SoftAssert softAssertion = new SoftAssert();
		//softAssertion.assertEquals(true, false);
		System.out.println(sActualLoginPageTitle);
		oBaseUtil.verifyTitle(sActualLoginPageTitle, expectedLoginPageTitle);
		//softAssertion.assertAll();
	}	
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest(){
		oHomePage.verifyCorrectUserName();
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		oHomePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealsLinkTest(){
		oHomePage.clickOnContactsLink();
	}
	
	@Test(priority=5)
	public void clickOnTasksLinkTest(){
		oHomePage.clickOnTasksLink();
	}
	
	@Test(priority=6)
	public void selectSpecificDateTest(){
		oHomePage.selectSpecificDate("12/07/2014");
	}
	
	@AfterMethod
	public void tearDown(){
		oBaseUtil.closeBrowser();
	}
	
	

}
