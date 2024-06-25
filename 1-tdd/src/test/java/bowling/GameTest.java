package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    public void testNewBowlingGame_hasZeroPoints() {
        assertEquals(0, game.score());
    }

    @Test
    public void testOneRoll_WithZeroSpinsDemolished() {
        game.roll(0);

        assertEquals(0, game.score());
    }

    @Test
    public void testOneRoll_WithXSpinsDemolished() {
        game.roll(7);

        assertEquals(7, game.score());
    }

    @Test
    public void testBadGame() {
        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17,0);

        assertEquals(16, game.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16,0);

        assertEquals(24, game.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12,10);

        assertEquals(300, game.score());
    }

    @Test
    public void testScoreCalculation_WithSingleSpare() {
        rollSpare();
        rollMany(18,0);

        assertEquals(10, game.score());
    }

    @Test
    public void testScoreCalculation_WithRollAfterSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17,0);

        assertEquals(16, game.score());
    }

    @Test
    public void testScoreCalculation_WithMultipleSpares() {
        rollSpare();
        rollSpare();
        rollMany(16,0);

        assertEquals(25, game.score());
    }

    @Test
    public void testScoreCalculation_WithMixedRolls() {
        rollSpare();
        game.roll(3);
        rollStrike();
        rollMany(16,0);

        assertEquals(26, game.score());
    }

    @Test
    public void testScoreCalculation_WithStrikeInLastFrame() {
        rollMany(18, 0);
        rollStrike();
        game.roll(3);
        game.roll(4);

        assertEquals(17, game.score());
    }

    @Test
    public void testScoreCalculation_WithSpareInLastFrame() {
        rollMany(18, 0);
        rollSpare();
        game.roll(3);

        assertEquals(13, game.score());
    }

    @Test
    public void testScoreCalculation_WithPartialScore() {
        game.roll(3);
        game.roll(5);
        game.roll(1);

        assertEquals(9, game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }
}
