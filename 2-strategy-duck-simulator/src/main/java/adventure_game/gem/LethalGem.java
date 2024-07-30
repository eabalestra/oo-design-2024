package adventure_game.gem;

import adventure_game.weapon.Weapon;

public class LethalGem extends Gem {
    private final int LETHAL_GEM_DAMAGE = 50;

    public LethalGem(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int useWeapon() {
        return LETHAL_GEM_DAMAGE + weapon.useWeapon();
    }
}
