package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

/**
 * The MovementStrategy interface defines the contract for movement strategies of enemies in the Bomberman game.
 *
 * Implementing classes should provide specific movement behavior for enemies, either vertical or horizontal.
 * The strategy allows the enemies to move in different patterns, and it can be swapped dynamically at runtime.
 */
public interface MovementStrategy {

    /**
     * Defines the movement behavior for an enemy.
     *
     * This method is called to update the movement of an enemy based on the assigned strategy. The movement is calculated
     * based on the time passed since the last move (timeDelta), allowing for movement to be adjusted based on time.
     *
     * @param enemy      The enemy that is moving. This allows the movement strategy to modify the enemy's speed or position.
     * @param timeDelta  The time difference (in milliseconds) since the last movement. This is used to control movement speed.
     * @return true if the enemy successfully moved; false otherwise.
     */
    boolean move(Enemies enemy, long timeDelta);
}
