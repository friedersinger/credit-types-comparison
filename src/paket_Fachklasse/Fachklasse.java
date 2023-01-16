package paket_Fachklasse;

public class Fachklasse
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
	private double benoetigtesKapital;
	private double benoetigtesKapitalAd;
	private double benoetigtesKapitalAnd;
	private double restschuldAd;
	private double restschuldAnd;
	private double zinsen;
	private double zinsenAd;
	private double zinsenAnd;
	private double barwertFd;
	private double barwertAd;
	private double barwertAnd;
	//Startwert Jahr 1
	//Datentyp int wegen Ganzzahl (keine Komma Zahl)
	private int jahr=1;
	private double barwertFdgesamt;
	private double barwertAdgesamt;
	private double barwertAndgesamt;
	private double leerenVariablen;
	
	
	//Setters und Getters
	
	public double getLeerenVariablen() {
		return leerenVariablen;
	}
	public void setLeerenVariablen(double leerenVariablen) {
		this.leerenVariablen = leerenVariablen;
	}
	public double getRestschuldAd() {
		return restschuldAd;
	}
	public void setLaufzeit(double laufzeit) {
		this.laufzeit = laufzeit;
	}

	public double getLaufzeit() {
		return laufzeit;
	}
	public void setRestschuldAd(double restschuldAd) {
		this.restschuldAd = restschuldAd;
	}
	public double getRestschuldAnd() {
		return restschuldAnd;
	}
	public void setRestschuldAnd(double restschuldAnd) {
		this.restschuldAnd = restschuldAnd;
	}
	public double getBenoetigtesKapitalAd() {
		return benoetigtesKapitalAd;
	}
	public void setBenoetigtesKapitalAd(double benoetigtesKapitalAd) {
		this.benoetigtesKapitalAd = benoetigtesKapitalAd;
	}
	public double getBenoetigtesKapitalAnd() {
		return benoetigtesKapitalAnd;
	}
	public void setBenoetigtesKapitalAnd(double benoetigtesKapitalAnd) {
		this.benoetigtesKapitalAnd = benoetigtesKapitalAnd;
	}
	public double getZinsenAd() {
		return zinsenAd;
	}
	public void setZinsenAd(double zinsenAd) {
		this.zinsenAd = zinsenAd;
	}
	public double getZinsenAnd() {
		return zinsenAnd;
	}
	public void setZinsenAnd(double zinsenAnd) {
		this.zinsenAnd = zinsenAnd;
	}
	public double getBarwertFdgesamt() {
		return barwertFdgesamt;
	}
	public void setBarwertFdgesamt(double barwertFdgesamt) {
		this.barwertFdgesamt = barwertFdgesamt;
	}
	public double getBarwertAdgesamt() {
		return barwertAdgesamt;
	}
	public void setBarwertAdgesamt(double barwertAdgesamt) {
		this.barwertAdgesamt = barwertAdgesamt;
	}
	public double getBarwertAndgesamt() {
		return barwertAndgesamt;
	}
	public void setBarwertAndgesamt(double barwertAndgesamt) {
		this.barwertAndgesamt = barwertAndgesamt;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public double getBarwertFd() {
		return barwertFd;
	}
	public void setBarwertFd(double barwertFd) {
		this.barwertFd = barwertFd;
	}
	public double getBarwertAd() {
		return barwertAd;
	}
	public void setBarwertAd(double barwertAd) {
		this.barwertAd = barwertAd;
	}
	public double getBarwertAnd() {
		return barwertAnd;
	}
	public void setBarwertAnd(double barwertAnd) {
		this.barwertAnd = barwertAnd;
	}
	public double getBenoetigtesKapital() {
		return benoetigtesKapital;
	}
	public void setBenoetigtesKapital(double benoetigtesKapital) {
		this.benoetigtesKapital = benoetigtesKapital;
	}
	public double getAbzinsungsfaktor() {
		return abzinsungsfaktor;
	}
	public void setAbzinsungsfaktor(double abzinsungsfaktor) {
		this.abzinsungsfaktor = abzinsungsfaktor;
	}
	public double getDarlehenssume() {
		return darlehenssume;
	}
	public void setDarlehenssume(double darlehenssume) {
		this.darlehenssume = darlehenssume;
	}
	public double getZinssatz() {
		return zinssatz;
	}
	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
	}
	public double getZinsen() {
		return zinsen;
	}
	public void setZinsen(double zinsen) {
		this.zinsen = zinsen;
	}
	public double getBestesDarlehen() {
		return bestesDarlehen;
	}
	public void setBestesDarlehen(double bestesDarlehen) {
		this.bestesDarlehen = bestesDarlehen;
	}
	
	
	//METHODEN erstellen
	
	//Methode für Barwert von Festdarlehen
	public void barwertfd()
	{	
		
		//zur Ausgabe in der Console
		System.out.println("--------------------------------------------------------");
		System.out.println("Festdarlehen");
		
		
		//lokale Hilfsvariablen zur Berechnung des Barwerts
		double abF,abPotenz;
		
		//Start der while Schleife
		//Laufzeit größer als Jahre (Start Jahr = 1 / nicht lokal gesetzt)
		while(getLaufzeit()>getJahr())
		{
			
			//Barwertfaktor mit Math.pow zum potenzieren
			abF=1/(1+(getAbzinsungsfaktor()/100));
			abPotenz=Math.pow(abF, getJahr());
			
			//Zinsen immer gleich und jedes Jahr (ein Schleifen durchlauf) addieren
			setZinsen(getDarlehenssume()*(getZinssatz()/100));
			System.out.println("Zinsen Festdarlehen: "+getZinsen());
			
			//die Liquiditätsbelastung (hier das benötigte Kapital) immer mit den Zinsen (bis auf das letzte Jahr)
			setBenoetigtesKapital(getZinsen());
			
			//da bis auf das letzte Jahr mit den benötigten Kapital gerechnet wird, ist hier auch der Barwert die ersten Jahre mit ihm zu rechnen
			setBarwertFd(Math.round(benoetigtesKapital*abPotenz));
			System.out.println("Barwerte Festdarlehen: "+getBarwertFd());
			//Summe der Barwerte berechnen
			setBarwertFdgesamt(getBarwertFd() + getBarwertFdgesamt());
			
			//bei jedem durchlauf der Schleife das Jahr um eins erhöhen
			//da keine lokale Hilfsvariable immer +1 anstatt ++
			setJahr(getJahr()+1);
			
		}
		//wenn das Jahr gleich der Laufzeit ist, ist die Schleife zu Ende und es fällt in diese Berechnung des letzten Jahres
		//letztes Jahr wird die 
		
			//Barwertfaktor
		    abF=1/(1+(getAbzinsungsfaktor()/100));
		    abPotenz=Math.pow(abF, getJahr());
		    
		    //Zinsen gleich wie in der Schleife
			setZinsen(getDarlehenssume()*(getZinssatz()/100));
			System.out.println("Zinsen Festdarlehen: "+getZinsen());
			
			//im letzten Jahr ist das benötigte Kapital höher und zwar muss man die Darlehenssumme addieren
			//Tilgung der gesamten Summe im letzten Jahr bie Festdarlehen
			setBenoetigtesKapital(getZinsen()+getDarlehenssume());
			
			//Barwert berechnen und Summe bilden
			setBarwertFd(Math.round(benoetigtesKapital*abPotenz));
			System.out.println("Barwerte Festdarlehen: "+getBarwertFd());
			setBarwertFdgesamt(Math.round(getBarwertFd() + getBarwertFdgesamt()));
			

	}
	
	
	//Werte wieder auf Null setzten - damit kann eine neue Rechnung fortgeführt werden!
	public void leerenVariablen()
	{
		setZinsen(0);
		setZinsenAd(0);
		setZinsenAnd(0);
		
		setRestschuldAd(0);
		setRestschuldAnd(0);
		
		setBarwertFd(0);
		setBarwertAd(0);
		setBarwertAnd(0);
		
		setBenoetigtesKapital(0);
		setBenoetigtesKapitalAd(0);
		setBenoetigtesKapitalAnd(0);
		
		setBarwertAdgesamt(0);
		setBarwertAndgesamt(0);
		setBarwertFdgesamt(0);
		
		setJahr(1);
		setDarlehenssume(0);
		setAbzinsungsfaktor(0);
		setLaufzeit(0);
		setBestesDarlehen(0);
		

	}
		
		

	
	
}
