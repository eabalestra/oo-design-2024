package decorator.adventure_game.weapon;

import decorator.adventure_game.FightStyle;

public class Knife extends Weapon {
    private final int KNIFE_DAMAGE = 10;
    private final int KNIFE_MAX_GEMS = 3;

    public Knife() {
        this.fightStyle = FightStyle.MELEE;
    }

    @Override
    public int maxGems() {
        return KNIFE_MAX_GEMS;
    }

    @Override
    public int useWeapon() {
        return KNIFE_DAMAGE;
    }

}
