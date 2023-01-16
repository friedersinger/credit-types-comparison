package paket_FachklasseAB;

public class FachklasseAB
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
	private double benoetigtesKapitalAd;
	private double restschuldAd;
	private double zinsenAd;
	private double barwertAd;
	private double tilgungAd;
	private double liqbe;
	private double liqbege;
	//Startwert Jahr 1
	//Datentyp int wegen Ganzzahl (keine Komma Zahl)
	private int jahr=1;
	private double barwertAdgesamt;
	
	
	//Getters und Setters
	
	public double getLiqbege() {
		return liqbege;
	}
	public void setLiqbege(double liqbege) {
		this.liqbege = liqbege;
	}
	public double getLiqbe() {
		return liqbe;
	}
	public void setLiqbe(double liqbe) {
		this.liqbe = liqbe;
	}
	public double getTilgungAd() {
		return tilgungAd;
	}
	public void setTilgungAd(double tilgungAd) {
		this.tilgungAd = tilgungAd;
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
	public double getBenoetigtesKapitalAd() {
		return benoetigtesKapitalAd;
	}
	public void setBenoetigtesKapitalAd(double benoetigtesKapitalAd) {
		this.benoetigtesKapitalAd = benoetigtesKapitalAd;
	}
	public double getRestschuldAd() {
		return restschuldAd;
	}
	public void setRestschuldAd(double restschuldAd) {
		this.restschuldAd = restschuldAd;
	}
	public double getZinsenAd() {
		return zinsenAd;
	}
	public void setZinsenAd(double zinsenAd) {
		this.zinsenAd = zinsenAd;
	}
	public double getBarwertAd() {
		return barwertAd;
	}
	public void setBarwertAd(double barwertAd) {
		this.barwertAd = barwertAd;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public double getBarwertAdgesamt() {
		return barwertAdgesamt;
	}
	public void setBarwertAdgesamt(double barwertAdgesamt) {
		this.barwertAdgesamt = barwertAdgesamt;
	}
	
	
	//Methode für das Berechnen des Barwerts vom Abzahlungsdarlehen
	public void barwertad()
	{
		
		//zur Ausgabe in der Console
		System.out.println("--------------------------------------------------------");
		System.out.println("Abzahlungsdarlehen");
		
		//lokale Hilfsvariablen für den Barwert
		double abFAB,abPotenzAB;
		
		//Restschuld beim ersten Mal gesetzt mit der Darlehenssumme
		setRestschuldAd(getDarlehenssume());
		
		//Schleife läuft so lange, bis das Jahr gleichgroß ist wie die Laufzeit (sprich bis zum Ende)
		while(getLaufzeit()>=getJahr())
		{
			
			//für die Berechnung des Barwertes
			abFAB=1/(1+(getAbzinsungsfaktor()/100));
		    abPotenzAB=Math.pow(abFAB, getJahr());
		    
		    //die Restschuld wird in jedem Jahr um eine Tilgung weniger
		    setRestschuldAd(getRestschuldAd()-getTilgungAd());
		    
		    //die Tilgung ist immer gleich (Darlehenssumme / Laufzeit)
		    setTilgungAd(getDarlehenssume()/getLaufzeit());		
		    
		    //die Zinsen ergeben sich immer aus der neuen Restschuld
			setZinsenAd(getRestschuldAd()*(getZinssatz()/100));
			System.out.println("Zinsen beim Abzahlungsdarlehen: "+getZinsenAd());
			
			//die Liquiditätsbelastung setzt sich aus Zinsen plus Tilgung zusammen
			setLiqbe(getZinsenAd()+getTilgungAd());

			//die gesamte Liquiditätsbelastung (Math.round zum aufrunden)
			setLiqbege(Math.round(getLiqbege()+getLiqbe()));
			System.out.println("Liquiditätsbelastung beim Abzahlungsdarlehen: "+getLiqbege());
			
			//Barwert Berechnung aus Liquiditätsbelastung und des Barwertsfaktors
			setBarwertAd(Math.round(getLiqbe()*abPotenzAB));
			System.out.println("Barwerte im einzelen Jahr Abzahlungsdarlehen: "+getBarwertAd());
			
			//Barwert gesamt berechnen
			setBarwertAdgesamt(Math.round(getBarwertAd() + getBarwertAdgesamt()));
			System.out.println("Barwerte aufaddiert beim Abzahlungsdarlehen: "+getBarwertAdgesamt());
			
			//bei jedem durchlauf der Schleife das Jahr um eins erhöhen
			//da keine lokale Hilfsvariable immer +1 anstatt ++
			setJahr(getJahr()+1);
			
		}
		//Ende der Schleife
	}
	//Ende der Methode
	
	
}
