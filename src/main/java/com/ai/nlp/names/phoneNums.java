package com.ai.nlp.names;

import static java.lang.System.out;

/**
 * Created by
 * @author derrick on 14-Oct-18.
 */
public class phoneNums {
    public static void phoneNumbers(){
        out.println("phone number : 0722345354 ->"+isPhoneNumber("0722345354"));
        out.println("phone number : 254722345354 ->"+isPhoneNumber("254722345354"));
        out.println("phone number : 722345354 ->"+isPhoneNumber("722345354"));
        out.println("phone number : (254) 722 345 354 ->"+isPhoneNumber("(254)722 345 354"));
        out.println();
        out.println();

    }

    /**
     * Phone method
     * @param s for string return variaable
     * @return a true or false
     */
    private static boolean isPhoneNumber(String s) {
        if(s.matches("[0-9]{10}")){
            return true;
        }else if(s.matches("[0-9]{12}")){
            return true;
        }else if(s.matches("[0-9]{9}")) {
            return true;
        }else if(s.matches("\\(\\d{3}\\)\\d{3}\\s\\d{3}\\s\\d{3}")){
            return true;
        }else{
            return false;
        }
    }
}
