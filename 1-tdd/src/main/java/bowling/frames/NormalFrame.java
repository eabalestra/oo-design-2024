package bowling.frames;

import bowling.frames.frame.Frame;
import bowling.roll.Roll;

public class NormalFrame extends Frame {

    @Override
    public boolean isCompleted() {
        return currentRoll == MAX_ROLLS || this.isStrike();
    }

    @Override
    public void roll(int pins) {
        checkRollsAllowed();
        addRoll(pins);
        handleStrike();
        currentRoll++;
    }

    @Override
    public int score() {
        if (isStrike()) {
            return calculateStrikeScore();
        }
        if (isSpare()) {
            return calculateBaseScore() + nextFrame.firstRollScore();
        }
        return calculateBaseScore();
    }

    @Override
    public int calculateBaseScore() {
        int score = NO_PINS_HIT;
        for (Roll roll : rolls) {
            score += roll.pins();
        }
        return score;
    }

    private int calculateStrikeScore() {
        Frame nextNextFrame = this.nextFrame.nextFrame;
        if (nextFrame.isStrike() && nextNextFrame != null) {
            return firstRollScore() + nextFrame.calculateBaseScore() + nextNextFrame.firstRollScore();
        }
        return firstRollScore() + nextFrame.calculateBaseScore();
    }

    private void handleStrike() {
        if (isStrike()) {
            addRoll(NO_PINS_HIT);
        }
    }
}
