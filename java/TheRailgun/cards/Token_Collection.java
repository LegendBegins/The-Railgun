package TheRailgun.cards;

import TheRailgun.actions.AddCardFromGridSelectAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheRailgun.DefaultMod;
import TheRailgun.characters.TheDefault;
import TheRailgun.orbs.DefaultOrb;
import com.megacrit.cardcrawl.orbs.*;

import static TheRailgun.DefaultMod.makeCardPath;

public class Token_Collection extends AbstractDynamicCard {

    public static final String ID = DefaultMod.makeID(Token_Collection.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("token collection.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 2;

    public Token_Collection() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);

    }

    @Override

        public void use(AbstractPlayer p, AbstractMonster m) {
            if (!this.upgraded) {
                AbstractDungeon.actionManager.addToTop(new AddCardFromGridSelectAction(p, p.discardPile, 1, "", true));
            }
            else {
                AbstractDungeon.actionManager.addToTop(new AddCardFromGridSelectAction(p, p.discardPile, 2, "", true));
            }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

}
