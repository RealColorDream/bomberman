package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

public class Map_1 implements IMapStrategy {
    private final ISpriteStore spriteStore;

    public Map_1(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    @Override
    public GameMap buildMap(int height, int width) {
        MapBuilder mapBuilder = new MapBuilder(spriteStore);
        GameMap map = new GameMap(height, width);
        mapBuilder.setBorder(map);
        return mapBuilder.buildMap(map);
    }
}
