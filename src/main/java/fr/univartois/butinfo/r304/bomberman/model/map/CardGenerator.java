package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;

public class CardGenerator {
    private final ISpriteStore spriteStore;

    public CardGenerator(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public GameMap generateCard(int height, int width) {
        MapBuilder mapBuilder = new MapBuilder(spriteStore);
        GameMap map = new GameMap(height, width);
        mapBuilder.setBorder(map);
        mapBuilder.setGrid(map);
        return mapBuilder.buildMap(map);
    }
}
