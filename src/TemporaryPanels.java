import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class TemporaryPanels extends JFrame{

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private final JPanel actionPanel;
    private final JButton move;
    private final JButton shoreUp;
    private final JButton giveTresCard;
    private final JButton capTres;
    private final JButton specAct;
    private final JButton skipTurn;
    private final Player player;
    private final GameState game;
    private final Multiplayer m;
    private int cnt;

    public TemporaryPanels(String sm, Player pl, GameState gam, Multiplayer mp){

        super(sm);
        setSize(WIDTH,HEIGHT);
        setLayout(null);

        Container contentPane = getContentPane();
        setLocationRelativeTo(null);
        setResizable(false);

        game = gam;
        player = pl;
        m = mp;

        actionPanel = new JPanel(null);
        actionPanel.setSize(500, 300);
        actionPanel.setLocation(0,0);

        JLabel turn = new JLabel(player.getName());
        turn.setBounds(230, 50,100,30);
        turn.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        actionPanel.add(turn);

        move = new JButton("1");
        move.setBounds(29,100,80,40);

            move.addActionListener(e -> {
               MovePanel mo = new MovePanel("Move Panel", player, game);
                cnt++;

                if(cnt==3){
                    dispose(); //gets rid of window
                    game.drawTreasureCards();
                    game.drawFloodCards();

                }

            });

        shoreUp = new JButton("2");
        shoreUp.setBounds(140,100,80,40);

            shoreUp.addActionListener(e -> {
                ShoreUpPanel mo = new ShoreUpPanel("Shore Up Panel", player, game);

                cnt++;
                if(cnt==3){
                    dispose(); //gets rid of window
                    game.drawTreasureCards();
                    game.drawFloodCards();
                }
            });

        giveTresCard = new JButton("3");
        giveTresCard.setBounds(251,100,80,40);
        giveTresCard.addActionListener(e -> {
            GiveCardPanel mo = new GiveCardPanel("Give Treasure Card Panel", player, mp);
            cnt++;

            if(cnt==3){
                dispose(); //gets rid of window
                game.drawTreasureCards();
                game.drawFloodCards();
            }
        });

        capTres = new JButton("4");
        capTres.setBounds(362,100,80,40);

            capTres.addActionListener(e -> {
                CaptTresPanel mo = new CaptTresPanel("Capture Treasure Panel", player, game);

                cnt++;
                if(cnt==3){
                    dispose(); //gets rid of window
                    game.drawTreasureCards();
                    game.drawFloodCards();
                }
            });

        specAct = new JButton("Special Action");
        specAct.setBounds(175,170,130,40);

        specAct.addActionListener(e -> {


            if(player.getName().equals("Navigator")){

                NavigatorSpecPanel nav = new NavigatorSpecPanel("Navigator's Special Actions", player, game, m);
            }
            if(player.getName().equals("Pilot")){

                PilotSpecPanel pi = new PilotSpecPanel("Pilot's Special Actions", player, game);
            }
            if(player.getName().equals("Messenger")){

                MessengerSpecPanel mes = new MessengerSpecPanel("Messenger's Special Actions", player, m);
            }
            if(player.getName().equals("Engineer")){

                EngineerSpecPanel en = new EngineerSpecPanel("Engineer's Special Actions", player, game);
            }
            if(player.getName().equals("Diver")){

                DiverSpecPanel div = new DiverSpecPanel("Diver's Special Actions", player, game);
            }
            if(player.getName().equals("Explorer")){

                ExplorerSpecPanel ex = new ExplorerSpecPanel("Explorer's Special Actions", player, game);
            }

            cnt++;
            if(cnt==3){
                dispose(); //gets rid of window
                game.drawTreasureCards();
                game.drawFloodCards();
            }
        });


        skipTurn = new JButton("Skip Turn");
        skipTurn.setBounds(370, 200, 100, 40);
        skipTurn.addActionListener(e -> {

            player.skipTurns();
            dispose();
            game.drawTreasureCards();
            game.drawFloodCards();

        });


        actionPanel.add(skipTurn);
        actionPanel.add(move);
        actionPanel.add(shoreUp);
        actionPanel.add(giveTresCard);
        actionPanel.add(capTres);
        actionPanel.add(specAct);
        contentPane.add(actionPanel);
        setVisible(true);

    }

}
