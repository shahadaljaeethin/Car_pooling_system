public class Non_SubscibersPassengers extends Passenger{
    private boolean hasDiscount;

    public Non_SubscibersPassengers(String name,String ID,boolean hasDiscount) {
        super.setName(name);
        super.setID(ID);
        this.hasDiscount = hasDiscount;
    }

    public void reserveCar(Car car)throws Exception{
    if(car.getMaxPassengers()==0) throw new Exception("Dear user "+super.getName()+", you can't reserve car "+car.getCarCode()+". it has no available seats right now.");

    super.setReservedCar(car);
    if(hasDiscount)
    super.setTripCost(car.rout.getTripPrice()-(car.rout.getTripPrice()*0.1));
    else super.setTripCost(car.rout.getTripPrice());
    }


    public void displayInfo(){
        if(getReservedCar()!=null)
            System.out.println("*non-Subscribed passenger/ Name: "+super.getName()+" ID#"+super.getID()+hasCoupon()+" | reserved car: "+ super.getReservedCar().getCarCode()+" trip cost:" +super.getTripCost());
        else
            System.out.println("*Subscribed passenger/ Name: "+super.getName()+" ID#"+super.getID()+hasCoupon()+" | no reserved car yet.");
    }

    public String hasCoupon(){
    if(hasDiscount) return " has coupon ";
    return " does not have coupon ";
    }
}
