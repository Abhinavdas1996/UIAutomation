package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ActionsDemo {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        DemoActions(driver);

//        NestedFrame(driver);

        MultipleWindows(driver);

        driver.close();
    }

    public static void DemoActions(WebDriver driver) {

        driver.get("https://www.amazon.in/");

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        Actions a = new Actions(driver);

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='nav-link-accountList']")));
        //Move to specific element
        a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();

        WebElement web = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Search Amazon.in']")));
        //Move to search box element and enter keys
        a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Search Amazon.in']"))).click().keyDown(Keys.SHIFT).sendKeys("alexa").doubleClick().build().perform();

        //Right click on specific element
        a.moveToElement(web).contextClick().build().perform();
    }

    public static void NestedFrame(WebDriver driver) throws Exception {

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();

        Thread.sleep(5);
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("content")).getText());

    }

    public static void MultipleWindows(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Multiple Windows")));
        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.partialLinkText("Here")).click();

        Set<String> win = driver.getWindowHandles();
        Iterator<String> it = win.iterator();
        String parentId = it.next();             //Parent window
        String childId = it.next();            //Child window


        //Print child window text
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("div h3")).getText());

        //Print parent window text
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div /h3")).getText());

        driver.switchTo().parentFrame();

    }
}
