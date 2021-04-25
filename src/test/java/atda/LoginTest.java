package atda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import github.LoginPage;
import github.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


//    @Test
//    public void shouldOpen() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.open();
//        assertTrue(loginPage.isLoaded());
//    }

    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        // probajte so vash user i password za da proverite dali raboti
        // da ne go pisuvam mojot pw
        loginPage.login("1vanjordanov", "Ivanlegendo77");
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void canNotLoginWithInvalidUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user", "secret");
        String errorMessage = loginPage.getUserErrorMessage();
        assertEquals(errorMessage, "Incorrect username or password.");
    }
    @Test
    public void canNotLoginWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user@gmail.com", "secret");
        String errorMessage = loginPage.getPasswordErrorMessage();
        assertEquals(errorMessage, "Incorrect username or password.");
    }
    @Test
    public void emptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "password");
        String errorMessage = loginPage.getUserErrorMessage();
        assertEquals(errorMessage, "Incorrect username or password.");
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Desktop\\new\\SeleniumSimple\\src\\main\\resources\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
