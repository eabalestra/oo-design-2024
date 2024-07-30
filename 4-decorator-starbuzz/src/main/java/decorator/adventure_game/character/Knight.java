package decorator.adventure_game.character;

import decorator.adventure_game.FightStyle;

public class Knight extends Character {

    public Knight() {
        fightStyle = FightStyle.MELEE;
    }
}