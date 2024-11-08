package fr.univartois.butinfo.r304.bomberman.model;

import fr.univartois.butinfo.r304.bomberman.model.movables.enemies.Enemies;
import fr.univartois.butinfo.r304.bomberman.model.movables.enemies.MovementStrategy;

import java.util.Random;

public class MovementsStrategy implements MovementStrategy {

    private static final Random random = new Random();
    private long lastMove = 0;

    @Override
    public boolean move(Enemies enemy, long timeDelta) {
        int direction = random.nextInt(4); // (0 = haut, 1 = bas, 2 = gauche, 3 = droite)
        int speed = random.nextInt(25, 50);
        long currentTime = System.currentTimeMillis();
        int moveDelay = random.nextInt(1000, 3000);

        if (currentTime - lastMove >= moveDelay) {
            switch (direction) {
                case 0: // Haut
                    enemy.setHorizontalSpeed(0);
                    enemy.setVerticalSpeed(-speed);
                    break;
                case 1: // Bas
                    enemy.setHorizontalSpeed(0);
                    enemy.setVerticalSpeed(speed);
                    break;
                case 2: // Gauche
                    enemy.setHorizontalSpeed(-speed);
                    enemy.setVerticalSpeed(0);
                    break;
                case 3: // Droite
                    enemy.setHorizontalSpeed(speed);
                    enemy.setVerticalSpeed(0);
                    break;
            }
            lastMove = currentTime;
        }

        return enemy.moveUsingSpeed(timeDelta);
    }
}
