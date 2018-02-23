// Tussoun Jitpanyoyos 6088030 Section 1

import java.util.Scanner;

public class CardTester {

    public static void main(String[] args){
        /*Card firstCard = new Card("5J");
        Card secondCard = new Card("6S");
        Card thirdCard = new Card("3K");

        System.out.println(firstCard.getDescription());
        System.out.println(secondCard.getDescription());
        System.out.println(thirdCard.getDescription());*/

        String notation = "";

        Scanner sc1 = new Scanner(System.in);
        Card card = new Card("");


        while(true){
            System.out.print("Please input ('q' to end): ");
            notation = sc1.next();

            if(notation.equals("q")){
                System.out.println("Thank you! Bye!");
                break;
            }

            card.setCardNotation(notation);
            System.out.println(card.getDescription());
        }


    }

}
