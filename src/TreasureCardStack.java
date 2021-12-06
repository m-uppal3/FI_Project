import java.util.Stack;
import java.util.Collections;

public class TreasureCardStack {
    private Stack<TreasureCard> treasureCardsStack = new Stack<>();
    private Stack<TreasureCard> discardedPile = new Stack<>();
    private Stack<TreasureCard> cardsGivenToPlayer = new Stack<>();

    public TreasureCardStack(){
        for(int i = 0; i < 5; i++){
            treasureCardsStack.add(new TreasureCard("The Earth Stone"));
        }
        for(int i = 0; i < 5; i++){
            treasureCardsStack.add(new TreasureCard("The Statue of the Wind"));
        }
        for(int i = 0; i < 5; i++){
            treasureCardsStack.add(new TreasureCard("The Crystal of Fire"));
        }
        for(int i = 0; i < 5; i++){
            treasureCardsStack.add(new TreasureCard("The Ocean’s Chalice"));
        }
        for(int i = 0; i < 3; i++){
            treasureCardsStack.add(new TreasureCard("Waters Rise!" ,"watersRise"));
        }
        for(int i = 0; i < 3; i++){
            treasureCardsStack.add(new TreasureCard("Helicopter Lift", "helicopterLift"));
        }
        for(int i = 0; i < 2; i++){
            treasureCardsStack.add(new TreasureCard("Sandbag","sandbag"));
        }

        Collections.shuffle(treasureCardsStack);
    }//creates all the treasures

    public Stack<TreasureCard> getTreasureCardsStack() {
        return treasureCardsStack;
    }
    public void reFillMainStackIfEmpty(){
        if(treasureCardsStack.isEmpty()){
            Collections.shuffle(discardedPile);
            treasureCardsStack.addAll(discardedPile);
            discardedPile.clear();
        }
    }
    public void addToDiscardedPile(TreasureCard card){
        discardedPile.push(card);
    }
    public TreasureCard drawCard(){
        TreasureCard temp = treasureCardsStack.pop();
        cardsGivenToPlayer.add(temp);
        return temp;
    }
    public void addToMainPile(TreasureCard card){
        treasureCardsStack.push(card);
    }
    public void shuffleMainPile(){
        Collections.shuffle(treasureCardsStack);
    }
}
