package TheRailgun.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import TheRailgun.DefaultMod;
import TheRailgun.characters.TheDefault;


import java.util.Iterator;

import static TheRailgun.DefaultMod.makeCardPath;

public class Gekota_Keychain extends AbstractDynamicCard {

    public static final String ID = DefaultMod.makeID(Gekota_Keychain.class.getSimpleName());
    public static final String IMG = makeCardPath("gekota keychain.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 2;

    public Gekota_Keychain() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        Iterator var1 = AbstractDungeon.player.hand.group.iterator();
        Iterator var2 = AbstractDungeon.player.drawPile.group.iterator();
        Iterator var3 = AbstractDungeon.player.discardPile.group.iterator();

        int counter = 1;

        if (this.upgraded) {
            counter = 0;
        }

        while (var1.hasNext() && counter < 2) {
            AbstractCard c = (AbstractCard) var1.next();
            if (c.type == CardType.CURSE) {
                counter++;
                AbstractDungeon.actionManager.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
            }
        }
        while (var2.hasNext() && counter < 2) {
            AbstractCard c = (AbstractCard) var1.next();
            if (c.type == CardType.CURSE) {
                counter++;
                AbstractDungeon.actionManager.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.drawPile));
            }
        }
        while (var3.hasNext() && counter < 2) {
            AbstractCard c = (AbstractCard) var1.next();
            if (c.type == CardType.CURSE) {
                counter++;
                AbstractDungeon.actionManager.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.discardPile));
            }
        }
    }

        @Override
        public void upgrade () {
            if (!upgraded) {
                upgradeName();
                rawDescription = UPGRADE_DESCRIPTION;
                initializeDescription();
            }
        }
    }

