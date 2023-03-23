package eg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGDemo1 {


    @Test
    public void Demo(){
        System.out.println("Hello World! Work smartly | " + Thread.currentThread().getName());


        int sum= 0;
        int[] a = new int[] {1,2,3,4,5,6,6,3,10};
        for (int j : a) {
            sum = sum + j;
        }
        System.out.println(sum);

//        Assert.assertEquals("a","b");
    }
}
