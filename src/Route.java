public class Route {
private String pickAddress, destinationAddress;
private double tripPrice;
//----

    public Route(){}
    public Route(String pickAddress, String destinationAddress, double tripPrice) {
        this.pickAddress = pickAddress;
        this.destinationAddress = destinationAddress;
        this.tripPrice = tripPrice;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }
}
