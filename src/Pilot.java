public class Pilot extends Player {
    public Pilot(String pilot) {
        super(pilot);
    }

    public void flyToLocation(int r, int c) {
        setCoordinate(new Coordinate(r, c));
        useAction();
    }

    @Override
    public boolean isPilot() {
        return true;
    }
}
