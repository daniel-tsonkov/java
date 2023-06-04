package DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int traveledDistance;

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public String getModel() {
        return model;
    }

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.traveledDistance = 0;
    }

    public boolean isFuelSufficient(int distance) {
        return this.fuelAmount >= neededFuel(distance);
    }

    private double neededFuel(int distance) {
        return this.fuelCostPerKm * distance;
    }
}
