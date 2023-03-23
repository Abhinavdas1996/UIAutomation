package eg;

import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Parameter;

public class Day1 {


    @Parameters({"url"})
    @Test
    void WebLoginBankLoan(String nest) {
        System.out.println("Web Login bank loan is to setup. | " +Thread.currentThread().getName());
        System.out.println(nest);
    }


    @Test
    void MobileLoginBankLoan() {
        System.out.println("Mobile Login bank loan is required. | " + Thread.currentThread().getName());
    }


    @AfterMethod
    void Everytest() {
        System.out.println("I will execute after every test method in Day1 class. | " + Thread.currentThread().getName());
    }


    @AfterTest
    void MobileLogin() {
        System.out.println("Mobile Login test | " + Thread.currentThread().getName());
        Assert.assertTrue(false);
    }


    @BeforeClass
    void TabletLoginBankLoan() {
        System.out.println("Tablet login bank loan system | " + Thread.currentThread().getName());

        Assert.assertEquals("Hello", "Hello");
    }


    @BeforeSuite
    void IphoneLogin() {
        System.out.println("I am login through Iphone. | " + Thread.currentThread().getName());
    }
}
