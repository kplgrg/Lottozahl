package lottoZahlApp.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import lottoZahlApp.controller.LottoZahlAppController;
import lottoZahlApp.model.LottoZahl;
import lottoZahlApp.model.Sechs49;
import lottoZahlApp.model.Spiel77;
import lottoZahlApp.model.Super6;
import lottoZahlApp.model.SuperZahl;



public class LottoZahlView extends JFrame implements ActionListener {

	private LottoZahl ziehungsZahlen;

	private JButton btn_start, btn_superzahl, btn_spiel77, btn_super6, btn_6aus49, btn_back;
	private JPanel launchPanel;
	private JPanel menuPanel;
	private JPanel panelContainer;
	private JButton btn_generate;
	private CardLayout card;
	private static JDialog dlg_result;
	private JLabel lbl_logo;

	public LottoZahlView() {


//		*********** Start von Bilder ***********

		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/image/lotto1.png"));
//		ImageIcon logo = new ImageIcon("lotto1.png");
		Image reLogo = logo.getImage();
		Image newImage = reLogo.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
		Image newImg1 = reLogo.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		logo = new ImageIcon(newImage);
		ImageIcon img1 = new ImageIcon(newImg1);



//		*********** Container-Panel für CardLayout zum Umschalten zwischen Panels ***********

		launchPanel = new JPanel();
		menuPanel = new JPanel();
		card = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(card);
		panelContainer.add(launchPanel,"1");
		panelContainer.add(menuPanel, "2");
		card.show(panelContainer, "1");

//		*********** Anfang von Buttons *************

		btn_start = new JButton();
		btn_start.setText("Bitte klicken Sie um fortzufahren");
		btn_start.setIcon(logo);
		btn_start.setForeground(new Color(19,98,7));
		btn_start.setBounds(225,225,150, 75);
		btn_start.setFocusable(true);
		btn_start.setBorder(emptyBorder);
		btn_start.addActionListener(this);
		btn_start.setFont(new Font("Roboto", Font.PLAIN	, 12));
		btn_start.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn_start.setHorizontalTextPosition(SwingConstants.CENTER);
		launchPanel.setLayout(new BorderLayout(0, 0));
		launchPanel.add(btn_start);



		btn_superzahl = new JButton();
		btn_superzahl.setFont(new Font("Roboto", Font.PLAIN, 26));
		btn_superzahl.setForeground(new Color(19,98,7));
		btn_superzahl.setText("Superzahl");
		btn_superzahl.addActionListener(this);


		btn_6aus49 = new JButton();
		btn_6aus49.setText("6 aus 49");
		btn_6aus49.setFont(new Font("Roboto", Font.PLAIN, 26));
		btn_6aus49.setForeground(new Color(19,98,7));
		btn_6aus49.addActionListener(this);
		menuPanel.setLayout(new GridLayout(0, 2, 0, 0));
		menuPanel.add(btn_6aus49);
		menuPanel.add(btn_superzahl);

		btn_spiel77 = new JButton();
		btn_spiel77.setBackground(new Color(0, 136, 255));
		btn_spiel77.setFont(new Font("Roboto", Font.PLAIN, 26));
		btn_spiel77.setForeground(new Color(19,98,7));
		btn_spiel77.setText("Spiel 77");

		btn_spiel77.addActionListener(this);
		menuPanel.add(btn_spiel77);

		btn_super6 = new JButton();
		btn_super6.setFont(new Font("Roboto", Font.PLAIN, 26));
		btn_super6.setForeground(new Color(19,98,7));
		btn_super6.setText("Super 6");
		btn_super6.addActionListener(this);
		menuPanel.add(btn_super6);

		lbl_logo = new JLabel();
		lbl_logo.setIcon(img1);
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setVerticalAlignment(SwingConstants.CENTER);
		menuPanel.add(lbl_logo);

		btn_back = new JButton();
		btn_back.setFont(new Font("Roboto", Font.PLAIN, 26));
		btn_back.setForeground(new Color (19,98,7));
		btn_back.setText("Zurück");
		btn_back.addActionListener(this);
		menuPanel.add(btn_back);

		menuPanel.setBorder(new CompoundBorder());
		menuPanel.setBackground(Color.WHITE);

//		*********** End of Buttons *************

//		*********** Hauptframe *************

		setTitle("Wilkommen zu Kaffee Negroni Lottozahl Generator");
		getContentPane().add(panelContainer);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(reLogo);
		setBounds(1500,200,500,500);
		setResizable(true);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		 Führt zu Menübildschirm
		if (e.getSource()== btn_start) {
			card.show(panelContainer, "2");
		}
		
//		 Führt zurück zu Hauptmenü
		else if (e.getSource()==btn_back) {
			card.show(panelContainer, "1");
		}
		
//		 Generiert Lottozahlen 6 aus 49 
		else if (e.getSource() == btn_6aus49) {
			ziehungsZahlen = new Sechs49();
			LottoZahlAppController.generateLottoZahl(ziehungsZahlen);

		}
		
//		 Generiert Lottozahlen Spiel77
		else if (e.getSource() == btn_spiel77) {
			ziehungsZahlen = new Spiel77();
			LottoZahlAppController.generateLottoZahl(ziehungsZahlen);

		}
		
//		 Generiert Lottozahlen Super6
		else if (e.getSource() == btn_super6) {
			ziehungsZahlen = new Super6();
			LottoZahlAppController.generateLottoZahl(ziehungsZahlen);

		}
		
//		 Generiert Lottozahlen Superzahl
		else if (e.getSource() == btn_superzahl) {
			ziehungsZahlen = new SuperZahl();
			LottoZahlAppController.generateLottoZahl(ziehungsZahlen);

		}

	}
//  Erstellt ein neues Dialogfeld zur Anzeige der generierten Zufallszahlen
	public void ergebnisseAnzeigen(ArrayList<Integer> lottoZahl, LottoZahl ziehung) {
		ziehungsZahlen = ziehung;
		StringBuilder result = new StringBuilder();

		for(Integer zahl: lottoZahl) {
			result.append(zahl).append("  ");
		}

		String showResult = result.toString();
		JLabel lbl_result = new JLabel(showResult);

		lbl_result.setVerticalAlignment(SwingConstants.CENTER);
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setForeground(new Color(19,98,7));
		lbl_result.setFont(new Font("Roboto", Font.PLAIN, 20));

		btn_generate = new JButton("Generieren");
		btn_generate.setForeground(new Color(19,98,7));
		btn_generate.setFont(new Font("Roboto",Font.PLAIN, 24));
		btn_generate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg_result.dispose();
				LottoZahlAppController.generateLottoZahl(ziehungsZahlen);
			}

		});

		dlg_result = new JDialog(this,"Dies sind Ihre aktuell gezogenen Zahlen", true);
		dlg_result.setLayout(new GridLayout(2,0));
		dlg_result.add(lbl_result);
		dlg_result.add(btn_generate);
		dlg_result.setBounds(1500,700,400,400);
		dlg_result.setVisible(true);
 
	}

}
