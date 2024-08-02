package facade.adventure_game.weapon;

import facade.adventure_game.FightStyle;
public class Bow extends Weapon {
    private final int BOW_DAMAGE = 15;
    private final int BOW_MAX_GEMS = 2;

    public Bow() {
        this.fightStyle = FightStyle.RANGED;
    }

    @Override
    public int maxGems() {
        return BOW_MAX_GEMS;
    }

    @Override
    public int useWeapon() {
        return BOW_DAMAGE;
    }

}
