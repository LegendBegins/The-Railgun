package TheRailgun.powers;

import TheRailgun.cards.Needle;
import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.EnemyMoveInfo;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import TheRailgun.DefaultMod;
import TheRailgun.util.TextureLoader;

import static TheRailgun.DefaultMod.makePowerPath;

public class MentalPower extends AbstractPower implements CloneablePowerInterface {
    public AbstractCreature source;

    public static final String POWER_ID = DefaultMod.makeID("MentalPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public byte nextIntent;
    public AbstractMonster m;
    public AbstractMonster.Intent moveIntent;
    public EnemyMoveInfo nextMoveInfo;
    public boolean used = false;


    // We create 2 new textures *Using This Specific Texture Loader* - an 84x84 image and a 32x32 one.
    private static final Texture tex84 = TextureLoader.getTexture("TheRailgunResources/images/powers/placeholder_power84.png");
    private static final Texture tex32 = TextureLoader.getTexture("TheRailgunResources/images/powers/placeholder_power32.png");

    public MentalPower(final AbstractCreature owner, final AbstractCreature source, final int amount, AbstractMonster m) {
        name = NAME;
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;
        this.source = source;

        type = PowerType.DEBUFF;
        isTurnBased = true;


        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);

        this.m = m;
        this.nextIntent = m.nextMove;
        this.moveIntent = m.intent;

        m.setMove((byte) -1, AbstractMonster.Intent.STUN);
        m.createIntent();

        updateDescription();
    }


    @Override
    public void atEndOfRound() {
        m.setMove(this.nextIntent, this.moveIntent);
        m.createIntent();
        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }



    @Override
    public AbstractPower makeCopy() {
        return new MentalPower(owner, source, amount, m);
    }
}

