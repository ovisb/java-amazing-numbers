package numbers;

class NumberCreate {

    private long firstNumber;
    private long secondNumber;

    NumberCreate(long firstNumber, long secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        createNumbers(firstNumber, secondNumber);
    }
    private void createNumbers(long firstNumber, long secondNumber) {
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
}
