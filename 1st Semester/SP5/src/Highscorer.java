public class Highscorer {
    private String player;
    private int score;
    private int time;

    public Highscorer(String player, int score, int time) {
        this.player = player;
        this.score = score;
        this.time = time;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }
}
