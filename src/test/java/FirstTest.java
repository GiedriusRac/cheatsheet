import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.assertj.core.api.Assertions;

public class FirstTest {
//    @Test
//    void myTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.delfi.lt");
//        driver.findElement(By.className("CybotCookiebotBannerCloseButton")).click();
//        driver.findElement(By.className("fa-search")).click();
//        driver.findElement(By.id("close_button")).click();
//        driver.findElement(By.id("gsc-i-id1")).sendKeys("Pienas");
//        driver.findElement(By.className("gsc-search-button gsc-search-button-v2")).click();
//        driver.quit();
    }

    @Test
    void ex1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // 2
        driver.get("https://demo.opencart.com");

        // 3
        driver.findElement(By.id("wishlist-total")).click();

        // 4
        int searchBoxesSize = driver.findElements(By.name("search")).size();
        System.out.println("Search boxes count: " + searchBoxesSize);
        Assertions.assertEquals(1, searchBoxesSize, "Search boxes size was not as expected");
//        Assertions.assertThat(searchBoxesSize).isEqualTo(1).as("Search boxes size was not as expected");


        // 5
        driver.findElement(By.id("input-email")).sendKeys("email@email.com");

        // 6
        driver.findElement(By.id("input-email")).clear();

        // 7
        driver.findElement(By.cssSelector("#form-login button")).click();

        // 8
        Thread.sleep(1000);
        driver.findElement(By.linkText("Continue")).click();

        // 9
        boolean passwordIsEnabled = driver.findElement(By.id("input-password")).isEnabled();
        System.out.println("Input password is enabled: " + passwordIsEnabled);
        Assertions.assertTrue(passwordIsEnabled);
//        Assertions.assertThat(passwordIsEnabled).isTrue().as("Password field is not enabled");

        // 10
        boolean cartElementIsDisplayed = driver.findElement(By.id("header-cart")).isDisplayed();
        System.out.println("Cart element is displayed: " + cartElementIsDisplayed);
        Assertions.assertTrue(cartElementIsDisplayed);
//        Assertions.assertThat(cartElementIsDisplayed).isTrue().as("Cart element is not displayed");

        // 11
        boolean agree = driver.findElement(By.name("agree")).isSelected();
        System.out.println("Agree checkbox is selected: " + agree);
        Assertions.assertFalse(agree);
//        Assertions.assertThat(agree).isFalse().as("Agree checkbox is not selected");

        // 12
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.className("see-all")).click();

        // 13
        Select showLimit = new Select(driver.findElement(By.id("input-limit")));
        showLimit.selectByVisibleText("25");

        // 14
        Select showLimit2 = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("Selected option: " + showLimit2.getFirstSelectedOption().getText());
        Assertions.assertEquals("25", showLimit2.getFirstSelectedOption().getText());
//        Assertions.assertThat(showLimit2.getFirstSelectedOption().getText()).isEqualTo("25");

        // 15
        Select showLimit3 = new Select(driver.findElement(By.id("input-limit")));
        showLimit3.selectByIndex(3);

        // 16
        Select showLimit4 = new Select(driver.findElement(By.id("input-limit")));
        System.out.println("Selected option: " + showLimit4.getFirstSelectedOption().getText());
        Assertions.assertEquals("75", showLimit4.getFirstSelectedOption().getText());
//        Assertions.assertThat(showLimit4.getFirstSelectedOption().getText()).isEqualTo("75");

        // 17
        driver.close();
    }

    @Test
    void ex2() {
        WebDriver driver = new ChromeDriver();

        // 2
        driver.get("https://demo.opencart.com");

        // 3
        driver.findElement(By.name("search")).sendKeys("MaxBook");

        // 4
        driver.findElement(By.className("btn")).click();

        // 5
        driver.navigate().back();

        // 6
        boolean searchButton = driver.findElement(By.className("btn")).isDisplayed();
        System.out.println("Search Button is displayed: " + searchButton);

        // 7
        driver.findElement(By.linkText("Phones & PDAs")).click();

        // 8
        Select showLimit = new Select(driver.findElement(By.id("input-sort")));
        showLimit.selectByVisibleText("Price (High > Low)");

        // 9
        int searchedItems = driver.findElements(By.className("product-thumb")).size();
        System.out.println("Found items: " + searchedItems);

        // 10
        Select showLimit2 = new Select(driver.findElement(By.id("input-sort")));
        showLimit2.selectByVisibleText("Price (Low > High)");

        // 11
        Select showLimit3 = new Select(driver.findElement(By.id("input-sort")));
        System.out.println("Selected option: " + showLimit3.getFirstSelectedOption().getText());

        // 12
        driver.close();
    }
}
