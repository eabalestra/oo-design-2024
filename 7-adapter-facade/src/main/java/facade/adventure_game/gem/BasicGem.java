package facade.adventure_game.gem;

import facade.adventure_game.weapon.Weapon;
public class BasicGem extends Gem {
    private final int BASIC_GEM_DAMAGE = 10;

    public BasicGem(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int useWeapon() {
        return BASIC_GEM_DAMAGE + weapon.useWeapon();
    }
}
