package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.model.map.wall.states.Brick;
import fr.univartois.butinfo.r304.bomberman.model.map.wall.states.UnbreakableWall;
import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

public class MapBuilder implements IMapBuilder{
    private final ISpriteStore spriteStore;

    public MapBuilder(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    @Override
    public GameMap buildMap(GameMap map) {
        return map;
    }

    @Override
    public void setLawn(GameMap map, int i, int j) {
        map.setAt(i, j, new Cell(spriteStore.getSprite("lawn")));
    }

    @Override
    public void setWall(GameMap map, int i, int j) {
        map.setAt(i, j, new Cell(new Wall(new UnbreakableWall(spriteStore))));
    }

    @Override
    public void setBrick(GameMap map, int i, int j) {
        map.setAt(i, j, new Cell(new Wall(new Brick(spriteStore))));
    }

    @Override
    public void setBorder(GameMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (i == 0 || i == map.getHeight() - 1 || j == 0 || j == map.getWidth() - 1) {
                    setWall(map, i, j);
                } else {
                    setLawn(map, i, j);
                }
            }
        }
    }

    @Override
    public void setGrid(GameMap map) {
        for (int i = 1; i < map.getHeight() - 1; i++) {
            for (int j = 1; j < map.getWidth() - 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    setBrick(map, i, j);
                }
            }
        }
    }

    @Override
    public void setGrid(GameMap map, int interval) {
        for (int i = 1; i < map.getHeight() - 1; i++) {
            for (int j = 1; j < map.getWidth() - 1; j++) {
                if (i % interval == 0 && j % interval == 0) {
                    setBrick(map, i, j);
                }
            }
        }
    }
}
