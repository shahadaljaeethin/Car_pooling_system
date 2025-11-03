public class Car {
private int maxPassengers;
public final Route rout;
private String carCode;
    public Car(Route rout,int maxPassengers,String carCode) {
        this.rout = rout;
        this.maxPassengers=maxPassengers;
        this.carCode=carCode;
    }
    //Car(){rout = new Route();} makes no sense since it is fixed value


    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
}
