package numbers;

import java.util.ArrayList;
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
            ArrayList<String> inputProperties = getUserProperties(request);
            validateProperty(inputProperties);
        }
    }

    static void isNatural(long number) throws Exception {
        if (number < 0) {
            throw new Exception();
        }
    }

    static void validateProperty(ArrayList<String> inputProperties) throws InputMismatchException {
        // [even, odd] / [spy, duck] / [sunny, square]
        ArrayList<String> wrongProperties = new ArrayList<>();

        for (String property: inputProperties) {
            try {
                Properties prop = Properties.valueOf(property.toUpperCase());
            } catch (IllegalArgumentException e) {
                wrongProperties.add(property.toUpperCase());
            }
        }

        if (!checkWrongProperties(wrongProperties)){
            throw new InputMismatchException();
        }

        if (!checkPropertyExclusivity(inputProperties)) {
            throw new InputMismatchException();
        }
    }

    static ArrayList<String> getUserProperties(String[] request) {
        ArrayList<String> inputProperties = new ArrayList<>();

        for (int i = 2; i < request.length; i++) {
            inputProperties.add(request[i]);
        }

        return  inputProperties;
    }

    static boolean checkWrongProperties(ArrayList<String> wrongProperties) {
        if (!wrongProperties.isEmpty()){
            if (wrongProperties.size() > 1) {
                System.out.printf("The properties [%s] are wrong.%n", String.join(", ", wrongProperties));

            } else {
                System.out.printf("The property [%s] is wrong.%n", wrongProperties.get(0));
            }
            System.out.printf("Available properties: %s%n", Arrays.toString(Properties.values()));
            return false;
        }
        return true;
    }

    static boolean checkPropertyExclusivity(ArrayList<String> inputProperties) {
        ArrayList<String> exclusiveProps = new ArrayList<>();

        int count = 0;

        outer: for (String propI: inputProperties) {
            for (String propJ: inputProperties) {

                // check property exclusivity
                if (!propI.equals(propJ) && propI.equals(Properties.valueOf(propJ.toUpperCase()).exclusivity)) {
                    exclusiveProps.add(propI.toUpperCase());
                    ++count;
                }
                if (count == 2) {
                    break outer;
                }

            }
        }

        if (!exclusiveProps.isEmpty()) {
            System.out.printf("The request contains mutually exclusive properties: [%s]%n", String.join(", ", exclusiveProps));
            System.out.println("There are no numbers with these properties.");
            return false;
        }

        return true;
    }
}
