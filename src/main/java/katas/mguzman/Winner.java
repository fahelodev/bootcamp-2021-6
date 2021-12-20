package katas.mguzman;

public class Winner {

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        while (fighter1.health>0 && fighter2.health>0) {
            if (firstAttacker.equals(fighter2.name)) {
                fighter1.health -= fighter2.damagePerAttack;
                firstAttacker = fighter1.name;
            } else {
                fighter2.health -= fighter1.damagePerAttack;
                firstAttacker = fighter2.name;
            }
        }
        if(fighter1.health <=0){ return fighter2.name;
        }
        else{return fighter1.name;
        }

    }
}

