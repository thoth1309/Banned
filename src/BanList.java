import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class BanList {
    private static final int COMMANDER = 1;
    private static final int STANDARD = 2;
    private static final int BRAWL = 3;
    private static final int PIONEER = 4;
    private static final int MODERN = 5;
    private static final int VINTAGE = 6;
    private static final int LEGACY = 7;
    private static final int BLOCK = 8;
    private int listStyle;
    private HashSet<String> banList;
    private HashSet<String> restrictedList;

    public BanList() {
        banList = new HashSet<>();
        restrictedList = new HashSet<>();
    }

    public BanList(int listStyle) {
        this();
        setDeckStyle(listStyle);
    }

    public boolean verifyCard(String cardName) {
        boolean retVal = true;
        if (banList.contains(cardName)) {
            System.out.printf("%s is on the ban-list!!\n", cardName);
            retVal = false;
        }

        return retVal;
    }

    public boolean verifyDeckList(String fileName) {
        boolean retVal = true;
        try {
            File deckList = new File(fileName);
            Scanner scanner = new Scanner(deckList);
            String next = new String();
            int i = 0;
            while(scanner.hasNextLine()) {
                i++;
                next = scanner.nextLine().toLowerCase().trim();
                System.out.printf("card %d = %s\n", i, next);

                if (banList.contains(next)) {
                    System.out.printf("%s is on the ban-list!\n", next);
                    retVal = false;
                }

                if(!restrictedList.isEmpty()) {
                    if(restrictedList.contains(next)) {
                        System.out.printf("%s is on the restricted list!\n", next);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("invalid input file");
            retVal = false;
        }

        return retVal;
    }

    public String getDeckStyle() {
        String retVal = new String();
        switch (this.listStyle) {
            case COMMANDER:
                retVal = "Commander";
                break;
            case STANDARD:
                retVal = "Standard";
                break;
            case BRAWL:
                retVal = "Brawl";
                break;
            case PIONEER:
                retVal = "Pioneer";
                break;
            case MODERN:
                retVal = "Modern";
                break;
            case VINTAGE:
                retVal = "Vintage";
                break;
            case LEGACY:
                retVal = "Legacy";
                break;
            case BLOCK:
                retVal = "Block";
                break;
            default:
                System.out.println("INVALID SELECTION!!! THIS SHOULDN'T HAPPEN!!! But, because it did, " +
                        "we're defaulting to the standard ban-list");
                retVal = "Standard";
                break;
        }

        return retVal;
    }

    public boolean setDeckStyle(int deckStyle) {
        boolean retVal = true;
        this.listStyle = deckStyle;

        if (listStyle < 1 || listStyle > 8) {
            System.out.println("Invalid ban-list style selection!!!");
            return false;
        }

        switch (this.listStyle) {
            case COMMANDER:
                retVal = loadList("data/commander.txt");
                break;
            case STANDARD:
                retVal = loadList("data/standard.txt");
                break;
            case BRAWL:
                retVal = loadList("data/brawl.txt");
                break;
            case PIONEER:
                retVal = loadList("data/pioneer.txt");
                break;
            case MODERN:
                retVal = loadList("data/modern.txt");
                break;
            case VINTAGE:
                retVal = loadList("data/vintage.txt");
                if(retVal)
                    retVal = loadRestList("data/vintage-restricted.txt");
                break;
            case LEGACY:
                retVal = loadList("data/legacy.txt");
                break;
            case BLOCK:
                retVal = loadList("data/block.txt");
                break;
            default:
                System.out.println("INVALID SELECTION!!! THIS SHOULDN'T HAPPEN!!! But, because it did, " +
                        "we're defaulting to the standard ban-list");
                retVal = loadList("data/standard.txt");
                break;
        }

        return retVal;
    }

    private boolean loadList(String fileName) {
        boolean retVal;

        try {
            File listFile = new File(fileName);
            Scanner scanner = new Scanner(listFile);

            // build the list
            while(scanner.hasNext()) {
                banList.add(scanner.nextLine().trim().toLowerCase());
            }

            // successfully read the file
            retVal = true;
        } catch (Exception e) {
            // file is bad, can't build the list
            System.out.printf("ban-list file error in file %s.\n", fileName);
            retVal = false;
        }

        return retVal;
    }

    private boolean loadRestList(String fileName) {
        boolean retVal;

        try {
            File listFile = new File(fileName);
            Scanner scanner = new Scanner(listFile);

            // build the list
            while(scanner.hasNext()) {
                restrictedList.add(scanner.nextLine().trim().toLowerCase());
            }

            // successfully read the file
            retVal = true;
        } catch (Exception e) {
            // file is bad, can't build the list
            System.out.printf("restricted list file error in file %s.\n", fileName);
            retVal = false;
        }

        return retVal;
    }
}
