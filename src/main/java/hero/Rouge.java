package hero;

import cards.Cards;
import cards.Spell;

public class Rouge {
    private HeroThings heroThings=new HeroThings();
    private Spell[] heroSpell=new Spell[2];
    private Cards[] cards=new Cards[13];

    public Rouge(Spell heroCard1,Spell heroCard2){
        heroCard1=new Spell("Friendly Smith","spell",1,"Discover a weapon from any class.Add it to your Adventure Deck with +2/-2","add it your saved cards",0);
        this.heroSpell[0]=heroCard1;
        heroCard2=new Spell("Healer","spell",2,"Add 5 heal to a minion","its for just for one",0);
        this.heroSpell[1]=heroCard2;
    }
    public  Cards heroPower(Cards cards) {
        /**mana cost*/
        heroThings.setMana(heroThings.getMana()-3);
        /**for adding card to my card*/
        return cards;
    }

    public void specialPower(Cards cards) {
        /**ghabel ertegha*/

            cards.setMana(cards.getMana()-2);

    }
}