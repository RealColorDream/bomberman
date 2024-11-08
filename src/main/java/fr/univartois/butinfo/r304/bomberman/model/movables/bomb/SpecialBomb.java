package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.map.Cell;

public class SpecialBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        int spriteSize = game.getSpriteStore().getSpriteSize();

        game.addMovable(new Explosion(game, bomb.getX() + spriteSize, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
        game.addMovable(new Explosion(game, bomb.getX() - spriteSize, bomb.getY(), game.getSpriteStore().getSprite("explosion")));
        game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() + spriteSize, game.getSpriteStore().getSprite("explosion")));
        game.addMovable(new Explosion(game, bomb.getX(), bomb.getY() - spriteSize, game.getSpriteStore().getSprite("explosion")));

        game.getCellAt((int) (bomb.getX() + spriteSize), (int) bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
        game.getCellAt((int) (bomb.getX() - spriteSize), (int) bomb.getY()).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
        game.getCellAt((int) bomb.getX(), (int) (bomb.getY() + spriteSize)).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
        game.getCellAt((int) bomb.getX(), (int) (bomb.getY() - spriteSize)).replaceBy(new Cell(game.getSpriteStore().getSprite("lawn")));
    }
}
