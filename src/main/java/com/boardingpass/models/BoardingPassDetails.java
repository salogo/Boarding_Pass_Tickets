package com.boardingpass.models;

public class BoardingPassDetails {
    //The BoardingPass File details will be here

    //PASSENGER INFORMATION
    //Separated first and last name to make it easy for validation
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String age;    //Still thinking if we should do string for age then convert to int or just keep it as an int?

    //TICKET INFORMATION

    private String boardingPassNumber;
    private String date;
    private String origin;
    private String destination;
    private String eta;
    private String departureTime;
    private double ticketPrice;

    //POJO class create getters and setters here...and zero parametized constructor

    public BoardingPassDetails(String firstName, String lastName, String email, String phoneNumber, String gender, String age, String boardingPassNumber, String date, String origin, String destination, String eta, String departureTime, double ticketPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.boardingPassNumber = boardingPassNumber;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.eta = eta;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
    }
 
    public BoardingPassDetails(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(String boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}
