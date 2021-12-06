public class Treasure {
    private String name;
    private boolean isCaptured = false;

    public Treasure(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getIsCaptured(){
        return isCaptured;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }
}
