package adventure_game.weapon;

import adventure_game.FightStyle;

public class Sword extends Weapon {
    private final int SWORD_DAMAGE = 10;
    private final int SWORD_MAX_GEMS = 2;

    public Sword() {
        this.fightStyle =  FightStyle.MELEE;
    }
    @Override
    public int useWeapon() {
        return SWORD_DAMAGE;
    }

    @Override
    public int maxGems() {
        return SWORD_MAX_GEMS;
    }

}
