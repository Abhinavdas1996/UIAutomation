package eg;

import org.testng.annotations.*;


public class CarLoan {


    @Test(dataProvider = "Login")
    public void everytime(String uname, String password) {
        System.out.println("I will execute after.");
        System.out.println(uname);
        System.out.println(password);
    }


    @Parameters({"URL"})
    @Test
    public void Car(String uname) {
        System.out.println(uname);
        System.out.println("This is Car loan.");
    }


    @DataProvider
    public Object[][] Login() {
        Object[][] ob = new Object[3][2];

        //1st user creds
        ob[0][0] = "firstusername";
        ob[0][1] = "1stPassword";

        //2nd row
        ob[1][0] = "Seconduser";
        ob[1][1] = "2ndpassword";

        //3rd row
        ob[2][0] = "Thirduser";
        ob[2][1] = "3rdpassword";

        return ob;
    }
}
