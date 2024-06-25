package bowling.frames.frame;

import bowling.roll.Roll;

public class FinalFrame extends Frame {
    private static final int MAX_ROLLS = 3;

    @Override
    public void roll(int pins) {
        checkRollsAllowed();
        addRoll(pins);
        currentRoll++;
    }

    @Override
    public int score() {
        if (isStrike() || isSpare()) {
            return calculateTotalScore();
        }
        return calculateBaseScore();
    }

    @Override
    public boolean isCompleted() {
        return currentRoll == MAX_ROLLS || isBonusRoll();
    }

    @Override
    public int calculateBaseScore() {
        return firstRollScore() + secondRollScore();
    }

    private int calculateTotalScore() {
        return calculateBaseScore() + thirdRollScore();
    }

    private int thirdRollScore() {
        return rolls.size() > MAX_ROLLS - 1 ? getThirdRoll().pins() : NO_PINS_HIT;
    }

    private Roll getThirdRoll() {
        return rolls.get(INITIAL_ROLL_INDEX + 2);
    }

    private boolean isBonusRoll() {
        return currentRoll == MAX_ROLLS - 1 && !isStrike() && !isSpare();
    }

}
