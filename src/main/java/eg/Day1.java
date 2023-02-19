package eg;

import org.testng.annotations.*;

import java.lang.reflect.Parameter;

public class Day1 {

    @Parameters({"URL","API"})
    @Test
    void WebLoginBankLoan(String name,String app) {
        System.out.println("Web Login bank loan is to setup.");
        System.out.println(name);
        System.out.println(app);
    }

    @Test
    void MobileLoginBankLoan() {
        System.out.println("Mobile Login bank loan is required.");
    }

    @BeforeMethod
    void Everytest(){
        System.out.println("I will execute before every test method in Day1 class.");
    }

    @Test(groups = {"Smoke"})
    void MobileLogin() {
        System.out.println("Mobile Login test");
    }

    @Test(enabled = false)
    void TabletLoginBankLoan() {
        System.out.println("Tablet login bank loan system");
    }

    @BeforeClass(enabled = false)
    void iphoneLogin() {
        System.out.println("I am login through Iphone.");
    }
}
