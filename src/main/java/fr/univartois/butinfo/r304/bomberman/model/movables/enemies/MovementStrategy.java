package fr.univartois.butinfo.r304.bomberman.model.movables.enemies;

public interface MovementStrategy {
    /**
     * Méthode de déplacement qui applique une stratégie de mouvement
     * à l'ennemi.
     *
     * @param enemy L'ennemi qui utilise cette stratégie de mouvement.
     * @param timeDelta Le temps écoulé depuis la dernière mise à jour.
     * @return true si le déplacement est effectué, false sinon.
     */
    boolean move(Enemies enemy, long timeDelta);
}
