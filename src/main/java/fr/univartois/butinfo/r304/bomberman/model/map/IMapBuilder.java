package fr.univartois.butinfo.r304.bomberman.model.map;

public interface IMapBuilder {
    GameMap buildMap(GameMap map);
    void setLawn(GameMap map, int i, int j);
    void setWall(GameMap map, int i, int j);
    void setBrick(GameMap map, int i, int j);
    void setBorder(GameMap map);
    void setGrid(GameMap map);
    void setGrid(GameMap map, int interval);
}
