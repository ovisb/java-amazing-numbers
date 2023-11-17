package numbers;

class Number {

    private boolean odd;
    private boolean even;
    private boolean buzz;
    private boolean duck;
    private boolean palindrome;
    private boolean gapful;

    private final long firstNumber;

    Number(long firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void printDiff() {
        StringBuilder str = new StringBuilder();
        String message = String.format("%s is", this.firstNumber);
        str.append(message);

        if (even) {
            str.append(" even");
        }
        if (odd) {
            str.append(" odd");
        }
        if (buzz) {
            str.append(" buzz");
        }
        if (duck) {
            str.append(" duck");
        }
        if (gapful) {
            str.append(" gapful");
        }
        if (palindrome) {
            str.append(" palindromic");
        }
        System.out.println(str);
    }

    @Override
    public String toString() {
        return String.format("""
                Properties of %d
                        even: %b
                        odd: %b
                        buzz: %b
                        duck: %b
                        palindromic: %b
                        gapful: %b
                """,
                this.firstNumber,
                this.even,
                this.odd,
                this.buzz,
                this.duck,
                this.palindrome,
                this.gapful
                );
    }

    private void checkGapful() {
        String toNum = String.valueOf(firstNumber);

        int numLength = toNum.length();
        if (toNum.length() < 3) {
            this.gapful = false;
            return;
        }
        int firstDigit = Integer.parseInt(String.valueOf(toNum.charAt(0)));
        int lastDigit = Integer.parseInt(String.valueOf(toNum.charAt(numLength - 1)));;

        int divisor = firstDigit * 10 + lastDigit;

        if (firstNumber % divisor == 0) {
            this.gapful = true;
            return;
        }

        this.gapful = false;

    }

    private void checkDuck() {
        long number = firstNumber;
        while (number > 0) {
            if (number % 10 == 0) {
                this.duck = true;
                return;
            }
            number /= 10;
        }
    }


    private void checkPalindrome() {
        String strNum = String.valueOf(firstNumber);
        int last = strNum.length() - 1;
        for (int i = 0; i <= strNum.length() / 2; i++) {
            if (strNum.charAt(i) != strNum.charAt(last--)) {
                return;
            }
        }
        this.palindrome = true;
    }


    private void checkOddEven() {
        if (firstNumber % 2 == 0) {
            even = true;
        } else {
            odd = true;
        }
    }
    private void checkIfBuzz() {
        if (firstNumber % 7 == 0 && firstNumber % 10 == 7) {
            buzz = true;
        }
        else if (firstNumber % 7 == 0) {
            buzz = true;
        } else if (firstNumber % 10 == 7) {
            buzz = true;
        } else {
            buzz = false;
        }
    }

    public void makeChecks() {
        checkOddEven();
        checkIfBuzz();
        checkDuck();
        checkPalindrome();
        checkGapful();
    }
}
