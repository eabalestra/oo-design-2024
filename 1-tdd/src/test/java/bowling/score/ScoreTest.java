package bowling.score;

import bowling.frames.frame.FramesSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    private static Stream<Arguments> provideRollsAndScores() {
        return Stream.of(
                Arguments.of(List.of(5, 4, 3, 6, 7, 2), (5+4) + (3+6) + (7+2)),
                Arguments.of(List.of(1, 1, 2, 2, 3, 3), (1+1) + (2+2) + (3+3)),
                Arguments.of(List.of(0, 0, 0, 0, 0, 0), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideRollsAndScores")
    public void testGetTotalScore(List<Integer> rolls, int expectedScore) {
        FramesSet gameFrames = new FramesSet();
        rolls.forEach(gameFrames::addRoll);
        Score score = new Score(gameFrames);
        assertEquals(expectedScore, score.getTotalScore());
    }
}