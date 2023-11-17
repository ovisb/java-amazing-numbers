package numbers;

public class Main {
    public static void main(String[] args) {
//        write your code here
//        Number natNumber = new Number();
//        natNumber.start();
        UserInput userInput = new UserInput();
        do {
            userInput.collectInput();

            new NumberCreate(userInput.getFirstNumber(), userInput.getSecondNumber());

        } while (userInput.isContinueLoop());
        System.out.println("Goodbye!");
    }
}
