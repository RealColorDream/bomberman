package fr.univartois.butinfo.r304.bomberman.model.map;

import fr.univartois.butinfo.r304.bomberman.view.ISpriteStore;

public class CardGenerator {
    private final ISpriteStore spriteStore;
    private IMapStrategy mapStrategy;

    public void setMapStrategy(IMapStrategy mapStrategy) {
        this.mapStrategy = mapStrategy;
    }

    public CardGenerator(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    public GameMap generateCard(int height, int width) {
        if (mapStrategy == null) {
            throw new IllegalStateException("Map strategy must be set before generating a card.");
        }
        return mapStrategy.buildMap(height, width);
    }
}
