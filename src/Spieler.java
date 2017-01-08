import java.util.InputMismatchException;
import java.util.Scanner;

public class Spieler {
	
	int[] coinCards = new int[15];
	int[] playedCards = new int[15];
	int punkte = 0;
	String name = "default";
	static int id = 1;
	
	public Spieler(){
		this.name = getName();
		id++;
		int a = 1;
		for(int i = 0; i < coinCards.length; i++){
			coinCards[i] = a;
			a++;
		}
	}
	
	//gets player input and starts returns setzen(input);
	public int setzen(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Einsatz "+name+":");
		try {
		int eingabe = sc.nextInt();
		return setzen(eingabe);
		} catch (InputMismatchException e) {
			System.out.println("Versuchs nochmal!");
			return setzen();
		}
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
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Spieler "+ id +" - Dein Name: ");
	    String eingabe = sc.next();
		return eingabe;
	}
	
	
	//Debugging:
	public static void main(String[] args) {
		Spieler p1 = new Spieler();
		while (true){
		p1.setzen();
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
}

