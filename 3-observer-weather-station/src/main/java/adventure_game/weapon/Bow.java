package adventure_game.weapon;

import adventure_game.FightStyle;

public class Bow implements Weapon {
    FightStyle fightStyle = FightStyle.RANGED;

    @Override
    public int useWeapon() {
        return 15;
    }

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
}
