public class Bot extends Spieler{
	
	boolean isABot = true;
	
	public static void main(String[] args) {
		//botGame.gameLoop();
	}
	
	
	public Bot(){
		setName();
		this.name = getName();
		id++;
		int a = 1;
		//fill hand with cards 1-15:
		for(int i = 0; i < coinCards.length; i++){
			coinCards[i] = a;
			a++;
		}
	}
	
	
	//Bot setzt immer den Betrag der Mitte, wenn dieser schon gesetzt ist den nächst höheren.
	//wenn alle höheren schon gesetzt sind, such er den nächst tieferen, vom betrag ausgehend:
	//equivalent to playerInput, but this one is found by algorithm
	public int whatToBet(Deck deck, Spieler p1, Spieler p2, int mitte){
		int a = Math.abs(mitte);
		int b = a;
		boolean low = false;
		
		if (a > 15){
			b = 15;
			low = true;
		}
		
		while (low == false && this.coinCards[a-1] == 0){
			a++;
			if (a==16){
				low = true;
				break;
			}
		}
		if(low){
			a = b;
			while (this.coinCards[a-1] == 0){
				a--;
			}
		}
		int bet = a;
		if(okayToBet(bet)){
			refreshStuff(bet);
			return bet;
		}
		else return 0;
	}
	
	public boolean okayToBet(int bet){
		if (bet > 15 || bet <= 0){
			System.out.println("Bet out of bounds");
			return false;
		}
		if (coinCards[bet-1]==0){
			System.out.println("Bot tries to bet value multiple times");
			return false;
		}
		return true;
	}
	
	
	//current card:
	int a = 0;
	//refreshes the array of cards left to play and the array of played cards
	public void refreshStuff(int bet){
		for(int i = 0; i < coinCards.length; i++){
			if (coinCards[i]==bet){
				coinCards[i] = 0;
				break;
			}
		}
		
		playedCards[a] = bet;
		a++;
	}
	
	
	
	public void setName(){
		this.name = "Bot 1";
	}
	public String getName(){
	    return name;
	}
	
}

