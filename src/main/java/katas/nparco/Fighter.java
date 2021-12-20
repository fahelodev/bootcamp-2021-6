package katas.nparco;

public class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        boolean first = fighter1.name == firstAttacker;
        while (true) {
            if (first) {
                fighter2.health -= fighter1.damagePerAttack;
                if (fighter2.health <= 0)
                    return fighter1.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                if (fighter1.health <= 0)
                    return fighter2.name;
            }
            first = !first;
        }
    }
}
