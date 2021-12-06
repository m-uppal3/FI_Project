import java.util.ArrayList;
import java.util.Collections;

public class Multiplayer {
    private final ArrayList<Player> playersUsed = new ArrayList<>();
    private int turn = 0;

    public Multiplayer(int count) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Navigator("Navigator"));
        players.add(new Pilot("Pilot"));
        players.add(new Explorer("Explorer"));
        players.add(new Diver("Diver"));
        players.add(new Engineer("Engineer"));
        players.add(new Messenger("Messenger"));

        Collections.shuffle(players);
        for (int i = 0; i < count; i++) {
            playersUsed.add(players.remove(0));
        }
    }

    public ArrayList<Player> getPlayersUsed() {
        return playersUsed;
    }
    public void nextPlayer() {
        if (turn == playersUsed.size() - 1) {
            turn = 0;
        } else {
            turn++;
        }
    }
    public Player getCurrentPlayer() {
        return playersUsed.get(turn);
    }
    public boolean loseGame() {
        for (Player p : playersUsed) {
            if (!p.isAlive()) {
                return true;
            }
        }
        return false;
    }
    public void resetActions(){
        for (Player player : playersUsed) {
            player.resetActions();
        }
    }

    //interactions between players

    public boolean sendTreasure(Player giver, Player receiver, TreasureCard card) {
        if (giver.getCoordinate().equals(receiver.getCoordinate())) {
            if (card.isHelicopterLift() || card.isSandBag()) {
                return false;
            } else {
                giver.removeCard(card);
                receiver.addCard(card);
                giver.useAction();
                return true;
            }
        }
        return false;
    }
    public boolean messengerSendTreasure(Messenger giver, Player receiver, TreasureCard card) {
        if (card.isHelicopterLift() || card.isSandBag()) {
            return false;
        } else {
            giver.removeCard(card);
            receiver.addCard(card);
            giver.useAction();
            return true;
        }
    }
    public void navigatorSpecialAction(Navigator giver, Player receiver, String direction) {
        switch (direction) {
            case "up":
                receiver.moveUp();
                giver.useAction();
                break;
            case "down":
                receiver.moveDown();
                giver.useAction();
                break;
            case "left":
                receiver.moveLeft();
                giver.useAction();
                break;
            case "right":
                receiver.moveRight();
                giver.useAction();
                break;
        }
    }
    public void navigatorSpecialAction(Navigator giver, Player receiver, String direction1, String direction2) {
        switch (direction1) {
            case "up":
                receiver.moveUp();
                giver.useAction();
                break;
            case "down":
                receiver.moveDown();
                giver.useAction();
                break;
            case "left":
                receiver.moveLeft();
                giver.useAction();
                break;
            case "right":
                receiver.moveRight();
                giver.useAction();
                break;
        }

        switch (direction2) {
            case "up":
                receiver.moveUp();
                break;
            case "down":
                receiver.moveDown();
                break;
            case "left":
                receiver.moveLeft();
                break;
            case "right":
                receiver.moveRight();
                break;
        }
        
    }

    //accessors for individual players
    public Player getEngineer(){
        for (Player player : playersUsed) {
            if (player.isEngineer()) {
                return player;
            }
        }
        return null;
    }
    public Player getMessenger(){
        for (Player player : playersUsed) {
            if (player.isEngineer()) {
                return player;
            }
        }
        return null;
    }
    public Player getNavigator(){
        for (Player player : playersUsed) {
            if (player.isMessenger()) {
                return player;
            }
        }
        return null;
    }
    public Player getExplorer(){
        for (Player player : playersUsed) {
            if (player.isExplorer()) {
                return player;
            }
        }
        return null;
    }
    public Player getPilot(){
        for (Player player : playersUsed) {
            if (player.isPilot()) {
                return player;
            }
        }
        return null;
    }
    public Player getDiver(){
        for (Player player : playersUsed) {
            if (player.isDiver()) {
                return player;
            }
        }
        return null;
    }

}
