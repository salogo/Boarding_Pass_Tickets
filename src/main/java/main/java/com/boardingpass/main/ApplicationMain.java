package main.java.com.boardingpass.main;

import com.boardingpass.models.BoardingPassDetails;
import com.boardingpass.utils.BoardingPassFileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.boardingpass.utils.StringUtils.*;

public class ApplicationMain {
    //All the user Input goes here....
    //We will create the object of the class BoardingPassDetails which will have an empty constructor. We will set the values for that object here using setters...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoardingPassDetails bp = new BoardingPassDetails();

        System.out.println("=======================================");
        System.out.println("Passenger Information");
        System.out.println("=======================================");

        do {
            try {
                System.out.print("Enter first name: ");
                bp.setFirstName(sc.next());
                if (!bp.getFirstName().matches("[a-zA-Z]+")) {
                    System.out.println("Please enter a valid first name.");
                }
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        } while (!bp.getFirstName().matches("[a-zA-Z]+"));

        do {
            try {
                System.out.print("Enter last name: ");
                bp.setLastName(sc.next());
                if (!bp.getLastName().matches("[a-zA-Z]+")) {
                    System.out.println("Please enter a valid last name");
                }
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        } while (!bp.getLastName().matches("[a-zA-Z]+"));

        do {
            try {
                System.out.print("Enter phone number: ");
                bp.setPhoneNumber(sc.next());
                if (bp.getPhoneNumber().matches("[a-zA-Z]+") || !bp.getPhoneNumber().matches("[a-zA-Z]+") && bp.getPhoneNumber().length() != 10) {
                    System.out.println("Please enter a valid number.");
                }
            } catch (Exception e) {
                System.out.println("Try again.");
            }
        } while (bp.getPhoneNumber().length() != 10);

        do {
            System.out.print("Enter e-mail address: ");
            bp.setEmail(sc.next());
            if (!validateEmail(bp.getEmail())){
                System.out.println("Please enter a valid email address.");
            }
        } while (!validateEmail(bp.getEmail()));

        do {
            try {
                System.out.print("Enter gender (M/F/X): ");
                char ch = sc.next().charAt(0);
                String gen = String.valueOf(ch).toUpperCase();
                bp.setGender(gen);
            } catch (Exception e) {
                System.out.println("Please enter M/F/X.");
            }
        } while (bp.getGender().isEmpty());

        do {
            try {
                System.out.print("Enter age: ");
                bp.setAge(sc.next());
                int currAge = Integer.parseInt(bp.getAge());
                if (bp.getAge().matches("[a-zA-Z]+")){
                    System.out.println("Please enter a valid age.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        } while (bp.getAge().matches("[a-zA-Z]+"));

        System.out.println();
        System.out.println("=======================================");
        System.out.println("Travel Information");
        System.out.println("=======================================");
        System.out.println("Available Destinations:");
        System.out.println("1- Alabama");
        System.out.println("2- Alaska");
        System.out.println("3- Arizona");
        System.out.println("4- Arkansas");
        System.out.println("5- California");
        System.out.println("6- Colorado");
        System.out.println("7- Connecticut");
        System.out.println("8- Delaware");
        System.out.println("9- Florida");
        System.out.println("10- Georgia");
        System.out.println("11- Hawaii");
        System.out.println("12- Idaho");
        System.out.println("13- Illinois");
        System.out.println("14- Indiana");
        System.out.println("15- Iowa");
        System.out.println("16- Kansas");
        System.out.println("17- Kentucky");
        System.out.println("18- Louisiana");
        System.out.println("19- Maine");
        System.out.println("20- Maryland");
        System.out.println("21- Massachusetts");
        System.out.println("22- Michigan");
        System.out.println("23- Minnesota");
        System.out.println("24- Mississippi");
        System.out.println("25- Missouri");
        System.out.println("26- Montana");
        System.out.println("27- Nebraska");
        System.out.println("28- Nevada");
        System.out.println("29- New Hampshire");
        System.out.println("30- New Jersey");
        System.out.println("31- New Mexico");
        System.out.println("32- New York");
        System.out.println("33- North Carolina");
        System.out.println("34- North Dakota");
        System.out.println("35- Ohio");
        System.out.println("36- Oklahoma");
        System.out.println("37- Oregon");
        System.out.println("38- Pennsylvania");
        System.out.println("39- Rhode Island");
        System.out.println("40- South Carolina");
        System.out.println("41- South Dakota");
        System.out.println("42- Tennessee");
        System.out.println("43- Texas");
        System.out.println("44- Utah");
        System.out.println("45- Vermont");
        System.out.println("46- Virginia");
        System.out.println("47- Washington");
        System.out.println("48- West Virginia");
        System.out.println("49- Wisconsin");

        do {
            try {
                System.out.print("Please enter the number of your destination: ");
                bp.setDestination(sc.next());
                if (bp.getDestination().matches("[a-zA-Z]+")){
                    System.out.println("Please enter a valid number.");
                }
            } catch (Exception e){
                System.out.println("Try again.");
            }
        } while (bp.getDestination().matches("[a-zA-Z]+"));

        String firstName = bp.getFirstName();
        String lastName = bp.getLastName();
        String phoneNumber = bp.getPhoneNumber();
        String emailAddress = bp.getEmail();
        String gender = bp.getGender();
        int age = Integer.parseInt(bp.getAge());
        String destination = bp.getDestination();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%20s\n", "First Name","Last Name","Phone Number","Email Address","Gender", "Age","Destination");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%20s\n", firstName,lastName,phoneNumber,emailAddress,gender, age,destination);
        BoardingPassFileUtil bpf = new BoardingPassFileUtil();
        String[] departureDetails = bpf.getSpecificRow(Integer.parseInt(bp.getDestination()));
        bp.setDestination(departureDetails[1]);
        bp.setEta(departureDetails[3]);
        bp.setDepartureTime(departureDetails[2]);
        int ticketPrice = getTicketPrice(Integer.parseInt(departureDetails[4]), Integer.parseInt(bp.getAge()),
                bp.getGender());
        bp.setTicketPrice(ticketPrice);
        Long boardingPassNumber = (long) (Math.random() * Math.pow(10, 10));
        bp.setBoardingPassNumber(boardingPassNumber.toString());
        printTicket(bp);
    }
    /**
     * Getting the ticket price
     *
     * @param price
     * @param age
     * @param gender
     * @return
     */
    private static int getTicketPrice(int price, int age, String gender) {
        int ticketPrice = price;
        if (age <= 12) {
            ticketPrice = price - (price / 2);
        }
        if (age >= 60) {
            ticketPrice = price - ((price) * (60 / 100));
        }
        if (gender.equals("F")) {
            ticketPrice = price - (price / 4);
        }
        return ticketPrice;

    }
    /**
     * Printing the ticket price
     *
     * @param bp
     */
    private static void printTicket(BoardingPassDetails bp) {

        String line = "------------------------------------------------------";
        String airline = "American Airlines";
        String id = "10-10-232";
        String origin = "USA";
        String flightNumber = "7869";
        System.out.println("✈");

        String info = " " + line
                + String.format("%n %1s %18s %15s  %n", "Name:" + bp.getFirstName() + " " + bp.getLastName(),
                "Ticket No. " + bp.getBoardingPassNumber(), "Airline: " + airline, "")
                + " " + line + "\n"
                + String.format(" %1s %25s %20s %n %1s  %n %54s ", "ID: " + id,
                origin + " \u2708 " + bp.getDestination(), "", "Flight No. " + flightNumber, "", "")
                + String.format("%n %1s %27s %20s %n %38s %15s", "║█║▌║█║▌│║▌█║▌║", "ETA: " + bp.getEta(), "",
                "Departure: " + bp.getDepartureTime(), "")
                + "\n " + line;
        System.out.println(info);

    }
}
