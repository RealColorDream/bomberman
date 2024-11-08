package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;

public class NormalBomb implements BombStrategy{
    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        // Explosion classique : affecte les cases voisines à une distance de 1 case
        for (int x = -1 * game.getSpriteStore().getSpriteSize(); x <= game.getSpriteStore().getSpriteSize(); x += 2 * game.getSpriteStore().getSpriteSize()) {
            game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() + x, game.getSpriteStore().getSprite("explosion")));
            game.addMovable(new Explosion(game, bomb.getX() + x, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
            game.getCellAt((int) (bomb.getX() + x), (int) bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            game.getCellAt((int) bomb.getX(), (int) (bomb.getY() + 1)).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
        }
    }
}
