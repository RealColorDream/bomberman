package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

public class Bomb extends AbstractMovable {

    private void explodeCellAt(int x, int y) {
        Cell cellToUpdate = game.getCellAt(x, y);
        if (cellToUpdate.getWall() != null) {
            cellToUpdate.getWall().explode();
            if (cellToUpdate.getWall().getState() == null)
                cellToUpdate.replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            else {
                cellToUpdate.getSpriteProperty().set(cellToUpdate.getWall().getSprite());
            }
        }
    }

    long dropTime = -1;
    static final long EXPLODE_DELAY = 5000;
    long creationTime;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Bomb(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        creationTime = System.currentTimeMillis();
    }

    public void drop(double x, double y) {
        int tileSize = game.getSpriteStore().getSpriteSize();

        long roundedX = Math.round(x / tileSize) * tileSize;
        long roundedY = Math.round(y / tileSize) * tileSize;


        xPosition.set(roundedX);
        yPosition.set(roundedY);
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

    private void addExplosion(double x, double y) {
        game.addMovable(new Explosion(game, x, y, game.getSpriteStore().getSprite("explosion")));
    }

    @Override
    public boolean move(long delta) {
        if (!isConsumed() && dropTime != -1 && System.currentTimeMillis() >= dropTime + EXPLODE_DELAY) {
            game.addMovable(new Explosion(game, xPosition.get(), yPosition.get(), game.getSpriteStore().getSprite("explosion")));
            for (int x = -1 * game.getSpriteStore().getSpriteSize(); x <= game.getSpriteStore().getSpriteSize(); x += 2 * game.getSpriteStore().getSpriteSize()) {
                addExplosion(xPosition.get() + x, yPosition.get());
                addExplosion(xPosition.get(), yPosition.get() + x);
            }
            game.removeMovable(this);
            game.addPlayerBomb();
        }
        return false;
    }
}
