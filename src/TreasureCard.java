public class TreasureCard {
    private String name;
    private String specialAction = "";//null, helicopterLift, watersRise, sandbag

    public TreasureCard(String n) {
        name = n;
    }

    public TreasureCard(String n, String specialAction) {
        name = n;
        this.specialAction = specialAction;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialAction() {
        return specialAction;
    }
    public void setSpecialAction(String specialAction) {
        this.specialAction = specialAction;
    }
    public boolean isHelicopterLift(){
        return specialAction.equals("helicopterLift");
    }
    public boolean isSandBag(){
        return specialAction.equals("sandbag");
    }
    public boolean isWatersRise(){
        return specialAction.equals("watersRise");
    }
}
