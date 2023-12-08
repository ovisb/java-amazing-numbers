package numbers;

public class CheckPropertyValue {

    static boolean checkProp(Number number, String prop) {
        return switch (prop) {
            case "odd" -> number.isOdd();
            case "even" -> number.isEven();
            case "spy" -> number.isSpy();
            case "duck" -> number.isDuck();
            case "buzz" -> number.isBuzz();
            case "palindromic" -> number.isPalindrome();
            case "gapful" -> number.isGapful();
            case "square" -> number.isSquare();
            case "sunny" -> number.isSunny();
            case "jumping" -> number.isJumping();
            case "happy" -> number.isHappy();
            case "sad" -> number.isSad();
            default -> false;
        };
    }
}
