package adventure_game.weapon;

import adventure_game.FightStyle;

public class Knife implements Weapon {
    FightStyle fightStyle = FightStyle.MELEE;

    @Override
    public int useWeapon() {
        return 10;
    }

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
}
