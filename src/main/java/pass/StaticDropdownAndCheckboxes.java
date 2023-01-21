package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.time.Duration;

public class StaticDropdownAndCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Dropdown with Select tag  -Static
        WebElement staticDropDown = driver.findElement(By.cssSelector("select[name*='DropDownListCurrency']"));
        Thread.sleep(1000);
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(1);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("USD");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        dropDown.selectByVisibleText("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());


        DropDown(driver);

        //Count number of checkboxes
        System.out.println("Total number of checkboxes: "+driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        // Checkboxes
        System.out.println("Is checkbox selected? : "+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  //Validating if actual and expected matches
        driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
        System.out.println("Is checkbox selected? : "+driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());   //Validating if actual and expected matches


        driver.close();
    }

    public static void DropDown(WebDriver driver) throws InterruptedException {

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"1 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());               //Print values before selection

        driver.manage().deleteAllCookies();


        int i=1;
        while (i<4){
            driver.findElement(By.id("hrefIncAdt")).click();            //Click 4 times
            i++;
        }

        for (int j=1; j<4; j++){
            driver.findElement(By.id("hrefIncChd")).click();            //Click 4 times
        }


        driver.findElement(By.xpath("//input[@value='Done']"));

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"4 Adult, 3 Child");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());              //Print values after selection
    }
}
