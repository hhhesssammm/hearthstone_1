package cards;

public class Minion extends Cards {
    private Cards cards;
    private int hp;

    public Minion(String name, String type, Integer mana, String description,int attack,int minionHp) {
        super(name, type, mana, description,attack);
        this.hp=minionHp;
    }
    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Cards getCards() {
        return cards;
    }

    public int getHp() {
        return hp;
    }

}
