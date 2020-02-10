package TheRailgun.cards;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheRailgun.DefaultMod;
import TheRailgun.characters.TheDefault;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static TheRailgun.DefaultMod.makeCardPath;

public class Electrical_Storm extends CustomCard {

    public static final String ID = DefaultMod.makeID(Electrical_Storm.class.getSimpleName());
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    public static final String IMG = makeCardPath("electrical storm.png");

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 0;
    private static final int DAMAGE = 0;

    public Electrical_Storm() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);

        baseDamage = DAMAGE;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!this.upgraded) {
            AbstractDungeon.actionManager.addToBottom(
                    new DamageAction(m, new DamageInfo(p, this.energyOnUse, damageTypeForTurn),
                            AbstractGameAction.AttackEffect.LIGHTNING));

            AbstractDungeon.actionManager.addToBottom(
                    new DamageAction(m, new DamageInfo(p, this.energyOnUse, damageTypeForTurn),
                            AbstractGameAction.AttackEffect.LIGHTNING));
        }
        if(this.upgraded) {
            AbstractDungeon.actionManager.addToTop(new DamageAllEnemiesAction(p, new int[]{this.energyOnUse, this.energyOnUse, this.energyOnUse, this.energyOnUse, this.energyOnUse}, this.damageType, AbstractGameAction.AttackEffect.LIGHTNING));
            AbstractDungeon.actionManager.addToTop(new DamageAllEnemiesAction(p, new int[]{this.energyOnUse, this.energyOnUse, this.energyOnUse, this.energyOnUse, this.energyOnUse}, this.damageType, AbstractGameAction.AttackEffect.LIGHTNING));
        }
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}
