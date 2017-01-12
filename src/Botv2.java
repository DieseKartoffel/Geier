
public class Botv2 extends Bot{
	
	String name = "Bot 2";
	boolean isABot = true;
	
	public int whatToBet(Deck deck, Spieler p1, Spieler p2, int mitte){
		int bet = 5;
		if(okayToBet(bet)){
			refreshStuff(bet);
			return bet;
		}
		else
		return 0;
	}
	
	public void setName(){
		this.name = "Bot 2";
	}
	
	public String getName(){
	    return name;
	}
	
}
