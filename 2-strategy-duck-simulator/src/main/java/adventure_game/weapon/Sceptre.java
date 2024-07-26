package adventure_game.weapon;

import adventure_game.FightStyle;

public class Sceptre implements Weapon {
    FightStyle fightStyle = FightStyle.MAGIC;

    @Override
    public int useWeapon() {
        return 10;
    }

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
}
