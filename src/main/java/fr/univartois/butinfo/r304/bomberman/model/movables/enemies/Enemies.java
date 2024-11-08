package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.MovementsStrategy;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

import java.util.Random;

public class Enemies extends AbstractMovable {
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    private static final Random random = new Random();
    private MovementStrategy movementStrategy;

    public Enemies(BombermanGame game, double xPosition, double yPosition, Sprite sprite, MovementsStrategy movementStrategy) {
        super(game, xPosition, yPosition, sprite);
        long lastMove = 0;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public boolean move(long timeDelta) {
        return movementStrategy.move(this, timeDelta);
    }

    public boolean moveUsingSpeed(long timeDelta) {
        return super.move(timeDelta); // Appelle la méthode move de AbstractMovable
    }

    @Override
    public void collidedWith(IMovable other) {
            other.explode();
    }

    @Override
    public void explode() {
        isConsumedProperty().set(true);
    }

    @Override
    public void hitEnemy() {
        explode();
    }
}


