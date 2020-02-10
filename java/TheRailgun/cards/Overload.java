package TheRailgun.cards;

import TheRailgun.powers.OneesamaPower;
import TheRailgun.powers.OverloadPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
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

public class Overload extends AbstractDynamicCard {

    public static final String ID = DefaultMod.makeID(Overload.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("overload.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 3;
    private static final int UPGRADE_REDUCED_COST = 2;

    public Overload() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        reduceCost(p.hand.group.iterator());
        reduceCost(p.exhaustPile.group.iterator());
        reduceCost(p.drawPile.group.iterator());
        reduceCost(p.discardPile.group.iterator());
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                new OverloadPower(p, p, magicNumber), magicNumber));
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
            rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
            upgradeBaseCost(UPGRADE_REDUCED_COST);
        }
    }

}
