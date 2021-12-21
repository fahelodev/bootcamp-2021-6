package katas.fFabricio;




public class DeclararGanadorJava {
    public static String declareWinner(Fighter fighter1, Fighter fighter2,  String firstAttacker) {

        if (firstAttacker.equals(fighter2.name)) {

            while (fighter1.health > 0 && fighter2.health > 0) { //Pregunta por la salud de los jugadores
                fighter1.health = fighter1.health - fighter2.damagePerAttack;//El peleador 1 recibe el daño
                if (fighter1.health <= 0) return fighter2.name; //retorna el nombre del jugador 2
                fighter2.health = fighter2.health - fighter1.damagePerAttack; // el peleador 2 recibe el daño
                if (fighter2.health <= 0) return fighter1.name; // retorna el nombre del jugador 1
            }
        } else {
            while (fighter1.health > 0 && fighter2.health > 0) {
                fighter2.health = fighter2.health - fighter1.damagePerAttack;
                if (fighter2.health <= 0) return fighter1.name;
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
                if (fighter1.health <= 0) return fighter2.name;
            }
        }
        return "";
    }



        }






