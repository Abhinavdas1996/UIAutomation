package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] vegetables = {"Carrot", "Beans", "Potato"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));

        Thread.sleep(2000);
        cartItems(driver, vegetables);

        driver.findElement(By.xpath("//img[@src='https://res.cloudinary.com/sivadass/image/upload/v1493548928/icons/bag.png']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        //Enter promo code

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
        driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button[class='promoBtn']")).click();


        //Applying promo code
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(),"Code applied ..!");
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.findElement(By.xpath("(//div/button)[2]")).click();


        //Selecting country to place an order
        driver.findElement(By.xpath("//div/select")).click();
        driver.findElement(By.xpath("//select/option[@value='Albania']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[class='chkAgree']")));
        driver.findElement(By.xpath("input[class='chkAgree']")).click();
        driver.findElement(By.xpath("//button")).click();

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
