package adventure_game.weapon;

import adventure_game.FightStyle;

public class FistPunch implements Weapon {
    FightStyle fightStyle = FightStyle.MELEE;

    @Override
    public int useWeapon() {
        return 2;
    }

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
}
