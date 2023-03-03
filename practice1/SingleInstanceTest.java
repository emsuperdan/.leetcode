package practice1;

import java.util.Arrays;
import java.util.Random;

public class SingleInstanceTest {
    private SingleInstanceTest(){

    }

    public static SingleInstanceTest getInstance(){
        return SingleInnerHolder.INSTANCE;
    }

    public static class SingleInnerHolder{
        private static SingleInstanceTest INSTANCE = new SingleInstanceTest();
    }

}
