package numbers;

import java.util.Arrays;
import java.util.InputMismatchException;

class Validation {

    static void validateInput(UserInput userInput) throws Exception {
        String[] request = userInput.getRequest();

        long firstNumber = Long.parseLong(request[0]);
        isNatural("The first parameter should be a natural number or zero", firstNumber);

        if (request.length == 2) {
            long secondNumber = Long.parseLong(request[1]);

            isNatural("The second parameter should be a natural number or zero", secondNumber);
        }
    }

    static void isNatural(String message, long number) throws Exception {
        if (number < 0) {
            System.out.println();
            System.out.printf("%s.%n", message);
            throw new Exception();
        }
    }
}
