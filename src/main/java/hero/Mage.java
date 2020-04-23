package hero;

import cards.Cards;
import cards.Spell;

public class Mage  {
    private HeroThings heroThings=new HeroThings();
    private Spell[] heroSpell=new Spell[2];
    private Cards[] cards=new Cards[13];
    public Mage(Spell heroCard1,Spell heroCard2){
        heroCard1=new Spell("Polymorph","spell",4,"Transfer a minion into a 1/1 sheep","its for all minions",0);
        this.heroSpell[0]=heroCard1;
        heroCard2=new Spell("Healer","spell",4,"Add 5 heal to hero","its for my hero",0);
        this.heroSpell[1]=heroCard2;
    }

    public Spell getHeroSpell(int index) {
        return heroSpell[index];
    }

    public void specialPower(Spell allSpell){
        allSpell.setMana(allSpell.getMana()-2);
    }
    /**return attacking power*/
    public int heroPower(){
        heroThings.setMana(heroThings.getMana()-2);
        /**return attacking power for all characters
         */
        return 1;
    }

}
