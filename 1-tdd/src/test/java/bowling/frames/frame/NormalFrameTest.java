package bowling.frames.frame;

import bowling.frames.NormalFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NormalFrameTest {
    private Frame frame;

    @BeforeEach
    public void setUp() {
        frame = new NormalFrame();
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
        frame.roll(3);

        assertEquals(8, frame.score());
    }

    @Test
    public void testSetNextFrame() {
        Frame frame2 = new NormalFrame();
        frame.setNextFrame(frame2);
        frame.roll(10);
        frame2.roll(5);

        assertEquals(15, frame.score());
    }

    @Test
    public void testRollsNotAllowed() {
        frame.roll(5);
        frame.roll(5);

        assertThrows(IllegalStateException.class, () -> frame.roll(5));
    }

}