package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

public class Map_2 implements IMapStrategy {
    private final ISpriteStore spriteStore;

    public Map_2(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public GameMap buildMap(int height, int width) {
        GameMap map = new GameMap(height, width);
        MapBuilder mapBuilder = new MapBuilder(spriteStore);
        mapBuilder.setBorder(map);
        mapBuilder.setGrid(map);
        return mapBuilder.buildMap(map);
    }
}
