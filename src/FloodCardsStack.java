
import java.util.Stack;
import java.util.Collections;

public class FloodCardsStack {
    private Stack<FloodCard> mainStack = new Stack<>();
    private Stack<FloodCard> discardedPile = new Stack<>();

    public FloodCardsStack(){
        mainStack.add(new FloodCard("Tidal Palace"));
        mainStack.add(new FloodCard("Coral Palace"));
        mainStack.add(new FloodCard("Temple of the Sun"));
        mainStack.add(new FloodCard("Temple of the Moon"));
        mainStack.add(new FloodCard("Cave of Shadows"));
        mainStack.add(new FloodCard("Cave of Embers"));
        mainStack.add(new FloodCard("Howling Garden"));
        mainStack.add(new FloodCard("Whispering Garden"));
        mainStack.add(new FloodCard("Bronze Gate"));
        mainStack.add(new FloodCard("Gold Gate"));
        mainStack.add(new FloodCard("Copper Gate"));
        mainStack.add(new FloodCard("Silver Gate"));
        mainStack.add(new FloodCard("Fool’s Landing"));
        mainStack.add(new FloodCard("Iron Gate"));

        String temp = "Dunes of Deception, Cities of Abandon, Watchtower, Twilight Hollow, Misty Marsh, Lost Lagoon, Breakers Bridge, Observatory, Phantom Rock, Crimson Forest";
        String[] tempArray = temp.split(", ");
        for (String s : tempArray) {
            mainStack.add(new FloodCard(s));
        }
    }

    public void reFillMainStackIfEmpty(){
        if(mainStack.isEmpty()) {
            Collections.shuffle(discardedPile);
            mainStack.addAll(discardedPile);
            discardedPile.clear();
        }
    }

    public void removeFloodCard(FloodCard f){
        mainStack.remove(f);
        discardedPile.remove(f);
    }
    public void watersRise(){
        Collections.shuffle(discardedPile);
        mainStack.addAll(discardedPile);
        discardedPile.clear();
    }
    public Stack<FloodCard> drawCards(){
        Stack<FloodCard> list = new Stack<>();
            for(int i = 0; i < WaterMeter.numFloodCards; i++){
                if(mainStack.isEmpty()){
                    reFillMainStackIfEmpty();
                }
                FloodCard temp = mainStack.pop();
                list.add(temp);
                discardedPile.add(temp);
            }
        return list;
    }
    public Stack<FloodCard> startGameDrawCards(){
        Stack<FloodCard> list = new Stack<>();
        for(int i = 0; i < 6; i++){
            if(mainStack.isEmpty()){
                reFillMainStackIfEmpty();
            }
            FloodCard temp = mainStack.pop();
            list.add(temp);
            discardedPile.add(temp);
        }
        return list;
    }
    public Stack<FloodCard> getMainStack() {
        return mainStack;
    }

}
