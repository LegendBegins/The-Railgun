package TheRailgun.actions.CardActions.Railgun;

        import TheRailgun.cards.Railgun;
        import com.megacrit.cardcrawl.actions.AbstractGameAction;
        import com.megacrit.cardcrawl.characters.AbstractPlayer;
        import com.megacrit.cardcrawl.core.AbstractCreature;
        import TheRailgun.characters.*;

public abstract class AbstractRailgunAction extends AbstractGameAction {
    public AbstractPlayer p;
    public AbstractCreature target;

    public AbstractRailgunAction() {
    }

    public boolean isRailgun(AbstractPlayer player) {
        return player instanceof TheDefault;
    }
}
