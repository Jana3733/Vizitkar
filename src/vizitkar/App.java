package vizitkar;

import vizitkar.Vizitka;
import java.awt.EventQueue;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelPanel panelPanel = new PanelPanel();
	private JPanel panelMain = new JPanel();
	private JPanel panel;
	private JButton btnLogo;
	private JPanel panelBorder;
	private PanelDesign panelDesign = new PanelDesign();
	private JComboBox comboBoxFontType;
	private JComboBox comboBoxAllignment;

	private int comboBoxTypeCislo = 0;
	private static Vizitka vizitka = new Vizitka();
	private JButton selectedButton;
	private PanelVizitka selectedPanel;
	private PanelVizitka panel_type1 = new PanelType1();
	private PanelVizitka panel_type2 = new PanelType2();
	private PanelVizitka panel_type3 = new PanelType3();
	private int style;
	private int fontSize;
	private JButton btnColorFG;
	private Color colorBG = new Color(255, 255, 255);
	private Color colorFG = new Color(255, 255, 255);
	private JComboBox comboBoxPomer;
	private int comboBoxPomerCislo = 0;
	private ImageIcon icon;
	private JButton btnRefresh;

	private boolean opened = false;
	private Vizitka openedVizitka;
	private String openedVizitkaNazov;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatDarkLaf());
					App frame = new App();
					frame.setVisible(true);
					frame.setSelectedPanel(frame.panel_type1);
					frame.setTheme(frame.getComboBoxTypeCislo());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Táto metóda spúšta App uz vytvorenej vizitky so všetkými dátami
	 * */
	public App(Vizitka vizitka) {
		this();
		zmenaTextu(vizitka.getMeno(), vizitka.getPriezvisko(),vizitka.getTitulPred(), vizitka.getTitulZa(), vizitka.getSpolocnost(), vizitka.getTelCislo(), vizitka.getEmail(), vizitka.getWeb(), vizitka.getAdresa());
		zmenaFarby(vizitka.getMenoColor(), vizitka.getSpolocnostColor(),vizitka.getTelCisloColor(), vizitka.getEmailColor(), vizitka.getWebColor(), vizitka.getAdresaColor());
		
		setAllign(Integer.parseInt(vizitka.getMenoAlign()), selectedPanel.getBtnMeno());
		setAllign(Integer.parseInt(vizitka.getSpolocnostAlign()), selectedPanel.getBtnSpolocnostName());
		setAllign(Integer.parseInt(vizitka.getTelCisloAlign()), selectedPanel.getBtnTelCislo());
		setAllign(Integer.parseInt(vizitka.getEmailAlign()), selectedPanel.getBtnEmail());
		setAllign(Integer.parseInt(vizitka.getWebAlign()), selectedPanel.getBtnWeb());
		setAllign(Integer.parseInt(vizitka.getAdresaAlign()), selectedPanel.getBtnAdresa());
		
		setFontType(Integer.parseInt(vizitka.getMenoFont()), selectedPanel.getBtnMeno());
		setFontType(Integer.parseInt(vizitka.getSpolocnostFont()), selectedPanel.getBtnSpolocnostName());
		setFontType(Integer.parseInt(vizitka.getTelCisloFont()), selectedPanel.getBtnTelCislo());
		setFontType(Integer.parseInt(vizitka.getEmailFont()), selectedPanel.getBtnEmail());
		setFontType(Integer.parseInt(vizitka.getWebFont()), selectedPanel.getBtnWeb());
		setFontType(Integer.parseInt(vizitka.getAdresaFont()), selectedPanel.getBtnAdresa());

		

		setComboBoxPomerCislo(Integer.parseInt(vizitka.getPomer()));
		setPomer();

		setColorBG(vizitka.getColorBG());
		switch (vizitka.getLogoORqr()) {
		case "0": {
			vizitka.setLogoORqr("0");
			break;
		}
		case "1": {
			vizitka.setLogoORqr("1");
			addLogo(vizitka.getLogoPath());
			break;
			
		}
		case "2": {
			vizitka.setLogoORqr("2");
			generateQR(vizitka.getQrColor());
			break;
		}};

		applyBackgroundColor(panelMain, vizitka.getColorBG());
		setTheme(Integer.parseInt(vizitka.getPanelType()));
	}
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 680);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(panelDesign, BorderLayout.NORTH);
		contentPane.add(panelPanel, BorderLayout.EAST);

		panelMain.setLayout(new FlowLayout());
		contentPane.add(panelMain, BorderLayout.CENTER);

		validate();
		repaint();
		// ------------------PANEL MAIN-------------------
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(160, 160, 160));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 160, 160));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelMain = new JPanel();
		panelMain.setBackground(new Color(126, 126, 126));
		panelMain.setOpaque(false);
		panelMain.setMaximumSize(new Dimension(500, 32767));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		// ------------------PANEL DESIGN-------------------

		panelDesign = new PanelDesign();
		contentPane.add(panelDesign, BorderLayout.NORTH);
		panelDesign.getComboBoxFontType().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFontType(panelDesign.getComboBoxFontType().getSelectedIndex(), getSelectedButton());
			}
		});
		panelDesign.getBtnColorFG().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorFG(setColor());
				setColorFGButtons(getColorFG(), getSelectedButton());
				//setDesign();
			}
		});
		panelDesign.getComboBoxAllignment().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAllign(panelDesign.getComboBoxAllignment().getSelectedIndex(), getSelectedButton());
			}
		});
		panelDesign.getBtnBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				App.this.dispose();
				Start start = new Start();
				start.setVisible(true);
			}
		});

		// ------------------PANEL Panel-------------------
		panelPanel = new PanelPanel();
		contentPane.add(panelPanel, BorderLayout.EAST);
		panelPanel.getBtnLogo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLogo();
			}
		});
		panelPanel.getBtnQR().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color qr= setColor();
				vizitka.setQrColor(qr);
				try {
					generateQR(qr);
				} catch (Exception e2) {
	                JOptionPane.showMessageDialog(null, "Na vytvorenie treba zadať web! ", "Error", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		panelPanel.getBtnRefresh().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zmenaTextu();
			}
		});

		panelPanel.getComboBoxType().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComboBoxTypeCislo(panelPanel.getComboBoxType().getSelectedIndex());
				setTheme(getComboBoxTypeCislo());
			}
		});
		panelPanel.getBtnColorBG().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setColorBG(setColor());
				applyBackgroundColor(panelMain, getColorBG());
				revalidate();
				repaint();
				
			}
		});
		panelPanel.getComboBoxPomer().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComboBoxPomerCislo(panelPanel.getComboBoxPomer().getSelectedIndex());
				setPomer();
			}
		});
		panelPanel.getBtnImport().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportDat importdat = new ImportDat();
				importdat.prehladavanieDat();
				App.this.dispose();
				
			}
		});
		panelPanel.getBtnExport().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportAsImage(panelBorder);
			}
		});
		panelPanel.getBtnPrint().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelPanel.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zmenaTextu();
				ulozenie();

			}
		});
		panelPanel.getBtnDisableLogo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableLogoQR();

			}
		});
		panelPanel.getBtnDisableQR().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableLogoQR();

			}
		});
		////////////// VYTVORENIE VIZITKY//////////
		panelBorder = new JPanel();
		panelBorder.setBorder(new EmptyBorder(0, 10, 0, 0));
		panelBorder.setBackground(new Color(255, 255, 255));
		panelMain.add(panelBorder);
		panelBorder.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		setSelectedPanel(panel_type1);
		getSelectedPanel().getBtnSpolocnostName().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnSpolocnostName());
			}
		});
		getSelectedPanel().getBtnMeno().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnMeno());
			}
		});
		getSelectedPanel().getBtnEmail().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnEmail());
			}
		});
		getSelectedPanel().getBtnTelCislo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnTelCislo());
			}
		});
		getSelectedPanel().getBtnWeb().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnWeb());
			}
		});
		getSelectedPanel().getBtnAdresa().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedButton(getSelectedPanel().getBtnAdresa());
			}
		});
		panelPanel.getBtnPrint().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printComponent();
			}
		});
		setTheme(0);

	}
	/**Metóda ktorá nastaví vybranú tému a taktiež obnoví vybraný dizajn vizitky
	 * 
	 * @param cislo číslo z comboBoxu daného motívu vizitky
	 * 
	 * */
	public void setTheme(int cislo) {
		panelBorder.removeAll();
		PanelVizitka newPanel = null;
		switch (cislo) {
		case 0:
			newPanel = panel_type1;
			break;
		case 1:
			newPanel = panel_type2;
			break;
		case 2:
			newPanel = panel_type3;
			break;
		}
		
		vizitka.setPanelType(""+cislo);
		setSelectedPanel(newPanel);
		zmenaTextu();
		zmenaFarby(vizitka.getMenoColor(), vizitka.getSpolocnostColor(),vizitka.getTelCisloColor(), vizitka.getEmailColor(), vizitka.getWebColor(), vizitka.getAdresaColor());
		
		setAllign(Integer.parseInt(vizitka.getMenoAlign()), selectedPanel.getBtnMeno());
		setAllign(Integer.parseInt(vizitka.getSpolocnostAlign()), selectedPanel.getBtnSpolocnostName());
		setAllign(Integer.parseInt(vizitka.getTelCisloAlign()), selectedPanel.getBtnTelCislo());
		setAllign(Integer.parseInt(vizitka.getEmailAlign()), selectedPanel.getBtnEmail());
		setAllign(Integer.parseInt(vizitka.getWebAlign()), selectedPanel.getBtnWeb());
		setAllign(Integer.parseInt(vizitka.getAdresaAlign()), selectedPanel.getBtnAdresa());
		
		setFontType(Integer.parseInt(vizitka.getMenoFont()), selectedPanel.getBtnMeno());
		setFontType(Integer.parseInt(vizitka.getSpolocnostFont()), selectedPanel.getBtnSpolocnostName());
		setFontType(Integer.parseInt(vizitka.getTelCisloFont()), selectedPanel.getBtnTelCislo());
		setFontType(Integer.parseInt(vizitka.getEmailFont()), selectedPanel.getBtnEmail());
		setFontType(Integer.parseInt(vizitka.getWebFont()), selectedPanel.getBtnWeb());
		setFontType(Integer.parseInt(vizitka.getAdresaFont()), selectedPanel.getBtnAdresa());
		
		applyBackgroundColor(panelMain, getColorBG());
		switch (vizitka.getLogoORqr()) {
		case "0": {
			vizitka.setLogoORqr("0");
			break;
		}
		case "1": {
			vizitka.setLogoORqr("1");
			addLogo(vizitka.getLogoPath());
			break;
			
		}
		case "2": {
			vizitka.setLogoORqr("2");
			generateQR(vizitka.getQrColor());
			break;
		}};
		//setDesign();
	}

	/////////////////////////// KONIEC JFRAMU ///////////////////////////////////
	/**
	 * Metóda, ktorá printne vizitku
	 * */
	public void printComponent() {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName("Print Component");

		pj.setPrintable(new Printable() {
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum > 0) {
					return Printable.NO_SUCH_PAGE;
				}

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				panelMain.printAll(g2);

				return Printable.PAGE_EXISTS;
			}
		});

		if (pj.printDialog() == false) {
			return;
		}

		try {
			pj.print();
		} catch (PrinterException ex) {
			JOptionPane.showMessageDialog(null, "Print Error: " + ex.getMessage(), "Print Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metóda na vytvorenie QR kódu
	 * 
	 * @param qrColor farba QR kódu
	 * */
	public void generateQR(Color qrColor) {
	    String web = panelPanel.getTextFieldWeb().getText();

	    if (web.isEmpty()) {

	        vizitka.setQrColor(qrColor);
	        return;
	    }

	    try {
	        QRCodeGenerator.createQR(web, "QRCode.png", 150, vizitka.getColorBG(), qrColor);

	        vizitka.setQrColor(qrColor);
	        vizitka.setLogoORqr("2");
	        loadQR();

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error generating QR code: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void setupActionListeners(PanelVizitka panel) {
		panel.getBtnSpolocnostName().addActionListener(e -> {
			setSelectedButton(panel.getBtnSpolocnostName());
		});

		panel.getBtnMeno().addActionListener(e -> {
			setSelectedButton(panel.getBtnMeno());
		});

		panel.getBtnEmail().addActionListener(e -> {
			setSelectedButton(panel.getBtnEmail());
		});

		panel.getBtnTelCislo().addActionListener(e -> {
			setSelectedButton(panel.getBtnTelCislo());
		});

		panel.getBtnWeb().addActionListener(e -> {
			setSelectedButton(panel.getBtnWeb());
		});

		panel.getBtnAdresa().addActionListener(e -> {
			setSelectedButton(panel.getBtnAdresa());
		});
	}

	public void setSelectedPanel(PanelVizitka selectedPanel) {
		if (this.selectedPanel != null) {
			clearActionListeners(this.selectedPanel);
		}
		this.selectedPanel = selectedPanel;
		setupActionListeners(selectedPanel);
		BorderLayout borderLayout = (BorderLayout) panel_type1.getLayout();
		panel_type1.getLblPicture().setText("");
		panelBorder.add(selectedPanel, BorderLayout.CENTER);
		panelBorder.revalidate();
		panelBorder.repaint();
	}

	public void clearActionListeners(PanelVizitka panel) {
		for (ActionListener al : panel.getBtnSpolocnostName().getActionListeners()) {
			panel.getBtnSpolocnostName().removeActionListener(al);
		}
	}
	/**
	 * Metóda na zmenu textu
	 * */
	public void zmenaTextu() {
		vizitka.setMeno(panelPanel.getTextFieldMeno().getText());
		vizitka.setPriezvisko(panelPanel.getTextFieldPriezvisko().getText());
		vizitka.setTitulPred(panelPanel.getTextFieldTitPred().getText());
		vizitka.setTitulZa(panelPanel.getTextFieldTitZa().getText());
		vizitka.setSpolocnost(panelPanel.getTextFieldSpolocnost().getText());
		vizitka.setTelCislo(panelPanel.getTextFieldTelCislo().getText());
		vizitka.setEmail(panelPanel.getTextFieldEmail().getText());
		vizitka.setWeb(panelPanel.getTextFieldWeb().getText());
		vizitka.setAdresa(panelPanel.getTextFieldAdresa().getText());
		
		selectedPanel.getBtnMeno().setText(vizitka.getTitulPred() + " " + vizitka.getMeno() + " "
				+ vizitka.getPriezvisko() + " " + vizitka.getTitulZa());
		selectedPanel.getBtnSpolocnostName().setText(vizitka.getSpolocnost());
		selectedPanel.getBtnEmail().setText(vizitka.getEmail());
		selectedPanel.getBtnWeb().setText(vizitka.getWeb());
		selectedPanel.getBtnTelCislo().setText("" + vizitka.getTelCislo());
		selectedPanel.getBtnAdresa().setText("" + vizitka.getAdresa());
	}
	/**
	 * Metóda na zmenu textu ale s parametrami (používa sa pri vykresľovaní už vytvorenej vizitky)
	 * */
	public void zmenaTextu(String meno, String priezvisko, String titulPred, String titulZa, String spolocnost,
			String telCislo, String email, String web, String adresa) {
		vizitka.setMeno(meno);
		vizitka.setPriezvisko(priezvisko);
		vizitka.setTitulPred(titulPred);
		vizitka.setTitulZa(titulZa);
		vizitka.setSpolocnost(spolocnost);
		vizitka.setTelCislo(telCislo);
		vizitka.setEmail(email);
		vizitka.setWeb(web);
		vizitka.setWeb(adresa);

		selectedPanel.getBtnMeno().setText(titulPred + " " + meno + " " + priezvisko + " " + titulZa);
		selectedPanel.getBtnSpolocnostName().setText(spolocnost);
		selectedPanel.getBtnEmail().setText(email);
		selectedPanel.getBtnWeb().setText(web);
		selectedPanel.getBtnTelCislo().setText("" + telCislo);
		selectedPanel.getBtnAdresa().setText("" + adresa);

		panelPanel.getTextFieldMeno().setText(meno);
		panelPanel.getTextFieldPriezvisko().setText(priezvisko);
		panelPanel.getTextFieldTitPred().setText(titulPred);
		panelPanel.getTextFieldTitZa().setText(titulZa);
		panelPanel.getTextFieldSpolocnost().setText(spolocnost);
		panelPanel.getTextFieldTelCislo().setText(telCislo);
		panelPanel.getTextFieldEmail().setText(email);
		panelPanel.getTextFieldWeb().setText(web);
		panelPanel.getTextFieldAdresa().setText(adresa);
		validate();
		repaint();
	}
	/**
	 * Metóda na zmenu farby s parametrami (používa sa pri vykresľovaní už vytvorenej vizitky)
	 * */
	private void zmenaFarby(Color menoColor, Color spolocnostColor, Color telCisloColor, Color emailColor,
			Color webColor, Color adresaColor) {
		vizitka.setMenoColor(menoColor);
		vizitka.setSpolocnostColor(spolocnostColor);
		vizitka.setTelCisloColor(telCisloColor);
		vizitka.setEmailColor(emailColor);
		vizitka.setWebColor(webColor);
		vizitka.setWebColor(adresaColor);

		selectedPanel.getBtnMeno().setForeground(menoColor);
		selectedPanel.getBtnSpolocnostName().setForeground(spolocnostColor);
		selectedPanel.getBtnEmail().setForeground(emailColor);
		selectedPanel.getBtnWeb().setForeground(webColor);
		selectedPanel.getBtnTelCislo().setForeground(telCisloColor);
		selectedPanel.getBtnAdresa().setForeground(adresaColor);
		validate();
		repaint();
		
	}
	/**
	 * Metóda na zmenu zarovnania
	 * @param cislo číslo z ComboBoxu Zarovnania 1-LEFT 2-CENTER 3-RIGHT
	 * @param btn zvolená časť vizitky
	 * */
	public void setAllign(int cislo, JButton btn) {
		switch (cislo) {
		case 0: {
			btn.setHorizontalAlignment(SwingConstants.LEFT);
			break;
		}
		case 1: {
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			break;
		}
		case 2: {
			btn.setHorizontalAlignment(SwingConstants.RIGHT);
			break;
		}
		}
		if (btn.equals(selectedPanel.getBtnMeno())) {
			vizitka.setMenoAlign(cislo+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnSpolocnostName())) {
			vizitka.setSpolocnostAlign(cislo+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnEmail())) {
			vizitka.setEmailAlign(cislo+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnWeb())) {
			vizitka.setWebAlign(cislo+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnTelCislo())) {
			vizitka.setTelCisloAlign(cislo+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnAdresa())) {
			vizitka.setAdresaAlign(cislo+"");
			return;
		}
	}
	/**
	 * Metóda na nastavenie farby textu danej časti vizitky
	 * @param color zvolená farba
	 * @param btn zvolená časť vizitky
	 * */
	public void setColorFGButtons(Color color, JButton btn) {
		btn.setForeground(color);
		if (btn.equals(selectedPanel.getBtnMeno())) {
			vizitka.setMenoColor(color);
			return;
		}
		else if(btn.equals(selectedPanel.getBtnSpolocnostName())) {
			vizitka.setSpolocnostColor(color);
			return;
		}
		else if(btn.equals(selectedPanel.getBtnEmail())) {
			vizitka.setEmailColor(color);
			return;
		}
		else if(btn.equals(selectedPanel.getBtnWeb())) {
			vizitka.setWebColor(color);
			return;
		}
		else if(btn.equals(selectedPanel.getBtnTelCislo())) {
			vizitka.setTelCisloColor(color);
			return;
		}
		else if(btn.equals(selectedPanel.getBtnAdresa())) {
			vizitka.setAdresaColor(color);
			return;
		}
	}
	/**
	 * Metóda na nastavenie farby pozadia
	 * 
	 * Preľadáva celý panel a všetko čo je v ňom - a mení im farbu pozadia
	 * */
	public void applyBackgroundColor(Component comp, Color color) {
		comp.setBackground(color);
		if (comp instanceof Container) {
			for (Component child : ((Container) comp).getComponents()) {
				applyBackgroundColor(child, color);
			}
		}
		
		String web = panelPanel.getTextFieldWeb().getText();

	    if (!web.isEmpty() && vizitka.getLogoORqr().equals("2")) {
	    	vizitka.setColorBG(getColorBG());
			generateQR(vizitka.getQrColor());
	    }

	}
	/**
	 * Metóda na nastavenie fontu textu danej časti vizitky
	 * @param index číslo comboBoxu zvoleného fontu
	 * @param btn zvolená časť vizitky
	 * */
	public void setFontType(int index, JButton btn) {
		if (btn == null) {
			System.out.println("Error: Button is null!");
			return;
		}
		int style = (btn.equals(getSelectedPanel().getBtnSpolocnostName())) ? Font.BOLD
				: Font.PLAIN;
		int size = (style == Font.BOLD) ? 35 : 15;

		String fontName = "";
		switch (index) {
		case 0:
			fontName = "Arial";
			break;
		case 1:
			fontName = "Calibri";
			break;
		case 2:
			fontName = "Comic Sans MS";
			break;
		case 3:
			fontName = "Georgia";
			break;
		case 4:
			fontName = "Segoe UI";
			break;
		case 5:
			fontName = "Times New Roman";
			break;
		}
		btn.setFont(new Font(fontName, style, size));

		if (btn.equals(selectedPanel.getBtnMeno())) {
			vizitka.setMenoFont(index+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnSpolocnostName())) {
			vizitka.setSpolocnostFont(index+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnEmail())) {
			vizitka.setEmailFont(index+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnWeb())) {
			vizitka.setWebFont(index+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnTelCislo())) {
			vizitka.setTelCisloFont(index+"");
			return;
		}
		else if(btn.equals(selectedPanel.getBtnAdresa())) {
			vizitka.setAdresaFont(index+"");
			return;
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton currentButton = getSelectedButton();
		if (currentButton != null) {
			setFontType(comboBoxFontType.getSelectedIndex(), currentButton);
		} else {
			System.out.println("No button is selected!");
		}
	}
	/**
	 * Nastavuje pomer Vizitky
	 * */
	public void setPomer() {
		int cislo = getComboBoxPomerCislo();
		switch (cislo) {
		case 0:
			panelBorder.setMinimumSize(new Dimension(500, 278));
			panelBorder.setMaximumSize(new Dimension(500, 278));
			panelBorder.setPreferredSize(new Dimension(500, 278));
			break;
		case 1:
			panelBorder.setMinimumSize(new Dimension(472, 306));
			panelBorder.setMaximumSize(new Dimension(472, 306));
			panelBorder.setPreferredSize(new Dimension(472, 306));
			break;
		case 2:
			panelBorder.setMinimumSize(new Dimension(500, 306));
			panelBorder.setMaximumSize(new Dimension(500, 306));
			panelBorder.setPreferredSize(new Dimension(500, 306));
			break;
		}
		panelBorder.revalidate();
		panelBorder.repaint();
		vizitka.setPomer(cislo+"");
	}
	/**
	 * Metóda na načítanie obrázku
	 * */
	public void loadLogo() {
		icon = getIcon();
		if (icon != null) {
			getSelectedPanel().getPanelPictureFrame().removeAll();
			getSelectedPanel().setLblPicture(new JLabel(icon));

			getSelectedPanel().getPanelPictureFrame().add(getSelectedPanel().getLblPicture());
			getSelectedPanel().getPanelPictureFrame().revalidate();
			getSelectedPanel().getPanelPictureFrame().repaint();
		} else {
			getSelectedPanel().getPanelPictureFrame().removeAll();
			getSelectedPanel().setLblPicture(new JLabel(""));

			getSelectedPanel().getPanelPictureFrame().add(getSelectedPanel().getLblPicture());
			getSelectedPanel().getPanelPictureFrame().revalidate();
			getSelectedPanel().getPanelPictureFrame().repaint();
		}
		
	}
	/**
	 * Metóda na načítanie a vytvorenie QR kódu
	 * */
	public void loadQR() {
		File selectedFile = new File("QRCode.png");
		try {
			setIcon(new ImageIcon(ImageIO.read(selectedFile)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		icon =getIcon();
		if (icon != null) {
			getSelectedPanel().getPanelPictureFrame().removeAll();
			getSelectedPanel().setLblPicture(new JLabel(icon));

			getSelectedPanel().getPanelPictureFrame().add(getSelectedPanel().getLblPicture());
			getSelectedPanel().getPanelPictureFrame().revalidate();
			getSelectedPanel().getPanelPictureFrame().repaint();
		} else {
			getSelectedPanel().getPanelPictureFrame().removeAll();
			getSelectedPanel().setLblPicture(new JLabel(""));

			getSelectedPanel().getPanelPictureFrame().add(getSelectedPanel().getLblPicture());
			getSelectedPanel().getPanelPictureFrame().revalidate();
			getSelectedPanel().getPanelPictureFrame().repaint();
		}
		
	}
	
	/**
	 * Metóda na vybratie obrázku pre Logo vizitky a následne zobrazenie vo vizitke
	 * */
	public void addLogo() {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
		fileChooser.setDialogTitle("Select an image");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg", "jpeg", "gif");
		fileChooser.addChoosableFileFilter(filter);

		int result = fileChooser.showOpenDialog(App.this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				setIcon(new ImageIcon(ImageIO.read(selectedFile)));
				// Resize icon if necessary
				Image image = icon.getImage().getScaledInstance(getSelectedPanel().getPanelPictureFrame().getWidth(),
						getSelectedPanel().getPanelPictureFrame().getHeight(), Image.SCALE_SMOOTH);
				icon = new ImageIcon(image);

				getSelectedPanel().getPanelPictureFrame().removeAll();
				getSelectedPanel().setLblPicture(new JLabel(icon));

				getSelectedPanel().getPanelPictureFrame().add(getSelectedPanel().getLblPicture());
				getSelectedPanel().getPanelPictureFrame().revalidate();
				getSelectedPanel().getPanelPictureFrame().repaint();

				vizitka.setLogoORqr("1");
				vizitka.setLogoPath(selectedFile.toString());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(App.this, "Error loading image: " + ex.getMessage(), "Image Load Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	/**
	 * Metóda na vybratie obrázku s už zvolenou cestou pre Logo vizitky a následne zobrazenie vo vizitke (používa sa na zobrazenie už vytvorenej vizitky)
	 * 
	 * @param filePath zvolená cesta obrázku
	 * */
	public void addLogo(String filePath) {
	    File selectedFile = new File(filePath);

	    if (!selectedFile.exists() || !selectedFile.canRead()) {
	        JOptionPane.showMessageDialog(App.this, "Súbor neexistuje alebo ho nie je možné prečítať.", "Chyba pri načítaní súboru", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        BufferedImage image = ImageIO.read(selectedFile);

	        if (image == null) {
	            JOptionPane.showMessageDialog(App.this, "Obrázok sa nepodarilo načítať.", "Chyba pri načítaní obrázka", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        ImageIcon icon = new ImageIcon(scaledImage);

	        JLabel label = new JLabel(icon);
	        getSelectedPanel().getPanelPictureFrame().removeAll();
	        getSelectedPanel().getPanelPictureFrame().add(label);
	        getSelectedPanel().getPanelPictureFrame().revalidate();
	        getSelectedPanel().getPanelPictureFrame().repaint();

	        vizitka.setLogoORqr("1");
	        vizitka.setLogoPath(filePath);
	    } catch (IOException ex) {
	        JOptionPane.showMessageDialog(App.this, "Chyba pri načítaní obrázka: " + ex.getMessage(), "Chyba pri načítaní obrázka", JOptionPane.ERROR_MESSAGE);
	    }
	}


	
	public void disableLogoQR() {
		getSelectedPanel().getPanelPictureFrame().removeAll();
		getSelectedPanel().getPanelPictureFrame().revalidate();
		getSelectedPanel().getPanelPictureFrame().repaint();
		vizitka.setLogoORqr("0");
	}
	
	/**
	 * Metóda ktorá kontroluje či už daná vizitka bola vytvorená alebo je to nový súbor
	 * */
	public void ulozenie() {
		if(isOpened()) {
			saveToCSVOpened();
			return;
		}
		else {
		  saveToCSV();
			return;
		}
		
	}
	/**
	 * Metóda, ktorá ukladá novo vytvorenú vizitku
	 * 
	 *<p> funguje tak, že najprv užívateľ vyberie kde to chce uložit. Do Data.csv uloží pod novým ID, názov súboru a cestu k súboru.</p>
	 *<p> následne uloží všetky hodnoty vizitky (vrátane dizajnu) do zvolenej cesty súboru.</p>
	 * 
	 * */
	public void saveToCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save CSV File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(null);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            
            String fileName = new File(filePath).getName();
            String nazovVizitka = fileName.endsWith(".csv") ? fileName.substring(0, fileName.length() - 4) : fileName;

            if (!filePath.endsWith(".csv")) {
                filePath += ".csv";
            }

            File file = new File(filePath);
            boolean isNewFile = !file.exists();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                if (isNewFile) {
                    writer.write("Id,Nazov,Meno,Priezvisko,TitulPred,TitulZa,Spolocnost,TelCislo,Email,Web,Adresa\n");
                }

                List<String> dataRows = new ArrayList<>();

                String basicData = String.join("_", 
                    "0",
                    nazovVizitka, 
                    vizitka.getMeno()+" ",
                    vizitka.getPriezvisko()+" ",
                    vizitka.getTitulPred()+" ",
                    vizitka.getTitulZa()+" ",
                    vizitka.getSpolocnost()+" ",
                    vizitka.getTelCislo()+" ",
                    vizitka.getEmail()+" ",
                    vizitka.getWeb()+" ",
                    vizitka.getAdresa()+" "
                ); 
                dataRows.add(basicData);
                //-----------------------------------------
                String colorData = String.join("_", 
                    "1",
                    nazovVizitka, 
                    "" + vizitka.getMenoColor(), 
                    "" + vizitka.getSpolocnostColor(), 
                    "" + vizitka.getTelCisloColor(), 
                    "" + vizitka.getEmailColor(), 
                    "" + vizitka.getWebColor(), 
                    "" + vizitka.getAdresaColor()
                );
                dataRows.add(colorData);
                //-----------------------------------------
				
				  String alignmentData = String.join("_",
					  "2", 
					  nazovVizitka, 
					  "" +vizitka.getMenoAlign(),
					  "" +vizitka.getSpolocnostAlign(),
					  "" +vizitka.getTelCisloAlign(),
					  "" +vizitka.getEmailAlign(), 
					  "" +vizitka.getWebAlign(), 
					  "" + vizitka.getAdresaAlign() );
				  dataRows.add(alignmentData); 
				  //-----------------------------------------
					
				  String fontData = String.join("_",
					  "3",
					  nazovVizitka,
					  "" +vizitka.getMenoFont(), 
					  "" + vizitka.getSpolocnostFont(), 
					  "" +vizitka.getTelCisloFont(), 
					  "" + vizitka.getEmailFont(), 
					  "" +vizitka.getWebFont(), 
					  "" + vizitka.getAdresaFont() );
				  dataRows.add(fontData);
				  //-----------------------------------------
				  if(vizitka.getColorBG()==null) {
					  vizitka.setColorBG(new Color(255,255,255));
				  }
				  String colorBGData = String.join("_",
						  "4",
						  nazovVizitka,
						  "" +vizitka.getColorBG());
				  dataRows.add(colorBGData);
				  //-----------------------------------------
				  String pomerData = String.join("_",
						  "5",
						  nazovVizitka,
						  "" +vizitka.getPomer());
				  dataRows.add(pomerData);
				  //-----------------------------------------
				  String panelTypeData = String.join("_",
						  "6",
						  nazovVizitka,
						  "" +vizitka.getPanelType());
				  dataRows.add(panelTypeData);
				  //-----------------------------------------
				  String filePathLogoQR="";
				  if(vizitka.getLogoORqr().equals("1")) {
					  filePathLogoQR=vizitka.getLogoPath();
				  }
				  else if (vizitka.getLogoORqr().equals("2")) {
					  filePathLogoQR=vizitka.getQrColor().toString();
				  }
				  String logoQRData = String.join("_",
						  "7",
						  nazovVizitka,
						  "" +vizitka.getLogoORqr(),
						  ""+filePathLogoQR );
				  dataRows.add(logoQRData);
				  //-----------------------------------------
                for (String row : dataRows) {
                    writer.write(row + "\n");
                }
                //--------------ulozenie cesty do Data
                String filePathData = "Data.csv";
        		File fileData = new File(filePathData);
        		boolean isNewFileData = !fileData.exists();

        		try (BufferedWriter writerData = new BufferedWriter(new FileWriter(filePathData, true))) {
        			if (isNewFileData) {
        				writerData.write("Id,Nazov,FilePath\n");
        			}

        			int id = findMaxId(filePathData) + 1;

        			String data = String.join(",", String.valueOf(id), nazovVizitka,filePath);
        			writerData.write(data + "\n");
        		} catch (IOException e) {
        			JOptionPane.showMessageDialog(null, "Error saving to CSV: " + e.getMessage(), "Error",
        					JOptionPane.ERROR_MESSAGE);
        		}
        		validate();
        		setVisible(false);
        		contentPane.setVisible(false);
        		Start start = new Start();
        		start.setVisible(true);
                
                JOptionPane.showMessageDialog(null, "Data saved to " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving to CSV: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    		
    	
    }
	/**
	 * Metóda hľadá najvyššie ID posledného uloženého súboru
	 * */
	public int findMaxId(String filePath) throws IOException {
	    int maxId = 0;
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] data = line.split(",");
	            if (data.length > 0 && !data[0].isEmpty()) {
	                try {
	                    int currentId = Integer.parseInt(data[0]);
	                    if (currentId > maxId) {
	                        maxId = currentId;
	                    }
	                } catch (NumberFormatException e) {
	                    System.err.println("Invalid ID: " + data[0]);
	                    continue;
	                }
	            }
	        }
	    }
	    return maxId;
	}
	/**
	 * Metóda, ktorá ukladá už vytvorenú vizitku
	 * 
	 *<p> V Data.csv sa hľadá konkrétny názov. Všetky súbory z Data ktoré sa nezhodujú s názvom uloží do ArrayListu. Keď nájde daný názov - prepíše ho a uloží do ArrayListu. Po skončení cyklu sa všetky riadky znova napíšu do vymazaného Data.csv</p>
	 *<p> V súbore danej vizitky dáta zmaže a prepíše na nové</p>
	 * 
	 * */
	public void saveToCSVOpened() {
		String filePath = "Data.csv";
		File file = new File(filePath);
		ArrayList<String> lines = new ArrayList<>();
		String inputLine;
		boolean isFirstLine = true;
		String header = "";
		String filePathVizitky = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((inputLine = reader.readLine()) != null) {
				if (isFirstLine) {
					header = inputLine;
					lines.add(header);
					isFirstLine = false;
					continue;
				}
				String[] data = inputLine.split(",");
				if (data.length < 2) {
					System.err.println("Nesprávny formát riadku: " + inputLine);
					continue;
				}

				if (data[1].equals(getOpenedVizitkaNazov())) {
					filePathVizitky = data[2];
				}

				lines.add(inputLine);
			}
		} catch (IOException e) {
			System.err.println("Chyba pri čítaní zo súboru CSV: " + e.getMessage());
			return;
		}

		try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
			for (String line : lines) {
				writer.println(line);
			}
		} catch (IOException e) {
			System.err.println("Chyba pri zápise do súboru CSV: " + e.getMessage());
			return;
		}

		File fileVizitky = new File(filePathVizitky);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileVizitky, false))) {
			writer.write("Id,Nazov,Meno,Priezvisko,TitulPred,TitulZa,Spolocnost,TelCislo,Email,Web,Adresa\n");

			String nazovVizitka = getOpenedVizitkaNazov();
			List<String> dataRows = new ArrayList<>();

			String basicData = String.join("_", 
				"0",
				nazovVizitka, 
				vizitka.getMeno() + "",
				vizitka.getPriezvisko() + "",
				vizitka.getTitulPred() + "",
				vizitka.getTitulZa() + "",
				vizitka.getSpolocnost() + "",
				vizitka.getTelCislo() + "",
				vizitka.getEmail() + "",
				vizitka.getWeb() + "",
				vizitka.getAdresa() + ""
			);
			dataRows.add(basicData);
                //-----------------------------------------
                String colorData = String.join("_", 
                    "1",
                    nazovVizitka, 
                    "" + vizitka.getMenoColor(), 
                    "" + vizitka.getSpolocnostColor(), 
                    "" + vizitka.getTelCisloColor(), 
                    "" + vizitka.getEmailColor(), 
                    "" + vizitka.getWebColor(), 
                    "" + vizitka.getAdresaColor()
                );
                dataRows.add(colorData);
                //-----------------------------------------
				
				  String alignmentData = String.join("_",
					  "2", 
					  nazovVizitka, 
					  "" +vizitka.getMenoAlign(),
					  "" +vizitka.getSpolocnostAlign(),
					  "" +vizitka.getTelCisloAlign(),
					  "" +vizitka.getEmailAlign(), 
					  "" +vizitka.getWebAlign(), 
					  "" + vizitka.getAdresaAlign() );
				  dataRows.add(alignmentData); 
				  //-----------------------------------------
					
				  String fontData = String.join("_",
					  "3",
					  nazovVizitka,
					  "" +vizitka.getMenoFont(), 
					  "" + vizitka.getSpolocnostFont(), 
					  "" +vizitka.getTelCisloFont(), 
					  "" + vizitka.getEmailFont(), 
					  "" +vizitka.getWebFont(), 
					  "" + vizitka.getAdresaFont() );
				  dataRows.add(fontData);
				  //-----------------------------------------
				  String colorBGData = String.join("_",
						  "4",
						  nazovVizitka,
						  "" +vizitka.getColorBG());
				  dataRows.add(colorBGData);
				  //-----------------------------------------
				  String pomerData = String.join("_",
						  "5",
						  nazovVizitka,
						  "" +vizitka.getPomer());
				  dataRows.add(pomerData);
				  //-----------------------------------------
				  String panelTypeData = String.join("_",
						  "6",
						  nazovVizitka,
						  "" +vizitka.getPanelType());
				  dataRows.add(panelTypeData);
				  //-----------------------------------------
				  String filePathLogoQR="";
				  if(vizitka.getLogoORqr().equals("1")) {
					  filePathLogoQR=vizitka.getLogoPath();
				  }
				  else if (vizitka.getLogoORqr().equals("2")) {
					  filePathLogoQR=vizitka.getQrColor().toString();
				  }
				  String logoQRData = String.join("_",
						  "7",
						  nazovVizitka,
						  "" +vizitka.getLogoORqr(),
						  ""+filePathLogoQR );
				  dataRows.add(logoQRData);
				  //-----------------------------------------
				  for (String row : dataRows) {
						writer.write(row + "\n");
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Chyba pri ukladaní do CSV: " + e.getMessage(), "Chyba", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Prechod späť do hlavného okna aplikácie

				setVisible(false);
				contentPane.setVisible(false);
				Start start = new Start();
				start.setVisible(true);

				JOptionPane.showMessageDialog(null, "Údaje boli uložené do " + filePathVizitky, "Úspech", JOptionPane.INFORMATION_MESSAGE);
			}
    		
    	
    
	/**
	 * Metóda ktorá slúži na kontrolu originálneho názvu súboru
	 * 
	 * @param vizitka názov vizitky
	 * */
	public boolean readNamesFromCSV(String vizitka) {
		String filePath = "Data.csv";
		boolean isNewFile = !new File(filePath).exists();
		if (isNewFile) {
			return true;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			boolean firstLine = true;

			while ((line = reader.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					continue;
				}
				String[] data = line.split(",");
				String nazov = data[1];
				if (nazov.equals(vizitka)) {
					return false;
				}
			}
			return true;
		} catch (IOException e) {
			System.err.println("Error reading from CSV file: " + e.getMessage());
		}
		return false;
	}
	/**
	 * Metóda ktorá slúži na exportovanie vizitky ako PNG, JPG, JPEG
	 * */
	public void exportAsImage(JPanel panel) {
		BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D obrazok = image.createGraphics();

		panel.paint(obrazok);
		obrazok.dispose();

		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
		fileChooser.setDialogTitle("Uložiť ako");
		FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG files", "png");
		FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("JPEG files", "jpg", "jpeg");
		fileChooser.addChoosableFileFilter(pngFilter);
		fileChooser.addChoosableFileFilter(jpgFilter);
		fileChooser.setFileFilter(pngFilter);

		int userSelection = fileChooser.showSaveDialog(panel);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			String filePath = fileToSave.getAbsolutePath();
			String ext = "png";

			if (fileChooser.getFileFilter().equals(jpgFilter)) {
				ext = "jpg";
				if (!filePath.toLowerCase().endsWith(".jpg")) {
					filePath += ".jpg";
				}
			} else if (fileChooser.getFileFilter().equals(pngFilter)) {
				if (!filePath.toLowerCase().endsWith(".png")) {
					filePath += ".png";
				}
			}

			try {
				ImageIO.write(image, ext, new File(filePath));
				JOptionPane.showMessageDialog(panel, "Obrázok bol úspešne uložený: " + filePath, "Uloženie obrázku",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(panel, "Chyba pri ukladaní obrázka: " + e.getMessage(), "Chyba",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
//	////////////////////////////////////////////////////////////////////////////////

	public JButton getSelectedButton() {
		return selectedButton;
	}

	public void setSelectedButton(JButton btn) {
		if (selectedButton != btn) {
			if (selectedButton != null) {
				selectedButton.setSelected(false);
			}
			this.selectedButton = btn;
			selectedButton.setSelected(true);

		} else {
			selectedButton.setSelected(false);
			this.selectedButton = null;
		}
	}

	public int getComboBoxTypeCislo() {
		return comboBoxTypeCislo;
	}

	public void setComboBoxTypeCislo(int comboBoxTypeCislo) {
		this.comboBoxTypeCislo = comboBoxTypeCislo;
	}

	public PanelVizitka getSelectedPanel() {
		return selectedPanel;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public JComboBox getComboBoxFontType() {
		return comboBoxFontType;
	}

	public void setComboBoxFontType(JComboBox comboBoxFontType) {
		this.comboBoxFontType = comboBoxFontType;
	}

	public JComboBox getComboBoxAllignment() {
		return comboBoxAllignment;
	}

	public void setComboBoxAllignment(JComboBox comboBoxAllignment) {
		this.comboBoxAllignment = comboBoxAllignment;
	}

	public Color getColorBG() {
		return colorBG;
	}

	public void setColorBG(Color colorBG) {
		this.colorBG = colorBG;
	}

	public void setColorFG(Color colorFG) {
		this.colorFG = colorFG;
	}

	public Color getColorFG() {

		return colorFG;
	}

	public Color setColor() {
		Color color = JColorChooser.showDialog(App.this, "Vyber farbu", panelPanel.getPanel().getBackground());
		if (color != null) {
			return color;
		}
		return null;
	}

	public int getComboBoxPomerCislo() {
		return comboBoxPomerCislo;
	}

	public void setComboBoxPomerCislo(int comboBoxPomerCislo) {
		this.comboBoxPomerCislo = comboBoxPomerCislo;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Vizitka getVizitka() {
		return vizitka;
	}

	public void setVizitka(Vizitka vizitka) {
		this.vizitka = vizitka;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public Vizitka getOpenedVizitka() {
		return openedVizitka;
	}

	public void setOpenedVizitka(Vizitka openedVizitka) {
		this.openedVizitka = openedVizitka;
	}

	public String getOpenedVizitkaNazov() {
		return openedVizitkaNazov;
	}

	public void setOpenedVizitkaNazov(String openedVizitkaNazov) {
		this.openedVizitkaNazov = openedVizitkaNazov;
	}
}
