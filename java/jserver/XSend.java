package jserver;

import java.io.PrintStream;

import javax.swing.JTextArea;

public abstract class XSend {
	Board board = null;
	public String result = "";
	static PrintStream stdout = System.out;

	abstract public void send() throws InterruptedException ;

	public void setUp(JTextArea messageField) {
		TOutputStream tos = new TOutputStream( System.out, messageField);
		PrintStream outStream = new PrintStream(tos, true); 
		System.setOut(outStream);
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setDown() {
		System.setOut(stdout);
	}
	
	public  void setBoard(Board board) {
		this.board = board;
	}

	public void groesse(int x, int y) {
		result +=  board.receiveMessage(">>r " + x + " " + y );
	}

	public void hintergrund(int i, int f) {
		result +=  board.receiveMessage( ">>b " + i + " " + f );
	}

	public void hintergrund2(int i, int j, int f) {
		result +=  board.receiveMessage(">>#b " + i + " " + j + " " + f );
	}

	public void flaeche(int f) {
		result +=  board.receiveMessage(">>ba " + f );
	}

	public void rahmen(int f) {
		result +=  board.receiveMessage(">>bo " + f );
	}

	public void loeschen() {
		result +=  board.receiveMessage(">>c");
	}

	public void farben(int f) {
		result +=  board.receiveMessage(">>a " + f );
	}

	public  void farbe(int i, int f) {
		result += board.receiveMessage(  ">>" + i + " " + f );
	}

	public void grau(int i, int g) {
		farbe(i, g << 16 | g << 8 | g);
	}

	public void farbe2(int i, int j, int f) {
		result +=  board.receiveMessage(">># " + i + " " + j + " " + f );
	}

	public void grau2(int i, int j, int g) {
		farbe2(i, j, g << 16 | g << 8 | g);
	}

	public void formen(String f) {
		result +=  board.receiveMessage(">>f " + f );
	}

	public void form(int i, String f) {
		result +=  board.receiveMessage(">>fi " + i + " " + f );
	}

	public void form2(int i, int j, String f) {
		result +=  board.receiveMessage(">>#fi " + i + " " + j + " " + f );
	}

	public void symbolGroesse(int i, double s) {
		result +=  board.receiveMessage(">>s " + i + " " + s );
	}

	public void symbolGroesse2(int i, int j, double s) {
		result +=  board.receiveMessage(">>#s " + i + " " + j + " " + s );
	}

	public void text(int i, String f) {
		result +=  board.receiveMessage(">>T " + i + " " + f );
	}

	public void text2(int i, int j, String f) {
		result +=  board.receiveMessage(">>#T " + i + " " + j + " " + f );
	}

	public void zeichen(int i, char c) {
		result +=  board.receiveMessage(">>#T " + i + " " + c );
	}

	public void zeichen2(int i, int j, char c) {
		result +=  board.receiveMessage(">>#T " + i + " " + j + " " + c );
	}

	public void statusText(String s) {
		result +=  board.receiveMessage(">>t " + s );
	}
	
	public String abfragen() {
		return board.receiveMessage(">>p \n"  );
	}
}
