import java.util.Random;
import java.util.Scanner;
public class Deck {
	
	int[] deck = new int[15];
	int[] playedCards = new int[15];
	
	//Consructor of deck:
	public Deck(){
		//filling deck[] with -5 to 10
		int a = -5;
		for (int i = 0; i < 15; i++){
			deck[i] = a;
			a++;
				if(a==0){
					a++;
			}
		}
	}
	

	//randomly returns 1 card of the deck that has not been returned yet
	public int getNextCard(){
		
		if (deck.length == 0){
			System.out.println("Deck leer");
			return 0;
		}
		
		Random r = new Random();
		int i = r.nextInt(deck.length);
		int card = deck[i];
		shortenDeck(deck[i]);
		return card;
	}
	
	//removes played cards out of deck[]
	int turn = 0;
	public void shortenDeck(int playedCard){
		//adding played card to array:
		playedCards[turn] = playedCard;
		turn++;
		
		//shorten deck by 1:
		this.deck = new int[deck.length-1];
		//filling deck again, without played cards:
		int a = -5;
		for (int i = 0; i < deck.length; i++){
			//if number is not in playedCards array yet: (skipping zero)
			if (a != 0 && notYetPlayed(a) == true){
				deck[i] = a;
				a++;
			}else{
				a++;
				i--;
			}	
		}
	}
	
	//has a card already been played? true = yes, false = no
	public boolean notYetPlayed(int a){
		for(int i = 0; i < playedCards.length; i++){
			if (a == playedCards[i]){
				return false;
			}
		}
		return true;
	}
	
	//allows user to return card by card from deck and check arrays
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		deck.printDeck();
		
		while(true){
		
			Scanner sc = new Scanner(System.in);
			System.out.print("1: Nächste Karte 2: Beenden ");
			int toDo = sc.nextInt();
			
			if(toDo == 1){
				System.out.println("Karte: " + deck.getNextCard());
				deck.printDeck();
			}else if(toDo ==2){
				return;
			}

		}
	}
	
	//for debugging: print decks to console as string:
	public void printDeck(){
		String deck = "";
		for (int i = 0; i < this.deck.length; i++) {
			deck += this.deck[i];
			deck += " ; ";
		}
		System.out.println("Im Deck: " + deck);
		
		String played = "";
		for (int i = 0; i < this.playedCards.length; i++) {
			played += this.playedCards[i];
			played += " ; ";
		}
		System.out.println("Aufgedeckte Karten: " + played);
	} 
	
}
