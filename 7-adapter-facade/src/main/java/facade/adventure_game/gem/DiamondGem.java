package facade.adventure_game.gem;

import facade.adventure_game.weapon.Weapon;
public class DiamondGem extends Gem {
    private final int DIAMOND_GEM_DAMAGE = 15;

    public DiamondGem(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int useWeapon() {
        return DIAMOND_GEM_DAMAGE + weapon.useWeapon();
    }
}
