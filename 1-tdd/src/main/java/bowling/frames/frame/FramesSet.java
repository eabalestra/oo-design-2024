package bowling.frames.frame;

import bowling.frames.NormalFrame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FramesSet implements Iterable<Frame> {
    private static final int NUMBER_OF_FRAMES = 10;
    final List<Frame> frames = new ArrayList<>();
    private int frameIndex = 0;

    public FramesSet(){
        for (int i = 0; i < NUMBER_OF_FRAMES - 1; i++) {
            frames.add(new NormalFrame());
        }
        frames.add(new FinalFrame());
    }
    
    public void addRoll(int pins) {
        checkGameOver();
        Frame currentFrame = getCurrentFrame();
        currentFrame.roll(pins);
        moveToNextFrameIfCurrentIsCompleted(currentFrame);
    }

    public int size() {
        return frames.size();
    }

    private Frame getCurrentFrame() {
        return frames.get(frameIndex);
    }

    private void checkGameOver() {
        if (frameIndex == NUMBER_OF_FRAMES) {
            throw new IllegalStateException("Game is over");
        }
    }

    private void moveToNextFrameIfCurrentIsCompleted(Frame currentFrame) {
        if (currentFrame.isCompleted() && isNotLastFrame()) {
            Frame nextFrame = frames.get(frameIndex + 1);
            currentFrame.setNextFrame(nextFrame);
            frameIndex++;
        }
    }

    private boolean isNotLastFrame() {
        return frameIndex < NUMBER_OF_FRAMES - 1;
    }

    @Override
    public Iterator<Frame> iterator() {
        return frames.iterator();
    }

}
