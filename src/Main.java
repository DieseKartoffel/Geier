
public class Main {
	public static void main(String[] args) {
		Deck deck = new Deck();
		Spieler p1 = new Bot();
		Spieler p2 = new Botv2();
		
		Spielfeld spiel1 = new Spielfeld(deck, p1, p2);
		spiel1.gameLoop();
	}
}
