package main.effect;

import java.util.ArrayList;
import java.util.List;

import main.entity.Renaud;

public enum Bonus {
    LANCE_DE_BRIQUE("Lancé de brique", 0, BonusType.SPELL, SpellType.ATTACK, 1, 15),
    POING_BOUCHE("Poing-bouche", 0, BonusType.SPELL, SpellType.ATTACK, 3, 25),

    SORTSCALEEX("1", 0, BonusType.SPELL_SCALING, SpellType.HEALTH, 3, 50),
    BUFFEX("2", 0, BonusType.BUFF, SpellType.DEFENSE, 20);

    private String name;
    private int rarity;
    private BonusType type;
    private SpellType spellType;
    private int cooldown;
    private int value;

    private Bonus(String name, int rarity, BonusType type, SpellType spellType, int cooldown, int value) {
        this.name = name;
        this.rarity = rarity;
        this.type = type;
        this.spellType = spellType;
        this.cooldown = cooldown;
        this.value = value;
    }

    private Bonus(String name, int rarity, BonusType type, SpellType spellType, int value) {
        this(name, rarity, type, spellType, 0, value);
    }

    public List<Bonus> getBonusList() {
        ArrayList<Bonus> res = new ArrayList<Bonus>();
        for(Bonus b : values()) {
            res.add(b);
        }
        return res;
    }

    public int calcValue(Renaud renaud) {
        int v = value;
        if (type.equals(BonusType.SPELL)) {
            return v;
        }
        if (spellType.equals(SpellType.ATTACK)) {
            
            return (int) (value*(renaud.getAtk()*0.01));
        }
        if (spellType.equals(SpellType.DEFENSE)) {
            return (int) (value*(renaud.getDef()*0.01));
        }
        return (int) (value*(renaud.getHp()*0.01));
    }

    public BonusType getBonusType() {
        return type;
    }
}
