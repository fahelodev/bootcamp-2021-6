package katas.fmarfull;

public class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String turn = firstAttacker;
        String winner = "";
        while (fighter1.health > 0 && fighter2.health > 0) {
            if (fighter1.name == turn) {
                fighter2.health -= fighter1.damagePerAttack;
                turn = fighter2.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                turn = fighter1.name;
            }
        }
        if (fighter1.health > 0) {
            winner = fighter1.name;
        } else {
            winner = fighter2.name;
        }
        System.out.println(winner);
        return winner;
    }
}