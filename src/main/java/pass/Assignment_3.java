package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Assignment_3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/abhinavdas/Documents/Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String name = "rahulshettyacademy";
        String pwd = "learning";

        String[] devices = {"iphone", "Samsung", "Nokia", "Blackberry"};

        //Hit URL
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        Assignment_3 signIn = new Assignment_3();

        //Process to login
        signIn.Login(driver, name, pwd, wait);

        //mobile shop
        signIn.shop(driver, devices, wait);

    }

    public void Login(WebDriver driver, String name, String pwd, WebDriverWait wait) {

        //Enter username & Password
        driver.findElement(By.id("username")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pwd);

        //Select User radio button
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='btn-success']")));
        driver.findElement(By.cssSelector("button[class*='btn-success']")).click();


        //Select consultant from dropdown
        driver.findElement(By.cssSelector("select[class='form-control']")).click();

        List<WebElement> options = driver.findElements(By.xpath("//select[@class='form-control'] / Option"));
        for (WebElement opt : options) {
            if (opt.getText().equalsIgnoreCase("Consultant")) {
                opt.click();
            }
        }

        //Agree to T&C
        driver.findElement(By.id("terms")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='signin']")));          //Explicit wait of 5sec
        //Click on Sign in button
        driver.findElement(By.cssSelector("input[name='signin']")).click();


    }

    public void shop(WebDriver driver, String[] devices, WebDriverWait wait) throws InterruptedException {


        Thread.sleep(1000);
        List<WebElement> allDevices = driver.findElements(By.cssSelector("h4[class='card-title']"));

        int count = 0;

        for (WebElement mobile : allDevices) {

            //Filtering model name only
            String[] modelName = mobile.getText().split(" ");
            String formattedText = modelName[0].trim();

            List product = Arrays.asList(devices);

            int j = 0;

            if (product.contains(formattedText)) {
                driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
                count++;
            }
        }

        System.out.println("Total devices in cart : "+count);

        //Clicking cart CTA
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn.btn-primary")));
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

        //Checkout
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();

        driver.quit();
    }
}
