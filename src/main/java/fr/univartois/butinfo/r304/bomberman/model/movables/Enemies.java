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
        int direction = random.nextInt(4);
        switch (direction) {
            case 0: // Haut
                setVerticalSpeed(-1);
                setHorizontalSpeed(0);
                break;
            case 1: // Bas
                setVerticalSpeed(1);
                setHorizontalSpeed(0);
                break;
            case 2: // Gauche
                setVerticalSpeed(0);
                setHorizontalSpeed(-1);
                break;
            case 3: // Droite
                setVerticalSpeed(0);
                setHorizontalSpeed(1);
                break;
            default:
                break;
        }
        return super.move(mouvement);
    }

    @Override
    public void collidedWith(IMovable other) {
            //TODO
    }

    @Override
    public void explode() {
        isAlive = false;
        isConsumedProperty().set(true);
    }

    @Override
    public void hitEnemy() {
        explode();
    }
}


