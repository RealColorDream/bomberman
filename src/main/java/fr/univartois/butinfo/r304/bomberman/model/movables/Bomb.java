package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

public class Bomb extends AbstractMovable {

    long dropTime=-1;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected Bomb(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }

    public void drop(double x, double y) {
        xPosition.set(x);
        yPosition.set(y);
        dropTime = System.currentTimeMillis();


    }

    @Override
    public void collidedWith(IMovable other) {

    }

    @Override
    public void explode() {

    }

    @Override
    public void hitEnemy() {

    }
}
