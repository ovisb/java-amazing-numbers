package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

class Number {

    private boolean isOdd;
    private boolean isEven;
    private boolean isBuzz;
    private boolean isDuck;

    private boolean isPalindromic;

    private long number;

    Number() {
        this.reset();
    }

    private void reset() {
        this.isOdd = false;
        this.isEven = false;
        this.isBuzz = false;
        this.isDuck = false;
        this.isPalindromic = false;
    }

    public void start() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.
                """);
        while (true) {
            this.reset();
            try {
                this.number = getInt();
                System.out.println();
            } catch (Exception e) {
                continue;
            }
            if (this.number == 0) {
                System.out.println("Goodbye!");
                break;
            }
            checkOddEven(number);
            checkIfBuzz(number);
            checkDuck(number);
            checkPalindrom(number);
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return String.format("""
                Properties of %d
                        even: %b
                        odd: %b
                        buzz: %b
                        duck: %b
                        palindromic: %b
                """,
                this.number,
                this.isEven,
                this.isOdd,
                this.isBuzz,
                this.isDuck,
                this.isPalindromic
                );
    }

    private void checkDuck(long number) {
        while (number > 0) {
            if (number % 10 == 0) {
                this.isDuck = true;
                return;
            }
            number /= 10;
        }
    }


    private void checkPalindrom(long number) {
//        StringBuilder palindrom = new StringBuilder();
//        String strNum = String.valueOf(number);
//        for (int i = strNum.length(); i > 0; i--) {
//            strNum.append()
//        }
        String strNum = String.valueOf(number);
        int last = strNum.length() - 1;
        for (int i = 0; i <= strNum.length() / 2; i++) {
            if (strNum.charAt(i) != strNum.charAt(last--)) {
                return;
            }
        }
        this.isPalindromic = true;
    }

    private void validateInt(long number) throws Exception {
        if (number < 0) {
            System.out.println();
            System.out.println("The first parameter should be a natural number or zero.\n");
            throw new Exception();
        }
    }

    private long getInt() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a request: ");
        long number;
        try {
            number = scanner.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Please input a number.");
            throw new InputMismatchException();
        }
        validateInt(number);
        return number;
    }

    private void checkOddEven(long number) {
        if (number % 2 == 0) {
//            System.out.println("The number is Even.");
            isEven = true;
        } else {
//            System.out.println("The number is Odd.");
            isOdd = true;
        }
    }
    private void checkIfBuzz(long number) {
//        String message;
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
