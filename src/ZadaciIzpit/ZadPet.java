package ZadaciIzpit;

import java.util.Scanner;

public class ZadPet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bestPlayer = "";
        int allGoals = 0;

        while (true){
            String name = scanner.nextLine();

            if(name.equals("END")){
                break;
            }

            int goals = Integer.parseInt(scanner.nextLine());
            if(allGoals < goals){
                bestPlayer = name;
                allGoals = goals;
            }

            if(goals >= 10){
                break;
            }
        }

        System.out.printf("%s is the best player!\n", bestPlayer);
        if(allGoals / 3 > 0){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", allGoals);
        }else{
            System.out.printf("He has scored %d goals.", allGoals);
        }
    }
}
