package com.company;

import java.util.Scanner;

public class Movies {
    Booking_System[] M = new Booking_System[4];

    public Movies(){
        for(int i=0;i<4;i++){
            M[i] = new Booking_System();
        }
    }

    Scanner sc = new Scanner(System.in);

    public void choose_movie(){
        list();
        int option = sc.nextInt();
        option-=1;

        switch (option){
            case 0:

                M[option].bookticket("1", "Spider-Man: No Way Home (2D)");
                break;

            case 1:
                M[option].bookticket("2", "Spider-Man: No Way Home (3D)");
                break;

            case 2:
                M[option].bookticket("3", "Shyam Singha Roy");
                break;

            case 3:
                M[option].bookticket("4", "Pushpa: The Rise");
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void cancellation(){
        System.out.print("Do you wish to cancel all bookings?(y-yes/n-no) ");
        char temp = sc.next().charAt(0);
        System.out.print("From which movie do you wish to cancel booking? ");
        list();
        int option = sc.nextInt();
        int tk;

        option-=1;
        System.out.print("Enter your token number: ");
        tk = sc.nextInt();
        M[option].cancel(tk, temp);
    }

    public void display(){
        System.out.println("From which screen you wish to display vacancies? ");
        list();
        int option = sc.nextInt();
        option-=1;

        M[option].vacancies();
    }

    private void list(){
        System.out.println("Choose movie from following list: ");
        System.out.println("\n==================================================================================================\n");
        System.out.println("1. Screen 1 - Spider-Man: No Way Home (2D)    |    Action . 2h 30m");
        System.out.println("2. Screen 2 - Spider-Man: No Way Home (3D)    |    Action . 2h 30m");
        System.out.println("3. Screen 3 - Shyam Singha Roy                |    Drama . 2h 35m");
        System.out.println("4. Screen 4 - Pushpa: The Rise                |    Action . 2h 58m");
        System.out.println("\n==================================================================================================");
        System.out.print("Enter: ");
    }
}
