import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PermanentPanels {
    ArrayList<Player> players;
    Player currentPlayer, playerOne, playerTwo, playerThree, playerFour;
    WaterMeter watermeter;
    IslandTile[][] islandmap;
    FloodCardsStack fStack;
    TreasureCardStack tStack;
    TreasureStack treasureStack;
    GameState gameState;
    Player cp;
    int rand;

    public PermanentPanels(GameState g,ArrayList<Player> p, Player cp, WaterMeter wm, IslandMap im, FloodCardsStack fs, TreasureCardStack ts, TreasureStack t, Multiplayer ml){
// run the ge
        gameState=g;
        players=p;
        currentPlayer=cp;
        watermeter=wm;
        islandmap=im.getIslandMap();
        fStack=fs;
        tStack= ts;
        treasureStack=t;

        startGame();
    }
 
    
    
    public void startGame(){

       
        WaterMeter meter = gameState.getWaterMeter();
        IslandMap map = gameState.getGameBoard();
        FloodCardsStack floodCards = gameState.getFloodCards();
        TreasureCardStack treCards = gameState.getTreasureCards();
        TreasureStack treStack = gameState.getTreasures();
        Multiplayer mul= gameState.getPlayers();
        //gameState.startGame();
        ArrayList<Player> playersArrayList= (gameState.getPlayers()).getPlayersUsed();
          if(rand<4){
              gameState.drawTreasureCards();
              gameState.drawFloodCards();
               cp= playersArrayList.get(rand);
          }
          else{
              rand=0;
          }
        JFrame mainPermanentPanelFinal= new JFrame("Main game");
        mainPermanentPanelFinal.setSize(1100,675);

        MainPermanentPanel mp= new MainPermanentPanel(gameState,players, cp, meter, map, floodCards, treCards, treStack, mul);
        mainPermanentPanelFinal.add(mp);
        mainPermanentPanelFinal.setResizable(false);
        mainPermanentPanelFinal.setVisible(true);
        BasicPermanentPanel bp= new BasicPermanentPanel("Basic Panel", gameState,players, cp, meter, map, floodCards, treCards, treStack, mul);
        
    }
}
