package vizitkar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVizitka extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanel panelTexty;
	public JPanel panelPicture;
	public JPanel panelInfo;
	public JLabel lblPicture;
	public JPanel panelMeno;
	public JPanel panelEmail;
	public JPanel panelTelC;
	public JPanel panelWeb;
	public JPanel panelInfoPanel;
	public JPanel panelAdresa;
	public JButton btnSpolocnostName;
	public JButton btnMeno;
	public JButton btnEmail;
	public JButton btnWeb;
	public JButton btnTelCislo;
	public JButton btnAdresa;
	public JPanel panelSpolocnost;
	public int fontBig = 35;
	public int fontSmall = 15;
	public JPanel panelPictureFrame;

	public PanelVizitka() {

	}
	public JPanel getPanelAdresa() {
		return panelAdresa;
	}
	public void setPanelAdresa(JPanel panelAdresa) {
		this.panelAdresa = panelAdresa;
	}
	public JButton getBtnAdresa() {
		return btnAdresa;
	}
	public void setBtnAdresa(JButton btnAdresa) {
		this.btnAdresa = btnAdresa;
	}
	public int getFontBig() {
		return fontBig;
	} 

	public void setFontBig(int fontBig) {
		this.fontBig = fontBig;
	}

	public int getFontSmall() {
		return fontSmall;
	}

	public void setFontSmall(int fontSmall) {
		this.fontSmall = fontSmall;
	}

	public JPanel getPanelPictureFrame() {
		return panelPictureFrame;
	}

	public void setPanelPictureFrame(JPanel panelPictureFrame) {
		this.panelPictureFrame = panelPictureFrame;
	}

	public void setPanelSpolocnost(JPanel panelSpolocnost) {
		this.panelSpolocnost = panelSpolocnost;
	}
	public JPanel getPanelSpolocnost() {
		return panelSpolocnost;
	}

	public JButton getBtnSpolocnostName() {
		return btnSpolocnostName;
	}

	public void setBtnSpolocnostName(JButton btnSpolocnostName) {
		this.btnSpolocnostName = btnSpolocnostName;
	}

	public JButton getBtnMeno() {
		return btnMeno;
	}

	public void setBtnMeno(JButton btnMeno) {
		this.btnMeno = btnMeno;
	}

	public JButton getBtnEmail() {
		return btnEmail;
	}

	public void setBtnEmail(JButton btnEmail) {
		this.btnEmail = btnEmail;
	}

	public JButton getBtnWeb() {
		return btnWeb;
	}

	public void setBtnWeb(JButton btnWeb) {
		this.btnWeb = btnWeb;
	}

	public JPanel getPanelTexty() {
		return panelTexty;
	}

	public void setPanelTexty(JPanel panelTexty) {
		this.panelTexty = panelTexty;
	}

	public JPanel getPanelPicture() {
		return panelPicture;
	}

	public void setPanelPicture(JPanel panelPicture) {
		this.panelPicture = panelPicture;
	}

	public JPanel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public JLabel getLblPicture() {
		return lblPicture;
	} 

	public void setLblPicture(JLabel lblPicture) {
		this.lblPicture = lblPicture;
	}

	public JPanel getPanelMeno() {
		return panelMeno;
	}

	public void setPanelMeno(JPanel panelMeno) {
		this.panelMeno = panelMeno;
	}

	public JPanel getPanelEmail() {
		return panelEmail;
	}

	public void setPanelEmail(JPanel panelEmail) {
		this.panelEmail = panelEmail;
	}

	public JPanel getPanelTelC() {
		return panelTelC;
	}

	public void setPanelTelC(JPanel panelTelC) {
		this.panelTelC = panelTelC;
	}

	public JPanel getPanelWeb() {
		return panelWeb;
	}

	public void setPanelWeb(JPanel panelWeb) {
		this.panelWeb = panelWeb;
	}

	public JPanel getPanelInfoPanel() {
		return panelInfoPanel;
	}

	public void setPanelInfoPanel(JPanel panelInfoPanel) {
		this.panelInfoPanel = panelInfoPanel;
	}

	public JButton getBtnTelCislo() {
		return btnTelCislo;
	}

	public void setBtnTelCislo(JButton btnTelCislo) {
		this.btnTelCislo = btnTelCislo;
	}
}
