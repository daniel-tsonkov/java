package ObjectsAndClasses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class a06VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehcicle> vehcicleList = new ArrayList<>();
        String line = scanner.nextLine();
        while(!line.equals("End")) {
            String[] data = line.split("\\s");
            Vehcicle vehcicle = new Vehcicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehcicleList.add(vehcicle);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("Close the Catalogue")){
            String model = line;

            vehcicleList.stream().filter(vehcicle -> vehcicle.getModel().equals(model)).forEach(vehcicle -> System.out.println(vehcicle.toString()));

            line = scanner.nextLine();
        }

        List<Vehcicle> cars = vehcicleList.stream().filter(vehcicle -> vehcicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehcicle> trucks = vehcicleList.stream().filter(vehcicle -> vehcicle.getType().equals("truck")).collect(Collectors.toList());


        double carsAvgHp = avrHp(cars);
        double trucksAvgHp = avrHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAvgHp);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAvgHp);
    }

    static double avrHp(List<Vehcicle> vehcicles) {
        if (vehcicles.size() == 0) {
            return 0;
        }
        return vehcicles.stream().mapToDouble(Vehcicle :: getHorsePower).sum() / vehcicles.size();
    }

    static class Vehcicle{
        String type;
        String model;
        String color;
        int horsePower;

        public Vehcicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getcolor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1), this.model, this.color, this.horsePower);
        }
    }
}
