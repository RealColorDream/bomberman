package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.scene.image.Image;

public class Bomb extends AbstractMovable {

    long dropTime=-1;
    final static long EXPLODE_DELAY=5000;

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
        //Do nothing
    }

    @Override
    public void explode() {
        dropTime = 0;
        move(0);
    }

    @Override
    public void hitEnemy() {
        //Do nothing
    }
    @Override
    public boolean move(long delta){
        if (dropTime != -1 && System.currentTimeMillis() >= dropTime+EXPLODE_DELAY) {
            game.addMovable(new Explosion(game, xPosition.get(), yPosition.get(), new Sprite(new Image("explosion"))));
            for(int x=-1; x<=1; x+=2){
                game.addMovable(new Explosion(game, xPosition.get()+x, yPosition.get(), game.getSpriteStore().getSprite("explosion")));
                game.addMovable(new Explosion(game, xPosition.get(), yPosition.get()+x, game.getSpriteStore().getSprite("explosion")));
                game.getCellAt((int) (xPosition.get()+x), (int) yPosition.get()).replaceBy(new Cell(game.getSpriteStore().getSprite("grass")));
                game.getCellAt((int) xPosition.get(), (int) (yPosition.get()+1)).replaceBy(new Cell(game.getSpriteStore().getSprite("grass")));
                isConsumedProperty().set(true);
            }
        }
    return false;
    }
}
