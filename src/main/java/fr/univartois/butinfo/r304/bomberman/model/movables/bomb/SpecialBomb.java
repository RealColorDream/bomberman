package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.movables.enemies.Enemies;

public class SpecialBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        if (!bomb.isConsumed()) {
            game.addMovable(new Explosion(game, bomb.getX(), bomb.getY(),
                    game.getSpriteStore().getSprite("explosion")));

            int spriteSize = game.getSpriteStore().getSpriteSize();
            for (int x = -spriteSize; x <= spriteSize; x += spriteSize) {
                for (int y = -spriteSize; y <= spriteSize; y += spriteSize) {
                    if (x != 0 || y != 0) {
                        game.addMovable(new Explosion(game, bomb.getX() + x, bomb.getY() + y,
                                game.getSpriteStore().getSprite("explosion")));
                    }
                }
            }
            game.removeMovable(bomb);
            game.addPlayerBomb();
        }
    }

    @Override
    public void onCollisionWithEnemy(Bomb bomb, Enemies enemy, BombermanGame game) {
        // Explosion déclenchée lorsqu'une bombe touche un ennemi
        explode(bomb, game);
    }
}
