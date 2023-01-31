package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

 /*       driver.findElement(By.xpath("(//input[@class='select_CTXT'])")).click();
        driver.findElement(By.xpath("(//a[@value='BHO'])[1]")).click();              //From location  -Dynamic Dropdown with Indexes


        driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).click();
        System.out.println(driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).getText() );        //Dynamic Dropdown with Indexes

        Thread.sleep(2000);  */
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='HBX']")).click();        //Parent-Child Relationship

        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();   //Parent-Child Relationship
        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).getText());

        driver.quit();;
    }
}
