/*

package TheRailgun.powers;


import TheRailgun.cards.Needle;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import TheRailgun.DefaultMod;
import TheRailgun.util.TextureLoader;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;

import java.util.Iterator;

import static TheRailgun.DefaultMod.makePowerPath;

public class ElectronMovementPower extends AbstractPower implements CloneablePowerInterface {
    public AbstractCreature source;

    public boolean used = false;
    public static final String POWER_ID = DefaultMod.makeID("ElectronMovementPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    private static final Texture tex84 = TextureLoader.getTexture(makePowerPath("placeholder_power84.png"));
    private static final Texture tex32 = TextureLoader.getTexture(makePowerPath("placeholder_power32.png"));

    public ElectronMovementPower(final AbstractCreature owner, final AbstractCreature source, final int amount) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;
        this.source = source;

        type = PowerType.BUFF;
        isTurnBased = false;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        updateDescription();
    }

    public void increaseCost(Iterator var3) {
        while(var3.hasNext()) {
            AbstractCard c = (AbstractCard)var3.next();
            if (c.isCostModified) {
                c.modifyCostForCombat(1);
                c.isCostModified = false;
            }
        }

    }

    @Override
    public void atEndOfTurn (boolean isPlayer) {
        if (!used) {
            increaseCost(AbstractDungeon.player.hand.group.iterator());

        }


    }



    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, this));
        increaseCost(AbstractDungeon.player.hand.group.iterator());
        this.used = true;
    }

    @Override
    public AbstractPower makeCopy() {
        return new ElectronMovementPower(owner, source, amount);
    }
}

*/