//****************************************************************
//* Copyright (c) 2015 Ford Motor Company. All Rights Reserved.
//****************************************************************
package bowlingSolution;

public class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(final int pins) {
        rolls[currentRoll++] = pins;

    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(rollIndex)) {
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }

        }
        return score;
    }

    private boolean isSpare(final int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

}
