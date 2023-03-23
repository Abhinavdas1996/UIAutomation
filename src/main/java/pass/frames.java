package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.linkText("Accept")).click();

        //Switching to Iframe from normal content screen
        System.out.println(driver.findElements(By.tagName("iframe")).size());   //Fetch index of iframes to know home many iframe are present
        driver.switchTo().frame(0);     //Since only 1 iframe is present so, We can use 0 index.
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));    //Switched using webelement
        //Taking an action to drag and drop the element.
        Actions a = new Actions(driver);
        WebElement toDrag = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.cssSelector("div.ui-widget-header.ui-droppable"));
        a.dragAndDrop(toDrag, destination).build().perform();
        driver.switchTo().defaultContent();


        driver.quit();
    }
}
