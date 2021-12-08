import java.util.ArrayList;
import java.util.Collections;

public class IslandMap {
    private final IslandTile[][] islandMap = new IslandTile[6][6];
    private final ArrayList<IslandTile> islandTiles = new ArrayList<>();

    public IslandMap() {
        islandTiles.add(new IslandTile("Tidal Palace", "Water"));
        islandTiles.add(new IslandTile("Coral Palace", "Water"));
        islandTiles.add(new IslandTile("Temple of the Sun", "Earth"));
        islandTiles.add(new IslandTile("Temple of the Moon", "Earth"));
        islandTiles.add(new IslandTile("Cave of Shadows", "Fire"));
        islandTiles.add(new IslandTile("Cave of Embers", "Fire"));
        islandTiles.add(new IslandTile("Howling Garden", "Wind"));
        islandTiles.add(new IslandTile("Whispering Garden", "Wind"));
        islandTiles.add(new IslandTile("Bronze Gate", "Engineer"));
        islandTiles.add(new IslandTile("Gold Gate", "Navigator"));
        islandTiles.add(new IslandTile("Copper Gate", "Explorer"));
        islandTiles.add(new IslandTile("Silver Gate", "Messenger"));
        islandTiles.add(new IslandTile("Fool’s Landing", "Pilot"));
        islandTiles.add(new IslandTile("Iron Gate", "Diver"));

        String temp = "Dunes of Deception, Cities of Abandon, Watchtower, Twilight Hollow, Misty Marsh, Lost Lagoon, Breakers Bridge, Observatory, Phantom Rock, Crimson Forest";
        String[] tempArray = temp.split(", ");
        for (String s : tempArray) {
            islandTiles.add(new IslandTile(s));
        }

        Collections.shuffle(islandTiles);

        for (int r = 0; r < 6; r++) {
            if (r == 0 || r == 5) {
                for (int c = 2; c <= 3; c++) {
                    IslandTile t = islandTiles.remove(0);
                    t.setCoordinate(r, c);
                    islandMap[r][c] = t;
                }
            } else if (r == 1 || r == 4) {
                for (int c = 1; c <= 4; c++) {
                    IslandTile t = islandTiles.remove(0);
                    t.setCoordinate(r, c);
                    islandMap[r][c] = t;
                }
            } else {
                for (int c = 0; c <= 5; c++) {
                    IslandTile t = islandTiles.remove(0);
                    t.setCoordinate(r, c);
                    islandMap[r][c] = t;
                }
            }

        }//creates island


    }

    public void floodTile(FloodCard f) {
        int r = f.getCoordinate().getR();
        int c = f.getCoordinate().getC();
        if (islandMap[r][c].getFloodedState().equals("flooded")) {
            islandMap[r][c].setFloodedState("sunk");
            islandTiles.remove(getIslandTileIndexArrayList(islandMap[r][c]));
        } else if (islandMap[r][c].getFloodedState().equals("dry")) {
            islandMap[r][c].setFloodedState("flooded");
        }

    }

    public boolean shoreupTile(Coordinate coord) {
        int r = coord.getR();
        int c = coord.getC();

        switch (islandMap[r][c].getFloodedState()) {
            case "flooded":
                islandMap[r][c].setFloodedState("dry");
                return true;
            case "sunk":
            case "dry":
                return false;
        }
        return false;
    }

    public Coordinate getIslandTileIndexMatrix(IslandTile tile) {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (islandMap[r][c].equals(tile)) {
                    return new Coordinate(r, c);
                }
            }
        }
        return new Coordinate(-1, -1);
    }//for the 2D matrix

    public int getIslandTileIndexArrayList(IslandTile tile) {
        for (int i = 0; i < islandTiles.size(); i++) {
            if (islandTiles.get(i).equals(tile)) {
                return i;
            }
        }
        return -1;
    }//for the array

    //losing conditions
    public boolean allWaterSunk() {
        return !islandTiles.contains(new IslandTile("Tidal Palace", "Water")) &&
                !islandTiles.contains(new IslandTile("Coral Palace", "Water"));
    }

    public boolean allEarthSunk() {
        return !islandTiles.contains(new IslandTile("Temple of the Sun", "Earth")) &&
                !islandTiles.contains(new IslandTile("Temple of the Moon", "Earth"));
    }

    public boolean allFireSunk() {
        return !islandTiles.contains(new IslandTile("Cave of Shadows", "Fire")) &&
                !islandTiles.contains(new IslandTile("Cave of Embers", "Fire"));
    }

    public boolean allWindSunk() {
        return !islandTiles.contains(new IslandTile("Howling Garden", "Wind")) &&
                !islandTiles.contains(new IslandTile("Whispering Garden", "Wind"));
    }

    public boolean foolsLandingSunk() {
        return !islandTiles.contains(new IslandTile("Fool’s Landing", "Pilot"));
    }

    //checking conditions
    public boolean hasUp(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return !(islandMap[r - 1][c] == null);
    }

    public boolean hasDown(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r + 1][c] != null;
    }

    public boolean hasLeft(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r][c - 1] != (null);
    }

    public boolean hasRight(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return !(islandMap[r][c + 1] == (null));
    }

    //Diver conditions
    public boolean hasUpUp(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return !(islandMap[r - 2][c] == (null)) && (islandMap[r - 1][c].getSpecialState().equals("flooded") ||
                islandMap[r - 1][c].getSpecialState().equals("sunk"));
    }

    public boolean hasDownDown(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r + 2][c] != null && !(islandMap[r - 2][c] == (null)) && (islandMap[r + 1][c].getSpecialState().equals("flooded") ||
                islandMap[r + 1][c].getSpecialState().equals("sunk"));
    }

    public boolean hasRightRight(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r][c + 2] != null && (islandMap[r][c + 1].getSpecialState().equals("flooded") ||
                islandMap[r][c + 1].getSpecialState().equals("sunk"));
    }

    public boolean hasLeftLeft(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r][c - 2] != null && (islandMap[r][c - 1].getSpecialState().equals("flooded") ||
                islandMap[r][c - 1].getSpecialState().equals("sunk"));
    }

    //Explorers conditions
    public boolean hasUpLeft(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r - 1][c - 1] != null;
    }

    public boolean hasUpRight(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r - 1][c + 1] != null;
    }

    public boolean hasDownLeft(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r + 1][c - 1] != null;
    }

    public boolean hasDownRight(IslandTile tile) {
        Coordinate coord = tile.getCoordinate();
        int r = coord.getR();
        int c = coord.getC();
        return islandMap[r + 1][c + 1] != null;
    }

    public IslandTile getTile(String name){
        for(int r = 0; r < 6; r++){
            for(int c = 0; c < 6; c++){
                if(islandMap[r][c] != null){
                    if(islandMap[r][c].getName().equals(name)){
                        return islandMap[r][c];
                    }
                }
            }
        }
        return null;
    }

    public IslandTile getTile(Coordinate coord) {
        return islandMap[coord.getR()][coord.getC()];
    }

    public IslandTile getTile(int r, int c) {
        return islandMap[r][c];
    }

    public ArrayList<IslandTile> getIslandTiles() {
        return islandTiles;
    }

    public IslandTile[][] getIslandMap() {
        return islandMap;
    }

}
