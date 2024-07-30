package decorator.adventure_game.character;

import decorator.adventure_game.FightStyle;

public class Thief extends Character {

    public Thief(){
        fightStyle = FightStyle.MELEE;
    }
}
