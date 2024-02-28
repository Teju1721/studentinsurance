package base.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.com.Driver;

public class TravelInsurance extends Driver   {

	public TravelInsurance (WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	//clicking on the insurance button
	@FindBy(how=How.XPATH,using="//*[@class='icon-bg homeIconsBg icon-bg-new ti']")
	public WebElement travelbutton;
	public void clicktravelbutton() {
		travelbutton.click();
	
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='country']")
	public WebElement searchbutton;
	public void clickButton(String country) 
	{
		searchbutton.click();
		searchbutton.sendKeys(country);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='search-country']/ul/li")
	public WebElement dropdownbutton;
	public void clickdropdownbutton() {
		dropdownbutton.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='travel_main_cta']")
	public WebElement nextbutton;
	public void clicknextbutton() 
	{
		nextbutton.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input")
	public WebElement datebutton;
	public void clickdatebutton()
	{
		datebutton.click();
	}
	
	@FindBy(how=How.XPATH,using="(//*[@class='MuiPickersDay-dayLabel'])[30]")
	public WebElement startdatebutton;
	public void choosestartdatebutton()
	{
		startdatebutton.click();
	}
	
	@FindBy(how=How.XPATH,using="(//*[@class='MuiPickersDay-dayLabel'])[50]")
	public WebElement enddatebutton;
	public void chooseenddatebutton()
	{
		enddatebutton.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='pqCtaWrapper']/button")
	public WebElement nextbutton1;
	public void choosenextbutton()
	{
		nextbutton1.click();
	}
	
	@FindBy(how=How.XPATH,using="//label[@for='traveller_2']")
	public WebElement numberoftravellers;
	public void choosenumberoftravellers()
	{
		numberoftravellers.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='divarrow_undefined']")
	public WebElement ageoftraveller1;
	public void selectageoftraveller1()
	{
		ageoftraveller1.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@for='22 years_undefined']")
	public WebElement ageoftravelleras22;
	public void selectageoftravelleras22()
	{
		ageoftravelleras22.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='place-holder AgeSelector-place-holder']")
	public WebElement ageoftraveller2;
	public void selectageoftraveller2()
	{
		ageoftraveller2.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@for='21 years_undefined']")
	public WebElement ageoftravelleras21;
	public void selectageoftravelleras21()
	{
		ageoftravelleras21.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='travel_main_cta']")
	public WebElement nextbutton2;
	public void choosenextbutton2()
	{
		nextbutton2.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='travel_main_cta']")
	public WebElement premedicalcondition;
	public void selectpremedicalcondition()
	{
		premedicalcondition.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@class='travel_main_cta']")
	public WebElement nextbutton3;
	public void choosenextbutton3()
	{
		nextbutton3.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='mobileNumber']")
	public WebElement mobileNumber;
	public void entermobilenumber(String mobilenumber)
	{
		mobileNumber.click();
		mobileNumber.sendKeys(mobilenumber);
	}

	@FindBy(how=How.XPATH,using="//*[@class='travel_main_cta']")
	public WebElement viewplans;
	public void selectviewplans()
	{
		viewplans.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@for='studentTrip']")
	public WebElement studnetplans;
	public void selectvstudnetplans()
	{
		studnetplans.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='Traveller_1']")
	public WebElement checkbox1;
	public void clickcheckbox1()
	{
		checkbox1.click();
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='Traveller_2']")
	public WebElement checkbox2;
	public void clickcheckbox2()
	{
		checkbox2.click();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='feet']")
	public WebElement Days;
	public void Days_no() {
		Days.click();
		Select select = new Select(Days);
		select.selectByVisibleText("30 Days");
	}
		
	@FindBy(how=How.XPATH, using = "//*[@class='pqCtaWrapper']/button")
	public WebElement apply;
	public void clickapply()
	{
		apply.click();
	}
	
	@FindBy(how=How.XPATH, using = "//*[@class='filter_name_heading']")
	public WebElement filterdropdown;
	public void clickfilterdropdown()
	{
		filterdropdown.click();
	}
	
	@FindBy(how=How.XPATH, using="//*[@for='17_sort']")
	public WebElement lowtohighprice;
	public void selectlowtohighprice()
	{
		lowtohighprice.click();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='quotesCardWrapper ']")
    public static List<WebElement> insuranceList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/header/article/h1/a")
    public WebElement HomeButton;
    
    public void clickHomeButton()
    {
    	HomeButton.click();
    }
    
    public boolean isTravelButtonClicked() {
    	// Find the travel button element 
    	WebElement travelButton = driver.findElement(By.xpath("//i[@class='icon-bg homeIconsBg icon-bg-new ti']"));
    
    	//check if the travel button is clicked
    	boolean isClicked = travelButton.isEnabled();
    
    	return isClicked;
    }
    
    public int getSelectedTrvellersCount() {
    	WebElement noOfTrav = driver.findElement(By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[1]/div[2]/label"));
    	noOfTrav.click();
    	
    	String count = noOfTrav.getText();
    	int selectedTravellersCount=2;
    	if (!count.equalsIgnoreCase("No")) {
            try {
                selectedTravellersCount = Integer.parseInt(count);
            } catch (NumberFormatException e) {
                // Handle the exception or log the error
            }
        }
    	
    	return selectedTravellersCount;
    }
    
    public boolean isPlanViewed() {
    	WebElement viewPlanedButton = driver.findElement(By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[2]/div"));
	 
    	//check view plan button is clicked 
    	boolean isClicked = viewPlanedButton.isEnabled();
	
    	return isClicked;
	
	}	
	
}
	
	
		
	
	
	

