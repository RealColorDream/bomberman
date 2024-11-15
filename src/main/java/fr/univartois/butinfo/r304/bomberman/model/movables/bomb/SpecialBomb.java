package fr.univartois.butinfo.r304.bomberman.model.movables.bomb;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;

public class SpecialBomb implements BombStrategy {

    @Override
    public void explode(Bomb bomb, BombermanGame game) {
        //make a bomb that explodes the entire line towards which the player is facing
    }
}
