package eg;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(eg.Listeners.class)
public class TestNGDemo1 {


    @Test
    public void Demo(){
        System.out.println("Hello World! Work smartly");


        int sum= 0;
        int[] a = new int[] {1,2,3,4,5,6,6,3,10};
        for (int j : a) {
            sum = sum + j;
        }
        System.out.println(sum);
    }
}
