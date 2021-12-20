package katas.rgutierrez;

public class FightersKata {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        boolean winner = false;

        while (!winner) {

            if (fighter1.name.equals(firstAttacker)) {
                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                fighter1.health = fighter1.health - fighter2.damagePerAttack;

                if(fighter2.health <= 0) {
                    return fighter1.name;
                } else if (fighter1.health <= 0) {
                    return fighter2.name;
                }

            } else if (fighter2.name.equals(firstAttacker)){
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
                fighter2.health = fighter2.health - fighter1.damagePerAttack;

                if(fighter1.health <= 0) {
                    return fighter2.name;
                } else if (fighter2.health <= 0) {
                    return fighter1.name;
                }
            }


        }

        return "";
    }
}
