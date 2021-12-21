package katas.mvargas;

public class Fighter {

        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }


    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

       String nameAttacker = firstAttacker;

         do{                    //se realiza el primer ataque
             if(nameAttacker == fighter1.name) {
                fighter2.health  -= fighter1.damagePerAttack;
                nameAttacker = fighter2.name;
             }else if (nameAttacker == fighter2.name){
                 fighter1.health  -= fighter2.damagePerAttack;
                 nameAttacker=fighter1.name;
             }
         }while(fighter1.health >0 && fighter2.health > 0); //solo si ambos siguen vivos

         if(fighter1.health < fighter2.health){ // se dice quien es el vencedor
             return fighter2.name;
         }else{
             return fighter1.name;
         }
    }
}

