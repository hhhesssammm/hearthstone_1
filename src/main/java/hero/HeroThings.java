package hero;

import cards.Cards;
import cards.Minion;

import java.util.ArrayList;
import java.util.List;

public class HeroThings {
    private int hp=30;
    private int mana;
    private int attack;
    private Cards[] normalCards=new Cards[18];

    public Cards getNormalCards(int index) {
        return normalCards[index];
    }

    public void setNormalCards(Cards normalCards,int index) {
        this.normalCards[index] = normalCards;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }
}
