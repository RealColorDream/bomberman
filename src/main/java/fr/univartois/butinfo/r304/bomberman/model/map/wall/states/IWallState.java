package fr.univartois.butinfo.r304.bomberman.model.map.wall.states;


import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.scene.image.Image;

public interface IWallState {
    Image getImage();
    Sprite getSprite();
    IWallState nextState();
}
