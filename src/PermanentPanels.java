import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PermanentPanels {
    ArrayList<Player> players;
    Player currentPlayer, playerOne, playerTwo, playerThree, playerFour;
    WaterMeter meter;
    IslandTile[][] map;
    IslandMap mo;
    FloodCardsStack floodCards;
    TreasureCardStack treCards;
    TreasureStack treStack;
    GameState gameState;
    Player cp;
    int rand;
    Multiplayer mul;

    public PermanentPanels(GameState g,ArrayList<Player> p, Player cp, WaterMeter wm, IslandMap im, FloodCardsStack fs, TreasureCardStack ts, TreasureStack t, Multiplayer ml){
// run the ge
        gameState=g;
        players=p;
        currentPlayer=cp;
        meter=wm;
        map=im.getIslandMap();
        floodCards=fs;
        treCards= ts;
        treStack=t;
        mul = ml;
        mo = im;

        JFrame mainPermanentPanelFinal= new JFrame("Main game");
        mainPermanentPanelFinal.setSize(1100,675);
        MainPermanentPanel mp= new MainPermanentPanel(gameState,players, cp, meter, mo, floodCards, treCards, treStack, mul);
        mainPermanentPanelFinal.add(mp);
        mainPermanentPanelFinal.setResizable(false);
        mainPermanentPanelFinal.setVisible(true);
        BasicPermanentPanel bp= new BasicPermanentPanel("Basic Panel", gameState,players, cp, meter, mo, floodCards, treCards, treStack, mul);

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
