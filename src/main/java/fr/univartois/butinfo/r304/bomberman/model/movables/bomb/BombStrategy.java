package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.movables.enemies.Enemies;

public interface BombStrategy {
    void explode(Bomb bomb, BombermanGame game);

    void onCollisionWithEnemy(Bomb bomb, Enemies enemy, BombermanGame game);
}
