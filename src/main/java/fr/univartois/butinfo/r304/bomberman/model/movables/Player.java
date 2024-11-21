package fr.univartois.butinfo.r304.bomberman.model.movables;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.Bomb;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractMovable implements IMovable {

    private final IntegerProperty score;
    private final IntegerProperty lives;
    private final IntegerProperty bombNumbers;

    private final ObservableList<Bomb> bombs;
    private final int spawnX;
    private final int spawnY;
    private long invulnerabilityStartedAt=0;

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
        spawnX = (int) xPosition;
        spawnY = (int) yPosition;
        this.score = new SimpleIntegerProperty(score);
        this.lives = new SimpleIntegerProperty(lives);
        this.bombs = FXCollections.observableArrayList(new ArrayList<>());
        this.bombNumbers = new SimpleIntegerProperty(0);
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

    public ObservableList<Bomb> getBombsProperty(){
        return bombs;
    }

    public IntegerProperty bombsLengthProperty(){
            return bombNumbers;
    }
    public void addBomb(){
        bombs.add(new Bomb(game, xPosition.get(), yPosition.get(), game.getSpriteStore().getSprite("bomb")));
        bombsLengthProperty().setValue(bombs.size());
    }

    public void decreaseLives() {
        lives.set(lives.get() - 1);
        if (lives.get() <= 0) {
            game.playerIsDead();
        }
    }
    public void die(){
        long invulnerabilityTime = 3000;
        if (invulnerabilityStartedAt+ invulnerabilityTime <=System.currentTimeMillis()) {
            decreaseLives();
            goToSpawn();
            invulnerabilityStartedAt = System.currentTimeMillis();
        }

    }


    @Override
    public void collidedWith(IMovable other) {
        //die();
    }

    @Override
    public void explode() {
        die();
    }

    public void goToSpawn(){
        setY(spawnY);
        setX(spawnX);
    }

    @Override
    public void hitEnemy() {
        die();
    }
}
