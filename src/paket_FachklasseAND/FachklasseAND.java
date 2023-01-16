package paket_FachklasseAND;

public class FachklasseAND
{
	
	//private = ein Zugriff außerhalb der Klasse wird verboten – nur die Klasse selbst kann darauf zugreifen
	//			Nur über passende Methode (Getter und Setter) wird ein ändern der Variablen ermöglicht
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

	
	//Methode für das Berechnen des Barwerts von dem Annuitätendarlehen
	public void barwertand()
	{
		
		//zur Ausgabe in der Console
		System.out.println("--------------------------------------------------------");
		System.out.println("Annuitätendarlehen");
		
		
		//lokale Hilfsvariablen zur Berechnung des Barwertes und des Annuitätenfaktors
		double abFAnd, abFAndg;
		double annuFaktor, wert1, wert1Pot, wert2,wert2Pot;
			
			//Übergabe der Werte für die Attribute mit Potenzen
			wert1 = ((1+(getZinssatz()/100)));
				
				//Potenzen immer mit Math.pow(Basis, Exponent[Hochzahl])
				wert1Pot = Math.pow(wert1, getLaufzeit());
				
			wert2 = ((1+(1/getZinssatz())));
				
				wert2Pot = Math.pow(wert2, getLaufzeit());
			
			//Annuitätenfaktorfaktorformel mit den potenzierten Werten
			annuFaktor = ((wert1Pot)*(getZinssatz()/100))/(wert2Pot-1);
			System.out.println("Annuitätenfaktor: "+annuFaktor);


		
		//Start der while Schleife
		//Laufzeit größer als Jahre (Start Jahr = 1 / nicht lokal gesetzt)
		while(getLaufzeit()>getJahr())
		{
					
			//setzten der Liquiditätsbelastung
			setLqbeand(Math.round(getDarlehenssume()*annuFaktor));
			System.out.println("Liquiditätsbelastung beim Annuitätendarlehen: " +getLqbeand());
			
			//für den Barwert = Barwertformel und abFAndg zum potenzieren
			abFAnd=1/(1+(getAbzinsungsfaktor()/100));
			abFAndg=Math.pow(abFAnd, getJahr());
			
			//Barwert Berechnung = Liquidität mal den Barwertfaktor
			setBarwertAnd(Math.round(getLqbeand()*abFAndg));
			System.out.println("Barwerte Annuitätendarlehen: "+getBarwertAnd());
			
			//Barwert summieren (Math.round = zum aufrunden der Zahlen)
			setBarwertAndgesamt(Math.round(getBarwertAndgesamt()+getBarwertAnd()));
			
			//bei jedem durchlauf der Schleife das Jahr um eins erhöhen
			//da keine lokale Hilfsvariable immer +1 anstatt ++
			setJahr(getJahr()+1);
			
		}
			
		//wenn das Jahr gleich der Laufzeit ist, ist die Schleife zu Ende und es fällt in diese Berechnung des letzten Jahres
		//kaum Unterschiede nur noch den gesamten Barwert ausrechnen lassen
		
			abFAnd=1/(1+(getAbzinsungsfaktor()/100));
			abFAndg=Math.pow(abFAnd, getJahr());
			
			setBarwertAnd(Math.round(getLqbeand()*abFAndg));
			System.out.println("Barwert letztes Jahr Annuitätendarlehen: "+getBarwertAnd());		
			
			setBarwertAndgesamt(Math.round(getBarwertAnd() + getBarwertAndgesamt()));
			System.out.println("Barwert gesamt Annuitätendarlehen: "+getBarwertAndgesamt());					
	}
	//Ende der Methode für das Berechnen des Barwerts von dem Annuitätendarlehen
	
	
	
	//Methode: leeren der Daten aus dem Annuitätendarlehen
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
