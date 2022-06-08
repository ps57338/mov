package com.company;

import java.util.Scanner;
import com.company.User;

public class Booking_System {
    Scanner sc= new Scanner(System.in);
    User sobj= new User();
    Linked_List<User> info = new Linked_List<>();
    int index=0;
    boolean[] seat;

    Booking_System()
    {
        seat=new boolean[101];
        for(int i=1;i<=100;i++){
            seat[i] = true;
        }
    }

    public void cancel(int t_no, char t) {
        User node_del = info.getNode(t_no);
        if(t=='y') {
            boolean is_del = info.remove(node_del);
            if(is_del) System.out.println("All bookings canceled!");
            else System.out.println("NO SUCH ENTRY IN SYSTEM!");

        }
        else if(t=='n'){
            System.out.print("Enter the number of seats whose booking is to be cancelled: ");
            int no = sc.nextInt();
            while(no -->0) {
                System.out.print("Enter the seat no.: ");
                int n = sc.nextInt();
                boolean is_del = node_del.seats.remove(n);
                if(is_del) {
                    System.out.println("Booking canceled!");
                    node_del.setTprice(node_del.getTprice()-100);
                }
                else{
                    System.out.println("NO SUCH ENTRY IN SYSTEM!");
                    no+=1;
                }

            }
            System.out.println("Booking for given seats cancelled successfully!\n New Bill generated!\n");
            System.out.println("\n================================================ # BILL # ================================================\n");
            System.out.println("Token no.: "+node_del.getToken_no()+"\nName: " + node_del.getName() +"\nMobile Number: "+node_del.getNumber()+ "\nMovie Name: " + node_del.getMovie() + "\nScreen number: "+sobj.getScreen()+"\nNumber of seats booked: "+sobj.seats.size()+"\nSeats Booked: "+sobj.seats+"\nTotal cost: " + sobj.getTprice() + "/-.\n");
            System.out.println("\n========================================Enjoy the Movie!=========================================\n");
        }
    }

    public void bookticket(String s_No, String m_name)
    {

        // name
        System.out.print("Enter the Name: ");
        String Name=sc.nextLine();

        //mobile no
        System.out.print("Enter the Mobile Number: ");
        String number=sc.next();

        //no of seats
        System.out.print("How many seats do you want to book?");
        int no=sc.nextInt();

        sobj.setName(Name);
        sobj.setNumber(number);
        sobj.setMovie(m_name);
        sobj.setScreen(s_No);
        sobj.setToken_no(index);

        int seatno=0;
        int row=0;


        // booking of seats
        for(int k=1;k<=no;k++)
        {
            System.out.print("Enter the Row: ");
            row=sc.nextInt();
            System.out.print("Choose your seat in given row: ");
            //Entering it from 1 to 10
            seatno=sc.nextInt();
            seatno = (row*10)+seatno;

            if(checkavailability(seatno)){
                int Tprice=100*(k);
                sobj.seats.add(seatno);
                sobj.setTprice(Tprice);
                seat[seatno]=false;
            }
            else{
                System.out.println("Seat already booked!");
            }

        }
        info.add(sobj);


        System.out.println("Seats Booked!");

        System.out.println("\n================================================ # BILL # ================================================\n");
        System.out.println("Token no.: "+index+"\nName: " + sobj.getName() +"\nMobile Number: "+sobj.getNumber()+ "\nMovie Name: " + sobj.getMovie() + "\nScreen number: "+sobj.getScreen()+"\nNumber of seats booked: "+sobj.seats.size()+"\nSeats Booked: "+sobj.seats+"\nTotal cost: " + sobj.getTprice() + "/-.\n");
        System.out.println("\n========================================Enjoy the Movie!=========================================\n");
        this.index+=1;
    }


    public void vacancies()
    {
        System.out.println("\n------------------------------------------\n");
        for(int i=1;i<=100;i++)
        {
            if(!checkavailability(i)) System.out.print("+"+"   ");
            else System.out.print("="+"   ");
            if(i%10==0) System.out.println();
        }
        System.out.println("\n------------------------------------------\n");
    }

    public boolean checkavailability(int seatno) //13
    {
        boolean is_booked = seat[seatno];
        return is_booked;
    }

    public void printBill()
    {
        if(info.root==null){
            System.out.println("No booking!");
            return;
        }
        else{
            System.out.println("\n================================================BILL================================================\n");
            System.out.println(info);
            System.out.println("\n========================================Enjoy the Movie!=========================================\n");

        }
    }
}
