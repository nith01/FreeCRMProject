package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage1;
import com.crm.qa.pages.LoginPage2;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactsPageTest extends TestBase {
    LoginPage1 loginpage1;
    LoginPage2 loginpage2;
    HomePage homepage;
    ContactsPage contactsLink;
    TestUtil testUtil;
    //String sheetName = "Sheet1";

    public ContactsPageTest(){
        super();

    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        testUtil =new TestUtil();
        loginpage1=new LoginPage1();
        loginpage2= loginpage1.validateLogin2();
        loginpage2 =new LoginPage2();
        contactsLink = new ContactsPage();
        homepage= loginpage2.validateLogin1(prop.getProperty("username"),prop.getProperty("password"));
        //testUtil.getTestData();
        //contactsLink= homepage.clickOnContactsLink();

    }

    @Test(priority = 1)
    public void verifyContactsLabelTest(){
        Assert.assertTrue(contactsLink.verifyContactsLabel(),"contact label is missing on the page");
    }

   /* @Test(priority = 2)
    public void verifyContactsByNameTest() throws InterruptedException {
        contactsLink.verifyContactsByName("tet ll");
        contactsLink.verifyContactsByName("Sam Mathew");

        //contactsLink.verifyContactsByName();
    }*/
    @DataProvider
    public Object[][] getFreeCRMTestData(){
      Object data[][] = TestUtil.getExcelData("FreeCRMtestData.xlsx","Sheet1" );
      return data;
    }

    @Test(priority = 2,dataProvider =  "getFreeCRMTestData")
    public void validateAddContact(String firstName, String lastName, String company) throws InterruptedException {
        homepage.clickOnAddContacts();
        //contactsLink.addContacts("Angel","sts","Facebook");
        contactsLink.addContacts(firstName,lastName,company);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
