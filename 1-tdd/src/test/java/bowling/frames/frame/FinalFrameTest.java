package bowling.frames.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinalFrameTest {
    FinalFrame frame;

    @BeforeEach
    protected void setUp() {
        frame = new FinalFrame();
    }

    @Test
    public void testRoll() {
        frame.roll(5);

        assertEquals(5, frame.firstRollScore());
    }

    @Test
    public void testIsCompleted() {
        frame.roll(5);
        frame.roll(5);
        frame.roll(5);

        assertTrue(frame.isCompleted());
    }

    @Test
    public void testIsStrike() {
        frame.roll(10);

        assertTrue(frame.isStrike());
    }

    @Test
    public void testIsSpare() {
        frame.roll(5);
        frame.roll(5);

        assertTrue(frame.isSpare());
    }

    @Test
    public void testScore() {
        frame.roll(5);
        frame.roll(5);
        frame.roll(5);

        assertEquals(15, frame.score());
    }

    @Test
    public void testCalculateBaseScore() {
        frame.roll(5);
        frame.roll(5);

        assertEquals(10, frame.calculateBaseScore());
    }

    @Test
    public void testRollsNotAllowed() {
        frame.roll(5);
        frame.roll(5);
        frame.roll(5);

        assertThrows(IllegalStateException.class, () -> frame.roll(5));
    }
}