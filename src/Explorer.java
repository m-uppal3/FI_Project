public class Explorer extends Player {
    public Explorer(String name) {
        super(name);
    }

    public void moveLeftUp() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r - 1, c - 1));
        useAction();
    }

    public void moveRightUp() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r - 1, c + 1));
        useAction();
    }

    public void moveDownLeft() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r + 1, c - 1));
        useAction();
    }

    public void moveDownRight() {
        Coordinate coordinate = super.getCoordinate();
        int r = coordinate.getR();
        int c = coordinate.getC();
        super.setCoordinate(new Coordinate(r + 1, c + 1));
        useAction();
    }

    @Override
    public boolean isExplorer() {
        return true;
    }
}
