package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;

public interface BombStrategy {
    void explode(Bomb bomb, BombermanGame game);
}
