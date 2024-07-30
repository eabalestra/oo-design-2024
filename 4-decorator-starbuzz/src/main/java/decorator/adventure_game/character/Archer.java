package decorator.adventure_game.character;


import decorator.adventure_game.FightStyle;

public class Archer extends Character {

    public Archer() {
        fightStyle = FightStyle.RANGED;
    }
}
