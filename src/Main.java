import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Route r1 = new Route("AL-Badeea", "Tuwaiq Academic", 90);
    Route r2 = new Route("Sewedi", "Areeja AL-Gharbiya", 30);
    Car c1 = new Car(r1, 4, "(KIA [ABC-123])");
    Car c2 = new Car(r2, 0, "(FORD [EFG-456])");
    ArrayList<Car> cars = new ArrayList<>();
    cars.add(c1); cars.add(c2); cars.add(new Car(new Route("Dammam","Bahrain",150),8,"(Hyundai [CCC-345] )"));
    cars.add(new Car(new Route("Tuwaiq","AL-Badeeah",90),2,"(IBM [VVV-555] )"));
//=================
    ArrayList<Passenger> passengers = new ArrayList<>();
    passengers.add(new Non_SubscibersPassengers("Khalid", "36680", true));
    passengers.add(new SubscribersPassengers("Huda", "12030"));
    try {
        passengers.get(0).reserveCar(c1);
    }

    catch (Exception e) {
        System.out.println(e.getMessage());
    }
    try {
        passengers.get(1).reserveCar(c2);
    }
        catch (Exception e) {
        System.out.println(e.getMessage());
    }
    showPassengers(passengers);
 /*============================================================================================
Project Extra:

    this part can help an employee to enter passengers data
 =============================================================================================
  */
int choice=0;  Scanner r = new Scanner(System.in); boolean isSub,hasCoupon;
    do {
    try {
        System.out.println("do you want to add new passenger?\n1] Yes\n2] No\n3]Show passengers list");
        choice = r.nextInt();
        if(choice==2) break;
        if(choice==1){
        System.out.println("does the new passenger have subscription??\n1] Yes\n2] No");
        choice = r.nextInt();
        if(choice==1) passengers.add(createSubPass());
        else
         if(choice==2) {passengers.add(createNONsubPass()); choice=0;}
        else {System.out.println("->Error creation passenger.."); choice=0; continue;}
        System.out.println("passenger "+passengers.getLast().getName()+" is added, which car did this passenger reserved?");
        showCars(cars);
        choice=r.nextInt()-1;
        if(choice>=cars.size()) throw new Exception("please stick to available cars only.");
        passengers.getLast().reserveCar(cars.get(choice));
        passengers.getLast().displayInfo();
        choice=0;}
        else if(choice==3) showPassengers(passengers);
        else throw new Exception("please choose from 1 to 3 only");
    }catch (InputMismatchException e){System.out.println("Please use 1 or 2 only"); r.nextLine();}
    catch (Exception e){System.out.println(e.getMessage());}
    } while (choice!=2);
    System.out.println("Thank you, have a nice day!");
}
public static void showPassengers(ArrayList<Passenger> passengers){System.out.println("_________________________\nCurrent Passengers Info:");
    for (Passenger p : passengers) p.displayInfo();}
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

            }catch (InputMismatchException e){System.out.println(e.getMessage()); r.nextLine();}
            catch (Exception e){System.out.println(e.getMessage());}
        }}


        public static void showCars(ArrayList<Car> cars){
        int index=1;
        for (Car c:cars) {System.out.println(index+"# Car: "+c.getCarCode()+" with Maximum passemgers of "+c.getMaxPassengers()+", Pick up address from ["+c.rout.getPickAddress()+"] To the destination address ["+c.rout.getDestinationAddress()+"] cost: "+c.rout.getTripPrice()); index++;}
        }
}
