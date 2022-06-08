
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner st= new Scanner(System.in);

        com.company.Movies M = new com.company.Movies();

        System.out.println("------------------------------- # Welcome to B3 Theatre # -------------------------------");


        while(true) {
            System.out.print("Choose option: \n1. BOOK TICKETS\n2. CANCEL TICKETS\n3. DISPLAY VACANCIES\n4. EXIT\nEnter: ");
            char option = st.next().charAt(0);
            System.out.println();

            if(option=='1') M.choose_movie();
            else if(option=='2') M.cancellation();
            else if(option=='4') break;
            else if(option=='3') M.display();
            else System.out.println("Invalid Option!");
        }
    }
}
