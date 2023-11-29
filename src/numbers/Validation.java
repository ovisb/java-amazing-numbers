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

    static String replaceDash(String property) {
        return property.replace("-", "");
    }

    static void validateProperty(ArrayList<String> inputProperties) throws InputMismatchException {
        ArrayList<String> wrongProperties = new ArrayList<>();

        for (String property: inputProperties) {
            try {

                // placeholder
                if (property.charAt(0) == '-') {
                    property = replaceDash(property);
                }

                Properties.valueOf(property.toUpperCase());
            } catch (IllegalArgumentException e) {
                wrongProperties.add(property.toUpperCase());
            }
        }

        if (!wrongProperties.isEmpty() && !checkWrongProperties(wrongProperties)) {
            System.out.printf("Available properties: %s%n", Arrays.toString(Properties.values()));
            throw new InputMismatchException();
        }

//        ArrayList<Properties> propertiesObjects = createPropertyObjects(inputProperties);

        if (!checkPropertyExclusivity(inputProperties)) {
            throw new InputMismatchException();
        }
    }

    static ArrayList<String> getUserProperties(String[] request) {

        return new ArrayList<>(Arrays.asList(request).subList(2, request.length));
    }

    static boolean checkWrongProperties(ArrayList<String> wrongProperties) {
        if (wrongProperties.size() > 1) {
            System.out.printf("The properties [%s] are wrong.%n", String.join(", ", wrongProperties));
            return false;
        } else if (wrongProperties.size() == 1){
            System.out.printf("The property [%s] is wrong.%n", wrongProperties.get(0));
            return false;
        }

        return true;
    }


    //
    static boolean checkPropertyExclusivity(ArrayList<String> inputProperties) {
        ArrayList<String> exclusiveProps = new ArrayList<>();

        int count = 0;

        outer: for (int i = 0; i < inputProperties.size(); i++) {
            String propI = inputProperties.get(i);
            for (int j = 0; j < inputProperties.size(); j++) {
                if (i == j) {
                    continue;
                }

                String propJ = inputProperties.get(j);

                // if both inputs start with sign
                if (propI.startsWith("-") && propJ.startsWith("-")) {
                    propI = propI.replace("-", "");
                    propJ = propJ.replace("-", "");

                    Properties propertyIEnum = Properties.valueOf(propI.toUpperCase());

                    // -SQUARE -SUNNY is allowed, so skip
                    if (propI.equalsIgnoreCase("square") && propJ.equalsIgnoreCase("sunny") ||
                            propI.equalsIgnoreCase("sunny") && propJ.equalsIgnoreCase("square")) {
                        break outer;
                    }

                    // if they are exclusive, add their names with sign
                    if (propertyIEnum.exclusivity.equalsIgnoreCase(propJ)) {
                        System.out.printf("-%s", propI.toUpperCase());
                        exclusiveProps.add(String.format("-%s", propI.toUpperCase()));
                        exclusiveProps.add(String.format("-%s", propJ.toUpperCase()));
                        break outer;
                    }
                }

                // if any of the inputs have a sign
                // check if inputs match, ODD, -ODD
                if (propI.startsWith("-") || propJ.startsWith("-")) {
                    String propIReplace = propI.replace("-", "");
                    String propJReplace = propJ.replace("-", "");

                    // if match, break
                    if (propIReplace.equalsIgnoreCase(propJReplace)) {
                        exclusiveProps.add(propI.toUpperCase());
                        exclusiveProps.add(propJ.toUpperCase());
                        break outer;
                    }
                }


                // only check exclusivity for inputs without a sign
                if (!propI.startsWith("-") && !propJ.startsWith("-")) {
                    Properties propIEnum = Properties.valueOf(propI.toUpperCase());
                    Properties propJEnum = Properties.valueOf(propJ.toUpperCase());
                    if (propIEnum.name().toLowerCase().equals(propJEnum.exclusivity)) {
                        exclusiveProps.add(propIEnum.name());
                        ++count;
                    }

                    if (count == 2) {
                        break outer;
                    }
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
