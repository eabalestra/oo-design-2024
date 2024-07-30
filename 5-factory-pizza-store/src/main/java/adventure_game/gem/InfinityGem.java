package adventure_game.gem;

import adventure_game.weapon.Weapon;

public class InfinityGem extends Gem {
    private final int INFINITY_GEM_DAMAGE = 100;

    public InfinityGem(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int useWeapon() {
        return INFINITY_GEM_DAMAGE + weapon.useWeapon();
    }
}
