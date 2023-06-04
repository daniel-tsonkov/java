package DefiningClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPolll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String[] personalInformation = scanner.nextLine().split("\\s+");
            String name = personalInformation[0];
            int age = Integer.parseInt(personalInformation[1]);

            Person person = new Person(name, age);

            if(age > 30) {
                peopleList.add(person);
            }
        }
        peopleList.sort(Comparator.comparing(person -> person.getName()));

        for (Person person : peopleList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

