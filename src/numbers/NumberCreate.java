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
        if (!properties.isEmpty()) {
            createNumbersWithProperty();
        } else {
            createNumberWithoutProperty();
        }
    }

    private void createNumberWithoutProperty() {
        long maxLoop = secondNumber == 0 ? firstNumber + 1 : firstNumber + secondNumber;
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

    private void createNumbersWithProperty() {
        int i = 0;
        while (i < secondNumber) {
            Number number = new Number(firstNumber++);
            number.makeChecks();
            int found = getNumberOfTimesFound(number);


            if (found == properties.size()) {
                number.printDiff();
                i++;
            }
        }
    }

    private int getNumberOfTimesFound(Number number) {
        int found = 0;

        for (String property: properties) {
            if (property.startsWith("-")) {
                property = property.replace("-", "");
                if (!CheckPropertyValue.checkProp(number, property)) {
                    found ++;
                }
            } else {
                if (CheckPropertyValue.checkProp(number, property)) {
                    found ++;
                }
            }
        }
        return found;
    }

}
