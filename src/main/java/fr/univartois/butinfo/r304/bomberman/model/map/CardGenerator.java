package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.Sprite;

public class CardGenerator {
    private Sprite wallSprite;
    private Sprite lawnSprite;

    public CardGenerator(Sprite wallSprite, Sprite lawnSprite) {
        this.wallSprite = wallSprite;
        this.lawnSprite = lawnSprite;
    }

    public GameMap generateCard(int height, int width) {
        GameMap map = new GameMap(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    map.setAt(i, j, new Cell(new Wall(wallSprite)));
                } else {
                    map.setAt(i, j, new Cell(lawnSprite));
                }
            }
        }
        return map;
    }
}
