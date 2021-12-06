import java.util.Objects;

public class IslandTile {
    private String floodedState = "dry"; //dry, flooded, sunk
    private String name;
    private Coordinate coordinate;
    private String specialState = "";//null, playerSpawn, treasureLocation, fool's landing

    public IslandTile(String name, String specialState){
        this.name = name;
        this.specialState = specialState;
    }

    public IslandTile(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFloodedState() {
        return floodedState;
    }

    public String getSpecialState() {
        return specialState;
    }

    public void setFloodedState(String floodedState) {
        this.floodedState = floodedState;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IslandTile)) return false;
        IslandTile that = (IslandTile) o;
        return Objects.equals(getFloodedState(), that.getFloodedState()) && Objects.equals(getName(), that.getName()) && Objects.equals(getCoordinate(), that.getCoordinate()) && Objects.equals(specialState, that.specialState);
    }

    public void setCoordinate(int r, int c) {
        coordinate = new Coordinate(r, c);
    }

    public void shoreup(){
        if(floodedState.equals("flooded")){
            floodedState = "dry";
        }
    }
    public boolean isSunk(){
        return floodedState.equals("sunk");
    }
}
