package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class a10LadyBugs {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        int arrayLenght = Integer.parseInt(scanner.nextLine());
        int[] myArray = new int[arrayLenght];
        int[] bugs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < bugs.length; i++) {
            myArray[bugs[i]] = 1;
        }

        String[] myCommand = scanner.nextLine().split(" ");
        while (!myCommand[0].equals("end")) {
            int positionBug = Integer.parseInt(myCommand[0]);
            int moveBug = Integer.parseInt(myCommand[2]);

            if (positionBug <= 0 || positionBug < myArray.length) {
                if (myArray[Integer.parseInt(myCommand[0])] == 1) {
                    if (myCommand[1].equals("right")) {
                        if (myArray[positionBug + moveBug] != 0) {
                            myArray[positionBug] = 0;
                            int progresPosition = positionBug + moveBug;

                            while(myArray[progresPosition] != 0) {
                                    progresPosition++;
                            }
                            if (progresPosition < myArray.length) {
                                myArray[progresPosition] = 1;
                            }
                        } else {
                            myArray[positionBug] = 0;
                        }

                    } else {
                        if (myArray[positionBug - moveBug] == 0) {
                            myArray[positionBug] = 0;
                            int progresPosition = positionBug - moveBug;

                            while(myArray[progresPosition] != 0) {
                                progresPosition++;
                            }
                            if (progresPosition > 0) {
                                myArray[progresPosition] = 1;
                            }
                        } else {
                            myArray[positionBug] = 0;
                        }

                    }
                }
            }
            myCommand = scanner.nextLine().split(" ");
        }
        for (int bug : myArray) {
            System.out.print(bug + " ");
        }
    }
}
