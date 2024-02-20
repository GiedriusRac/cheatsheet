import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestWebsite {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

//        @AfterEach
//    void close() {
//        driver.quit();
//    }


    @Test
    void login() {
        // Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Log in
        driver.findElement(By.id("login-button")).click();

        // Logged in
        boolean loggedIn = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        Assertions.assertTrue(loggedIn);
        System.out.println("Test login = Logged in: " + loggedIn);
    }

    @Test
    void logout() throws InterruptedException {
        // Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Log in
        driver.findElement(By.id("login-button")).click();

        // Open nav
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Log out
        driver.findElement(By.linkText("Logout")).click();
        boolean loggedOut = driver.findElement(By.id("login-button")).isDisplayed();
        Assertions.assertTrue(loggedOut);
        System.out.println("Test [logout] = Logged out: " + loggedOut);
    }

    @Test
    void addToCart() {
        // Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Log in
        driver.findElement(By.id("login-button")).click();

        // Add to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Check if added 1
        boolean isAdded = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assertions.assertTrue(isAdded);
        System.out.println("Test [addtoCart] = Backpack is added (test 1): " + isAdded);

        // Check if added 2
        boolean isAdded2 = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        Assertions.assertTrue(isAdded2);
        System.out.println("Test [addtoCart] = Backpack is added (test 2): " + isAdded2);

        // Check if added 3
        driver.findElement(By.className("shopping_cart_link")).click();
        boolean isAdded3 = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        Assertions.assertTrue(isAdded3);
        System.out.println("Test [addtoCart] = Backpack is added (test 3): " + isAdded);
    }
}
