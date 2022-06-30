import java.util.Scanner;

public class a03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPersons = Integer.parseInt(scanner.nextLine());
        String typePerson = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double totalPrice = 0.00;

        switch (typePerson) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = (numberPersons * 8.45);
                        break;
                    case "Saturday":
                        totalPrice = (numberPersons * 9.80);
                        break;
                    case "Sunday":
                        totalPrice = (numberPersons * 10.46);
                        break;
                }
                if (numberPersons >= 30) {
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Business":
                double tenPerson = 0;
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = (numberPersons * 10.90);
                        tenPerson = 10.90 * 10;
                        break;
                    case "Saturday":
                        totalPrice = (numberPersons * 15.60);
                        tenPerson = 15.60 * 10;
                        break;
                    case "Sunday":
                        totalPrice = (numberPersons * 16);
                        tenPerson = 16 * 10;
                        break;
                }
                if (numberPersons >= 100) {

                    totalPrice = totalPrice - tenPerson;
                }
                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        totalPrice = (numberPersons * 15);
                        break;
                    case "Saturday":
                        totalPrice = (numberPersons * 20);
                        break;
                    case "Sunday":
                        totalPrice = (numberPersons * 22.50);
                        break;
                }
                if (numberPersons >= 10 && numberPersons <= 20) {
                    totalPrice = totalPrice * 0.95;
                }
                break;
        }
        String answear = String.format("Total price: %.2f", totalPrice);
        System.out.println(answear);
    }
}