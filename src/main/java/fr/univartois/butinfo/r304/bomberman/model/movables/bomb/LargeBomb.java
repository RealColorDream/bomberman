package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;
import fr.univartois.butinfo.r304.bomberman.model.movables.enemies.Enemies;

public class LargeBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        int spriteSize = game.getSpriteStore().getSpriteSize();

        for (int x = -2 * spriteSize; x <= 2 * spriteSize; x += spriteSize) {
            if (bomb.getX() + x >= 0 && bomb.getX() + x < game.getWidth())  {
                game.addMovable(new Explosion(game, bomb.getX() + x, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
                game.getCellAt((bomb.getX() + x), bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            }
            if (bomb.getY() + x >= 0 && bomb.getY() + x < game.getHeight())   {
                game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() + x, game.getSpriteStore().getSprite("explosion")));
                game.getCellAt(bomb.getX(), (bomb.getY() + x)).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
            }
        }
    }

    @Override
    public void onCollisionWithEnemy(Bomb bomb, Enemies enemy, BombermanGame game) {
        //do nothing
    }
}

