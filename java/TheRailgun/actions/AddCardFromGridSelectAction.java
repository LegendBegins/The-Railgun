package TheRailgun.actions;

import TheRailgun.characters.*;
import TheRailgun.actions.CardActions.Railgun.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
import com.megacrit.cardcrawl.cards.CardGroup.CardGroupType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddCardFromGridSelectAction extends AbstractRailgunAction {
    private static final Logger logger = LogManager.getLogger(AddCardFromGridSelectAction.class.getName());
    private ArrayList<AbstractCard> cards;
    private CardGroup temp;
    private boolean discard;

    public AddCardFromGridSelectAction(AbstractPlayer p, CardGroup cardGroup, int numCards, String note, boolean discard) {
        this(p, cardGroup.group, numCards, note, discard);
    }

    public AddCardFromGridSelectAction(AbstractPlayer p, CardGroup cardGroup, int numCards, String note) {
        this(p, cardGroup.group, numCards, note);
        this.temp = cardGroup;
    }

    public AddCardFromGridSelectAction(AbstractPlayer p, ArrayList<AbstractCard> cards, int numCards, String note, boolean discard) {
        this.cards = new ArrayList();
        this.discard = discard;
        this.p = p;
        if (p instanceof TheDefault) {
        }

        this.isDone = false;
        this.cards = cards;
        if (cards.size() < 1 && !this.discard) {
            // if (p instanceof TheDefault) {
            //  cards.add(new ChloeCreateableTraceCard());
            // } else {
            AbstractCard tmpCd = AbstractDungeon.getColorlessCardFromPool(CardRarity.UNCOMMON);
            cards.add(tmpCd);
            //   }
        }

        this.temp = new CardGroup(CardGroupType.CARD_POOL);
        Iterator var8 = cards.iterator();

        while(var8.hasNext()) {
            AbstractCard c = (AbstractCard)var8.next();
            UnlockTracker.markCardAsSeen(c.cardID);
            this.temp.group.add(c);
        }

        AbstractDungeon.gridSelectScreen.open(this.temp, numCards, true, note);
    }

    public AddCardFromGridSelectAction(AbstractPlayer p, ArrayList<AbstractCard> cards, int numCards, String note) {
        this.cards = new ArrayList();
        this.p = p;
        if (p instanceof TheDefault) {
        }

        this.isDone = false;
        this.cards = cards;
        if (cards.size() < 1 && !this.discard) {
            if (p instanceof TheDefault) {
                //    cards.add(new ChloeCreateableTraceCard());
                // } else {
                AbstractCard tmpCd = AbstractDungeon.getColorlessCardFromPool(CardRarity.UNCOMMON);
                cards.add(tmpCd);
            }
        }

        this.temp = new CardGroup(CardGroupType.CARD_POOL);
        Iterator var7 = cards.iterator();

        while(var7.hasNext()) {
            AbstractCard c = (AbstractCard)var7.next();
            UnlockTracker.markCardAsSeen(c.cardID);
            this.temp.group.add(c);
        }

        AbstractDungeon.gridSelectScreen.open(this.temp, numCards, true, note);
    }

    public void update() {
        if (!this.isDone && !AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
            Iterator var1 = AbstractDungeon.gridSelectScreen.selectedCards.iterator();

            while(var1.hasNext()) {
                AbstractCard c = (AbstractCard)var1.next();
                this.p.hand.moveToHand(c, this.temp);
                this.temp.group.remove(c);
            }

            AbstractDungeon.gridSelectScreen.selectedCards.clear();
            this.p.hand.refreshHandLayout();
            this.isDone = true;
        }

        if (AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
            this.isDone = true;
        }

    }
}


