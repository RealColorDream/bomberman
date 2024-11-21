package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

import java.util.Random;

/**
 * The Enemies class represents an enemy in the Bomberman game.
 *
 * Enemies move according to a randomly chosen strategy, either horizontal or vertical movement.
 * They interact with other objects based on collisions and can explode.
 */
public class Enemies extends AbstractMovable {

    /**
     * Random generator used to choose the movement strategy.
     */
    private static final Random random = new Random();

    /**
     * The movement strategy for the enemy, which is randomly assigned upon instantiation.
     */
    private final MovementStrategy movementStrategy;

    /**
     * Initializes a new enemy in the game with a specific position and sprite.
     * The movement strategy is randomly selected to be either horizontal or vertical.
     *
     * @param game       The Bomberman game that the enemy belongs to.
     * @param xPosition  The initial horizontal position of the enemy.
     * @param yPosition  The initial vertical position of the enemy.
     * @param sprite     The sprite representing the enemy visually.
     */
    public Enemies(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        // Randomly choose between horizontal or vertical movement strategy
        if (random.nextBoolean()) {
            this.movementStrategy = new HorizontalMovementStrategy();
        } else {
            this.movementStrategy = new VerticalMovementStrategy();
        }
    }

    /**
     * Moves the enemy according to its assigned movement strategy.
     * The movement is determined by the current strategy (horizontal or vertical).
     *
     * @param timeDelta The time passed since the last move, used to update the movement speed.
     * @return true if the enemy successfully moved, false otherwise.
     */
    @Override
    public boolean move(long timeDelta) {
        return movementStrategy.move(this, timeDelta);
    }

    /**
     * Calls the move method from the parent class (AbstractMovable).
     * This method is used for moving the enemy without applying any custom movement strategy.
     *
     * @param timeDelta The time passed since the last move, used to update the movement.
     * @return true if the movement was successful, false otherwise.
     */
    public boolean moveUsingSpeed(long timeDelta) {
        return super.move(timeDelta);
    }

    /**
     * Handles the collision of the enemy with another movable object.
     * If the other object is an explosion or bomb, the enemy will explode.
     *
     * @param other The object that the enemy collided with.
     */
    @Override
    public void collidedWith(IMovable other) {
        other.hitEnemy();
    }


    /**
     * Causes the enemy to explode. This marks the enemy as consumed, meaning it is removed from the game.
     */
    @Override
    public void explode() {
        isConsumedProperty().set(true);
    }


    /**
     * This method is called when an enemy is hit.
     * It causes the enemy to explode.
     */
    @Override
    public void hitEnemy() {
        //do nothing
    }

}
