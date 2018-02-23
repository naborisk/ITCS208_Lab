// Tussoun Jitpanyoyos 6088030 Section 1

public class Card {

    private String cardNotation;

    Card(String notation){
        cardNotation = notation;
    }

    public String getDescription(){

        String cardAmount, cardDescription;

        switch (cardNotation.charAt(0)){
            case '1':
                cardAmount = "One";
            break;
            case '2':
                cardAmount = "Two";
            break;
            case '3':
                cardAmount = "Three";
            break;
            case '4':
                cardAmount = "Four";
            break;
            case '5':
                cardAmount = "Five";
            break;
            default:
                return "Unknown";
        }

        if(cardNotation.length() < 2) {
            return "Unknown";
        }

        switch (cardNotation.charAt(1)){
            case 'A':
                cardDescription = "Ace";
            break;
            case 'J':
                cardDescription = "Jack";
            break;
            case 'Q':
                cardDescription = "Queen";
            break;
            case 'K':
                cardDescription = "King";
            break;
            case 'S':
                cardDescription = "Spades";
            break;
            default:
                return "Unknown";
        }

        /*if(!cardAmount.equals("One")){
            cardDescription += "s";
        }*/

        return cardAmount + " " +cardDescription;
    }

    public void setCardNotation(String cardNotation) {
        this.cardNotation = cardNotation;
    }
}
