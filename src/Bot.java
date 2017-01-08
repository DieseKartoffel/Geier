import java.util.InputMismatchException;
import java.util.Scanner;

public class Bot extends Spieler{

	static Spielfeld botGame = new Spielfeld();
	
	public static void main(String[] args) {
		botGame.gameLoop();;
	}
	
	
	public Bot(){
		this.name = "Bot";
		id++;
		int a = 1;
		for(int i = 0; i < coinCards.length; i++){
			coinCards[i] = a;
			a++;
		}
	}
	
	
	//Bot setzt immer den Betrag der Mitte, wenn dieser schon gesetzt ist den nächst höhren.
	//wenn alle höheren schon gesetzt sind, sucht er den nächst tieferen, vom betrag ausgehen:
	
	
	public int setzen(){
		int a = Math.abs(botGame.getMitte());
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
		return setzen(a);
	}
	
	//return value of Coincard player chose, and turn its value in CoinCards[] to 0
	//if player input has already been played -> retry
	int a = 0;
	public int setzen(int eingabe){
		
		//check if input has already been played
		if (eingabe > 15 || eingabe <= 0){
			System.out.println("Versuchs nochmal!");
			return setzen();
		}
		if (coinCards[eingabe-1]==0){
			System.out.println("Diesen Betrag hast du bereits gesetzt!");
			return setzen();
		}else{
		
		
		//if not:
		for(int i = 0; i < coinCards.length; i++){
			if (coinCards[i]==eingabe){
				coinCards[i] = 0;
				break;
			}
		}
		
		playedCards[a] = eingabe;
		a++;
		
		return eingabe;
		}
	}
	
	//user enters name
	public String getName(){
	    return "Bot";
	}
	
	
	//Debugging:

	public void printCoins(){
		String hand = "";
		for (int i = 0; i < this.coinCards.length; i++) {
			hand += this.coinCards[i];
			hand += " ; ";
		}
		System.out.println("Verfügbar: " + hand);
		
		String played = "";
		for (int i = 0; i < this.playedCards.length; i++) {
			played += this.playedCards[i];
			played += " ; ";
		}
		System.out.println("Gespielt: " + played);
	} 
}

