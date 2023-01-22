package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String[] vegetables = {"Carrot", "Beans", "Potato"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(4000);
        cartItems(driver, vegetables);

    }

    public static void cartItems(WebDriver driver, String[] vegetables) throws InterruptedException{


        List<WebElement> items = driver.findElements(By.cssSelector("h4[class='product-name']"));

        int j = 0;

        for (int i = 0; i < items.size(); i++) {

            String[] veg = items.get(i).getText().split("-");
            String formattedText = veg[0].trim();

            List itemsList = Arrays.asList(vegetables);



            if (itemsList.contains(formattedText)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == vegetables.length)
                    break;
            }

        }
    }
}
