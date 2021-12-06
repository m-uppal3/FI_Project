import java.util.Objects;

public class Coordinate {
    private int r, c;
    public Coordinate(){
    }
    public Coordinate(int r, int c){
        this.r = r;
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }

    public void incrementR(){
        r++;
    }
    public void incrementC(){
        c++;
    }
    public void decrementR(){
        r--;
    }
    public void decrementC(){
        c--;
    }
    public void setC(int c) {
        this.c = c;
    }
    public void setR(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return r == that.r && c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }
}
