package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

class Number {

    private boolean isOdd;
    private boolean isEven;
    private boolean isBuzz;
    private boolean isDuck;

    private int number;

    Number() {
        this.isOdd = false;
        this.isEven = false;
        this.isBuzz = false;
        this.isDuck = false;
    }

    public void start() {
        try {
            this.number = getInt("Enter a natural number: ");
        } catch (Exception e) {
            return;
        }
        checkOddEven(number);
        checkIfBuzz(number);
        checkDuck(number);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("""
                Properties of %d
                        even: %b
                        odd: %b
                        buzz: %b
                        duck: %b
                """,
                this.number,
                this.isEven,
                this.isOdd,
                this.isBuzz,
                this.isDuck
                );
    }

    private void checkDuck(int number) {
        while (number > 0) {
            if (number % 10 == 0) {
                this.isDuck = true;
                return;
            }
            number /= 10;
        }
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
//            System.out.println("The number is Even.");
            isEven = true;
        } else {
//            System.out.println("The number is Odd.");
            isOdd = true;
        }
    }
    private void checkIfBuzz(int number) {
        String message;
        if (number % 7 == 0 && number % 10 == 7) {
//            System.out.println("It is a Buzz number.");
//            message = String.format("%d number is divisible by 7 and ends with 7.", number);
            isBuzz = true;
        }
        else if (number % 7 == 0) {
//            System.out.println("It is a Buzz number.");
//            message = String.format("%d is divisible by 7.", number);
            isBuzz = true;
        } else if (number % 10 == 7) {
//            System.out.println("It is a Buzz number.");
//            message = String.format("%d ends with 7.", number);
            isBuzz = true;
        } else {
//            System.out.println("It is not a Buzz number.");
//            message = String.format("%d is neither divisible by 7 nor does it end with 7", number);
        }
//        System.out.println("Explanation:");
//        System.out.println(message);
    }
}
