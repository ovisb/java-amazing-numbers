package numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;

class NumberCreate {

    private long firstNumber;
    private long secondNumber;

    private final ArrayList<String> properties;

    NumberCreate(long firstNumber, long secondNumber, ArrayList<String> properties) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.properties = properties;
        createNumbers();
    }
    private void createNumbers() {
        long maxLoop = secondNumber == 0 ? firstNumber + 1 : firstNumber + secondNumber;

        if (!properties.isEmpty()) {
            System.out.println(properties);
            createNumbersWithProperty();
        } else {
            for (long num = firstNumber; num < maxLoop ; num++) {
                Number number = new Number(num);
                number.makeChecks();

                if (secondNumber != 0) {
                    number.printDiff();
                } else {
                    System.out.println(number);
                }
            }
        }
    }

    private void createNumbersWithProperty() {
        int i = 0;
        while (i < secondNumber) {
            int found = 0;
            Number number = new Number(firstNumber++);
            number.makeChecks();

            for (String property: properties) {
                if (checkProp(number, property)) {
                    found ++;
                }
            }
            if (properties.size() == found) {
                number.printDiff();
                i++;
            }
        }
    }

    private boolean checkProp(Number number, String prop) {
        return switch (prop) {
            case "odd" -> number.isOdd();
            case "even" -> number.isEven();
            case "spy" -> number.isSpy();
            case "duck" -> number.isDuck();
            case "buzz" -> number.isBuzz();
            case "palindromic" -> number.isPalindrome();
            case "gapful" -> number.isGapful();
            case "square" -> number.isSquare();
            case "sunny" -> number.isSunny();
            case "jumping" -> number.isJumping();
            case "happy" -> number.isHappy();
            case "sad" -> number.isSad();
            default -> false;
        };
    }
}
