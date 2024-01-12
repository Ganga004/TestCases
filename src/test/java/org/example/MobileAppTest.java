package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MobileAppTest {
    private MobileAppImpl mobileAppImpl;

    @BeforeEach
    public void setup() {
        mobileAppImpl= new MobilApp();
    }

    @AfterEach
    public void endJunit() {
        System.out.println("After test cases");
    }
//    @Before
//    public void startJunit() {
//        System.out.println("Before test cases");
//    }


    @Test
    public void testStatement () {
        System.out.println("statement is not there");
    }

    @Test
    public void codeStatement() {
        System.out.println("code is working");
    }

    @Test
    public void appNameTest() {
//        MobileAppImpl mobileApp = new MobilApp();
        String result=mobileAppImpl.appName("junit");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result,"this is junit");
    }

    @Test
    public void appNameIsEmptyOrNull() {
       Exception ex =  Assertions.assertThrows(RuntimeException.class, () -> {
            mobileAppImpl.appName("");
        });
    }
}