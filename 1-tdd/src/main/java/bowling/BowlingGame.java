package bowling;

public class BowlingGame {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Rolling 20 times with 2 pins each");
        for (int i = 0; i < 20; i++) {
            game.roll(2);
        }
        System.out.println("Score: ");
        System.out.println(game.score());
    }
}
