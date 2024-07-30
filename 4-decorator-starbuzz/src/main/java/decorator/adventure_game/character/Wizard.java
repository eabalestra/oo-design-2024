package decorator.adventure_game.character;

import decorator.adventure_game.FightStyle;

public class Wizard extends Character {

    public Wizard() {
        fightStyle = FightStyle.MAGIC;
    }

}