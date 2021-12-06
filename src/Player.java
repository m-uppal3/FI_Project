import java.util.ArrayList;
import java.util.Iterator;

public class Player{
    private int actionsRemain = 3;
    private String name;
    private ArrayList<TreasureCard> inventory= new ArrayList<>();
    private Coordinate coordinate;
    private boolean isAlive;

    public Player(String name) {
        this.name = name;
    }

    public void moveUp(){
        coordinate.decrementR();
        useAction();
    }
    public void moveDown(){
        coordinate.incrementR();
        useAction();
    }
    public void moveLeft(){
        coordinate.decrementC();
        useAction();
    }
    public void moveRight(){
        coordinate.incrementC();
        useAction();
    }
    public void skipTurns(){
        actionsRemain = 0;
    }

    public void useAction() {
      actionsRemain--;
    }
    public void resetActions(){
        actionsRemain = 3;
    }

    public void addCard(TreasureCard t){
        inventory.add(t);
    }
    public TreasureCard removeCard(TreasureCard card){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).equals(card)){
                return inventory.remove(i);
            }
        }
        return null;
    }

    public boolean removeSandbag(){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).isSandBag()){
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeHelicopterLift(){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).isHelicopterLift()){
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate useHelicopterLift(int r, int c){
        Iterator<TreasureCard> iter = inventory.iterator();
        while(iter.hasNext()){
            TreasureCard temp = iter.next();
            if(temp.isHelicopterLift()){
                iter.remove();
                setCoordinate(new Coordinate(r, c));
                return new Coordinate(r, c);
            }
        }
        return new Coordinate(-1, -1);
    }
    public int getCardIndex(TreasureCard card){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).equals(card)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<TreasureCard> getInventory() {
        return inventory;
    }

    public void killPlayer(){
        isAlive = false;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public boolean isEngineer() {
        return false;
    }
    public boolean isMessenger(){
        return false;
    }
    public boolean isNavigator(){
        return false;
    }
    public boolean isExplorer(){
        return false;
    }
    public boolean isPilot(){
        return false;
    }
    public boolean isDiver(){
        return false;
    }

    public boolean inventoryIsFull(){
        return inventory.size() >= 5;
    }

    public String getName() {
        return name;
    }

    public void addActions(){
        actionsRemain++;
    }
    public int getActionsRemain(){
        return actionsRemain;
    }
}
