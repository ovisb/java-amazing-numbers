package numbers;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        while (true) {
            userInput.collectInput();

            if (!userInput.isContinueLoop()) {
                System.out.println("Goodbye!");
                return;
            }
            new NumberCreate(userInput.getFirstNumber(), userInput.getSecondNumber(), userInput.getProperties());
        }
    }
}
