package fr.univartois.butinfo.r304.bomberman.model.map.wall.states;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.scene.image.Image;

public class Brick implements IWallState{
    private final ISpriteStore spriteStore;
    private final Sprite sprite;
    public Brick(ISpriteStore spriteStore){
        this.spriteStore=spriteStore;
        this.sprite= spriteStore.getSprite("bricks");
    }

    @Override
    public Image getImage() {
        return sprite.getImage();
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public IWallState nextState() {
        return new BreackableBrick(spriteStore);
    }
}
