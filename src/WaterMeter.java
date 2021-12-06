public class WaterMeter {
    public static int numFloodCards = 2;
    private String difficulty = "Novice";
    public static int meter = 1;

    public WaterMeter() {
    }

    public WaterMeter(String difficulty) {
        this.difficulty = difficulty.toLowerCase();
        switch (this.difficulty) {
            case "novice":
                break;
            case "normal":
                meter = 2;
                break;
            case "elite":
                meter = 3;
                break;
            case "legendary":
                meter = 4;
                break;
        }
    }

    public void watersRise() {
        meter++;
        if (meter >= 8) {
            numFloodCards = 5;
        } else if (meter >= 6) {
            numFloodCards = 4;
        } else if (meter >= 3) {
            numFloodCards = 3;
        } else {
            numFloodCards = 2;
        }
    }

    public boolean loseGame() {
        return !(meter >= 10);
    }

    public int getMeter() {
        return meter;
    }

    public int getNumFloodCards() {
        return numFloodCards;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
