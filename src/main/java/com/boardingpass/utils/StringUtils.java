package main.java.com.boardingpass.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static void validateFirstName(String fName){
        if (!fName.matches("[a-zA-Z]+") || fName.isEmpty()){
            System.out.println("Please enter a valid first name.");
        }
    }

    public static void validateLastName(String lName){
        if (!lName.matches("[a-zA-Z]+") || lName.isEmpty()){
            System.out.println("Please enter a valid last name.");
        }
    }

    public static void validatePhoneNumber(String number){
        if (number.matches("[a-zA-Z]+") || number.isEmpty()){
            System.out.println("Please enter a valid number.");
        } else if (number.matches("[1-9]+")  && number.length() != 10){
            System.out.println("Please enter a valid 10-digit number.");
        }
    }

    public static void validateAge(String age){
        if (age.matches("[a-zA-Z]+")){
            System.out.println("Please enter a valid number.");
        }
    }

    public static void validateDestination(String dest){
        if (!dest.matches("[1-9]+")){
            System.out.println("Please enter a number.");
        }
    }

    public static void validateEmail(String emailStr) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(emailStr);
        if (!matcher.find()){
            System.out.println("Please enter a valid email address.");
        }
    }


}
