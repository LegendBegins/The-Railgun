package TheRailgun.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import TheRailgun.DefaultMod;
import TheRailgun.util.TextureLoader;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static TheRailgun.DefaultMod.makeRelicOutlinePath;
import static TheRailgun.DefaultMod.makeRelicPath;

public class CoinRelic extends CustomRelic {


    public static final String ID = DefaultMod.makeID("CoinRelic");

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("token_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("placeholder_relic.png"));

    public CoinRelic() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.MAGICAL);
    }


    @Override
    public void onPlayerEndTurn() {
        if (EnergyPanel.getCurrentEnergy() >= 3) {
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
        }
        else if (EnergyPanel.getCurrentEnergy() == 2){
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
        }
        else if (EnergyPanel.getCurrentEnergy() == 1) {
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));

        }
    }
    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
