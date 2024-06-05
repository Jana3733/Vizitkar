package vizitkar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panelMain = new JPanel();
	private JPanel panelBorder;
	private PanelDesign panelDesign = new PanelDesign();
	private JComboBox comboBoxFontType;
	private JComboBox comboBoxAllignment;
	
	private JPanel panelPanel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	
	private JTextField textFieldMeno;
	private JLabel lblNewLabel_1;
	private JTextField textFieldPriezvisko;
	private JLabel lblNewLabel_2;
	private JTextField textFieldTitPred;
	private JLabel lblNewLabel_3;
	private JTextField textFieldSpolocnost;
	private JLabel lblNewLabel_4;
	private JTextField textFieldTelCislo;
	private JLabel lblNewLabel_5;
	private JTextField textFieldEmail;
	private JTextField textFieldWeb;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnLogo;
	private JLabel lblNewLabel_8;
	private JButton btnQR;
	private JLabel lblNewLabel_9;
	private JComboBox comboBoxType;
	private JLabel lblNewLabel_15;
	private JTextField textFieldTitZa;
	private JPanel panel_2;
	private JPanel panel_6;
	private JButton btnImport;
	private JButton btnExport;
	private JButton btnSave;
	private JButton btnPrint;
	private JButton btnRefresh;
	private JLabel lblNewLabel_24;
	private JButton btnColorBG;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_21;
	private JPanel panel_Adresa;
	private JLabel lblNewLabel_13;
	private JComboBox comboBoxPomer;
	private JLabel lblNewLabel_Adresa;
	private JTextField textFieldAdresa;
	private JButton btnDisableLogo;
	private JButton btnDisableQR;
	
    public PanelPanel() {
		setBorder(new EmptyBorder(10, 0, 0, 0));
		setSize(new Dimension(500, 0));
		setMinimumSize(new Dimension(500, 10));
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 20, 10, 20));
		panel.setForeground(new Color(0, 0, 0));
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));

		panel_4 = new JPanel();
		panel.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_4.rowHeights = new int[] { 32, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblNewLabel = new JLabel("Meno");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		textFieldMeno = new JTextField();
		GridBagConstraints gbc_textFieldMeno = new GridBagConstraints();
		gbc_textFieldMeno.fill = GridBagConstraints.BOTH;
		gbc_textFieldMeno.gridx = 1;
		gbc_textFieldMeno.gridy = 0;
		panel_4.add(textFieldMeno, gbc_textFieldMeno);
		textFieldMeno.setColumns(10);

		panel_5 = new JPanel();
		panel.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_5.rowHeights = new int[] { 32, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		lblNewLabel_1 = new JLabel("Priezvisko");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldPriezvisko = new JTextField();
		GridBagConstraints gbc_textFieldPriezvisko = new GridBagConstraints();
		gbc_textFieldPriezvisko.fill = GridBagConstraints.BOTH;
		gbc_textFieldPriezvisko.gridx = 1;
		gbc_textFieldPriezvisko.gridy = 0;
		panel_5.add(textFieldPriezvisko, gbc_textFieldPriezvisko);
		textFieldPriezvisko.setColumns(10);

		panel_7 = new JPanel();
		panel.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_7.rowHeights = new int[] { 32, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		lblNewLabel_2 = new JLabel("Titul pred");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_7.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldTitPred = new JTextField();
		GridBagConstraints gbc_textFieldTitPred = new GridBagConstraints();
		gbc_textFieldTitPred.fill = GridBagConstraints.BOTH;
		gbc_textFieldTitPred.gridx = 1;
		gbc_textFieldTitPred.gridy = 0;
		panel_7.add(textFieldTitPred, gbc_textFieldTitPred);
		textFieldTitPred.setColumns(10);

		panel_8 = new JPanel();
		panel.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_8.rowHeights = new int[] { 32, 0 };
		gbl_panel_8.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		lblNewLabel_15 = new JLabel("Titul za");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 0;
		panel_8.add(lblNewLabel_15, gbc_lblNewLabel_15);

		textFieldTitZa = new JTextField();
		GridBagConstraints gbc_textFieldTitZa = new GridBagConstraints();
		gbc_textFieldTitZa.fill = GridBagConstraints.BOTH;
		gbc_textFieldTitZa.gridx = 1;
		gbc_textFieldTitZa.gridy = 0;
		panel_8.add(textFieldTitZa, gbc_textFieldTitZa);
		textFieldTitZa.setColumns(10);

		panel_9 = new JPanel();
		panel.add(panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_9.rowHeights = new int[] { 32, 0 };
		gbl_panel_9.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_9.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_9.setLayout(gbl_panel_9);

		lblNewLabel_3 = new JLabel("Spoločnosť");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_9.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldSpolocnost = new JTextField();
		GridBagConstraints gbc_textFieldSpolocnost = new GridBagConstraints();
		gbc_textFieldSpolocnost.fill = GridBagConstraints.BOTH;
		gbc_textFieldSpolocnost.gridx = 1;
		gbc_textFieldSpolocnost.gridy = 0;
		panel_9.add(textFieldSpolocnost, gbc_textFieldSpolocnost);
		textFieldSpolocnost.setColumns(10);
		
		////////////////////////////////////////////////
		panel_Adresa = new JPanel();
		panel.add(panel_Adresa);
		GridBagLayout gbl_panel_Adresa = new GridBagLayout();
		gbl_panel_Adresa.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_Adresa.rowHeights = new int[] { 32, 0 };
		gbl_panel_Adresa.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Adresa.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_Adresa.setLayout(gbl_panel_Adresa);

		lblNewLabel_Adresa = new JLabel("Adresa");
		lblNewLabel_Adresa.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_Adresa = new GridBagConstraints();
		gbc_lblNewLabel_Adresa.anchor = GridBagConstraints.WEST;
		panel_Adresa.add(lblNewLabel_Adresa, gbc_lblNewLabel_Adresa);
		
		textFieldAdresa = new JTextField();
		GridBagConstraints gbc_textFieldAdresa = new GridBagConstraints();
		gbc_textFieldAdresa.fill = GridBagConstraints.BOTH;
		gbc_textFieldAdresa.gridx = 1;
		gbc_textFieldAdresa.gridy = 0;
		panel_Adresa.add(textFieldAdresa, gbc_textFieldAdresa);
		textFieldAdresa.setColumns(10);
		///////////////////////////////////////////////
		

		panel_10 = new JPanel();
		panel.add(panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_10.rowHeights = new int[] { 32, 0 };
		gbl_panel_10.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_10.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_10.setLayout(gbl_panel_10);

		lblNewLabel_4 = new JLabel("Tel. číslo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_10.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textFieldTelCislo = new JTextField();
		GridBagConstraints gbc_textFieldTelCislo = new GridBagConstraints();
		gbc_textFieldTelCislo.fill = GridBagConstraints.BOTH;
		gbc_textFieldTelCislo.gridx = 1;
		gbc_textFieldTelCislo.gridy = 0;
		panel_10.add(textFieldTelCislo, gbc_textFieldTelCislo);
		textFieldTelCislo.setColumns(10);

		panel_11 = new JPanel();
		panel.add(panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_11.rowHeights = new int[] { 32, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		lblNewLabel_5 = new JLabel("E-mail");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_11.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 0;
		panel_11.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);

		panel_12 = new JPanel();
		panel.add(panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[] { 100, 200, 0 };
		gbl_panel_12.rowHeights = new int[] { 32, 0 };
		gbl_panel_12.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_12.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_12.setLayout(gbl_panel_12);

		lblNewLabel_6 = new JLabel("Web");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel_12.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textFieldWeb = new JTextField();
		GridBagConstraints gbc_textFieldWeb = new GridBagConstraints();
		gbc_textFieldWeb.fill = GridBagConstraints.BOTH;
		gbc_textFieldWeb.gridx = 1;
		gbc_textFieldWeb.gridy = 0;
		panel_12.add(textFieldWeb, gbc_textFieldWeb);
		textFieldWeb.setColumns(10);

		panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 9;
		panel.add(panel_14, gbc_panel_14);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[] { 100, 160, 40, 0 };
		gbl_panel_14.rowHeights = new int[] { 32, 0 };
		gbl_panel_14.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_14.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_14.setLayout(gbl_panel_14);

		lblNewLabel_7 = new JLabel("Logo");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_14.add(lblNewLabel_7, gbc_lblNewLabel_7);

		btnLogo = new JButton("Nahrať");
		GridBagConstraints gbc_btnLogo = new GridBagConstraints();
		gbc_btnLogo.fill = GridBagConstraints.BOTH;
		gbc_btnLogo.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogo.gridx = 1;
		gbc_btnLogo.gridy = 0;
		panel_14.add(btnLogo, gbc_btnLogo);

		btnDisableLogo = new JButton("x");
		GridBagConstraints gbc_btnDisablePicture_1 = new GridBagConstraints();
		gbc_btnDisablePicture_1.fill = GridBagConstraints.BOTH;
		gbc_btnDisablePicture_1.gridx = 2;
		gbc_btnDisablePicture_1.gridy = 0;
		panel_14.add(btnDisableLogo, gbc_btnDisablePicture_1);

		panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 10;
		panel.add(panel_13, gbc_panel_13);
		panel_13.setBorder(new EmptyBorder(0, 0, 5, 0));
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[] { 100, 160, 40, 0 };
		gbl_panel_13.rowHeights = new int[] { 32, 0 };
		gbl_panel_13.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_13.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_13.setLayout(gbl_panel_13);

		lblNewLabel_8 = new JLabel("QR kód");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_13.add(lblNewLabel_8, gbc_lblNewLabel_8);

		btnQR = new JButton("Vytvoriť");
		GridBagConstraints gbc_btnQR = new GridBagConstraints();
		gbc_btnQR.fill = GridBagConstraints.BOTH;
		gbc_btnQR.insets = new Insets(0, 0, 0, 5);
		gbc_btnQR.gridx = 1;
		gbc_btnQR.gridy = 0;
		panel_13.add(btnQR, gbc_btnQR);

		btnDisableQR = new JButton("x");
		GridBagConstraints gbc_btnDisablePicture = new GridBagConstraints();
		gbc_btnDisablePicture.fill = GridBagConstraints.BOTH;
		gbc_btnDisablePicture.gridx = 2;
		gbc_btnDisablePicture.gridy = 0;
		panel_13.add(btnDisableQR, gbc_btnDisablePicture);

		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(0, 64, 128));
		panel_3.add(btnRefresh);
		

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(56, 58, 61));
		panel_2.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 5));

		panel_15 = new JPanel();
		panel_15.setBackground(new Color(56, 58, 61));
		panel_2.add(panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[] { 100, 100, 50 };
		gbl_panel_15.rowHeights = new int[] { 32, 0 };
		gbl_panel_15.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_15.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_15.setLayout(gbl_panel_15);

		lblNewLabel_9 = new JLabel("Typ rozpoloženia");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		panel_15.add(lblNewLabel_9, gbc_lblNewLabel_9);

		comboBoxType = new JComboBox();
		
		GridBagConstraints gbc_comboBoxType = new GridBagConstraints();
		gbc_comboBoxType.fill = GridBagConstraints.BOTH;
		gbc_comboBoxType.gridx = 1;
		gbc_comboBoxType.gridy = 0;
		panel_15.add(comboBoxType, gbc_comboBoxType);
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));

		panel_16 = new JPanel();
		panel_16.setBackground(new Color(56, 58, 61));
		panel_2.add(panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[] { 100, 100, 50 };
		gbl_panel_16.rowHeights = new int[] { 32, 0 };
		gbl_panel_16.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_16.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_16.setLayout(gbl_panel_16);

		lblNewLabel_24 = new JLabel("Farba pozadia");
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_24.gridx = 0;
		gbc_lblNewLabel_24.gridy = 0;
		panel_16.add(lblNewLabel_24, gbc_lblNewLabel_24);

		btnColorBG = new JButton("Vybrať");
		
		GridBagConstraints gbc_btnColorBG = new GridBagConstraints();
		gbc_btnColorBG.fill = GridBagConstraints.BOTH;
		gbc_btnColorBG.gridx = 1;
		gbc_btnColorBG.gridy = 0;
		panel_16.add(btnColorBG, gbc_btnColorBG);

		panel_21 = new JPanel();
		panel_21.setBackground(new Color(56, 58, 61));
		panel_2.add(panel_21);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[] { 100, 100, 50 };
		gbl_panel_21.rowHeights = new int[] { 32, 0 };
		gbl_panel_21.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_21.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_21.setLayout(gbl_panel_21);

		lblNewLabel_13 = new JLabel("Pomer");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 0;
		panel_21.add(lblNewLabel_13, gbc_lblNewLabel_13);

		comboBoxPomer = new JComboBox();
		comboBoxPomer.setModel(new DefaultComboBoxModel(new String[] { "90 x 50 mm", "85 x 55 mm", "90 x 55 mm" }));
		GridBagConstraints gbc_comboBoxPomer = new GridBagConstraints();
		gbc_comboBoxPomer.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPomer.gridx = 1;
		gbc_comboBoxPomer.gridy = 0;
		panel_21.add(comboBoxPomer, gbc_comboBoxPomer);

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(47, 49, 51));
		panel_1.add(panel_6, BorderLayout.SOUTH);

		btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.add(btnImport);

		btnExport = new JButton("Export");
		panel_6.add(btnExport);

		btnPrint = new JButton("Print");
		panel_6.add(btnPrint);

		btnSave = new JButton("Save");
		panel_6.add(btnSave);
	}
	//-----------GET SET---------------
	//---------------------------------
	public JButton getBtnLogo() {
		return btnLogo;
	}
	public void setBtnLogo(JButton btnLogo) {
		this.btnLogo = btnLogo;
	}
	public JComboBox getComboBoxType() {
		return comboBoxType;
	}
	public void setComboBoxType(JComboBox comboBoxType) {
		this.comboBoxType = comboBoxType;
	}
	public JButton getBtnRefresh() {
		return btnRefresh;
	}
	public void setBtnRefresh(JButton btnRefresh) {
		this.btnRefresh = btnRefresh;
	}
	public JButton getBtnColorBG() {
		return btnColorBG;
	}
	public void setBtnColorBG(JButton btnColorBG) {
		this.btnColorBG = btnColorBG;
	}
	public JComboBox getComboBoxPomer() {
		return comboBoxPomer;
	}
	public void setComboBoxPomer(JComboBox comboBoxPomer) {
		this.comboBoxPomer = comboBoxPomer;
	}
	public JTextField getTextFieldMeno() {
		return textFieldMeno;
	}
	public void setTextFieldMeno(JTextField textFieldMeno) {
		this.textFieldMeno = textFieldMeno;
	}
	public JButton getBtnQR() {
		return btnQR;
	}
	public void setBtnQR(JButton btnQR) {
		this.btnQR = btnQR;
	}
	public JTextField getTextFieldPriezvisko() {
		return textFieldPriezvisko;
	}
	public void setTextFieldPriezvisko(JTextField textFieldPriezvisko) {
		this.textFieldPriezvisko = textFieldPriezvisko;
	}
	public JTextField getTextFieldTitPred() {
		return textFieldTitPred;
	}
	public void setTextFieldTitPred(JTextField textFieldTitPred) {
		this.textFieldTitPred = textFieldTitPred;
	}
	public JTextField getTextFieldSpolocnost() {
		return textFieldSpolocnost;
	}
	public void setTextFieldSpolocnost(JTextField textFieldSpolocnost) {
		this.textFieldSpolocnost = textFieldSpolocnost;
	}
	public JTextField getTextFieldTelCislo() {
		return textFieldTelCislo;
	}
	public void setTextFieldTelCislo(JTextField textFieldTelCislo) {
		this.textFieldTelCislo = textFieldTelCislo;
	}
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}
	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}
	public JTextField getTextFieldWeb() {
		return textFieldWeb;
	}
	public void setTextFieldWeb(JTextField textFieldWeb) {
		this.textFieldWeb = textFieldWeb;
	}
	public JTextField getTextFieldTitZa() {
		return textFieldTitZa;
	}
	public void setTextFieldTitZa(JTextField textFieldTitZa) {
		this.textFieldTitZa = textFieldTitZa;
	}

	public JButton getBtnImport() {
		return btnImport;
	}
	public void setBtnImport(JButton btnImport) {
		this.btnImport = btnImport;
	}
	public JButton getBtnExport() {
		return btnExport;
	}
	public void setBtnExport(JButton btnExport) {
		this.btnExport = btnExport;
	}
	public JButton getBtnSave() {
		return btnSave;
	}
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	public JButton getBtnPrint() {
		return btnPrint;
	}
	public void setBtnPrint(JButton btnPrint) {
		this.btnPrint = btnPrint;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextField getTextFieldAdresa() {
		return textFieldAdresa;
	}
	public void setTextFieldAdresa(JTextField textFieldAdresa) {
		this.textFieldAdresa = textFieldAdresa;
	}
	public JButton getBtnDisableLogo() {
		return btnDisableLogo;
	}
	public void setBtnDisableLogo(JButton btnDisableLogo) {
		this.btnDisableLogo = btnDisableLogo;
	}
	public JButton getBtnDisableQR() {
		return btnDisableQR;
	}
	public void setBtnDisableQR(JButton btnDisableQR) {
		this.btnDisableQR = btnDisableQR;
	}
}

