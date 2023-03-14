package DefiningClasses.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        Map<String, Person> peopleData = new HashMap<>();

        while (!information.equals("End")) {
            String[] parameters = information.split("\\S+");
            String personName = parameters[0];
            if(!peopleData.containsKey(personName)) {
                peopleData.put(personName, new Person());
            }
            String typeCommand = parameters[1];
            switch (typeCommand) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);
                    break;
                case "pocemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    break;
                case "parents":
                    String nameParent = parameters[2];
                    String parentBirthday = parameters[3];
                    Parent parent = new Parent(nameParent, parentBirthday);
                    break;
                case "children":
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Child child = new Child(childName, childBirthday);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    Car car = new Car(carModel, carSpeed);
                    break;
            }

            information = scanner.nextLine();
        }
    }
}
