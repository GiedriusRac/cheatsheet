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

    @AfterEach
    void close() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"user_credentials.txt"})
    void ex1() {
        // 2
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // 3
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // 4
        boolean loggedIn = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        Assertions.assertTrue(loggedIn);
        System.out.println("Logged in: " + loggedIn);
    }
}
