package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
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
    private boolean isAlive;

    public Enemies(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }

    public boolean move(int mouvement) {
        if (!isAlive) {
            return false;
        }
        int direction = random.nextInt(0, 4);
        return super.move(direction);
    }

    @Override
    public void collidedWith(IMovable other) {
            other.hitEnemy();
    }

    @Override
    public void explode() {
        isAlive = false;
        isConsumedProperty().set(true);
    }

    @Override
    public void hitEnemy() {
        //do nothing
    }
}


