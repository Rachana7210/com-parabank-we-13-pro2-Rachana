package testsuite;

import javafx.scene.input.InputMethodTextRun;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/*down the following test into ‘LoginTest’ class
1..userShouldLoginSuccessfullyWithValidCredentials
* Enter valid username
* Enter valid password
* Click on ‘LOGIN’ button
* Verify the ‘Accounts Overview’ text is display
2.verifyTheErrorMessage
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘The username and password could not be verified.’
3.userShouldLogOutSuccessfully
* Enter valid username
* Enter valid password
* Click on ‘LOGIN’ button
* Click on ‘Log Out’ link
* Verify the text ‘Customer Login
 */


public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid username in username field
        sendTextFromElements(By.name("username"),"ALPHA");
        //Enter valid password in password field
        sendTextFromElements(By.name("password"),"Hr1234");
        //Click on ‘LOGIN’ button using click method
        clickonElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));

        //Verify the ‘Accounts Overview’ text is display
        String expectedMessage = "Accounts Overview";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Varify actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        sendTextFromElements(By.name("username"), "Sazaz");
        //Enter valid password
        sendTextFromElements(By.name("password"), "Hr1234");
        // Click on Login button
        clickonElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        // Verify the error message ‘The username and password could not be verified.’
        String expectedMessage = "Error!";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[text() = 'Error!']"));
        String actualMessage = actualTextMessageElement.getText();

        // Varify actual and expected
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        sendTextFromElements(By.name("username"),"ALPHA");
        // Enter valid password
        sendTextFromElements(By.name("password"),"Hr1234");
        // Click on ‘LOGIN’ button
        clickonElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //Click on ‘Log Out’ link
        clickonElement(By.xpath("//a[contains(text(),'Log Out')]"));

        //Verify the text ‘Customer Login’
            String expectedMessage = "Customer Login";
            WebElement actualTextMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
            String actualMessage = actualTextMessageElement.getText();

            //Varify actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
