package com.company;

import com.company.Linked_List;

public class User {
    Linked_List<Integer> seats = new Linked_List<>();
    private int token_no;
    private int sprice;
    private String Name;
    private String Movie;
    private String Screen;
    private int time;
    private String number;
    private int Tprice;
    public int getTprice() {
        return Tprice;
    }
    public void setTprice(int tprice) {
        Tprice = tprice;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getSprice() {
        return sprice;
    }
    public void setSprice(int sprice) {
        this.sprice = sprice;
    }
    public String getMovie() {
        return Movie;
    }
    public void setMovie(String movie) {
        Movie = movie;
    }
    public String getScreen() {
        return Screen;
    }
    public void setScreen(String screen) {
        Screen = screen;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public int getToken_no() {
        return token_no;
    }

    public void setToken_no(int token_no) {
        this.token_no = token_no;
    }

    @Override
    public String toString() {
        return "Token no.: "+ token_no +"\nName: " + Name +"\nMobile Number: "+number+ "\nMovie Name: " + Movie + "\nScreen number: "+Screen+"\nNumber of seats booked: "+this.seats.size()+"\nSeats Booked: "+this.seats+"\nTotal cost: " + Tprice + "/-.\n";
    }
}
