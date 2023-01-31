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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        System.out.println("Is One Way trip enabled? : "+driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());    //Is Radio button enabled


        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));       //Print style attribute value
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("Round trip radio button is disabled.");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertFalse(true);
        }

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
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());                            //Validating if actual and expected matches
        driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
        System.out.println("Is checkbox selected? : "+driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());         //Validating if actual and expected matches


        driver.close();
    }

    public static void DropDown(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.id("divpaxinfo")).click();
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
