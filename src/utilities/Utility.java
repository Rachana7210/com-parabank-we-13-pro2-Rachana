package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Utility extends BaseTest {

    public void sendTextFromElements(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    public void clickonElement(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

}
