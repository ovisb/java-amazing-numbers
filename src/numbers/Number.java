package numbers;

import java.util.ArrayList;

class Number {

    private boolean odd = false;
    private boolean even = false;
    private boolean buzz = false;
    private boolean duck = false;
    private boolean palindrome = false;
    private boolean gapful = false;
    private boolean spy = false;
    private boolean square = false;

    private boolean sunny = false;

    private boolean jumping = false;

    private boolean sad = false;

    private boolean happy = false;

    private final long firstNumber;

    Number(long firstNumber) {
        this.firstNumber = firstNumber;
    }

    public boolean isEven() {
        return even;
    }

    public boolean isOdd() {
        return odd;
    }

    public boolean isBuzz() {
        return buzz;
    }

    public boolean isDuck() {
        return duck;
    }

    public boolean isGapful() {
        return gapful;
    }

    public boolean isPalindrome() {
        return palindrome;
    }

    public boolean isSpy() {return spy; }

    public boolean isSquare() {return square; }

    public boolean isSunny() {return sunny; }
    public boolean isJumping() { return jumping; }
    public boolean isHappy() { return happy; }
    public boolean isSad() { return sad; }

    private int getNumLength() {
        return String.valueOf(firstNumber).length();
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
        if (spy) {
            str.append(" spy");
        }
        if (square) {
            str.append(" square");
        }
        if (sunny) {
            str.append(" sunny");
        }
        if (jumping) {
            str.append(" jumping");
        }
        if (happy) {
            str.append(" happy");
        }
        if (sad) {
            str.append(" sad");
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
                        spy: %b
                        square: %b
                        sunny: %b
                        jumping: %b
                        happy: %b
                        sad: %b
                """,
                this.firstNumber,
                this.even,
                this.odd,
                this.buzz,
                this.duck,
                this.palindrome,
                this.gapful,
                this.spy,
                this.square,
                this.sunny,
                this.jumping,
                this.happy,
                this.sad
                );
    }

    private void checkSpy() {
        String toNum = String.valueOf(firstNumber);

        int sum = 0;
        int prod = 1;
        for (int i = 0; i < toNum.length(); i++) {
            sum += Character.getNumericValue(toNum.charAt(i));
            prod *= Character.getNumericValue(toNum.charAt(i));
        }

        if (sum == prod) {
            this.spy = true;
        }
    }

    private void checkGapful() {
        String toNum = String.valueOf(firstNumber);

        int numLength = toNum.length();
        if (toNum.length() < 3) {
            this.gapful = false;
            return;
        }
        int firstDigit = Character.getNumericValue(toNum.charAt(0));
        int lastDigit = Character.getNumericValue(toNum.charAt(numLength - 1));

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

    private boolean checkSqrt(long number) {
        return Math.sqrt(number) % 1 == 0;
    }

    private void checkSquare() {
        if (checkSqrt(this.firstNumber)) {
            this.square = true;
        }
    }

    private void checkSunny() {
        if (checkSqrt(this.firstNumber + 1)) {
            sunny = true;
        }
    }

    private void checkJumping() {
        String strNum = String.valueOf(firstNumber);

        if (getNumLength() == 1) {
            jumping = true;
            return;
        }

        for (int i = 1; i < strNum.length(); i++) {
            int currentDigit = Character.getNumericValue(strNum.charAt(i));
            int previousDigit = Character.getNumericValue(strNum.charAt(i - 1));
            int difference = Math.abs(currentDigit - previousDigit);

            if (difference != 1) {
                jumping = false;
                return;
            }
        }

        jumping = true;

    }

    private long getTotalDigits(long number) {
        long higher_num = number;
        long total = 0;
        while (higher_num >= 1) {
            long last_digit = higher_num % 10;
            total += last_digit * last_digit;
            higher_num /= 10;
        }
        return total;
    }

    private boolean setHappySad(long number) {
        if (number == 1) {
            this.happy = true;
        } else if(number == 4) {
            this.sad = true;
        }
        return this.sad || this.happy;
    }

    private void checkHappySad() {
        long number = this.firstNumber;
        while (true) {
            if (number / 10 == 0) {
                number *= number;
            } else {
                number = getTotalDigits(number);
            }
            if (setHappySad(number)) {
                break;
            }
        }
    }

    public void makeChecks() {
        checkOddEven();
        checkIfBuzz();
        checkDuck();
        checkPalindrome();
        checkGapful();
        checkSpy();
        checkSquare();
        checkSunny();
        checkJumping();
        checkHappySad();
    }
}
