
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;


public class IntroductionPanel extends JFrame {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 500;
    private static JButton downloadRules, novice, normal, elite, legendary, startGame;
    private static JLabel title, askNum, askDifficulty;
    private static JTextField takePlayers;
    private int numberOfPlayers;
    private String difficulty;
    public IntroductionPanel(String theT) throws IOException {

        super(theT);
        setSize(WIDTH,HEIGHT);
        setLayout(null);
        Container content = getContentPane();
        //makes screen be in middle
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel introPanel = new JPanel(null) {
            ImageIcon image = new ImageIcon(getClass().getResource("Images/background.png"));

            public void paint(Graphics g) {

                        g.drawImage(image.getImage(), 0, 0, null, null);
                super.paint(g);
            }
        };
        introPanel.setSize(1200, 1200);
        introPanel.setLocation(0,0);
        introPanel.setVisible(true);
        introPanel.setBackground(new Color(0,0,0,65));


        //the game title on the panel
        title = new JLabel("Forbidden Island");
        title.setBounds(0,50,800,80);
        title.setFont(new Font("Simsun", Font.PLAIN, 80));
        title.setForeground(Color.lightGray);
        introPanel.add(title);



        //get number of players
        askNum = new JLabel("Enter number of players");
        askNum.setBounds(7,200,200,20);
        askNum.setFont(new Font("Simsun", Font.PLAIN, 16));
        askNum.setForeground(Color.white);
        introPanel.add(askNum);



        String[] choices = {"2", "3", "4"};
        final JComboBox<String> first = new JComboBox<String>(choices);
        first.setBounds(230,200,90,20);
        introPanel.add(first);

        //ask for difficulty
        askDifficulty = new JLabel("Choose level of difficulty");
        askDifficulty.setBounds(7,250,250,20);
        askDifficulty.setFont(new Font("Simsun", Font.PLAIN, 16));
        askDifficulty.setForeground(Color.white);

        novice = new JButton("Novice");
        novice.setBounds(230,250,100,20);
        novice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                difficulty = "novice";
                novice.setBackground(Color.pink);

            }
        });
        normal = new JButton("Normal");
        normal.setBounds(350,250,100,20);
        normal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                difficulty = "normal";
                normal.setBackground(Color.pink);

            }
        });
        elite = new JButton("Elite");
        elite.setBounds(470,250,100,20);
        elite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                difficulty = "elite";
                elite.setBackground(Color.pink);

            }
        });
        legendary = new JButton("Legendary");
        legendary.setBounds(590,250,100,20);
        legendary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                difficulty = "legendary";
                legendary.setBackground(Color.pink);

            }
        });



        introPanel.add(askDifficulty);
        introPanel.add(novice);
        introPanel.add(normal);
        introPanel.add(elite);
        introPanel.add(legendary);


        startGame = new JButton("Start Game");
        startGame.setBounds(10,290,100, 20);
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberOfPlayers = Integer.parseInt((String) first.getSelectedItem());
                    GameState gam = new GameState(numberOfPlayers, difficulty);
                    WaterMeter meter = gam.getWaterMeter();
                    IslandMap map = gam.getGameBoard();
                    FloodCardsStack floodCards = gam.getFloodCards();
                    TreasureCardStack treCards = gam.getTreasureCards();
                    TreasureStack treStack = gam.getTreasures();
                    Multiplayer mul= gam.getPlayers();
                    introPanel.setVisible(false);

                     ArrayList<Player> playersArrayList= (gam.getPlayers()).getPlayersUsed();
                     Player cp= playersArrayList.get(1);
                     PermanentPanels perm = new PermanentPanels( gam, playersArrayList,  cp,  meter,  map,  floodCards,  treCards,  treStack, mul);

                    dispose();


            }
        });
        introPanel.add(startGame);

        downloadRules = new JButton("Access Rules");
        downloadRules.setBounds(10,330,170,20);
        downloadRules.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                downloadRules.setBackground(Color.orange);
                PrintWriter outfile;
                try {
                    outfile = new PrintWriter(new File("ForbiddenIslandRules.txt"));
                    outfile.print("These are the rules");
                    outfile.close();
                }catch(FileNotFoundException e1) {
                    e1.printStackTrace();
                }


            }
        });
        introPanel.add(downloadRules);


        content.add(introPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        repaint();
    }

}
