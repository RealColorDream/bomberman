package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

public class Explosion extends AbstractMovable {

    static final int EXPLOSION_DELAY = 1000;
    long creationTime;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected Explosion(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        creationTime = System.currentTimeMillis();
    }

    @Override
    public void collidedWith(IMovable other) {
        other.explode();
    }

    @Override
    public void explode() {
        //do nothing
    }

    @Override
    public void hitEnemy() {
        //do nothing
    }

    @Override
    public boolean move(long timeDelta){
        if (System.currentTimeMillis()>=creationTime+EXPLOSION_DELAY){
            isConsumedProperty().set(true);
        }
        return false;
    }

}
