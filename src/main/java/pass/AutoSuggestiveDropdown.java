package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("Br");

        Thread.sleep(2000);
        List<WebElement> Options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement Opt : Options) {

            if (Opt.getText().equalsIgnoreCase("Brunei Darussalam")) {
                Opt.click();
                break;
            }
        }

        Thread.sleep(1000);

        driver.quit();
    }
}
