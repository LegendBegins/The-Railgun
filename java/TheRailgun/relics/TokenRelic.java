/*

package TheRailgun.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.CollectorCurseEffect;
import TheRailgun.DefaultMod;
import TheRailgun.util.TextureLoader;


import java.util.Iterator;

import static TheRailgun.DefaultMod.makeRelicOutlinePath;
import static TheRailgun.DefaultMod.makeRelicPath;

public class TokenRelic extends CustomRelic implements ClickableRelic { // You must implement things you want to use from StSlib


    // ID, images, text.
    public static final String ID = DefaultMod.makeID("TokenRelic");

    public int counter = 3;
    public boolean nextFight = false;

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("token_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("default_clickable_relic.png"));

    private boolean usedThisTurn = false; // You can also have a relic be only usable once per combat. Check out Hubris for more examples, including other StSlib things.
    private boolean isPlayerTurn = false; // We should make sure the relic is only activateable during our turn, not the enemies'.

    public TokenRelic() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.CLINK);

        tips.clear();
        tips.add(new PowerTip(name, description));
    }


    @Override
    public void onRightClick() {// On right click
        if (!isObtained) {

            return; // Don't do anything.
        }

        if (AbstractDungeon.getCurrRoom() != null && AbstractDungeon.getCurrRoom().phase != AbstractRoom.RoomPhase.COMBAT && !nextFight && this.counter > 0) { // Only if you're in combat
            nextFight = true; // Set relic as "Used this turn"
            flash(); // Flash
            stopPulse(); // And stop the pulsing animation (which is started in atPreBattle() below)

        }

    }


    @Override
    public void atPreBattle() {

        if (nextFight) {

            double chance = Math.random();

            Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
            Iterator bossChecker = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
            while (bossChecker.hasNext()) {

                AbstractMonster m = (AbstractMonster) bossChecker.next();
                if (m.type == AbstractMonster.EnemyType.BOSS) {
                    this.nextFight = false;
                    return;
                }
            }
            while (var1.hasNext()) {
                AbstractMonster m = (AbstractMonster) var1.next();

                if (chance < .5) {

                    AbstractDungeon.player.currentHealth--;
                    AbstractDungeon.player.healthBarUpdatedEvent();
                    break;

                } else {
                    m.currentHealth = 1;
                    m.healthBarUpdatedEvent();
                }

            }
        this.counter--;
        if (this.counter < 1) {

            this.usedUp();
        }
        }

    nextFight = false; // Make sure usedThisTurn is set to false at the start of each combat.
}


    public void atTurnStart() {
        usedThisTurn = false;
        isPlayerTurn = true;
    }

    @Override
    public void onPlayerEndTurn() {
        isPlayerTurn = false; // Not our turn now.
        stopPulse();
    }


    @Override
    public void onVictory() {
        stopPulse(); // Don't keep pulsing past the victory screen/outside of combat.
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
*/