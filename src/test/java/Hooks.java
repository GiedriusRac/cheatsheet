import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://www.delfi.lt");
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Test
    void myTest() {
        driver.findElement(By.cssSelector("div")).getText();
    }

    @Test
    void myTest2() {
        driver.findElement(By.cssSelector("div")).getText();
    }

    @Test
    void myTest3() {
        driver.findElement(By.cssSelector("div")).getText();
    }
}
