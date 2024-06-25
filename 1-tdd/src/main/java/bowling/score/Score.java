package bowling.score;

import bowling.frames.frame.Frame;
import bowling.frames.frame.FramesSet;

public class Score {
    public static final int INITIAL_POINTS = 0;
    private int score = INITIAL_POINTS;
    final FramesSet gameFramesSet;

    public Score(FramesSet gameFramesSet) {
        this.gameFramesSet = gameFramesSet;
    }

    public int getTotalScore(){
        for (Frame frame : gameFramesSet) {
            score += frame.score();
        }
        return score;
    }
}
