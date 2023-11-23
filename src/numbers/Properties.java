package numbers;

enum Properties {
    EVEN( "odd"),
    ODD("even"),
    BUZZ(""),
    DUCK("spy"),
    PALINDROMIC(""),
    GAPFUL(""),
    SPY("duck");

    final String exclusivity;

    Properties(String exclusivity) {
        this.exclusivity = exclusivity;
    }
}
