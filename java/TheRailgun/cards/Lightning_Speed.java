package TheRailgun.cards;

import TheRailgun.powers.HeroinismPower;
import TheRailgun.powers.LightningSpeedPower;
import TheRailgun.powers.MagneticFlightPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheRailgun.DefaultMod;
import TheRailgun.characters.TheDefault;


import static TheRailgun.DefaultMod.makeCardPath;

public class Lightning_Speed extends AbstractDynamicCard {

    public static final String ID = DefaultMod.makeID(Lightning_Speed.class.getSimpleName());
    public static final String IMG = makeCardPath("lightning speed.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 3;
    private static final int UPGRADE_REDUCED_COST = 2;
    private static final int MAGIC = 1;

    public Lightning_Speed() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MAGIC;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                new LightningSpeedPower(p, p, magicNumber), magicNumber));

    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            initializeDescription();
            rawDescription = UPGRADE_DESCRIPTION;
            upgradeBaseCost(UPGRADE_REDUCED_COST);
        }
    }
}
