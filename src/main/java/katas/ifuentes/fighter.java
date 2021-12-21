package ifuentes;
public class fighter {

    public String name;
    public int health, damagePerAttack;
    public fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public fighter(){
        fighter fighter1 = new fighter("Lew",10,2);
        fighter fighter2 = new fighter("Harry",5,4);
    }


    public static String declareWinner(fighter fighter1, fighter fighter2, String firstAttacker) {

        String nameAttacker = firstAttacker;
        do{
            if(nameAttacker == fighter1.name) {
                fighter2.health  -= fighter1.damagePerAttack;
                nameAttacker = fighter2.name;
            }else if (nameAttacker == fighter2.name){
                fighter1.health  -= fighter2.damagePerAttack;
                nameAttacker=fighter1.name;
            }
        }while(fighter1.health >0 && fighter2.health > 0);
        if(fighter1.health < fighter2.health){
            return fighter2.name;
        }else{
            return fighter1.name;
        }
    }
}