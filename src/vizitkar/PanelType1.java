package vizitkar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelType1 extends PanelVizitka {

	private static final long serialVersionUID = 1L;
	public PanelType1() { 
		int fontSmall=15;
		int fontBig=35;
		setPreferredSize(new Dimension(450, 278));
		setBackground(new Color(255, 255, 255));
		setMinimumSize(new Dimension(450, 278));
		setMaximumSize(new Dimension(450, 278));
		setLayout(new BorderLayout(0, 0));

		JPanel panelSpolocnost = new JPanel();
		panelSpolocnost.setBorder(null);
		add(panelSpolocnost, BorderLayout.NORTH);
		panelSpolocnost.setBackground(new Color(255, 255, 255));
		panelSpolocnost.setLayout(new GridLayout(0, 1, 0, 0));

		btnSpolocnostName = new JButton("Spoločnosť s.r.o.");
		btnSpolocnostName.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnSpolocnostName.setMargin(new Insets(10, 14, 2, 14));
		btnSpolocnostName.setForeground(new Color(0, 0, 0));
		btnSpolocnostName.setBackground(new Color(255, 255, 255));
		btnSpolocnostName.setFont(new Font("Segoe UI", Font.BOLD, fontBig));
		panelSpolocnost.add(btnSpolocnostName);

		panelTexty = new JPanel(); 
		panelTexty.setBorder(new EmptyBorder(0, 0, 10, 0));
		add(panelTexty);
		panelTexty.setLayout(new GridLayout(0, 2, 0, 0));

		panelPicture = new JPanel();
		panelPicture.setBackground(new Color(255, 255, 255));
		panelTexty.add(panelPicture);
		panelPicture.setLayout(new GridLayout(0, 1, 0, 0));

		panelPictureFrame = new JPanel();
		panelPictureFrame.setBorder(new EmptyBorder(2, 10, 10, 10));
		panelPicture.add(panelPictureFrame);
		panelPictureFrame.setLayout(new GridLayout(0, 1, 0, 0));

		lblPicture = new JLabel("Obrazok");
		panelPictureFrame.add(lblPicture);
		lblPicture.setForeground(new Color(0, 0, 0));
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);

		panelInfo = new JPanel();
		panelTexty.add(panelInfo);
		panelInfo.setLayout(new BorderLayout(0, 0));

		panelInfoPanel = new JPanel();
		panelInfoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelInfoPanel.setBackground(new Color(255, 255, 255));
		panelInfo.add(panelInfoPanel, BorderLayout.CENTER);
		panelInfoPanel.setLayout(new GridLayout(6, 1, 0, 0));

		panelMeno = new JPanel();
		panelMeno.setSize(new Dimension(0, 20));
		panelMeno.setPreferredSize(new Dimension(10, 20));
		panelMeno.setMinimumSize(new Dimension(10, 20));
		panelMeno.setMaximumSize(new Dimension(32767, 20));
		panelMeno.setForeground(new Color(0, 0, 0));
		panelMeno.setBackground(new Color(255, 255, 255));
		panelInfoPanel.add(panelMeno);
		panelMeno.setLayout(new GridLayout(0, 1, 0, 0));

		btnMeno = new JButton("Mgr. Meno Priezvisko PhD.");
		btnMeno.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeno.setBorder(null);
		btnMeno.setForeground(new Color(0, 0, 0));
		btnMeno.setBackground(new Color(255, 255, 255));
		btnMeno.setMargin(new Insets(0, 0, 0, 0));
		btnMeno.setFont(new Font("Segoe UI", Font.PLAIN, fontSmall));
		panelMeno.add(btnMeno);

		panelTelC = new JPanel();
		panelTelC.setBorder(null);
		panelTelC.setBackground(new Color(255, 255, 255));
		panelInfoPanel.add(panelTelC);
		panelTelC.setLayout(new GridLayout(0, 1, 2, 0));

		btnTelCislo = new JButton("+421 949 556 939");
		btnTelCislo.setHorizontalAlignment(SwingConstants.LEFT);
		btnTelCislo.setBorder(null);
		btnTelCislo.setForeground(new Color(0, 0, 0));
		btnTelCislo.setBackground(new Color(255, 255, 255));
		btnTelCislo.setFont(new Font("Segoe UI", Font.PLAIN, fontSmall));
		panelTelC.add(btnTelCislo);

		panelEmail = new JPanel();
		panelEmail.setBackground(new Color(255, 255, 255));
		panelInfoPanel.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 1, 2, 0));

		btnEmail = new JButton("email@gmail.com");
		btnEmail.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmail.setForeground(Color.BLACK);
		btnEmail.setFont(new Font("Segoe UI", Font.PLAIN, fontSmall));
		btnEmail.setBorder(null);
		btnEmail.setBackground(Color.WHITE);
		panelEmail.add(btnEmail);

		panelWeb = new JPanel();
		panelWeb.setBackground(new Color(255, 255, 255));
		panelInfoPanel.add(panelWeb);
		panelWeb.setLayout(new GridLayout(0, 1, 2, 0));

		btnWeb = new JButton("webstranka.com");
		btnWeb.setHorizontalAlignment(SwingConstants.LEFT);
		btnWeb.setForeground(Color.BLACK);
		btnWeb.setFont(new Font("Segoe UI", Font.PLAIN, fontSmall));
		btnWeb.setBorder(null);
		btnWeb.setBackground(Color.WHITE);
		panelWeb.add(btnWeb);
		
		panelAdresa = new JPanel();
		panelAdresa.setBackground(Color.WHITE);
		panelInfoPanel.add(panelAdresa);
		panelAdresa.setLayout(new GridLayout(0, 1, 2, 0));
		
		btnAdresa = new JButton("Mostná 1");
		btnAdresa.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdresa.setForeground(Color.BLACK);
		btnAdresa.setFont(new Font("Segoe UI", Font.PLAIN, fontSmall));
		btnAdresa.setBorder(null);
		btnAdresa.setBackground(Color.WHITE);
		panelAdresa.add(btnAdresa);
	}

}
