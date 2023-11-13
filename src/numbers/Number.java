package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

class Number {

    public void start() {
        int number;
        try {
            number = getInt("Enter a natural number: ");
        } catch (Exception e) {
            return;
        }
        checkOddEven(number);
        checkIfBuzz(number);
    }

    private void validateInt(int number) throws Exception {
        if (number <= 0) {
            System.out.println("This number is not natural!");
            throw new Exception();
        }
    }

    private int getInt(String message) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please input a number.");
            throw new InputMismatchException();
        }
        validateInt(number);
        return number;
    }

    private void checkOddEven(int number) {
        if (number % 2 == 0) {
            System.out.println("The number is Even.");
        } else {
            System.out.println("The number is Odd.");
        }
    }
    private void checkIfBuzz(int number) {
        String message;
        if (number % 7 == 0 && number % 10 == 7) {
            System.out.println("It is a Buzz number.");
            message = String.format("%d number is divisible by 7 and ends with 7.", number);
        }
        else if (number % 7 == 0) {
            System.out.println("It is a Buzz number.");
            message = String.format("%d is divisible by 7.", number);
        } else if (number % 10 == 7) {
            System.out.println("It is a Buzz number.");
            message = String.format("%d ends with 7.", number);
        } else {
            System.out.println("It is not a Buzz number.");
            message = String.format("%d is neither divisible by 7 nor does it end with 7", number);
        }
        System.out.println("Explanation:");
        System.out.println(message);
    }
}
