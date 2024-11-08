package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

import java.util.Random;

public class HorizontalMovementStrategy implements MovementStrategy {
    private static final Random random = new Random();
    private long lastMove = 0;

    @Override
    public boolean move(Enemies enemy, long timeDelta) {
        int speed = random.nextInt(25, 50);
        long currentTime = System.currentTimeMillis();
        int moveDelay = random.nextInt(1000, 3000);

        if (currentTime - lastMove >= moveDelay) {
            if (random.nextBoolean()) {
                // Déplacement vers la droite
                enemy.setHorizontalSpeed(speed);
            } else {
                // Déplacement vers la gauche
                enemy.setHorizontalSpeed(-speed);
            }
            enemy.setVerticalSpeed(0); // Aucune vitesse verticale
            lastMove = currentTime;
        }

        return enemy.moveUsingSpeed(timeDelta);
    }
}
