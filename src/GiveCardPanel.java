import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GiveCardPanel extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JPanel cardPanel;
    private JTextField whichPlayerGive, whichCardGive;
    private JButton enter;
    private String givePlayer, giveCard;
    private Player player, receiver;
    private JLabel whichPl, whichCar;
    private Multiplayer mul;

    public GiveCardPanel(String s, Player p, Multiplayer mp){
        super(s);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        player = p;
        mul = mp;
        Container contentPane = getContentPane();
        setLocationRelativeTo(null);

        cardPanel = new JPanel(null);
        cardPanel.setSize(400,300);
        cardPanel.setLocation(0,0);


      //.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));

        whichPl = new JLabel("Enter player name to give card to (ex: Navigator)");
        whichPl.setBounds(45,72,300,15);
        whichPlayerGive = new JTextField("");
        whichPlayerGive.setBounds(45,90,300,20);

        whichCar = new JLabel("Enter name of card to trade");
        whichCar.setBounds(45,132,250,10);

        String[] choices = {"The Earth Stone", "The Statue of the Wind", "The Crystal of Fire", "The Ocean’s Chalice"};
        final JComboBox<String> first = new JComboBox<String>(choices);
        first.setBounds(45,150, 150,20);


        enter = new JButton("Enter");
        enter.setBounds(160, 185, 80, 30);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                givePlayer = whichPlayerGive.getText();
                giveCard = (String) first.getSelectedItem();


                TreasureCard c = new TreasureCard(giveCard);
                boolean ifWorked = mp.sendTreasure(player, getReceiver(givePlayer) , c);
               /* if(ifWorked) {
                    cardPanel.setVisible(false);
                }
                else {
                    JPanel h = new JPanel(null);
                    h.setSize(200,200);
                    h.setLocation(0,0);
                    JLabel sh = new JLabel("Make sure to be on the same tile with desired receiver!");
                    sh.setBounds(30,50,170,20);
                    contentPane.add(h);
                } */
                dispose();
            }
        });


        cardPanel.add(enter);
        cardPanel.add(whichCar);
        cardPanel.add(whichPl);
        cardPanel.add(whichPlayerGive);
        contentPane.add(first);

        contentPane.add(cardPanel);
        setVisible(true);




    }

    public Player getReceiver(String s){


        switch (s) {
            case "engineer":
                receiver = mul.getEngineer() ;
                break;
            case "messenger":
                receiver = mul.getMessenger();
                break;
            case "diver":
                receiver = mul.getDiver();
                break;
            case "explorer":
                receiver = mul.getExplorer();
                break;
            case "pilot":
                receiver = mul.getPilot();
                break;
        }

        return receiver;
    }
}
