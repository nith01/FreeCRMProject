package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage1 extends TestBase {
    //PageFactory:OR
    @FindBy(xpath= "//header/div[1]/nav[1]/div[1]/div[1]/a[1]")
    WebElement Login;
    @FindBy(xpath= "//span[@class='mdi-chart-bar icon icon-md']")
    WebElement SignUp;
    @FindBy(xpath="//a[(@class= \"brand-name\")and (@title=\"free crm home\")]")
    WebElement FreeCrmLogo;

    //initialize the page Objects:
    public LoginPage1(){
        PageFactory.initElements(driver,this);
    }

    //Action:features
    public String validateLoginPage1Title(){
        return driver.getTitle();
    }

    public boolean validateFreeCrmLogo(){
        return FreeCrmLogo.isDisplayed();
    }

    public LoginPage2 validateLogin2(){
        Login.click();
        return new LoginPage2();
    }

}
