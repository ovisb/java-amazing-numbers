package numbers;

import java.util.ArrayList;
import java.util.Scanner;

class UserInput {

    private String[] request;

    private long firstNumber;

    private long secondNumber;

    private ArrayList<String> properties;

    private boolean continueLoop = true;

    UserInput() {
        properties = new ArrayList<>();
        printMenu();
    }

    public long getFirstNumber() {
        return firstNumber;
    }

    public long getSecondNumber() {
        return secondNumber;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public boolean isContinueLoop() {
        return continueLoop;
    }

    public void collectInput() {
        properties = new ArrayList<>();
        while (true) {
            this.request = getInput();
            System.out.println();

            try {
                Validation.validateInput(this);
            } catch (Exception e) {
                System.out.println();
                continue;
            }

            firstNumber = Long.parseLong(this.request[0]);
            if (firstNumber == 0) {
                continueLoop = false;
                return;
            }

            try {
                secondNumber = Long.parseLong(this.request[1]);
            } catch (Exception e) {
                secondNumber = 0;
            }

            addProperties(request);
            return;
        }
    }
    public String[] getRequest() {
        return request;
    }

    private String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a request: ");
        return scanner.nextLine().split(" ");
    }

    private void addProperties(String[] request) {
        for (int i = 2; i < request.length; i++) {
            properties.add(request[i].toLowerCase());
        }
    }

    private void printMenu() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("""
                Supported requests:
                - enter a natural number to know its properties;\s
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and a property to search for;
                - two natural numbers and two properties to search for;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }
}
