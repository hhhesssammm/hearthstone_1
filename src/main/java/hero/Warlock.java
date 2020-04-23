package hero;

import cards.Cards;
import cards.Minion;
import cards.Spell;

import java.util.Random;

public class Warlock  {
    private HeroThings heroThings=new HeroThings();
    private Spell[] heroSpell=new Spell[2];
    private Cards[] cards=new Cards[13];
    public void specialPower(){
        heroThings.setHp(35);
    }
    Random rand = new Random();
    int rand_int1 = rand.nextInt(2);
    public void heroPower1(Minion minion) {
        if (rand_int1 == 1) {
            minion=new Minion(minion.getName(),minion.getType(),minion.getMana(),minion.getDescription(),minion.getAttack()+1,minion.getHp()+1);
        }
    }
    public void heropower2(){
        if(rand_int1==0){

        }
    }
}
