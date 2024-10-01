package fr.univartois.butinfo.r304.bomberman.model.map;

public class CardGenerator {
    public GameMap generateCard(int height, int width) {
        return new GameMap(height, width);
    }
}
