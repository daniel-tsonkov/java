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

        for (int j : bugs) {
            if(j >= 0 && j < myArray.length) {
                myArray[j] = 1;
            }
        }

        String[] myCommand = scanner.nextLine().split(" ");
        while (!myCommand[0].equals("end")) {
            int positionBug = Integer.parseInt(myCommand[0]);
            int moveBug = Integer.parseInt(myCommand[2]);

            if (positionBug >= 0 && positionBug < myArray.length  && myArray[positionBug] == 1) {
                if (myCommand[1].equals("left")) {
                    moveBug *= -1;
                }
                myArray[positionBug] = 0;

                if(positionBug + moveBug >= 0 && positionBug + moveBug < myArray.length ) {
                    if (myArray[positionBug + moveBug] == 1) {
                        int progresPosition = positionBug + moveBug;

                        while (progresPosition >= 0 && progresPosition < myArray.length) {
                            if (myArray[progresPosition] == 0) {
                                myArray[progresPosition] = 1;
                                break;
                            }
                            if (myCommand[1].equals("left")) {
                                progresPosition--;
                            }else {
                                progresPosition++;
                            }

                        }
                    } else {
                        myArray[positionBug + moveBug] = 1;
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
