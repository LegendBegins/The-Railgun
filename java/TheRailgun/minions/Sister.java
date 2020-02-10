/*

package TheRailgun.minions;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import kobting.friendlyminions.monsters.AbstractFriendlyMonster;
import kobting.friendlyminions.monsters.MinionMove;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import kobting.friendlyminions.monsters.AbstractFriendlyMonster;
import kobting.friendlyminions.monsters.MinionMove;

public class Sister extends AbstractFriendlyMonster {
    public static String ID = "Sister";
    public static MonsterStrings monsterStrings;
    public static String[] MOVES;
    public static String[] DIALOG;
    public static String NAME;
    private AbstractMonster target;
    public int baseDamageAmount = 5;
    public int baseBlockAmount = 4;
    private boolean renderCheckpoint = false;

    public Sister(float x, float y) {
        super(NAME, ID, 20, -8.0F, 10.0F, 230.0F, 240.0F, "TheRailgunResources/images/char/defaultCharacter/standing/Mis000_00.png", x, y);
        this.addMoves();
        System.out.println("FOX FAMILIAR: initialized at (" + x + "," + y + ").");
    }

    private void addMoves() {
        this.moves.addMove(new MinionMove("Attack", this, new Texture("TheRailgunResources/images/monsters/atk_bubble.png"), "Deal 5 damage", () -> {
            target = AbstractDungeon.getRandomMonster();
            DamageInfo info = new DamageInfo(this,5,DamageInfo.DamageType.NORMAL);
            info.applyPowers(this, target); // <--- This lets powers effect minions attacks
            AbstractDungeon.actionManager.addToBottom(new DamageAction(target, info));
        }));
        this.moves.addMove(new MinionMove("Defend", this, new Texture("TheRailgunResources/images/monsters/block_bubble.png"),"Gain 5 block", () -> {
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this,this, 5));
        }));
    }

    public void render(SpriteBatch sb) {
        if (!this.renderCheckpoint) {
            System.out.println("FOX FAMILIAR: render method reached for the first time");
            this.renderCheckpoint = true;
        }

        super.render(sb);
    }

    static {
        monsterStrings = CardCrawlGame.languagePack.getMonsterStrings(ID);
        MOVES = monsterStrings.MOVES;
        DIALOG = monsterStrings.DIALOG;
        NAME = monsterStrings.NAME;
    }
}


*/