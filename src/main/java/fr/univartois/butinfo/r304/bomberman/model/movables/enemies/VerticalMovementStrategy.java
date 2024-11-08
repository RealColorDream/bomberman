package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

import java.util.Random;

/**
 * The VerticalMovementStrategy class implements the MovementStrategy interface.
 * It defines the movement behavior for an enemy to move vertically, either up or down, at random intervals.
 *
 * This strategy allows an enemy to move along the vertical axis (up or down) while keeping the horizontal speed to zero.
 */
public class VerticalMovementStrategy implements MovementStrategy {

    private static final Random random = new Random();
    private long lastMove = 0;

    /**
     * Moves the enemy vertically either up or down, with a random delay between movements.
     * The speed is also randomly chosen within a defined range.
     *
     * @param enemy      The enemy object that will be moved.
     * @param timeDelta  The time passed since the last movement, used to update movement based on time.
     * @return true if the enemy was successfully moved, false otherwise.
     */
    @Override
    public boolean move(Enemies enemy, long timeDelta) {
        int speed = random.nextInt(25, 50);
        long currentTime = System.currentTimeMillis();
        int moveDelay = random.nextInt(1000, 3000);

        // Move the enemy if enough time has passed
        if (currentTime - lastMove >= moveDelay) {
            if (random.nextBoolean()) {
                // Move down
                enemy.setVerticalSpeed(speed);
            } else {
                // Move up
                enemy.setVerticalSpeed(-speed);
            }
            enemy.setHorizontalSpeed(0);
            lastMove = currentTime;
        }
        return enemy.moveUsingSpeed(timeDelta);
    }
}
