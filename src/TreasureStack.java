import java.util.ArrayList;

public class TreasureStack {
    private ArrayList<Treasure> treasureStack = new ArrayList<>();
    private ArrayList<Treasure> capturedTreasure =  new ArrayList<>();

    public TreasureStack(){
        treasureStack.add(new Treasure("The Earth Stone"));
        treasureStack.add(new Treasure("The Statue of the Wind"));
        treasureStack.add(new Treasure("The Crystal of Fire"));
        treasureStack.add(new Treasure("The Ocean's Chalice"));
    }

    public boolean allTreasuresCaptured(){
        for(Treasure t: treasureStack){
            if(!t.getIsCaptured()){
                return false;
            }
        }
        return true;
    }

    public void captureEarth(){
        treasureStack.get(0).setCaptured(true);
    }
    public void captureWind(){
        treasureStack.get(1).setCaptured(true);
    }
    public void captureFire(){
        treasureStack.get(2).setCaptured(true);
    }
    public void captureWater(){
        treasureStack.get(3).setCaptured(true);
    }

    public boolean earthCaptured(){return treasureStack.get(0).getIsCaptured();}
    public boolean windCaptured(){return treasureStack.get(1).getIsCaptured();}
    public boolean fireCaptured(){return treasureStack.get(2).getIsCaptured();}
    public boolean waterCaptured(){return treasureStack.get(3).getIsCaptured();}





}
