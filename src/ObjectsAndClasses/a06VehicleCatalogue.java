package ObjectsAndClasses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

        @Override
        public String toString() {
            return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d%n", this.type, this.model, this.color, this.horsePower);
        }
    }
}