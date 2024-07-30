package adventure_game.weapon;

import adventure_game.FightStyle;

public abstract class Weapon {
    protected FightStyle fightStyle;

    public abstract int maxGems();

    public abstract int useWeapon();

    public int gemCount() {
        return 0;
    }

    public FightStyle getFightStyle() {
        return this.fightStyle;
    }
}
