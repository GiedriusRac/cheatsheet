import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

//    @AfterEach
//    void close() {
//        driver.quit();
//    }

    @ParameterizedTest
    @ValueSource(strings = {"user_credentials.txt"})
    void ex1() throws InterruptedException {
        // Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Log in
        driver.findElement(By.id("login-button")).click();

        // Logged in
        boolean loggedIn = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        Assertions.assertTrue(loggedIn);
        System.out.println("Logged in: " + loggedIn);

        // Add to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Check if added 1
        boolean isAdded = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assertions.assertTrue(isAdded);
        System.out.println("Backpack is added: " + isAdded);

//        // Open nav
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//        Thread.sleep(1000);

//        // Log out
//        driver.findElement(By.linkText("Logout")).click();
//        boolean loggedOut = driver.findElement(By.id("login-button")).isDisplayed();
//        Assertions.assertTrue(loggedOut);
//        System.out.println("Logged out: " + loggedOut);
    }
}
