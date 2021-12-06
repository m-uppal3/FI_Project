public class Diver extends Player {
    public Diver(String name) {
        super(name);
    }

    public void diveLeft() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r, c - 2));
        useAction();
    }

    public void diveRight() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r, c + 2));
        useAction();
    }

    public void diveUp() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r - 2, c));
        useAction();
    }

    public void diveDown() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r + 2, c));
        useAction();
    }

    @Override
    public boolean isDiver() {
        return true;
    }
}
