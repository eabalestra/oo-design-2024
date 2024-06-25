package bowling;

import bowling.frames.frame.FramesSet;
import bowling.score.Score;

public class Game {
    final FramesSet frames;
    final Score score;

    public Game() {
        this.frames = new FramesSet();
        this.score = new Score(frames);
    }

    public void roll(int pins) {
        frames.addRoll(pins);
    }

    public int score() {
        return score.getTotalScore();
    }
}
