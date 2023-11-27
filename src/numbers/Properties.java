package numbers;

enum Properties {
    EVEN( "odd"),
    ODD("even"),
    BUZZ(""),
    DUCK("spy"),
    PALINDROMIC(""),
    GAPFUL(""),
    SPY("duck"),
    SUNNY("square"),
    SQUARE("sunny"),
    JUMPING("jumping");

    final String exclusivity;

    Properties(String exclusivity) {
        this.exclusivity = exclusivity;
    }
}
