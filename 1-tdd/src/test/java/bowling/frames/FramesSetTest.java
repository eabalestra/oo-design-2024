package bowling.frames;

import bowling.frames.frame.FramesSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FramesSetTest {
    private FramesSet frames;

    @BeforeEach
    protected void setUp() {
        frames = new FramesSet();
    }

    @Test
    public void testAddRoll() {
        rollMany(frames, 20);

        assertEquals(10, frames.size());
    }

    @Test
    public void testGameOverException() {
        rollMany(frames, 21);

        assertThrows(IllegalStateException.class, () -> frames.addRoll(5));
    }

    private static void rollMany(FramesSet gameFrames, int rolls) {
        for (int i = 0; i < rolls; i++) {
            gameFrames.addRoll(5);
        }
    }

}
