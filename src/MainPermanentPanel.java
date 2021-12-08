import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.Locale;
import java.util.Objects;


class MainPermanentPanel extends JPanel{
    ArrayList<Player> players;
    Player currentPlayer, playerOne, playerTwo, playerThree, playerFour;
    WaterMeter watermeter;
    IslandTile[][] islandmap;
    FloodCardsStack fStack;
    TreasureCardStack tStack;
    TreasureStack treasureStack;
    GameState gameState;

    ArrayList<ImageFinder> tImageList= new ArrayList<>();
    ArrayList<ImageFinder> cImageList= new ArrayList<>();
   ArrayList<ImageFinder> pImageList= new ArrayList<>();

    private ImageIcon background, fImage, tImage, fDImage, tDImage, waterMeterImage, lionTreasure, blueTreasure, purpleTreasure, redTreasure, waterMarker;
    private ImageIcon tidalpalace,tidalpalaceflooded,coralpalace,coralpalaceflooded,templeofthesun,templeofthesunflooded,templeofthemoon,templeofthemoodflooded;
    private ImageIcon caveofshadows,caveofshadowsflooded,caveofembers,caveofembersflooded,howlinggarden,howlinggardenflooded,whisperinggarden,whisperinggardenflooded;
    private ImageIcon bronzegate,bronzegateflooded,goldgate,goldgateflooded,coppergate,coppergateflooded,silvergate,silvergateflooded,foolslanding,foolslaningflooded,irongate,irongateflooded;
    private ImageIcon dunesofdeception, dunesofdeceptionflooded,citiesofabandon,citiesofabandonflooded, watchtowerflooded, watchtower,twilighthollow,twilighthollowflooded,mistymarsh,mistymarshflooded, lostlagoon,lostlagoonflooded;
    private ImageIcon breakersbridge,breakersbridgeflooded, observatory,observatoryflooded,phantomrock,phantomrockflooded, crimsonforest,crimsonforestflooded;
    private ImageIcon thecrystaloffire, theearthstone,helicopterlift,theoceanschalice,sandbagCard, thestatueofthewind;
    private ImageIcon explorer, navigator,engineer,pilot,diver, messenger;

    public MainPermanentPanel(GameState g,ArrayList<Player> p, Player cp, WaterMeter wm, IslandMap im, FloodCardsStack fs, TreasureCardStack ts, TreasureStack t, Multiplayer ml){
        super();
        gameState=g;
        players=p;
        currentPlayer=cp;
        watermeter=wm;
        islandmap=im.getIslandMap();
        fStack=fs;
        tStack= ts;
        treasureStack=t;
        getEachPlayer();


        background= new ImageIcon(( (Objects.requireNonNull(getClass().getResource("Background.PNG")))));
        fImage= new ImageIcon(( (Objects.requireNonNull(getClass().getResource("FloodCard.PNG")))));
        tImage= new ImageIcon( (Objects.requireNonNull(getClass().getResource("TreasureCard.PNG"))));
        fDImage= new ImageIcon( (Objects.requireNonNull(getClass().getResource("FloodDiscard.PNG"))));
        tDImage= new ImageIcon( (Objects.requireNonNull(getClass().getResource("TreasureDiscard.PNG"))));
        waterMeterImage= new ImageIcon( (Objects.requireNonNull(getClass().getResource("WaterMeter.PNG"))));
        blueTreasure= new ImageIcon( (Objects.requireNonNull(getClass().getResource("BlueTreasure.PNG"))));
        lionTreasure= new ImageIcon( (Objects.requireNonNull(getClass().getResource("LionTreasure.PNG"))));
        purpleTreasure= new ImageIcon( (Objects.requireNonNull(getClass().getResource("PurpleTreasure.PNG"))));
        redTreasure= new ImageIcon( (Objects.requireNonNull(getClass().getResource("RedTreasure.PNG"))));
        waterMarker= new ImageIcon( (Objects.requireNonNull(getClass().getResource("WaterMarker.png"))));

        tidalpalace= new ImageIcon( (Objects.requireNonNull(getClass().getResource("tidalpalace.png"))));
        tImageList.add(new ImageFinder(tidalpalace.getImage(),"tidalpalace"));

        tidalpalaceflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("tidalpalaceflooded.png"))));
        tImageList.add(new ImageFinder(tidalpalaceflooded.getImage(),"tidalpalaceflooded"));

        coralpalace= new ImageIcon( (Objects.requireNonNull(getClass().getResource("coralpalace.png"))));
        tImageList.add(new ImageFinder(coralpalace.getImage(),"coralpalace"));

        coralpalaceflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("coralpalaceflooded.png"))));
        tImageList.add(new ImageFinder(coralpalaceflooded.getImage(),"coralpalaceflooded"));

        templeofthesun= new ImageIcon( (Objects.requireNonNull(getClass().getResource("templeofthesun.png"))));
        tImageList.add(new ImageFinder(templeofthesun.getImage(),"templeofthesun"));

        templeofthesunflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("templeofthesunflooded.png"))));
        tImageList.add(new ImageFinder(templeofthesunflooded.getImage(),"templeofthesunflooded"));

        templeofthemoon= new ImageIcon( (Objects.requireNonNull(getClass().getResource("templeofthemoon.png"))));
        tImageList.add(new ImageFinder(templeofthemoon.getImage(),"templeofthemoon"));

        templeofthemoodflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("templeofthemoonflooded.png"))));
        tImageList.add(new ImageFinder(templeofthemoodflooded.getImage(),"templeofthemoonflooded"));

        caveofshadows= new ImageIcon( (Objects.requireNonNull(getClass().getResource("caveofshadows.png"))));
        tImageList.add(new ImageFinder(caveofshadows.getImage(),"caveofshadows"));

        caveofshadowsflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("caveofshadowsflooded.png"))));
        tImageList.add(new ImageFinder(caveofshadowsflooded.getImage(),"caveofshadowsflooded"));

        caveofembers= new ImageIcon( (Objects.requireNonNull(getClass().getResource("caveofembers.png"))));
        tImageList.add(new ImageFinder(caveofembers.getImage(),"caveofembers"));

        caveofembersflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("caveofembersflooded.png"))));
        tImageList.add(new ImageFinder(caveofembersflooded.getImage(),"caveofembersflooded"));

        howlinggarden= new ImageIcon( (Objects.requireNonNull(getClass().getResource("howlinggarden.png"))));
        tImageList.add(new ImageFinder(howlinggarden.getImage(),"howlinggarden"));

        howlinggardenflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("howlinggardenflooded.png"))));
        tImageList.add(new ImageFinder(howlinggardenflooded.getImage(),"howlinggardenflooded"));

        whisperinggarden= new ImageIcon( (Objects.requireNonNull(getClass().getResource("whisperinggarden.png"))));
        tImageList.add(new ImageFinder(whisperinggarden.getImage(),"whisperinggarden"));

        whisperinggardenflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("whisperinggardenflooded.png"))));
        tImageList.add(new ImageFinder(whisperinggardenflooded.getImage(),"whisperinggardenflooded"));

        bronzegate=new ImageIcon( (Objects.requireNonNull(getClass().getResource("bronzegate.png"))));
        tImageList.add(new ImageFinder(bronzegate.getImage(),"bronzegate"));

        bronzegateflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("bronzegateflooded.png"))));
        tImageList.add(new ImageFinder(bronzegateflooded.getImage(),"bronzegateflooded"));

        goldgate=new ImageIcon( (Objects.requireNonNull(getClass().getResource("goldgate.png"))));
        tImageList.add(new ImageFinder(goldgate.getImage(),"goldgate"));

        goldgateflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("goldgateflooded.png"))));
        tImageList.add(new ImageFinder(goldgateflooded.getImage(),"goldgateflooded"));

        coppergate= new ImageIcon( (Objects.requireNonNull(getClass().getResource("coppergate.png"))));
        tImageList.add(new ImageFinder(coppergate.getImage(),"coppergate"));

        coppergateflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("coppergateflooded.png"))));
        tImageList.add(new ImageFinder(coppergateflooded.getImage(),"coppergateflooded"));

        silvergate= new ImageIcon( (Objects.requireNonNull(getClass().getResource("silvergate.png"))));
        tImageList.add(new ImageFinder(silvergate.getImage(),"silvergate"));

        silvergateflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("silvergateflooded.png"))));
        tImageList.add(new ImageFinder(silvergateflooded.getImage(),"silvergateflooded"));

        foolslanding= new ImageIcon( (Objects.requireNonNull(getClass().getResource("foolslanding.png"))));
        tImageList.add(new ImageFinder(foolslanding.getImage(),"foolslanding"));

        foolslaningflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("foolslandingflooded.png"))));
        tImageList.add(new ImageFinder(foolslaningflooded.getImage(),"foolslandingflooded"));

        irongate= new ImageIcon( (Objects.requireNonNull(getClass().getResource("irongate.png"))));
        tImageList.add(new ImageFinder(irongate.getImage(),"irongate"));

        irongateflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("irongateflooded.png"))));
        tImageList.add(new ImageFinder(irongateflooded.getImage(),"irongateflooded"));

        dunesofdeceptionflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("dunesofdeceptionflooded.png"))));
        tImageList.add(new ImageFinder(dunesofdeceptionflooded.getImage(),"dunesofdeceptionflooded"));

        dunesofdeception= new ImageIcon( (Objects.requireNonNull(getClass().getResource("dunesofdeception.png"))));
        tImageList.add(new ImageFinder(dunesofdeception.getImage(),"dunesofdeception"));

        citiesofabandonflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("citiesofabandonflooded.png"))));
        tImageList.add(new ImageFinder(citiesofabandonflooded.getImage(),"citiesofabandonflooded"));

        citiesofabandon= new ImageIcon( (Objects.requireNonNull(getClass().getResource("citiesofabandon.png"))));
        tImageList.add(new ImageFinder(citiesofabandon.getImage(),"citiesofabandon"));

        watchtowerflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("watchtowerflooded.png"))));
        tImageList.add(new ImageFinder(watchtowerflooded.getImage(),"watchtowerflooded"));

        watchtower= new ImageIcon( (Objects.requireNonNull(getClass().getResource("watchtower.png"))));
        tImageList.add(new ImageFinder(watchtower.getImage(),"watchtower"));

        twilighthollow= new ImageIcon( (Objects.requireNonNull(getClass().getResource("twilighthollow.png"))));
        tImageList.add(new ImageFinder(twilighthollow.getImage(),"twilighthollow"));

        twilighthollowflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("twilighthollowflooded.png"))));
        tImageList.add(new ImageFinder(twilighthollowflooded.getImage(),"twilighthollowflooded"));

        mistymarsh= new ImageIcon( (Objects.requireNonNull(getClass().getResource("mistymarsh.png"))));
        tImageList.add(new ImageFinder(mistymarsh.getImage(),"mistymarsh"));

        mistymarshflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("mistymarshflooded.png"))));
        tImageList.add(new ImageFinder(mistymarshflooded.getImage(),"mistymarshflooded"));

        lostlagoon= new ImageIcon( (Objects.requireNonNull(getClass().getResource("lostlagoon.png"))));
        tImageList.add(new ImageFinder(lostlagoon.getImage(),"lostlagoon"));

        lostlagoonflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("lostlagoonflooded.png"))));
        tImageList.add(new ImageFinder(lostlagoonflooded.getImage(),"lostlagoonflooded"));

        breakersbridge= new ImageIcon( (Objects.requireNonNull(getClass().getResource("breakersbridge.png"))));
        tImageList.add(new ImageFinder(breakersbridge.getImage(),"breakersbridge"));

        breakersbridgeflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("breakersbridgeflooded.png"))));
        tImageList.add(new ImageFinder(breakersbridgeflooded.getImage(),"breakersbridgeflooded"));

        observatoryflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("observatoryflooded.png"))));
        tImageList.add(new ImageFinder(observatoryflooded.getImage(),"observatoryflooded"));

        observatory= new ImageIcon( (Objects.requireNonNull(getClass().getResource("observatory.png"))));
        tImageList.add(new ImageFinder(observatory.getImage(),"observatory"));

        phantomrock= new ImageIcon( (Objects.requireNonNull(getClass().getResource("phantomrock.png"))));
        tImageList.add(new ImageFinder(phantomrock.getImage(),"phantomrock"));

        phantomrockflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("phantomrockflooded.png"))));
        tImageList.add(new ImageFinder(phantomrockflooded.getImage(),"phantomrockflooded"));

        crimsonforest= new ImageIcon( (Objects.requireNonNull(getClass().getResource("crimsonforest.png"))));
        tImageList.add(new ImageFinder(crimsonforest.getImage(),"crimsonforest"));

        crimsonforestflooded= new ImageIcon( (Objects.requireNonNull(getClass().getResource("crimsonforestflooded.png"))));
        tImageList.add(new ImageFinder(crimsonforestflooded.getImage(),"crimsonforestflooded"));

        thecrystaloffire= new ImageIcon( (Objects.requireNonNull(getClass().getResource("thecrystaloffire.png"))));
        cImageList.add(new ImageFinder(thecrystaloffire.getImage(),"thecrystaloffire"));

        theearthstone= new ImageIcon( (Objects.requireNonNull(getClass().getResource("theearthstone.png"))));
        cImageList.add(new ImageFinder(theearthstone.getImage(),"theearthstone"));

        helicopterlift= new ImageIcon( (Objects.requireNonNull(getClass().getResource("helicopterlift.png"))));
        cImageList.add(new ImageFinder(helicopterlift.getImage(),"helicopterlift"));


        theoceanschalice= new ImageIcon( (Objects.requireNonNull(getClass().getResource("theocean'schalice.png"))));
        cImageList.add(new ImageFinder(theoceanschalice.getImage(),"theoceanschalice"));

        thestatueofthewind= new ImageIcon( (Objects.requireNonNull(getClass().getResource("thestatueofthewind.png"))));
        cImageList.add(new ImageFinder(thestatueofthewind.getImage(),"thestatueofthewind"));

        sandbagCard= new ImageIcon( (Objects.requireNonNull(getClass().getResource("sandbagCard.png"))));
        cImageList.add(new ImageFinder(sandbagCard.getImage(),"sandbagCard"));


        explorer= new ImageIcon( (Objects.requireNonNull(getClass().getResource("explorer.png"))));
        pImageList.add(new ImageFinder(explorer.getImage(),"explorer"));

        navigator= new ImageIcon( (Objects.requireNonNull(getClass().getResource("navigator.png"))));
        pImageList.add(new ImageFinder(navigator.getImage(),"navigator"));

        engineer= new ImageIcon( (Objects.requireNonNull(getClass().getResource("engineer.png"))));
        pImageList.add(new ImageFinder(engineer.getImage(),"engineer"));

        pilot= new ImageIcon( (Objects.requireNonNull(getClass().getResource("bluepilot.PNG"))));
        pImageList.add(new ImageFinder(pilot.getImage(),"pilot"));

        diver= new ImageIcon( (Objects.requireNonNull(getClass().getResource("diver.png"))));
        pImageList.add(new ImageFinder(diver.getImage(),"diver"));

        messenger= new ImageIcon( (Objects.requireNonNull(getClass().getResource("messenger.png"))));
        pImageList.add(new ImageFinder(messenger.getImage(),"messenger"));


    }

    public void getEachPlayer(){
        int numOfPlayers= players.size();
            playerOne=players.get(0);
            playerTwo=players.get(1);
        if(numOfPlayers>2){
            playerThree=players.get(2);
            if(numOfPlayers>3){
                playerFour=players.get(3);
            }
            else{
                playerFour=null;
            }
        }
        else{
            playerThree=null;
            playerFour=null;
        }
    }

    public ArrayList<TreasureCard> getPlayerCards(Player p){
        return p.getInventory();
    }

    public int getWaterMeter(){
        return watermeter.getMeter();
    }


    public void paint(Graphics g) {
        try {
            drawCard(g);
        }
        catch(Exception E) {
            System.out.println(E.getMessage());//"Exception Error Main Panel");
            return;
        }
    }
    private void drawCard(Graphics g) {

        g.drawImage(background.getImage(),0,0,1100,675,null);
        g.setColor(Color.lightGray);
        g.setFont(new Font("Dialog", 1, 15));

        //player 1

        String role= playerOne.getName();
        if(role.equals("Explorer")){
            g.setColor(Color.green);
            g.fillRect(10,10,330,120);
        }
        else if(role.equals("Navigator")){
            g.setColor(Color.yellow);
            g.fillRect(10,10,330,120);
        }
        else if(role.equals("Pilot")){
            g.setColor(Color.blue);
            g.fillRect(10,10,330,120);
        }
        else if(role.equals("Engineer")){
            g.setColor(Color.red);
            g.fillRect(10,10,330,120);
        }
        else if(role.equals("Diver")){
            g.setColor(Color.lightGray);
            g.fillRect(10,10,330,120);
        }
        else if(role.equals("Messenger")){
            g.setColor(Color.white);
            g.fillRect(10,10,330,120);
        }
        g.setColor(Color.black);
        g.drawRect(10,110,330,20);
        g.drawString(role,150,125);


        ArrayList<TreasureCard> list= playerOne.getInventory();
        int xValue= 15;
        for(TreasureCard c: list){
            String name= c.getName();
            name=name.toLowerCase();
            name= name.replaceAll("\\s", "");
            name= name.replaceAll("’", "");
            name= name.replaceAll("'", "");
            if(name.equals("sandbag")){
                name+="Card";
            }
            Image rand= findImageCard(name);
            g.drawImage(rand,xValue,15,60,85,null);
            g.setFont(new Font("Dialog", 1, 5));
            g.drawString(c.getName(),xValue,115);
            g.setFont(new Font("Dialog", 1, 10));
            xValue+=65;

        }

        g.drawRect(15,15,60,85);
        g.drawRect(80,15,60,85);
        g.drawRect(145,15,60,85);
        g.drawRect(210,15,60,85);
        g.drawRect(275,15,60,85);

        g.setColor(Color.lightGray);

        //player 2
        role=playerTwo.getName();
        if(role.equals("Explorer")){
            g.setColor(Color.green);
            g.fillRect(10,500,330,120);
        }
        else if(role.equals("Navigator")){
            g.setColor(Color.yellow);
            g.fillRect(10,500,330,120);
        }
        else if(role.equals("Pilot")){
            g.setColor(Color.blue);
            g.fillRect(10,500,330,120);
        }
        else if(role.equals("Engineer")){
            g.setColor(Color.red);
            g.fillRect(10,500,330,120);
        }
        else if(role.equals("Diver")){
            g.setColor(Color.lightGray);
            g.fillRect(10,500,330,120);
        }
        else if(role.equals("Messenger")){
            g.setColor(Color.white);
            g.fillRect(10,500,330,120);
        }

        g.setColor(Color.black);
        g.drawRect(10,600,330,20);
        g.drawString(role,150,615);

        list= playerTwo.getInventory();
        xValue= 15;
        for(TreasureCard c: list){
            String name= c.getName();
            name=name.toLowerCase();
            name= name.replaceAll("\\s", "");
            name= name.replaceAll("’", "");
            name= name.replaceAll("'", "");
            if(name.equals("sandbag")){
                name+="Card";
            }

            Image rand= findImageCard(name);


            g.drawImage(rand,xValue,510,60,85,null);
            g.setFont(new Font("Dialog", 1, 5));
            g.drawString(c.getName(),xValue,610);
            g.setFont(new Font("Dialog", 1, 10));
            xValue+=65;
        }
        g.drawRect(15,510,60,85);
        g.drawRect(80,510,60,85);
        g.drawRect(145,510,60,85);
        g.drawRect(210,510,60,85);
        g.drawRect(275,510,60,85);

        g.setColor(Color.lightGray);

        //player 3
        if(playerThree!=null) {
            role=playerThree.getName();
            if(role.equals("Explorer")){
                g.setColor(Color.green);
                g.fillRect(750, 10, 330, 120);
            }
            else if(role.equals("Navigator")){
                g.setColor(Color.yellow);
                g.fillRect(750, 10, 330, 120);
            }
            else if(role.equals("Pilot")){
                g.setColor(Color.blue);
                g.fillRect(750, 10, 330, 120);
            }
            else if(role.equals("Engineer")){
                g.setColor(Color.red);
                g.fillRect(750, 10, 330, 120);
            }
            else if(role.equals("Diver")){
                g.setColor(Color.lightGray);
                g.fillRect(750, 10, 330, 120);
            }
            else if(role.equals("Messenger")){
                g.setColor(Color.white);
                g.fillRect(750, 10, 330, 120);
            }
            g.setColor(Color.black);
            g.drawRect(750,110,330,20);

             list= playerThree.getInventory();
             xValue= 755;
            for(TreasureCard c: list){
                String name= c.getName();
                name=name.toLowerCase();
                name= name.replaceAll("\\s", "");
                name= name.replaceAll("’", "");
                name= name.replaceAll("'", "");
                if(name.equals("sandbag")){
                    name+="Card";
                }
                Image rand= findImageCard(name);
                g.drawImage(rand,xValue,15,60,85,null);
                g.setFont(new Font("Dialog", 1, 5));
                g.drawString(c.getName(),xValue,115);
                g.setFont(new Font("Dialog", 1, 10));
                xValue+=65;
            }

            g.drawRect(755,15,60,85);
            g.drawRect(820,15,60,85);
            g.drawRect(885,15,60,85);
            g.drawRect(950,15,60,85);
            g.drawRect(1015,15,60,85);

            role = playerThree.getName();
            g.drawString(role, 880, 125);
        }
        else {
            g.fillRect(750, 10, 330, 120);
        }


        g.setColor(Color.lightGray);

        //player 4

        if(playerFour!=null) {
            role = playerFour.getName();
            if(role.equals("Explorer")){
                g.setColor(Color.green);
                g.fillRect(750,500,330,120);
            }
            else if(role.equals("Navigator")){
                g.setColor(Color.yellow);
                g.fillRect(750,500,330,120);
            }
            else if(role.equals("Pilot")){
                g.setColor(Color.blue);
                g.fillRect(750,500,330,120);
            }
            else if(role.equals("Engineer")){
                g.setColor(Color.red);
                g.fillRect(750,500,330,120);
            }
            else if(role.equals("Diver")){
                g.setColor(Color.lightGray);
                g.fillRect(750,500,330,120);
            }
            else if(role.equals("Messenger")){
                g.setColor(Color.white);
                g.fillRect(750,500,330,120);
            }
            g.setColor(Color.black);
            list= playerThree.getInventory();
            xValue= 755;
            for(TreasureCard c: list){
                String name= c.getName();
                name=name.toLowerCase();
                name= name.replaceAll("\\s", "");
                name= name.replaceAll("’", "");
                name= name.replaceAll("'", "");
                if(name.equals("sandbag")){
                    name+="Card";
                }
                Image rand= findImageCard(name);
                g.drawImage(rand,xValue,510,60,85,null);
                g.setFont(new Font("Dialog", 1, 5));
                g.drawString(c.getName(),xValue,610);
                g.setFont(new Font("Dialog", 1, 10));
                xValue+=65;
            }


            g.drawRect(755,510,60,85);
            g.drawRect(820,510,60,85);
            g.drawRect(885,510,60,85);
            g.drawRect(950,510,60,85);
            g.drawRect(1015,510,60,85);


            g.drawString(role, 880, 615);
            g.drawRect(750, 600, 330, 20);
        }else{
            g.fillRect(750,500,330,120);
            g.setColor(Color.black);
        }


        g.setFont(new Font("Dialog", 1, 10));

        // rect outlines
        g.drawRect(10,10,330,120);
        g.drawRect(10,500,330,120);
        g.drawRect(750,10,330,120);
        g.drawRect(750,500,330,120);

        //flood and treasure card icons
        g.drawImage(fImage.getImage(),10,140,200,75, null);
        g.drawImage(fDImage.getImage(),10,230,200,75, null);
        g.drawImage(tImage.getImage(),10,320,200,75, null);
        g.drawImage(tDImage.getImage(),10,410,200,75, null);


        //actions left
        g.drawRect(765,150, 150, 40);
        g.setFont(new Font("Dialog", 1, 20));
        int aL= currentPlayer.getActionsRemain();
        g.drawString("Actions Left: "+aL,768, 180);

        //current player
        g.drawRect(920,150, 150, 40);
        g.setFont(new Font("Dialog", 1, 12));
        g.drawString("Current Player:",925, 165);
        g.setFont(new Font("Dialog", 1, 18));
        g.drawString(currentPlayer.getName(), 945, 183);

        //specific actions
        g.setColor(Color.lightGray);
        g.fillRect(840, 200, 150, 275);
        g.setColor(Color.black);
        g.drawRect(840, 200, 150, 275);

        g.drawString("Actions List:",850,220);
        g.setFont(new Font("Dialog", 1, 16));
        g.drawString("1: Move Up", 840, 245);
        g.drawString("2: Shore Up", 840, 270);
        g.drawString("3: Give Treasure", 840, 295);
        g.drawString("4) Capture", 840, 320);
        g.drawString("Treasure", 840, 340);
        g.setFont(new Font("Dialog", 1, 18));



        String name= currentPlayer.getName();
        g.drawString("Special Actions", 840, 365);
        g.setFont(new Font("Dialog", 1, 15));
        if(name=="Diver"){
            g.drawString("A) Dive through 1", 840, 385);
            g.drawString("or more adjacent", 840, 405);
            g.drawString("flooded or missing", 840, 425);
            g.drawString("tile for one action", 840, 445);
            g.drawString("B) N/A", 840, 465);
        }
        if(name=="Engineer"){
            g.drawString("A) Shore up 2", 840, 385);
            g.drawString("tiles for one", 840, 405);
            g.drawString("action", 840, 425);
            g.drawString("B) N/A", 840, 445);
        }
        if(name=="Explorer"){
            g.drawString("A) Move diagonally", 840, 385);
            g.drawString("B) Shore up", 840, 405);
            g.drawString("diagonally", 840, 425);
        }
        if(name=="Messenger"){
            g.drawString("A) Give Treasure", 840, 385);
            g.drawString("cards to a player", 840, 405);
            g.drawString("anywhere on the", 840, 425);
            g.drawString("island for one action", 840, 445);
            g.drawString("B) N/A", 840, 465);
        }
        if(name=="Navigator"){
            g.drawString("A) Move another", 840, 385);
            g.drawString("player up to 2", 840, 405);
            g.drawString("adjacent tiles for", 840, 425);
            g.drawString("one action", 840, 445);
            g.drawString("B) N/A", 840, 465);
        }
        if(name=="Pilot"){
            g.drawString("A) ONCE PER TURN:", 840, 385);
            g.drawString("Fly to any tile on", 840, 405);
            g.drawString("the island", 840, 425);
            g.drawString("for one action", 840, 445);
            g.drawString("B) N/A", 840, 465);
        }

        //watermeter
        g.drawImage(waterMeterImage.getImage(),1000, 200, 85, 275,null);
        int numWM= watermeter.getMeter();
        if(numWM==1){
            g.drawImage(waterMarker.getImage(), 1000,430,200,5,null);
        }
        if(numWM==2){
            g.drawImage(waterMarker.getImage(), 1000,405,200,5,null);
        }
        if(numWM==3){
            g.drawImage(waterMarker.getImage(), 1000,383,200,5,null);
        }
        if(numWM==4){
            g.drawImage(waterMarker.getImage(), 1000,360,200,5,null);
        }
        if(numWM==5){
            g.drawImage(waterMarker.getImage(), 1000,340,200,5,null);
        }
        if(numWM==6){
            g.drawImage(waterMarker.getImage(), 1000,315,200,5,null);
        }
        if(numWM==7){
            g.drawImage(waterMarker.getImage(), 1000,293,200,5,null);
        }
        if(numWM==8){
            g.drawImage(waterMarker.getImage(), 1000,273,200,5,null);
        }
        if(numWM==9){
            g.drawImage(waterMarker.getImage(), 1000,250,200,5,null);
        }
        if(numWM>=10){
            g.drawImage(waterMarker.getImage(), 1000,227,200,5,null);
        }

        //tiles
        //row 1
        if(!treasureStack.windCaptured()) {
            g.drawImage(lionTreasure.getImage(), 360, 30, 80, 80, null);//treasure 1
        }


        //tile1
        IslandTile tileOne= islandmap[0][2];
        String title= tileOne.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileOne.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        Image rand= findImage(title);
        if(!tileOne.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450, 30, 80, 80,null);
        }else{
            g.drawRect(450, 30, 80, 80);
        }




        IslandTile tileTwo= islandmap[0][3];
        title= tileTwo.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileOne.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwo.getFloodedState().equals("sunk")) {

            g.drawImage(rand,540, 30, 80, 80, null);
        }else{
            g.drawRect(540, 30, 80, 80);
        }

        if(!treasureStack.waterCaptured()) {
            g.drawImage(blueTreasure.getImage(), 630, 30, 80, 80, null);//treasure 2
        }

        //row 2
        IslandTile tileThree= islandmap[1][1];
        title= tileThree.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileThree.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileThree.getFloodedState().equals("sunk")) {
            g.drawImage(rand,360,130, 80,80,null);
        }
        else{
            g.drawRect(360,130, 80,80);
        }
        IslandTile tileFour= islandmap[1][2];
        title= tileFour.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileFour.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileFour.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450,130, 80,80,null);
        }else{
            g.drawRect(450,130, 80,80);
        }
        IslandTile tileFive= islandmap[1][3];
        title= tileFive.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileFive.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileFive.getFloodedState().equals("sunk")) {
            g.drawImage(rand,540,130, 80,80,null);
        }else{
            g.drawRect(540,130, 80,80);
        }
        IslandTile tileSix= islandmap[1][4];
        title= tileSix.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileSix.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileSix.getFloodedState().equals("sunk")) {
            g.drawImage(rand,630,130, 80,80,null);
        }else{
            g.drawRect(630,130, 80,80);
        }


        //1st middle row
        IslandTile tileSeven= islandmap[2][0];
        title= tileSeven.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileSeven.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileSeven.getFloodedState().equals("sunk")) {
            g.drawImage(rand,270, 230, 80,80,null);
        }else{
            g.drawRect(270, 230, 80,80);
        }

        IslandTile tileEight= islandmap[2][1];
        title= tileEight.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileEight.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileEight.getFloodedState().equals("sunk")) {
            g.drawImage(rand,360,230, 80,80,null);
        }else{
            g.drawRect(360,230, 80,80);
        }


        IslandTile tileNine= islandmap[2][2];
        title= tileNine.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileNine.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileNine.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450,230, 80,80,null);
        }else{
            g.drawRect(450,230, 80,80);
        }

        IslandTile tileTen= islandmap[2][3];
        title= tileTen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,540,230, 80,80,null);
        }else{
            g.drawRect(540,230, 80,80);
        }

        IslandTile tileEleven= islandmap[2][4];
        title= tileEleven.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileEleven.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileEleven.getFloodedState().equals("sunk")) {
            g.drawImage(rand,630,230, 80,80,null);
        }else{
            g.drawRect(630,230, 80,80);
        }

        IslandTile tileTwelve= islandmap[2][5];
        title= tileTwelve.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwelve.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwelve.getFloodedState().equals("sunk")) {
            g.drawImage(rand,720, 230, 80,80,null);
        }else{
            g.drawRect(720, 230, 80,80);
        }


        //2nd middle row
        IslandTile tileThirteen= islandmap[3][0];
        title= tileThirteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileThirteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileThirteen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,270, 340, 80,80,null);
        }else{
            g.drawRect(270, 340, 80,80);
        }

        IslandTile tileFourteen= islandmap[3][1];
        title= tileFourteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileFourteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileFourteen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,360,340, 80,80,null);
        }else{
            g.drawRect(360,340, 80,80);
        }

        IslandTile tileFifteen= islandmap[3][2];
        title= tileFifteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileFifteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileFifteen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450,340, 80,80,null);
        }else{
            g.drawRect(450,340, 80,80);
        }

        IslandTile tileSixteen= islandmap[3][3];
        title= tileSixteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileSixteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileSixteen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,540,340, 80,80,null);
        }else{
            g.drawRect(540,340, 80,80);
        }
        IslandTile tileSeventeen= islandmap[3][4];
        title= tileSeventeen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileSeventeen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileSeventeen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,630,340, 80,80,null);
        }else{
            g.drawRect(630,340, 80,80);
        }

        IslandTile tileEighteen= islandmap[3][5];
        title= tileEighteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileEighteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileEighteen.getFloodedState().equals("sunk")) {
            g.drawImage(rand,720, 340, 80,80,null);
        }else{
            g.drawRect(720, 340, 80,80);
        }

        //2nd to last row
        IslandTile tileNineteen= islandmap[4][1];
        title= tileNineteen.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileNineteen.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileNineteen.getFloodedState().equals("sunk")){
            g.drawImage(rand,360,440, 80,80,null);
        }else{
            g.drawRect(360,440, 80,80);
        }

        IslandTile tileTwenty= islandmap[4][2];
        title= tileTwenty.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwenty.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwenty.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450,440, 80,80,null);
        }else{
            g.drawRect(450,440, 80,80);
        }

        IslandTile tileTwentyOne= islandmap[4][3];
        title= tileTwentyOne.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwentyOne.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwentyOne.getFloodedState().equals("sunk")) {
            g.drawImage(rand,540,440, 80,80,null);
        }else{
            g.drawRect(540,440, 80,80);
        }

        IslandTile tileTwentyTwo= islandmap[4][4];
        title= tileTwentyTwo.getName();
        title=title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwentyTwo.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwentyTwo.getFloodedState().equals("sunk")) {
            g.drawImage(rand,630,440, 80,80,null);
        }else{
            g.drawRect(630,440, 80,80);
        }


        // last row
        if(!treasureStack.earthCaptured()) {
            g.drawImage(purpleTreasure.getImage(), 360, 540, 80, 80, null);//treasure 3
        }
        IslandTile tileTwentyThree= islandmap[5][2];
        title= tileTwentyThree.getName();
        title= title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwentyThree.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwentyThree.getFloodedState().equals("sunk")) {
            g.drawImage(rand,450, 540, 80, 80,null);
        }else{
            g.drawRect(450,540, 80,80);
        }
        IslandTile tileTwentyFour= islandmap[5][3];
        title= tileTwentyFour.getName();
        title= title.toLowerCase();
        title= title.replaceAll("\\s", "");
        if(tileTwentyFour.getFloodedState().equals("flooded")){
            title+="flooded";
        }
        rand= findImage(title);
        if(!tileTwentyFour.getFloodedState().equals("sunk")) {
            g.drawImage(rand,540,540, 80,80,null);
        }else{
            g.drawRect(540,540, 80,80);
        }
        if(!treasureStack.fireCaptured()) {
            g.drawImage(redTreasure.getImage(), 630, 540, 80, 80, null);//treasure 4
        }

        for(Player p:players){
            Coordinate co= p.getCoordinate();
            String plName= p.getName();
            plName= plName.toLowerCase();
            Image r= findPlayerImage(plName);
            int XV= 270+90*co.getC()-5; //c
            int YV= 30+100*co.getR()-10; //r
            if(YV>3){
                YV+=10;
            }
            g.drawImage(r,XV,YV,50,50,null);
            repaint();

        }


    }
    public Image findPlayerImage(String n){
        for(ImageFinder k: pImageList){
            if(k.getName().equals(n)){
                return k.getImage();
            }
            if(k.getName().equals("theocean’schalice")){
                return theoceanschalice.getImage();
            }
        }
        return background.getImage();
    }
    public Image findImage(String n) {
        for (ImageFinder k : tImageList) {
            if (k.getName().equals(n)) {
                return k.getImage();
            } else if (n.equals("fool’slanding")) {
                return foolslanding.getImage();
            } else if (n.equals("fool’slandingflooded")) {
                return foolslaningflooded.getImage();
            }
        }
        return waterMarker.getImage();
    }

    public Image findImageCard(String n){
        for (ImageFinder k : cImageList) {
            if (k.getName().equals(n)) {
                return k.getImage();
            }
            if(n.equals("theoceanschalice")){
                return theoceanschalice.getImage();
            }
            if(n.equals("theocean’schalice")) {
                return theoceanschalice.getImage();
            }
            if(n.equals("thestatueofthewind")){
                return thestatueofthewind.getImage();
            }
        }
        return waterMarker.getImage();
    }


    //waters rise, change player icon for multiple ones

}


