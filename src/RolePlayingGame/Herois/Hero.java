package RolePlayingGame.Herois;

import RolePlayingGame.FantasyCharacter;
import RolePlayingGame.Merch.Merchant;
import RolePlayingGame.Merch.Seller;

public class Hero extends FantasyCharacter implements Seller {
    public Hero(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold); }


    @Override
    public String sell(Merchant.Goods goods) {
        return sell(Merchant.Goods.POTION);
    }

}



