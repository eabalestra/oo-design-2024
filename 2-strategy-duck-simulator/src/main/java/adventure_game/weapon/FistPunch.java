package adventure_game.weapon;

import adventure_game.FightStyle;

public class FistPunch extends Weapon {
    private final int FIST_PUNCH_DAMAGE = 2;
    private final int FIST_PUNCH_MAX_GEMS = 4;

    public FistPunch() {
        this.fightStyle = FightStyle.MELEE;
    }

    @Override
    public int maxGems() {
        return FIST_PUNCH_MAX_GEMS;
    }

    @Override
    public int useWeapon() {
        return FIST_PUNCH_DAMAGE;
    }
}
