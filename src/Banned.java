import java.util.Scanner;

public class Banned {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Verifier verifier = new Verifier();
        BanList banlist = new BanList();
        String playStyle = new String();
        String cardCount = new String();
        boolean deckList;

        System.out.println("Welcome to my Unofficial MTG Ban-List Checker!");
        System.out.println("Which playstyle are you using?");
        System.out.println("(Please select (c)ommander, (s)tandard, (b)rawl, (p)ioneer, (m)odern, (v)intage, (l)egacy, (bl)ock), or (pa)uper");
        playStyle = scanner.nextLine().trim().toLowerCase();

        // make sure the user selected a valid play style
        while (!verifier.verifyStyleChoice(playStyle)) {
            System.out.println("Invalid play style selection. Please choose from the following:");
            System.out.println("(c)ommander");
            System.out.println("(s)tandard");
            System.out.println("(b)rawl");
            System.out.println("(p)ioneer");
            System.out.println("(m)odern");
            System.out.println("(v)intage");
            System.out.println("(l)egacy");
            System.out.println("(bl)ock\n");
            System.out.println("(pa)uper");
            playStyle = scanner.nextLine().trim().toLowerCase();
        }

        // set your banlist
        int deckStyle;

        switch (playStyle) {
            case "c":
                deckStyle = 1;
                break;
            case "commander":
                deckStyle = 1;
                break;
            case "s":
                deckStyle = 2;
                break;
            case "standard":
                deckStyle = 2;
                break;
            case "b":
                deckStyle = 3;
                break;
            case "brawl":
                deckStyle = 3;
                break;
            case "p":
                deckStyle = 4;
                break;
            case "pioneer":
                deckStyle = 4;
                break;
            case "m":
                deckStyle = 5;
                break;
            case "modern":
                deckStyle = 5;
                break;
            case "v":
                deckStyle = 6;
                break;
            case "vintage":
                deckStyle = 6;
                break;
            case "l":
                deckStyle = 7;
                break;
            case "legacy":
                deckStyle = 7;
                break;
            case "bl":
                deckStyle = 8;
                break;
            case "block":
                deckStyle = 8;
                break;
            case "pa":
                deckStyle = 9;
                break;
            case "pauper":
                deckStyle = 9;
                break;
            default:
                deckStyle = 2;
                break;
        }
//        System.out.println(deckStyle);

        banlist.setDeckStyle(deckStyle);

        System.out.println("Are you checking a single card, or a deck list?");
        System.out.println("Please select (s)ingle or (d)eck");
        cardCount = scanner.nextLine().trim().toLowerCase();

        // verify input
        while (!verifier.verifyCardCount(cardCount)) {
            System.out.print("Invalid selection. Please choose from one of the following:");
            System.out.println("(s)ingle");
            System.out.println("(d)eck\n");
            cardCount = scanner.nextLine().trim().toLowerCase();
        }

        if (cardCount.equals("s") || cardCount.equals("single")) {
            String cardName = new String();
            System.out.println("Please enter the exact English name of the card (program is sensitive to spelling, " +
                    "but not capitalization)");
            cardName = scanner.nextLine().trim().toLowerCase();

            if (banlist.verifyCard(cardName))
                System.out.println("Card does not appear in current ban list.");

            System.out.println("Thank you for checking your card! Come again soon!");
        } else {
            String fileName = new String();
            // verify in a loop
            System.out.println("Please enter the name and relative path of the file containing your decklist");
            fileName = scanner.nextLine().trim().toLowerCase();

            while (!verifier.verifyDeckList(fileName)) {
                System.out.println("Please enter a valid file path:");
                fileName = scanner.nextLine().trim().toLowerCase();
            }
            if (banlist.verifyDeckList(fileName))
                System.out.println("Congratulations! Your deck-list is valid!.");

            System.out.println("Would you like to check more cards?");
            String response = scanner.nextLine().trim().toLowerCase();

            while (verifier.verifyYesNo(response)) {
                System.out.println("Please enter yes or no.");
                response = scanner.nextLine().trim().toLowerCase();
            }

            if (response.equals("yes")) {
                System.out.println("Would you like to change play format?");
                response = scanner.nextLine().trim().toLowerCase();

                while (verifier.verifyYesNo(response)) {
                    System.out.println("Please enter yes or no.");
                    response = scanner.nextLine().trim().toLowerCase();
                }

                if(response.equals("yes")) {
                    // TODO: start over
                    System.out.println("not yet implemented!");
                } else if (response.equals("no")) {
                    // TODO: start at deck or card selection
                    System.out.println("not yet implemented!");
                }
            }

            System.out.println("Thank you for checking your decklist! Play well, my friend!");

        }
    }
}
