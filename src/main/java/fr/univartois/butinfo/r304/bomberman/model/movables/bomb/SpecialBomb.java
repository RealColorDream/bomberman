package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;

public class SpecialBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        // Explosion plus petite : affecte moins de cases (moins de cellules)
        for (int x = -1 * game.getSpriteStore().getSpriteSize(); x <= game.getSpriteStore().getSpriteSize(); x += game.getSpriteStore().getSpriteSize()) {
            if (Math.abs(x) < 2) { // Affecte uniquement les cases proches
                game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() + x, game.getSpriteStore().getSprite("explosion")));
                game.addMovable(new Explosion(game, bomb.getX() + x, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
                game.getCellAt((int) (bomb.getX() + x), (int) bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            }
        }
    }
}
