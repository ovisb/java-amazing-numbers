package numbers;

import java.util.ArrayList;
import java.util.Scanner;

class UserInput {

    private String[] request;

    private long firstNumber;

    private long secondNumber;

    private boolean continueLoop = true;



    UserInput() {
        printMenu();
    }

    public long getFirstNumber() {
        return firstNumber;
    }

    public long getSecondNumber() {
        return secondNumber;
    }

    public boolean isContinueLoop() {
        return continueLoop;
    }

    public void collectInput() {
        while (true) {
            this.request = getInput();

            try {
                Validation.validateInput(this);
            } catch (Exception e) {
                continue;
            }

            firstNumber = Long.parseLong(this.request[0]);
            if (firstNumber == 0) {
//                System.out.println("Goodbye!");
                continueLoop = false;
                return;
            }

            try {
                secondNumber = Long.parseLong(this.request[1]);
            } catch (Exception e) {
                secondNumber = 0;
            }
            return;
        }

//        while (true) {
//            this.request = getInput();
//
//            try {
//                Validation.validateInput(this);
//            } catch (Exception e) {
//                continue;
//            }
//
//            firstNumber = Long.parseLong(this.request[0]);
//            if (firstNumber == 0) {
//                System.out.println("Goodbye!");
//                return;
//            }
//
//           try {
//                secondNumber = Long.parseLong(this.request[1]);
//           } catch (Exception e) {
//               secondNumber = 0;
//           }
//
//           createNumbers(firstNumber, secondNumber);
//        }
    }


//    private void createNumbers(long firstNumber, long secondNumber) {
//        long maxLoop = secondNumber == 0 ? firstNumber + 1 : firstNumber + secondNumber;
//
//        for (long num = firstNumber; num < maxLoop ; num++) {
//            Number number = new Number(num);
//            number.makeChecks();
//
//            if (secondNumber != 0) {
//                number.printDiff();
//            } else {
//                System.out.println(number);
//            }
//        }
//    }

    public String[] getRequest() {
        return request;
    }

    private String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a request: ");
        return scanner.nextLine().split(" ");
    }

    private void printMenu() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }
}
