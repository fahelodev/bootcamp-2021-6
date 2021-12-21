package katas.rvargas;

public class DeclareWinner {
    public static String declareWinner(Fighter peleadorUno, Fighter peleadorDos, String ataqueInicial) {
        //declarar Atacante
        Fighter primerAtacante = new Fighter("", 100, 5);
        Fighter segundoAtacante = new Fighter("", 100, 5);


        //ver quien ataca
        if (peleadorUno.name.equals(ataqueInicial)) {
            primerAtacante = peleadorUno;
            segundoAtacante = peleadorDos;
        }
        if (peleadorDos.name.equals(ataqueInicial)) {
            primerAtacante = peleadorDos;
            segundoAtacante = peleadorUno;
        }
        //determinar resultados del ataque (quien muere primero
        while (primerAtacante.health > 0 && segundoAtacante.health > 0) {
            segundoAtacante.health = segundoAtacante.health - primerAtacante.damagePerAttack;
            if (segundoAtacante.health <= 0) return primerAtacante.name;
            primerAtacante.health = primerAtacante.health - segundoAtacante.damagePerAttack;
            if (primerAtacante.health <= 0) return segundoAtacante.name;
        }
        return "";

    }
}
