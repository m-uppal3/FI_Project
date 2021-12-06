import java.util.ArrayList;
import java.util.Stack;

public class GameState {
    private FloodCardsStack floodCards;
    private IslandMap gameBoard;
    private Multiplayer players;
    private WaterMeter waterMeter;
    private TreasureStack treasures;
    private TreasureCardStack treasureCards;
    public String loseReason = "gameIsNotLost";

    public GameState(int numPlayers, String difficulty) {
        floodCards = new FloodCardsStack();
        gameBoard = new IslandMap();
        players = new Multiplayer(numPlayers);
        waterMeter = new WaterMeter(difficulty);
        treasures = new TreasureStack();
        treasureCards = new TreasureCardStack();

        Stack<FloodCard> floodCards1 = floodCards.getMainStack();
        for(FloodCard card : floodCards1){
            for(int r = 0; r < 6; r++){
                for(int c = 0; c < 6; c++){
                    if (gameBoard.getIslandMap()[r][c]!=null) {
                        if (gameBoard.getIslandMap()[r][c].getName().equals(card.getName())) {
                            card.setCoordinate(new Coordinate(r, c));
                        }
                    }
                }
            }
        }

        //flood 6 tiles
        Stack<FloodCard> temp = floodCards.startGameDrawCards();
        for (FloodCard c : temp) {
            gameBoard.floodTile(c);
        }
        //distribute cards to players
        ArrayList<Player> p = players.getPlayersUsed();
        for (int i = 0; i < p.size(); i++) {
            for (int j = 0; j < 2; j++) {
                TreasureCard t = treasureCards.drawCard();
                if (t.isWatersRise()) {
                    treasureCards.addToMainPile(t);
                    treasureCards.shuffleMainPile();
                    j--;
                }else {
                    players.getCurrentPlayer().addCard(t);
                }
            }
            nextPlayer();
        }
        //set players' location
        IslandTile [][] tempMap = gameBoard.getIslandMap();

        for(int i = 0; i < players.getPlayersUsed().size(); i++){
            Player tempPlayer = players.getPlayersUsed().get(i);
            for(int r = 0; r < 6; r++){
                for(int c = 0; c < 6; c++){
                    if(tempMap[r][c]!=null) {
                        if (tempMap[r][c].getSpecialState().equals(tempPlayer.getName())) {
                            tempPlayer.setCoordinate(new Coordinate(r, c));
                        }
                    }
                }
            }
        }
    }

    //checking game losing conditions
    public boolean gameLost() {
        if (waterMeter.loseGame()) {
            loseReason = "waterMeter";
            return true;
        } else if (players.loseGame()) {
            loseReason = "playerDied";
            return true;
        } else if (getGameBoard().foolsLandingSunk()) {
            loseReason = "foolsLandingSunk";
            return true;
        } else if(cantGetTreasuresLoseGame()){
            loseReason = "cantGetTreasure";
            return true;
        }
        return false;
    }


    //regular actions that every player has, costs actions
    public void shoreupUp() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.decrementR();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupDown() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.incrementR();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupLeft() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.decrementC();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupRight() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.incrementC();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupCurrent() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        gameBoard.shoreupTile(coord);
    }

    public void captureEarth() {
        treasures.captureWater();
        players.getCurrentPlayer().useAction();
    }

    public void captureWind() {
        treasures.captureWind();
        players.getCurrentPlayer().useAction();
    }

    public void captureFire() {
        treasures.captureFire();
        players.getCurrentPlayer().useAction();
    }

    public void captureWater() {
        treasures.captureWater();
        players.getCurrentPlayer().useAction();
    }

    //special actions for explorer

    public void shoreupLeftUp() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.decrementC();
        coord.decrementR();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupRightUp() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.decrementR();
        coord.incrementC();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupLeftDown() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.incrementR();
        coord.decrementC();
        gameBoard.shoreupTile(coord);
    }

    public void shoreupRightDown() {
        Player current = players.getCurrentPlayer();
        current.useAction();
        Coordinate coord = current.getCoordinate();
        coord.incrementR();
        coord.incrementC();
        gameBoard.shoreupTile(coord);
    }

    //special actions for engineer

    public void shoreupLeftAndUp(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupUp();
        shoreupLeft();
    }
    public void shoreupLeftAndDown(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupDown();
        shoreupLeft();
    }
    public void shoreupLeftAndRight(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupRight();
        shoreupLeft();
    }
    public void shoreupUpAndRight(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupUp();
        shoreupRight();
    }
    public void shoreupUpAndDown(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupDown();
        shoreupUp();
    }
    public void shoreupDownAndRight(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupDown();
        shoreupRight();
    }

    public void shoreupCurrentAndUp(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupCurrent();
        shoreupUp();
    }
    public void shoreupCurrentAndDown(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupCurrent();
        shoreupDown();
    }
    public void shoreupCurrentAndLeft(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupCurrent();
        shoreupLeft();
    }
    public void shoreupCurrentAndRight(){
        Player current = players.getCurrentPlayer();
        current.addActions();
        shoreupCurrent();
        shoreupRight();
    }


    //drawing floodCards and treasureCards
    public void drawTreasureCards() {
        for (int i = 0; i < 2; i++) {
            TreasureCard card = treasureCards.drawCard();
            if (card.isWatersRise()) {
                watersRise();
            } else {
                players.getCurrentPlayer().addCard(card);
            }
        }
    }//assumes the player does not have full inventory

    public void drawFloodCards() {
        Stack<FloodCard> temp = floodCards.drawCards();
        for (FloodCard c : temp) {
            gameBoard.floodTile(c);
            if(gameBoard.getTile(c.getCoordinate()).isSunk()) {
                floodCards.removeFloodCard(c);
            }
        }
    }

    public boolean playerHasFullInventory(Player player) {
        return player.getInventory().size() >= 5;
    }

    //actions that players can take at anytime (not bound by turn)
    public boolean useSandbag(Player p, IslandTile tile) {
        if (p.removeSandbag()) {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 6; c++) {
                    Coordinate coord = new Coordinate(r, c);
                    if (gameBoard.getTile(coord).equals(tile)) {
                        gameBoard.getTile(coord).shoreup();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean useHelicopterLift(Player p, IslandTile tile) {
        if (p.removeHelicopterLift()) {
            if (!tile.isSunk()) {
                p.setCoordinate(tile.getCoordinate());
                return true;
            }
        }
        return false;
    }

    public boolean useHelicopterLift(Player giver, Player receiver, IslandTile tile) {
        if (giver.removeHelicopterLift()) {
            if (!tile.isSunk()) {
                receiver.setCoordinate(tile.getCoordinate());
                return true;
            }
        }
        return false;
    }

    public void playerDiscardCard(Player p, TreasureCard card) {
        TreasureCard temp = p.removeCard(card);
        treasureCards.addToDiscardedPile(temp);
    }

    //making turns
    public void nextPlayer() {
        players.nextPlayer();
        players.resetActions();
    }//reset actions, move onto next player;

    //private conditions methods
    private ArrayList<Player> strandedPlayers() {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        for (Player p : players.getPlayersUsed()) {
            if (playerIsStranded(p)) {
                playerArrayList.add(p);
            }
        }
        return playerArrayList;
    }

    private boolean playerHasNoEscape(Player p) {
        Coordinate coord = p.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        IslandTile tile = gameBoard.getTile(coord);
        if (playerIsStranded(p)) {
            if (p.isExplorer()) {
                return explorerHasNoEscape(p);
            } else if (p.isDiver()) {
                return diverHasNoEscape(p);
            } else if (p.isPilot()) {
                return pilotHasNoEscape(p);
            } else {
                if (gameBoard.hasUp(tile)) {
                    return gameBoard.getTile(new Coordinate(r - 1, c)).isSunk();
                } else if (gameBoard.hasDown(tile)) {
                    return gameBoard.getTile(new Coordinate(r + 1, c)).isSunk();
                } else if (gameBoard.hasLeft(tile)) {
                    return gameBoard.getTile(new Coordinate(r, c - 1)).isSunk();
                } else if (gameBoard.hasRight(tile)) {
                    return gameBoard.getTile(new Coordinate(r, c + 1)).isSunk();
                }
            }
            return true;
        }
        return false;
    }//player's tile is sunk and have no neighbor tiles to escape to, kills the player, lose the game

    private boolean pilotHasNoEscape(Player pilot) {
        if (playerIsStranded(pilot)) {
            return gameBoard.getIslandTiles().isEmpty();
        }
        return false;
    }

    private boolean explorerHasNoEscape(Player diver) {
        Coordinate coord = diver.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        IslandTile tile = gameBoard.getTile(coord);
        if (gameBoard.hasUp(tile)) {
            return gameBoard.getTile(new Coordinate(r - 1, c)).isSunk();
        } else if (gameBoard.hasDown(tile)) {
            return gameBoard.getTile(new Coordinate(r + 1, c)).isSunk();
        } else if (gameBoard.hasLeft(tile)) {
            return gameBoard.getTile(new Coordinate(r, c - 1)).isSunk();
        } else if (gameBoard.hasRight(tile)) {
            return gameBoard.getTile(new Coordinate(r, c + 1)).isSunk();
        } else if (gameBoard.hasUpLeft(tile)) {
            return gameBoard.getTile(new Coordinate(r - 1, c - 1)).isSunk();
        } else if (gameBoard.hasUpRight(tile)) {
            return gameBoard.getTile(new Coordinate(r - 1, c + 1)).isSunk();
        } else if (gameBoard.hasDownLeft(tile)) {
            return gameBoard.getTile(new Coordinate(r + 1, c - 1)).isSunk();
        } else if (gameBoard.hasDownRight(tile)) {
            return gameBoard.getTile(new Coordinate(r + 1, c + 1)).isSunk();
        }
        return true;
    }

    private boolean diverHasNoEscape(Player diver) {
        Coordinate coord = diver.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        IslandTile tile = gameBoard.getTile(coord);
        if (gameBoard.hasUp(tile)) {
            return gameBoard.getTile(new Coordinate(r - 1, c)).isSunk();
        } else if (gameBoard.hasDown(tile)) {
            return gameBoard.getTile(new Coordinate(r + 1, c)).isSunk();
        } else if (gameBoard.hasLeft(tile)) {
            return gameBoard.getTile(new Coordinate(r, c - 1)).isSunk();
        } else if (gameBoard.hasRight(tile)) {
            return gameBoard.getTile(new Coordinate(r, c + 1)).isSunk();
        } else if (gameBoard.hasDownDown(tile)) {
            return gameBoard.getTile(new Coordinate(r + 2, c)).isSunk();
        } else if (gameBoard.hasUpUp(tile)) {
            return gameBoard.getTile(new Coordinate(r - 2, c)).isSunk();
        } else if (gameBoard.hasLeftLeft(tile)) {
            return gameBoard.getTile(new Coordinate(r, c - 2)).isSunk();
        } else if (gameBoard.hasRightRight(tile)) {
            return gameBoard.getTile(new Coordinate(r, c + 2)).isSunk();
        }
        return true;
    }

    private boolean cantGetTreasuresLoseGame() {
        if (!treasures.earthCaptured() && gameBoard.allEarthSunk()) {
            return true;
        } else if (!treasures.fireCaptured() && gameBoard.allFireSunk()) {
            return true;
        } else if (!treasures.windCaptured() && gameBoard.allWindSunk()) {
            return true;
        } else return !treasures.waterCaptured() && gameBoard.allWaterSunk();
    }//Treasure is not captured

    //public condition methods
    public boolean playersHasNoEscape() {
        for (int i = 0; i < players.getPlayersUsed().size(); i++) {
            if (playerHasNoEscape(players.getPlayersUsed().get(i))) {
                players.getPlayersUsed().get(i).killPlayer();
                return true;
            }
        }
        return false;
    }//any player gets killed

    public boolean playerIsStranded(Player p) {
        Coordinate coord = p.getCoordinate();
        return gameBoard.getTile(coord).getFloodedState().equals("sunk");
    }//player's current tile just got sunk

    //private action methods
    private void watersRise() {
        waterMeter.watersRise();
    }


    //get methods
    public FloodCardsStack getFloodCards() {
        return floodCards;
    }

    public IslandMap getGameBoard() {
        return gameBoard;
    }

    public Multiplayer getPlayers() {
        return players;
    }

    public TreasureCardStack getTreasureCards() {
        return treasureCards;
    }

    public TreasureStack getTreasures() {
        return treasures;
    }

    public WaterMeter getWaterMeter() {
        return waterMeter;
    }

    public Player getCurrentPlayer() {
        return players.getCurrentPlayer();
    }
    public boolean gameWon(){

        for(int i = 0; i < players.getPlayersUsed().size(); i++){
            if(!players.getPlayersUsed().get(i).getCoordinate().equals(gameBoard.getTile("Fool's Landing").getCoordinate())){
                return false;
            }
        }
        for(Player p : players.getPlayersUsed()){
            if(p.removeHelicopterLift()){
                return true;
            }
        }
        return false;
    }
}
