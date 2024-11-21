package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

import java.util.Random;

public class Map_3 implements IMapStrategy {
    private final ISpriteStore spriteStore;

    public Map_3(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public GameMap buildMap(int height, int width) {
        GameMap map = new GameMap(height, width);
        MapBuilder mapBuilder = new MapBuilder(spriteStore);
        mapBuilder.setBorder(map);
        Random random = new Random();
        int fillSize = (height * width) / 3;
        int nbBricks = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int xr = random.nextInt(height);
                int yr = random.nextInt(width);
                if ((xr > 1 && yr > 1) && (xr < height - 1 && yr < width - 1) && (nbBricks < fillSize)) {
                    nbBricks++;
                    mapBuilder.setBrick(map, xr, yr);
                }
            }
        }
        return mapBuilder.buildMap(map);
    }
}
