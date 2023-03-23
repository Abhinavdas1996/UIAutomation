package pass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DataDrivenUsingHashmap {

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","C:\\Users\\abhin\\Documents\\Personal doc\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        //Login

        driver.findElement(By.id("email")).sendKeys(username("Ram"));
        driver.findElement(By.id("pass")).sendKeys(password("Ram"));


        driver.quit();

    }

    public static Map<String,String> userCredentials(){

        Map<String, String> user = new HashMap<>();
        user.put("Ram","ram : Test@1234");
        user.put("vikas","vikas : Test@12357");
        user.put("Abhinav","Abhinav : Test@12332");
        user.put("Shyam","Shyam : Test@1234");

        return user;
    }

    public static String username(String name){

        String[] uname =userCredentials().get(name).split(":");

        return uname[0].trim();
    }

    public static String password(String name){

       String[] pass=userCredentials().get(name).split(":");

       return pass[1].trim();
    }
}
