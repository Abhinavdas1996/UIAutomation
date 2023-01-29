package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SpiceJet {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        driver.switchTo().alert().dismiss();

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys("PATNA");
        List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe'] //div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));

        for (WebElement opt : dropdown) {
            if (opt.getText().equalsIgnoreCase("PATNA")) {
                opt.click();
                break;
            }
        }


        driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys("De");
        List<WebElement> drop = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe'] //div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));

        for (WebElement option : drop) {
            if (option.getText().equalsIgnoreCase("Delhi")) ;
            {
                option.click();
                break;
            }
        }

        Thread.sleep(1000);
        //Date of Journey
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();

        //Clicking on Passenger field
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).click();

        List<WebElement> Adult = driver.findElements(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[1]"));

        int hit = 1;
        while (hit < 4) {
            driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[1]")).click();
            hit++;
        }

        //Selecting number of children
        List<WebElement> child = driver.findElements(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[2]"));
        int hitNum = 1;
        while (hitNum < 3){
            driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[2]")).click();
            hitNum++;
        }
        Assert.assertEquals(driver.findElements(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[3]")),"2 Adults, 2 Children");

        Thread.sleep(1000);

//        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[4]")).click();


        driver.quit();
    }
}
