package paket_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// 1. Schritt: Import der Fachklassen
import paket_Fachklasse.*;
import paket_FachklasseAB.FachklasseAB;
import paket_FachklasseAND.FachklasseAND;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.TextField;


public class GUI extends JFrame {

	private JPanel contentPane;

	// 2. Schritt: Variable (Instanz) der Fachklassen
	private Fachklasse objektKV;
	private FachklasseAB objektFachklasseAB;
	private FachklasseAND objektFachklasseAND;
	
	private JTextField txtDahrlehensumme;
	private JTextField txtZinssatz;
	private JTextField txtBarwertFd;
	private JTextField txtBarwertAd;
	private JTextField txtBarwertAnd;
	private JTextField txtBesteDarlehen;
	private JTextField txtAbzinsungsfaktor;
	private JTextField txtLaufzeit;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() 
	{	
		//3. Schritt: Erzeugung des Objekts der Fachklassen
		objektKV = new Fachklasse();
		objektFachklasseAB = new FachklasseAB();
		objektFachklasseAND = new FachklasseAND();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 634);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKreditartenvergleich = new JLabel("Kreditartenvergleich");
		lblKreditartenvergleich.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblKreditartenvergleich.setBounds(293, 13, 271, 61);
		contentPane.add(lblKreditartenvergleich);
		
		JLabel lblFestdarlehen = new JLabel("Festdarlehen");
		lblFestdarlehen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFestdarlehen.setBounds(39, 380, 98, 25);
		contentPane.add(lblFestdarlehen);
		
		JLabel lblAbzahlungsdarlehen = new JLabel("Abzahlungsdarlehen");
		lblAbzahlungsdarlehen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbzahlungsdarlehen.setBounds(353, 380, 174, 25);
		contentPane.add(lblAbzahlungsdarlehen);
		
		JLabel lblAnnuittendarlehen = new JLabel("Annuit\u00E4tendarlehen");
		lblAnnuittendarlehen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnnuittendarlehen.setBounds(676, 380, 174, 25);
		contentPane.add(lblAnnuittendarlehen);
		
		JLabel lblEingabefeld = new JLabel("Eingabefelder / Bitte Daten eintragen");
		lblEingabefeld.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEingabefeld.setBounds(280, 143, 298, 25);
		contentPane.add(lblEingabefeld);
		
		JLabel lblDarlehenssume = new JLabel("Darlehenssume");
		lblDarlehenssume.setBounds(99, 177, 114, 25);
		contentPane.add(lblDarlehenssume);
		
		
		JLabel lblZinssatz = new JLabel("Zinssatz");
		lblZinssatz.setBounds(514, 177, 77, 25);
		contentPane.add(lblZinssatz);
		
		txtDahrlehensumme = new JTextField();
		txtDahrlehensumme.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDahrlehensumme.setBounds(239, 178, 116, 22);
		contentPane.add(txtDahrlehensumme);
		txtDahrlehensumme.setColumns(10);
		
		
		txtZinssatz = new JTextField();
		txtZinssatz.setHorizontalAlignment(SwingConstants.RIGHT);
		txtZinssatz.setBounds(659, 178, 116, 22);
		contentPane.add(txtZinssatz);
		txtZinssatz.setColumns(10);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnExit.setBounds(745, 538, 136, 36);
		contentPane.add(btnExit);
		
		JButton btnLoeschen = new JButton("Daten l\u00F6schen");
		btnLoeschen.setForeground(Color.WHITE);
		btnLoeschen.setBackground(Color.DARK_GRAY);

		btnLoeschen.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoeschen.setBounds(600, 538, 136, 36);
		contentPane.add(btnLoeschen);
		
		JButton btnRechnen = new JButton("Berechne Barwerte");
		btnRechnen.setForeground(Color.WHITE);
		btnRechnen.setBackground(Color.RED);

		btnRechnen.setBounds(324, 276, 203, 40);
		contentPane.add(btnRechnen);
		
		txtBarwertFd = new JTextField();
		txtBarwertFd.setBackground(new Color(50, 205, 50));
		txtBarwertFd.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBarwertFd.setBounds(29, 418, 116, 22);
		contentPane.add(txtBarwertFd);
		txtBarwertFd.setColumns(10);
		
		txtBarwertAd = new JTextField();
		txtBarwertAd.setBackground(new Color(50, 205, 50));
		txtBarwertAd.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBarwertAd.setBounds(370, 418, 116, 22);
		contentPane.add(txtBarwertAd);
		txtBarwertAd.setColumns(10);
		
		txtBarwertAnd = new JTextField();
		txtBarwertAnd.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBarwertAnd.setBackground(new Color(50, 205, 50));
		txtBarwertAnd.setBounds(696, 418, 116, 22);
		contentPane.add(txtBarwertAnd);
		txtBarwertAnd.setColumns(10);
		
		Label textHintergrundB = new Label();
		textHintergrundB.setForeground(Color.WHITE);
		textHintergrundB.setBackground(new Color(51, 51, 51));
		textHintergrundB.setFont(new Font("Tahoma", Font.BOLD, 20));
		textHintergrundB.setText("BARWERTE");
		textHintergrundB.setBounds(370, 346, 125, 28);
		contentPane.add(textHintergrundB);
		
		Label labelGrey = new Label("");
		labelGrey.setBackground(new Color(51, 51, 51));
		labelGrey.setBounds(10, 342, 871, 36);
		contentPane.add(labelGrey);
		
		JLabel lblTextBW = new JLabel("Der Barwert gibt an, welcher Betrag heute angelegt (verzinst) werden muss, um dann am F\u00E4lligkeitstag der Zahlung den Betrag");
		lblTextBW.setToolTipText("");
		lblTextBW.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextBW.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTextBW.setBounds(29, 70, 852, 36);
		contentPane.add(lblTextBW);
		
		JLabel lblErreichtZuHaben = new JLabel("erreicht zu haben. Es gilt: Desto geringer der Barwert, umso besser das Darlehen.");
		lblErreichtZuHaben.setHorizontalAlignment(SwingConstants.LEFT);
		lblErreichtZuHaben.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblErreichtZuHaben.setBounds(29, 105, 852, 25);
		contentPane.add(lblErreichtZuHaben);
		
		JLabel lblDasBesteDarlehen = new JLabel("Das beste Darlehen, nach der Barwert Betrachtung, ist das");
		lblDasBesteDarlehen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDasBesteDarlehen.setBounds(29, 471, 457, 36);
		contentPane.add(lblDasBesteDarlehen);
		
		txtBesteDarlehen = new JTextField();
		txtBesteDarlehen.setBackground(new Color(255, 215, 0));
		txtBesteDarlehen.setBounds(475, 479, 125, 22);
		contentPane.add(txtBesteDarlehen);
		txtBesteDarlehen.setColumns(10);
		
		JLabel lblAbzinsungsfaktor = new JLabel("Abzinsungsfaktor");
		lblAbzinsungsfaktor.setBounds(514, 219, 116, 16);
		contentPane.add(lblAbzinsungsfaktor);
		
		txtAbzinsungsfaktor = new JTextField();
		txtAbzinsungsfaktor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAbzinsungsfaktor.setBounds(659, 216, 116, 22);
		contentPane.add(txtAbzinsungsfaktor);
		txtAbzinsungsfaktor.setColumns(10);
		
		JLabel lblAusrufezeichen = new JLabel("!");
		lblAusrufezeichen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAusrufezeichen.setBounds(609, 481, 21, 16);
		contentPane.add(lblAusrufezeichen);
		
		JLabel lblLaufzeit = new JLabel("Laufzeit in Jahren");
		lblLaufzeit.setBounds(99, 219, 128, 16);
		contentPane.add(lblLaufzeit);
		
		txtLaufzeit = new JTextField();
		txtLaufzeit.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLaufzeit.setBounds(239, 216, 116, 22);
		contentPane.add(txtLaufzeit);
		txtLaufzeit.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(360, 180, 56, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(780, 181, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("%");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(780, 219, 56, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u20AC");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(157, 421, 56, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u20AC");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(498, 420, 56, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u20AC");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(824, 421, 56, 16);
		contentPane.add(label_5);
		
				
				
				
		//Button für EXIT
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
			
		});//Ende des EXIT Btn
		
		
		
		//Button für das Rechnen		
		btnRechnen.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0)
			{
				//Texte rausnehmen für objektKV
				//Mit dieser Mehtode konvertiert man die Strings zu einem double Wert
				//Double groß geschrieben ist ein Objekt
				objektKV.setDarlehenssume(Double.parseDouble(txtDahrlehensumme.getText()));
				objektKV.setZinssatz(Double.parseDouble(txtZinssatz.getText()));
				objektKV.setAbzinsungsfaktor(Double.parseDouble(txtAbzinsungsfaktor.getText()));
				objektKV.setLaufzeit(Double.parseDouble(txtLaufzeit.getText()));
				//Texte rausnehmen für objektFachklasseAB
				objektFachklasseAB.setDarlehenssume(Double.parseDouble(txtDahrlehensumme.getText()));
				objektFachklasseAB.setZinssatz(Double.parseDouble(txtZinssatz.getText()));
				objektFachklasseAB.setAbzinsungsfaktor(Double.parseDouble(txtAbzinsungsfaktor.getText()));
				objektFachklasseAB.setLaufzeit(Double.parseDouble(txtLaufzeit.getText()));
				//Texte rausnehmen für objektFachklasseAnd
				objektFachklasseAND.setDarlehenssume(Double.parseDouble(txtDahrlehensumme.getText()));
				objektFachklasseAND.setZinssatz(Double.parseDouble(txtZinssatz.getText()));
				objektFachklasseAND.setAbzinsungsfaktor(Double.parseDouble(txtAbzinsungsfaktor.getText()));
				objektFachklasseAND.setLaufzeit(Double.parseDouble(txtLaufzeit.getText()));
						
			
				
				
				//Methoden aus Fachklassen laufen lassen
				objektKV.barwertfd();
				objektFachklasseAB.barwertad();	
				objektFachklasseAND.barwertand();

				
				//Ergebnisse in Texte umwandeln und den Textfeldern übergeben
				//double in einen String umwandeln
				txtBarwertFd.setText(Double.toString(objektKV.getBarwertFdgesamt()));
				txtBarwertAd.setText(Double.toString(objektFachklasseAB.getBarwertAdgesamt()));
				txtBarwertAnd.setText(Double.toString(objektFachklasseAND.getBarwertAndgesamt()));

				
				
				//if Bedingung
				//Anzeigen vom besten Kredit mit der if Bedinung
				//hiermit wird jeweils beim richtigen Kredit und bei der richtigen Bedingung der Kredit im Textfeld angezeigt
				
				
				//Erste Bedingung = Festdarlehen kleiner als Abzahlungsdarlehen?
						
				if (objektKV.getBarwertFdgesamt()<objektFachklasseAB.getBarwertAdgesamt())
				{
							
						//Ja, erste B.: Prüfung B.2
						//Zweite Bedingung: Festdarlehen kleiner als Annuitätendarlehen
							
						if (objektKV.getBarwertFdgesamt()<objektFachklasseAND.getBarwertAndgesamt())
						{
										
								//Ja, zweite B.: Text Ausgabe "Festdarlehen" (Anweisung)
								txtBesteDarlehen.setText("Festdarlehen");
									
						}
								
						else
						{
									
								//Nein, zweite B.: Text Ausgabe "Annuitätendarlehen" (Anweisung)									
								txtBesteDarlehen.setText("Annuitätendarlehen");
										
						}
								
				}	
						
					//Nein, erste B.: Prüfung B.3						
					else
					{
								
						//Dritte Bedingung: Abzahlungsdarlehen kleiner als Annuitätendarlehen
						if (objektFachklasseAB.getBarwertAdgesamt()<objektFachklasseAND.getBarwertAndgesamt())
						{		
									
								//Ja, dritte B.: Text Ausgabe "Abzahlungsdarlehen" (Anweisung)
								txtBesteDarlehen.setText("Abzahlungsdarlehen");
													
						}

						else
						{
											
								//Nein, dritte B.: Text Ausgabe "Annuitätendarlehen" (Anweisung)									
								txtBesteDarlehen.setText("Annuitätendarlehen");	
								
						}
					}

				} //Ende der if Bedingung 
			
			
			
		}); //Ende des Buttons (Barwerte berechnen)
		
		
		
		
		//Button fürs löschen
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Textfelder leer machen
				txtDahrlehensumme.setText("");
				txtLaufzeit.setText("");
				txtZinssatz.setText("");
				txtBarwertAd.setText("");
				txtBarwertAnd.setText("");
				txtBarwertFd.setText("");
				txtAbzinsungsfaktor.setText("");
				txtBesteDarlehen.setText("");
				
				//Methoden fürs leeren der Rechnungen
				objektKV.leerenVariablen();
				objektFachklasseAND.leerenVariablen();
				
				//In der console wird angezeigt, dass alles gelöscht ist.
				System.out.println("Alles gelöscht! Daten auf Null!");
			}
			
		}); //Ende des Buttons (Daten löschen)
		

		
		

	}
}
