package org.example;

/**
 * Hello world!
 *
 */
public class MobilApp implements MobileAppImpl {

        public String appName (String appName) {
            if(appName.isBlank()||appName==null)
            {
                throw new RuntimeException("name is empty");
            }
            return "this is "+appName;
        }
//        System.out.println("Hello World!");
}
