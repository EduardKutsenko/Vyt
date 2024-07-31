package com.vyt.testData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.Random;

public class TestData {

    static int randomInt;

    @BeforeClass
    private static void setRandomNumber(){
        Random rand = new Random();
        randomInt = rand.nextInt(10000);
    }



    @DataProvider (name = "name")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"1"},
                {"2"}
        };
    }

    public static String getNewRandomTestName(){
        return "testName_"+ randomInt;
    }
    public static String getNewRandomTestLastName(){
        return "testLastName_"+ randomInt;
    }


}
