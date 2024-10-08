package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

public class Player extends AbstractMovable implements IMovable {

    private final IntegerProperty score;
    private final IntegerProperty lives;

    private ObservableList<Bomb> bombs;

    /**
     * Crée une nouvelle instance de Player.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     * @param score     Le score initial du joueur.
     * @param lives     Le nombre de vies initiales du joueur.
     */
    public Player(BombermanGame game, double xPosition, double yPosition, Sprite sprite, int score, int lives) {
        super(game, xPosition, yPosition, sprite);
        this.score = new SimpleIntegerProperty(score);
        this.lives = new SimpleIntegerProperty(lives);
        this.bombs = new SimpleListProperty<>();
    }

    public IntegerProperty getScoreProperty() {
        return score;
    }

    public int getScore() {
        return score.get();
    }

    public void increaseScore(int points) {
        score.set(score.get() + points);
    }

    public IntegerProperty getLivesProperty() {
        return lives;
    }

    public int getLives() {
        return lives.get();
    }

    public void decreaseLives() {
        lives.set(lives.get() - 1);
        if (lives.get() <= 0) {
            explode();
        }
    }

    @Override
    public void collidedWith(IMovable other) {
        //TODO
    }

    @Override
    public void explode() {
        decreaseLives();
    }

    @Override
    public void hitEnemy() {
        decreaseLives();
    }
}
