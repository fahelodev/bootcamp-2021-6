package katas.rcabral;

public class KataFighter {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        while(true){
            if(firstAttacker.equals(fighter1.name)){
                fighter2.health -= fighter1.damagePerAttack;
                if(fighter2.health <= 0){
                    return fighter1.name;
                }else{
                    fighter1.health -= fighter2.damagePerAttack;
                    if(fighter1.health <= 0){
                        return fighter2.name;
                    }
                }
            }else{
                fighter1.health -= fighter2.damagePerAttack;
                if(fighter1.health <= 0){
                    return fighter2.name;
                }else{
                    fighter2.health -= fighter1.damagePerAttack;
                    if(fighter2.health <= 0){
                        return fighter1.name;
                    }
                }
            }
        }
    }
}
