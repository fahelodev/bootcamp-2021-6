package katas.iromero;

public class DeclareWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        while(fighter1.health>0 && fighter2.health>0){
            if(firstAttacker.equals(fighter1.name)){
                fighter2.health -= fighter1.damagePerAttack;
                firstAttacker = fighter2.name;
            }else{
                fighter1.health -= fighter2.damagePerAttack;
                firstAttacker = fighter1.name;
            }
        }



        return fighter2.health <= 0 ? fighter1.name : fighter2.name;
    }
}