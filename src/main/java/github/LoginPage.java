package github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.github.com/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(user);
        Thread.sleep(5);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5);
        driver.findElement(By.cssSelector("[value=\"Sign in\"]")).click();
        Thread.sleep(5);
    }


    public String getPasswordErrorMessage() {
        WebElement errorPage = driver.findElement(By.id("js-flash-container"));
        return errorPage.getText();
    }
    public String getUserErrorMessage() {
        WebElement errorPage = driver.findElement(By.id("js-flash-container"));
        return errorPage.getText();
    }
}

