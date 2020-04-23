package cards;

public class Spell extends Cards {
    private Cards cards;
    private String effective;
    public Spell(String name, String type, Integer mana, String description,String effective,int attack) {
        super(name, type, mana, description,attack);
        this.effective=effective;
    }

    public Cards getCards() {
        return cards;
    }
}
