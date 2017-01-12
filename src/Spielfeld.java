
public class Spielfeld {
	Deck deck;
	Spieler p1;
	Spieler p2;
	
	public Spielfeld(Deck deck, Bot p1, Bot p2){
		this.deck = deck;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Spielfeld(Deck deck, Spieler p1, Spieler p2){
		this.deck = deck;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	
	
	int round = 0;
	int mitte = 0;
	
	public int getMitte(){
		return mitte;
	}
	
	public void gameLoop(){
		
		boolean print = true;
		if(p1.isABot() && p2.isABot())
			print = false;
				
		while (deck.deck.length > 0){
			//get card
			if(print)
				System.out.println("------------------------------------------");
			int card = deck.getNextCard();
			if(print){
				System.out.println("Die Karte " + card + " wurde aufgedeckt!");
				deck.printDeck();
			}
			mitte += card;
			if(print)
				System.out.println("In der Mitte liegen: " + mitte);
			if(mitte == 0){
				if(print)
					System.out.println("In diesem Fall wird neu aufgedeckt!");
				continue;
			}
			if(print)
			System.out.println("");
			//get bets
			
			int a = p1.whatToBet(deck, p1, p2, getMitte());		
			if(print){
				System.out.println(p1.name + " hat " + a + " gesetzt!");
				p1.printCoins();
				System.out.println("");
				}
			
			int b = p2.whatToBet(deck, p1, p2, getMitte());
			if(print){
				System.out.println(p2.name + " hat " + b + " gesetzt!");
				p2.printCoins();
				System.out.println("");
			}
			//higher bet gets points
			//exept middle is <0, smaller bet gets negative points
			if(mitte<0){
				int c = a;
				a = b;
				b = c;
			}
			if(a>b){
				p1.punkte += mitte;
				if(print)
					System.out.println(p1.name + " hat " + mitte + " Punkte bekommen. Neuer Stand: " + p1.punkte);
				mitte = 0;
			}
			if(b>a){p2.punkte += mitte;
				if(print)
					System.out.println(p2.name + " hat " + mitte + " Punkte bekommen. Neuer Stand: " + p2.punkte);
				mitte = 0;
			}
			//in case of draw:
			if(a==b){
				if(print)
					System.out.println("Unentschieden! Punkte bleiben in der Mitte!");;
			}
		}
		Spieler winner = null;
		if(p1.punkte > p2.punkte){
			winner = p1;
		}
		if(p2.punkte > p1.punkte){
			winner = p2;
		}
		if(p1.punkte == p2.punkte){
			System.out.println("Unentschieden!!! Das gibts ja gar nicht!!!");
			return;
		}
				
		System.out.println("Glückwunsch! Mit "+ winner.punkte +" Punkten hat " + winner.name + " gewonnen!");
	}
	

}
