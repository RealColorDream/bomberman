package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;

public class NormalBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        int spriteSize = game.getSpriteStore().getSpriteSize();

        for (int x = -spriteSize; x <= spriteSize; x += spriteSize) {

            game.addMovable(new Explosion(game, bomb.getX() + x, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
            game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() + x, game.getSpriteStore().getSprite("explosion")));

            if (bomb.getX() + x >= 0 && bomb.getX() + x < game.getWidth()) {
                game.getCellAt((int) (bomb.getX() + x), (int) bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            }
            if (bomb.getY() + x >= 0 && bomb.getY() + x < game.getHeight()) {  
                game.getCellAt((int) bomb.getX(), (int) (bomb.getY() + x)).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            }
        }
    }
}
