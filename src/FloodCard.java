public class FloodCard {
    private String name;
    private Coordinate coordinate;

    public FloodCard(String name){
        this.name = name;
    }

    public FloodCard(String name, Coordinate c){
        this.name = name;
        coordinate = c;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setName(String name) {
        this.name = name;
    }


}
