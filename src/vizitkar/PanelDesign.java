package vizitkar;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

class PanelDesign extends JPanel {
    private JComboBox<String> comboBoxFontType;
    private JButton btnColorFG;
    private JComboBox<String> comboBoxAllignment;
    private JButton btnBack;

    public PanelDesign() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(new Color(48, 50, 52));
        
        comboBoxFontType = new JComboBox<>(new String[]{"Arial", "Calibri", "Comic Sans", "Georgia", "Segoe UI", "Times New Roman"});
        
        btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon("C:\\Users\\jana3\\eclipse-workspace\\semestralka\\home.png"));
        
        btnBack.setMargin(new Insets(2, 14, 2, 30));
        btnBack.setBorder(new EmptyBorder(5, 5, 5, 5));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(btnBack);
        
        JLabel label = new JLabel("Font:");
        label.setBorder(new EmptyBorder(0, 20, 0, 0));
        this.add(label);
        this.add(comboBoxFontType);

        
        btnColorFG = new JButton("Vybrať");
        this.add(new JLabel("Farba textu:"));
        this.add(btnColorFG);

        comboBoxAllignment = new JComboBox<>(new String[]{"Left", "Center", "Right"});
        this.add(new JLabel("Zarovnanie:"));
        this.add(comboBoxAllignment);
    }

	//-----------GET SET---------------
	//---------------------------------
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
	public JButton getBtnColorFG() {
		return btnColorFG;
	}
	public void setBtnColorFG(JButton btnColorFG) {
		this.btnColorFG = btnColorFG;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
}
