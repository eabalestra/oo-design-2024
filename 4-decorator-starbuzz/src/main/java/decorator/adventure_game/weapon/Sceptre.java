package decorator.adventure_game.weapon;

import decorator.adventure_game.FightStyle;

public class Sceptre extends Weapon {
    private final int SCEPTRE_PUNCH_DAMAGE = 10;
    private final int SCEPTRE_PUNCH_MAX_GEMS = 3;

    public Sceptre() {
        this.fightStyle = FightStyle.MAGIC;
    }

    @Override
    public int maxGems() {
        return SCEPTRE_PUNCH_MAX_GEMS;
    }

    @Override
    public int useWeapon() {
        return SCEPTRE_PUNCH_DAMAGE;
    }
}
