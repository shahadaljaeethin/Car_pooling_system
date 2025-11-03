public class SubscribersPassengers extends Passenger{
    public SubscribersPassengers(String name,String ID) {
        super.setName(name);
        super.setID(ID);
    }

    public void reserveCar(Car car)throws Exception{
     if(car.getMaxPassengers()==0) throw new Exception("Dear user "+super.getName()+", you can't reserve car "+car.getCarCode()+". it has no available seats right right now.");

     super.setReservedCar(car);
     super.setTripCost(car.rout.getTripPrice()*0.5);
}
public void displayInfo(){
    if(getReservedCar()!=null)
   System.out.println("*Subscribed passenger/ Name: "+super.getName()+" ID#"+super.getID()+" | reserved car: "+ super.getReservedCar().getCarCode()+" trip cost:" +super.getTripCost());
    else
    System.out.println("*Subscribed passenger/ Name: "+super.getName()+" ID#"+super.getID()+" | no reserved car yet.");
}
}
