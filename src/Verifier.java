import java.util.HashSet;

public class Verifier {
    private HashSet<String> styleList;
    private HashSet<String> countList;

    /**
     * Constructor for Verifier. Populates all necessary lists to verify anything
     * the user may need verified
     */
    public Verifier() {
        // set up the play style list
        styleList = new HashSet<>();
        styleList.add("bl");
        styleList.add("block");
        styleList.add("s");
        styleList.add("standard");
        styleList.add("m");
        styleList.add("modern");
        styleList.add("v");
        styleList.add("vintage");
        styleList.add("l");
        styleList.add("legacy");
        styleList.add("c");
        styleList.add("commander");
        styleList.add("b");
        styleList.add("brawl");
        styleList.add("p");
        styleList.add("pioneer");

        // set up the card count list
        countList = new HashSet<>();
        countList.add("s");
        countList.add("single");
        countList.add("d");
        countList.add("deck");
    }

    /**
     * Verifies the user selected play style is one of the supported play styles
     *
     * @param playStyle
     * @return
     */
    public boolean verifyStyleChoice(String playStyle) {
        return styleList.contains(playStyle);
    }

    public boolean verifyCardCount(String cardCount) {
        return countList.contains(cardCount);
    }
}
