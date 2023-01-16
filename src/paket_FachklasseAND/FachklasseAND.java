package paket_FachklasseAND;

public class FachklasseAND
{
	
	//private = ein Zugriff au�erhalb der Klasse wird verboten � nur die Klasse selbst kann darauf zugreifen
	//			Nur �ber passende Methode (Getter und Setter) wird ein �ndern der Variablen erm�glicht
	//			Das Prinzip dahinter nennt man Geheimnisprinzip
	
	//double = ist eine Gleitkommavariable = sie merkt sich eine bestimmte Anzahl Ziffern und dazu die Position des Kommas
	
	private double darlehenssume;
	private double laufzeit;
	private double zinssatz;
	private double bestesDarlehen;
	private double abzinsungsfaktor;
	private double benoetigtesKapitalAnd;
	private double restschuldAnd;
	private double zinsenAnd;
	private double barwertAnd;
	private double barwertAndgesamt;
	private double lqbeand;
	//Startwert Jahr 1
	//Datentyp int wegen Ganzzahl (keine Komma Zahl)
	private int jahr=1;
	private double leerenVariablen;
	
	
	//Getters und Setters
	
	public double getLqbeand() {
		return lqbeand;
	}
	public void setLqbeand(double lqbeand) {
		this.lqbeand = lqbeand;
	}
	public double getDarlehenssume() {
		return darlehenssume;
	}
	public void setDarlehenssume(double darlehenssume) {
		this.darlehenssume = darlehenssume;
	}
	public double getLaufzeit() {
		return laufzeit;
	}
	public void setLaufzeit(double laufzeit) {
		this.laufzeit = laufzeit;
	}
	public double getZinssatz() {
		return zinssatz;
	}
	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}
	public double getBestesDarlehen() {
		return bestesDarlehen;
	}
	public void setBestesDarlehen(double bestesDarlehen) {
		this.bestesDarlehen = bestesDarlehen;
	}
	public double getAbzinsungsfaktor() {
		return abzinsungsfaktor;
	}
	public void setAbzinsungsfaktor(double abzinsungsfaktor) {
		this.abzinsungsfaktor = abzinsungsfaktor;
	}
	public double getBenoetigtesKapitalAnd() {
		return benoetigtesKapitalAnd;
	}
	public void setBenoetigtesKapitalAnd(double benoetigtesKapitalAnd) {
		this.benoetigtesKapitalAnd = benoetigtesKapitalAnd;
	}
	public double getRestschuldAnd() {
		return restschuldAnd;
	}
	public void setRestschuldAnd(double restschuldAnd) {
		this.restschuldAnd = restschuldAnd;
	}
	public double getZinsenAnd() {
		return zinsenAnd;
	}
	public void setZinsenAnd(double zinsenAnd) {
		this.zinsenAnd = zinsenAnd;
	}
	public double getBarwertAnd() {
		return barwertAnd;
	}
	public void setBarwertAnd(double barwertAnd) {
		this.barwertAnd = barwertAnd;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public double getBarwertAndgesamt() {
		return barwertAndgesamt;
	}
	public void setBarwertAndgesamt(double barwertAndgesamt) {
		this.barwertAndgesamt = barwertAndgesamt;
	}
	public double getLeerenVariablen() {
		return leerenVariablen;
	}
	public void setLeerenVariablen(double leerenVariablen) {
		this.leerenVariablen = leerenVariablen;
	}

	
	//Methode f�r das Berechnen des Barwerts von dem Annuit�tendarlehen
	public void barwertand()
	{
		
		//zur Ausgabe in der Console
		System.out.println("--------------------------------------------------------");
		System.out.println("Annuit�tendarlehen");
		
		
		//lokale Hilfsvariablen zur Berechnung des Barwertes und des Annuit�tenfaktors
		double abFAnd, abFAndg;
		double annuFaktor, wert1, wert1Pot, wert2,wert2Pot;
			
			//�bergabe der Werte f�r die Attribute mit Potenzen
			wert1 = ((1+(getZinssatz()/100)));
				
				//Potenzen immer mit Math.pow(Basis, Exponent[Hochzahl])
				wert1Pot = Math.pow(wert1, getLaufzeit());
				
			wert2 = ((1+(1/getZinssatz())));
				
				wert2Pot = Math.pow(wert2, getLaufzeit());
			
			//Annuit�tenfaktorfaktorformel mit den potenzierten Werten
			annuFaktor = ((wert1Pot)*(getZinssatz()/100))/(wert2Pot-1);
			System.out.println("Annuit�tenfaktor: "+annuFaktor);


		
		//Start der while Schleife
		//Laufzeit gr��er als Jahre (Start Jahr = 1 / nicht lokal gesetzt)
		while(getLaufzeit()>getJahr())
		{
					
			//setzten der Liquidit�tsbelastung
			setLqbeand(Math.round(getDarlehenssume()*annuFaktor));
			System.out.println("Liquidit�tsbelastung beim Annuit�tendarlehen: " +getLqbeand());
			
			//f�r den Barwert = Barwertformel und abFAndg zum potenzieren
			abFAnd=1/(1+(getAbzinsungsfaktor()/100));
			abFAndg=Math.pow(abFAnd, getJahr());
			
			//Barwert Berechnung = Liquidit�t mal den Barwertfaktor
			setBarwertAnd(Math.round(getLqbeand()*abFAndg));
			System.out.println("Barwerte Annuit�tendarlehen: "+getBarwertAnd());
			
			//Barwert summieren (Math.round = zum aufrunden der Zahlen)
			setBarwertAndgesamt(Math.round(getBarwertAndgesamt()+getBarwertAnd()));
			
			//bei jedem durchlauf der Schleife das Jahr um eins erh�hen
			//da keine lokale Hilfsvariable immer +1 anstatt ++
			setJahr(getJahr()+1);
			
		}
			
		//wenn das Jahr gleich der Laufzeit ist, ist die Schleife zu Ende und es f�llt in diese Berechnung des letzten Jahres
		//kaum Unterschiede nur noch den gesamten Barwert ausrechnen lassen
		
			abFAnd=1/(1+(getAbzinsungsfaktor()/100));
			abFAndg=Math.pow(abFAnd, getJahr());
			
			setBarwertAnd(Math.round(getLqbeand()*abFAndg));
			System.out.println("Barwert letztes Jahr Annuit�tendarlehen: "+getBarwertAnd());		
			
			setBarwertAndgesamt(Math.round(getBarwertAnd() + getBarwertAndgesamt()));
			System.out.println("Barwert gesamt Annuit�tendarlehen: "+getBarwertAndgesamt());					
	}
	//Ende der Methode f�r das Berechnen des Barwerts von dem Annuit�tendarlehen
	
	
	
	//Methode: leeren der Daten aus dem Annuit�tendarlehen
	public void leerenVariablen()
	{
		setLqbeand(0);
		setZinsenAnd(0);
		setZinssatz(0);
		setRestschuldAnd(0);
		setBarwertAnd(0);
		setBarwertAndgesamt(0);
		setBenoetigtesKapitalAnd(0);
		setJahr(1);
		setDarlehenssume(0);
		setAbzinsungsfaktor(0);
		setLaufzeit(0);
		setBestesDarlehen(0);
	}
}
