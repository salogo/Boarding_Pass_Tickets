package main.java.com.boardingpass.main;

import main.java.com.boardingpass.models.BoardingPassDetails;
import main.java.com.boardingpass.utils.StringUtils;

import java.util.Scanner;

public class ApplicationMain extends StringUtils {

    //All the user Input goes here....
    //We will create the object of the class BoardingPassDetails which will have an empty constructor. We will set the values for that object here using setters...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardingPassDetails bp = new BoardingPassDetails();

        System.out.println("=======================================");
        System.out.println("Passenger Information");
        System.out.println("=======================================");
        System.out.print("Enter first name: ");
        bp.setFirstName(sc.next());
        validateFirstName(bp.getFirstName());
        System.out.print("Enter last name: ");
        bp.setLastName(sc.next());
        validateLastName(bp.getLastName());

        System.out.print("Enter e-mail address: ");
        bp.setEmail(sc.next());
        validateEmail(bp.getEmail());

        System.out.print("Enter phone number: ");
        bp.setPhoneNumber(sc.next());
        validatePhoneNumber(bp.getPhoneNumber());

        System.out.print("Enter gender (M/F/X): ");
        bp.setGender(sc.next());

        System.out.print("Enter age: ");
        bp.setAge(sc.next());
        validateAge(bp.getAge());

        System.out.println("=======================================");
        System.out.println("Travel Information");
        System.out.println("=======================================");
        System.out.println("Available Destinations:");
        System.out.println("1- ");
        System.out.println("2- ");
        System.out.println("3- ");
        System.out.println("4- ");
        System.out.println("5- ");
        System.out.print("Please enter the number of your destination: ");
        bp.setDestination(sc.next());
        validateDestination(bp.getDestination());

    }
}