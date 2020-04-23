package cards;

public class Cards {
    private String name;
    private int mana;
    private String Description;
    private String type;
    private int attack=0;
    public Cards(String name, String type, Integer mana, String description,int attack){
        this.name=name;
        this.mana=mana;
        this.Description=description;
        this.attack=attack;
        if(attack!=0){
            this.type=type+" weapon";
        }else {
            this.type = type;
        }
    };

    public int getAttack() {
        return attack;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMana(int mana) {
        if(mana<0){
            this.mana=0;
        }else {
            this.mana = mana;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }
}
