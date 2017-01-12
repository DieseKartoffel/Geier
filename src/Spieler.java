import java.util.InputMismatchException;
import java.util.Scanner;

public class Spieler {
	
	int[] coinCards = new int[15];
	int[] playedCards = new int[15];
	int punkte = 0;
	String name = "default";
	static int id = 1;
	boolean isABot = false;
	
	public Spieler(){
		setName();
		this.name = getName();
		id++;
		int a = 1;
		for(int i = 0; i < coinCards.length; i++){
			coinCards[i] = a;
			a++;
		}
	}
	
	//gets player input, checks if its valid, and if so returns setzen(input);
	public int whatToBet(Deck deck, Spieler p1, Spieler p2, int mitte){
		return whatToBet();
	}
	
	public int whatToBet(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Einsatz "+name+":");
		try {
		int eingabe = sc.nextInt();
		return setzen(eingabe);
		} catch (InputMismatchException e) {
			System.out.println("Versuchs nochmal!");
			return whatToBet();
		}
	}
	
	
	//return value of Coincard player chose, and turn its value in CoinCards[] to 0
	//if player input has already been played -> retry
	int a = 0;
	public int setzen(int eingabe){
		
		//check if input has already been played
		if (eingabe > 15 || eingabe <= 0){
			System.out.println("Versuchs nochmal!");
			return whatToBet();
		}
		if (coinCards[eingabe-1]==0){
			System.out.println("Diesen Betrag hast du bereits gesetzt!");
			return whatToBet();
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
	public void setName(){
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Spieler "+ id +" - Dein Name: ");
	    String eingabe = sc.next();
		this.name = eingabe;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	//Debugging:
	public static void main(String[] args) {
		Spieler p1 = new Spieler();
		while (true){
		p1.whatToBet();
		p1.printCoins();
		}
	}
	
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
	public boolean isABot(){
		return isABot;
	}
}

