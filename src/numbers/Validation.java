package numbers;

import java.util.Arrays;
import java.util.InputMismatchException;

class Validation {

    static void validateInput(UserInput userInput) throws Exception {
        String[] request = userInput.getRequest();

        try {
            long firstNumber = Long.parseLong(request[0]);
            isNatural(firstNumber);
        } catch (Exception e) {
            System.out.println("The first parameter should be a natural number or zero");
            throw new Exception();
        }

        if (request.length == 2) {
            try {
                long secondNumber = Long.parseLong(request[1]);
                isNatural(secondNumber);
            } catch (Exception e) {
                System.out.println("The second parameter should be a natural number or zero");
                throw new Exception();
            }
        }

        if (request.length > 2) {
            validateProperty(request);
        }
    }

    static void isNatural(long number) throws Exception {
        if (number < 0) {
            throw new Exception();
        }
    }

    static void validateProperty(String[] request) throws InputMismatchException {
        for (int i = 2; i < request.length ; i++) {
            try {
                Properties prop = Properties.valueOf(request[i].toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.printf("The property [%s] is wrong.%n", request[i].toUpperCase());
                System.out.printf("Available properties: %s%n", Arrays.toString(Properties.values()));
                throw new InputMismatchException();            }
        }
    }
}
