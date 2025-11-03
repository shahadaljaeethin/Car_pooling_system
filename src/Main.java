import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Route r1 = new Route("AL-Badeea", "Tuwaiq Academic", 90);
    Route r2 = new Route("Sewedi", "Areeja AL-Gharbiya", 30);
    Car c1 = new Car(r1, 8, "(KIA [ABC-123])");
    Car c2 = new Car(r2, 0, "(FORD [EFG-456])");
//=================
    ArrayList<Passenger> passengers = new ArrayList<>();
    passengers.add(new Non_SubscibersPassengers("Khalid", "36680", true));
    passengers.add(new SubscribersPassengers("Huda", "12030"));
    try {
        passengers.get(0).reserveCar(c1);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    try {
        passengers.get(1).reserveCar(c2);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    System.out.println("_________________________\nCurrent Passengers Info:");
    for (Passenger p : passengers) p.displayInfo();
 /*============================================================================================
Project Extra:


 =============================================================================================
  */
int choice=0;  Scanner r = new Scanner(System.in); boolean isSub,hasCoupon;
    do {
    try {
        System.out.println("do you want to add new passenger?\n1] Yes\n2] No");
        choice = r.nextInt();
        if(choice==2) break;
        System.out.println("does the new passenger have subscription??\n1] Yes\n2] No");
        choice = r.nextInt();
        if(choice==1) passengers.add(createSubPass());
        else
         if(choice==2) passengers.add(createNONsubPass());
        else {System.out.println("->Error creation passenger.."); choice=0;}
    }catch (Exception e){System.out.println(e.getMessage());}
    } while (choice!=2);
}

public static Passenger createSubPass(){
Scanner r = new Scanner(System.in);
while (true){
try {
   System.out.println("Enter the name please:");
   String name = r.nextLine();
   System.out.println("Now the ID please:");
   String ID = r.next();

   return new SubscribersPassengers(name,ID);
}catch (Exception e){}
}}
    public static Passenger createNONsubPass(){
        Scanner r = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter the name please:");
                String name = r.nextLine();
                System.out.println("Now the ID please:");
                String ID = r.next();
                System.out.println("does the passenger have a coupon?\n1] Yes\n2] No");
                int choice = r.nextInt();
                if(choice==1)
                return new Non_SubscibersPassengers(name,ID,true);
                return new Non_SubscibersPassengers(name,ID,false);

            }catch (Exception e){}
        }}
}
