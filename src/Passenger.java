public abstract class Passenger {
private String name,ID;
private double tripCost;
private Car reservedCar;
//-

    public double getTripCost() {
        return tripCost;
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Car getReservedCar() {
        return reservedCar;
    }

    public void setReservedCar(Car reservedCar) {
        this.reservedCar = reservedCar;
    }

public abstract void reserveCar(Car car) throws Exception;
public void displayInfo(){
System.out.println("Name: "+name+" ID#"+ID+" | reserved car: "+ reservedCar.getCarCode()+" trip cost:" +tripCost);
}


}
