package bowling.frames.frame;

import bowling.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    protected final int MAX_ROLLS = 2;
    protected final int TOTAL_PINS = 10;
    protected final int NO_PINS_HIT = 0;
    protected final int INITIAL_ROLL_INDEX = 0;

    protected int currentRoll = INITIAL_ROLL_INDEX;
    public Frame nextFrame;

    protected final List<Roll> rolls = new ArrayList<>(MAX_ROLLS);

    public abstract boolean isCompleted();

    public abstract void roll(int pins);

    public abstract int score();

    public abstract int calculateBaseScore();

    public boolean isStrike() {
        return !rolls.isEmpty() && firstRollScore() == TOTAL_PINS;
    }

    public boolean isSpare() {
        return !rolls.isEmpty() && !isStrike() && calculateBaseScore() == TOTAL_PINS;
    }

    public int firstRollScore() {
        return !rolls.isEmpty() ? getFirstRoll().pins() : NO_PINS_HIT;
    }

    public int secondRollScore() {
        return !rolls.isEmpty() ? getSecondRoll().pins() : NO_PINS_HIT;
    }

    public void setNextFrame(Frame nextFrame){
        this.nextFrame = nextFrame;
    }

    protected void addRoll(int pins) {
        rolls.add(new Roll(pins));
    }

    protected void checkRollsAllowed() {
        if (isCompleted()) {
            throw new IllegalStateException("No more rolls allowed in a regular frame");
        }
    }

    private Roll getFirstRoll() {
        return rolls.get(INITIAL_ROLL_INDEX);
    }

    private Roll getSecondRoll() {
        return rolls.get(INITIAL_ROLL_INDEX + 1);
    }
}
