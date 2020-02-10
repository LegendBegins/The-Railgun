/*
package TheRailgun.cards;

import TheRailgun.powers.ElectronMovementPower;
import TheRailgun.powers.OneesamaPower;
import TheRailgun.powers.OverloadPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.unique.ApotheosisAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheRailgun.DefaultMod;
import TheRailgun.characters.TheDefault;
import TheRailgun.orbs.DefaultOrb;
import com.megacrit.cardcrawl.orbs.*;
import com.megacrit.cardcrawl.actions.unique.ApotheosisAction;

import java.util.Iterator;

import static TheRailgun.DefaultMod.makeCardPath;

public class Electron_Movement extends AbstractDynamicCard {

    public static final String ID = DefaultMod.makeID(Electron_Movement.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("electron movement.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;


    public Electron_Movement() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        reduceCost(p.hand.group.iterator());
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                new ElectronMovementPower(p, p, magicNumber), magicNumber));
        this.cost = 1;
        this.isCostModified = false;
    }

    public void reduceCost(Iterator var3) {
        while(var3.hasNext()) {
            AbstractCard c = (AbstractCard)var3.next();
            if (c.cost > 0) {
                c.modifyCostForCombat(-1);
                c.isCostModified = true;
            }
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.initializeDescription();
        }
    }

}


*/