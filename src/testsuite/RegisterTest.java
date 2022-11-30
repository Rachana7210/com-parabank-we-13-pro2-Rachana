package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

/*1.verifyThatSigningUpPageDisplay
* click on the ‘Register’ link
* Verify the text ‘Signing up is easy!’
2.userSholdRegisterAccountSuccessfully
* click on the ‘Register’ link
* Enter First name
* Enter Last name
* Enter Address
* Enter City
* Enter State
* Enter Zip Code
* Enter Phone
* Enter SSN
* Enter Username
* Enter Password
* Enter Confirm
* Click on REGISTER button
* Verify the text 'Your account was created successfully. You are now logged in.
*/
public class RegisterTest extends Utility {

    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseurl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        // Verify the text 'Signing up is easy!';
        String expectedMessage = "Signing up is easy!";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Varify actual and Expected
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully(){
        // Click on'Register' link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        // Enter First name
        sendTextFromElements(By.id("customer.firstName"),"Dazy");
        // Enter Last name
        sendTextFromElements(By.id("customer.lastName"),"Parmar");
        // Enter address
        sendTextFromElements(By.id("customer.address.street"),"1,Moreview Street");
        //Enter city
        sendTextFromElements(By.id("customer.address.city"),"City of Edinbrough");
        // Enter State
        sendTextFromElements(By.id("customer.address.state"),"Scotland");
        // Enter Zip code
        sendTextFromElements(By.id("customer.address.zipCode"),"SW1 0TD");
        // Enter Phone
        sendTextFromElements(By.id("customer.phoneNumber"),"07846332778");
        //Enter SSN
        sendTextFromElements(By.id("customer.ssn"),"123456");
        //Enter Username
        sendTextFromElements(By.id("customer.username"),"ALPHA");
        //Enter Password
        sendTextFromElements(By.id("customer.password"),"Hr1234");
        //Enter Confirm Password
        sendTextFromElements(By.id("repeatedPassword"),"Hr1234");
        // Click on Register button
        clickonElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        // Actual Requirements
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        String actualMessage = actualTextMessageElement.getText();
        // Varify actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}









