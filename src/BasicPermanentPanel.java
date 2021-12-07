import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BasicPermanentPanel extends JFrame{
    final int WIDTH = 320;
    final int HEIGHT = 370;
    JFrame extraOne;
    JPanel extraPanel;
    JButton shoreUp, helicopterLift, nextPlayer;
    JLabel instructions;
    ArrayList<Player> players;
    Player currentPlayer;
    WaterMeter watermeter;
    IslandTile[][] islandmap;
    FloodCardsStack fStack;
    TreasureCardStack tStack;
    TreasureStack treasureStack;
    GameState gameState;
    Multiplayer mul;
    IslandMap map;
    int rand;

    public BasicPermanentPanel(String bas,GameState g,ArrayList<Player> p, Player cp, WaterMeter wm, IslandMap im, FloodCardsStack fs, TreasureCardStack ts, TreasureStack t, Multiplayer ml) {
        super(bas);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        gameState=g;
        players=p;
        currentPlayer=cp;
        watermeter=wm;
        islandmap=im.getIslandMap();
        fStack=fs;
        tStack= ts;
        treasureStack=t;
        mul = ml;
        map = im;


        Container con = getContentPane();
     /*   extraOne= new JFrame();
        extraOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        extraOne.setSize(WIDTH, HEIGHT); */

        extraPanel = new JPanel(null);
        extraPanel.setSize(WIDTH, HEIGHT);
        extraPanel.setLocation(0,0);
        instructions= new JLabel("<html>Order of Play:<br/>1) Take up to 3 Actions<br/>2) Draw 2 Treasure Cards(automatic and discard until 5)<br/>3) Draw 3 Flood Cards(automatic and equates to water level)<br/><br/>Click these buttons anytime throughout the game! <br/><br/>*These cards can only be used if a player has the specific Treasure Card!*<html>");
        instructions.setBounds(5,-60,300,300);
        extraPanel.add(instructions);

        shoreUp = new JButton("Shore Up");
        shoreUp.setBounds(40,180,90,30);
        shoreUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShoreUpPanel("ShoreUpPanel",cp,g);

            }
        });
        helicopterLift = new JButton("Helicopter Lift");
        helicopterLift.setBounds(150,180,120,30);
        helicopterLift.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new HelicopterLift("Helicopter Lift",currentPlayer, gameState, mul, map);

            }
        });

        JPanel escapeIslandP = new JPanel(null);
        escapeIslandP.setSize(400,300);
        escapeIslandP.setLocation(0,0);
        escapeIslandP.setVisible(false);

        nextPlayer = new JButton("Begin Turn");
        nextPlayer.setBounds(85,220,110,30);
        nextPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(gameState.gameLost()) {
                    WaterMeter meter = gameState.getWaterMeter();
                    IslandMap map = gameState.getGameBoard();
                    FloodCardsStack floodCards = gameState.getFloodCards();
                    TreasureCardStack treCards = gameState.getTreasureCards();
                    TreasureStack treStack = gameState.getTreasures();
                    Multiplayer mul = gameState.getPlayers();
                    //gameState.startGame();
                    ArrayList<Player> playersArrayList = (gameState.getPlayers()).getPlayersUsed();
                    JFrame mainPermanentPanelFinal = new JFrame("Main game");
                    mainPermanentPanelFinal.setSize(1100, 675);
                    TemporaryPanels pan = new TemporaryPanels("Action Panel", currentPlayer, gameState, ml);


                    if(gameState.playerIsStranded(currentPlayer)){
                        IslandSinkingPanel ip = new IslandSinkingPanel("Island Sinking Panel", currentPlayer, gameState);
                    }

                    if(rand < playersArrayList.size() ){
                        currentPlayer = playersArrayList.get(rand);
                        rand++;
                    }
                    else{
                        rand=0;
                        currentPlayer = playersArrayList.get(rand);
                    }
                }
                else if(!gameState.gameLost()){
                    JLabel newinstructions = new JLabel("Game lost!");
                    newinstructions.setBounds(20,80,800,30);
                    newinstructions.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));

                    JButton ex = new JButton("Exit");
                    ex.setBounds(140, 130, 80, 30);
                    ex.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });

                    escapeIslandP.add(newinstructions);
                    escapeIslandP.add(ex);

                }

            }
        });

        extraPanel.add(nextPlayer);
        extraPanel.add(shoreUp);
        extraPanel.add(helicopterLift);

        /*
        extraOne.add(extraPanel);
        extraOne.setVisible(true);
        */
        con.add(extraPanel);
        setVisible(true);


    }
}
