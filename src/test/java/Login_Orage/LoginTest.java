package Login_Orage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    WebDriverWait wait;

    public void login(String username, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }
    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-userdropdown-name")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Test
    public void TC01_ValidCredentials() {
        login("Admin", "admin123");
        Assert.assertTrue(isDashboardDisplayed(), "Should login successfully");
    }

    @Test
    public void TC02_UsernameWithSpaces() {
        login(" Admin ", "admin123");
        System.out.println("Invalid credentials.");

    }

    @Test
    public void TC03_UsernameWithNumber() {
        login("Admin123", "admin123");
        System.out.println("Invalid credentials.");

    }

    @Test
    public void TC04_UsernameWithSpecialChars() {
        login("Admin@", "admin123");
        System.out.println("Invalid credentials.");

    }

    @Test
    public void TC05_EmptyUsername() {
        login("", "admin123");
        System.out.println("Required.");

    }

    @Test
    public void TC06_PasswordWithSpaces() {
        login("Admin", " admin123 ");
        System.out.println("Invalid credentials.");
        driver.quit();
    }

    @Test
    public void TC07_PasswordWithCapitalFirstLetter() {
        login("Admin", "Admin123");
        System.out.println("Invalid credentials.");

    }

    @Test
    public void TC08_PasswordAllUppercase() {
        login("Admin", "ADMIN123");
        System.out.println("Invalid credentials.");

    }

    @Test
    public void TC09_EmptyPassword() {
        login("Admin", "");
        System.out.println("Password Required.");

    }

    @Test
    public void TC10_EmptyUsernameAndPassword() {
        login("", "");
        System.out.println("username and password Required.");

    }
}
