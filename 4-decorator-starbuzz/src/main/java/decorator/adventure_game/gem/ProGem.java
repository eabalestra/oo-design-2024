package decorator.adventure_game.gem;

import decorator.adventure_game.weapon.Weapon;

public class ProGem extends Gem {
    private final int PRO_GEM_DAMAGE = 20;

    public ProGem(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int useWeapon() {
        return PRO_GEM_DAMAGE + weapon.useWeapon();
    }
}
