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
        switch (prop) {
            case "odd":
                return number.isOdd();
            case "even":
                return number.isEven();
            case "spy":
                return number.isSpy();
            case "duck":
                return number.isDuck();
            case "buzz":
                return number.isBuzz();
            case "palindromic":
                return number.isPalindrome();
            case "gapful":
                return number.isGapful();
            case "square":
                return number.isSquare();
            case "sunny":
                return number.isSunny();
            default:
                return false;
        }
    }
}
