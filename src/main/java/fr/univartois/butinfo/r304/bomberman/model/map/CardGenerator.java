package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.model.map.wall.states.Brick;
import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

public class CardGenerator {
    private final ISpriteStore spriteStore;

    public CardGenerator(ISpriteStore spriteStore) {
        this.spriteStore=spriteStore;
    }

    public GameMap generateCard(int height, int width) {
        GameMap map = new GameMap(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    map.setAt(i, j, new Cell(new Wall(new Brick(spriteStore))));
                } else {
                    map.setAt(i, j, new Cell(spriteStore.getSprite("lawn")));
                }
            }
        }
        return map;
    }
}
