package OOF;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {

    private String[] theDeck;
    private boolean[] truthyDeck;

    private Stack<String> riffleDeck;

    Random rand;


    Deck(){
        theDeck = new String[18];
        truthyDeck = new boolean[18];
        riffleDeck = new Stack<>();
        for(int i = 0; i < 18; i++){

            if(i < 6){
                theDeck[i] = ("Rock of " + (6 - i));
            }
            else if(i < 12){
                theDeck[i] = ("Paper of " + (12 - i));
            }
            else if (i < 18) {
                theDeck[i] = ("Scissors of " + (18 - i));
            }

        }
    }

    Stack<String> allocDeck(){
        rand = new Random();
        int i = 0;
        while(i < 18){
            int possible = rand.nextInt(18);
            if(truthyDeck[possible] == false){
                riffleDeck.push(theDeck[possible]);
                i++;
                truthyDeck[possible] = true;
            }
        }
        return riffleDeck;
    }


}
