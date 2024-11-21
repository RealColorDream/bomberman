package fr.univartois.butinfo.r304.bomberman.model.map.wall.states;


import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.scene.image.Image;

public class UnbreakableWall implements IWallState{
    private final Sprite sprite;
    public UnbreakableWall(ISpriteStore spriteStore){
        this.sprite= spriteStore.getSprite("wall");
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
        return this;
    }
}
