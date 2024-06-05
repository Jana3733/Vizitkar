package vizitkar;

import java.awt.Color;

public class Vizitka {
	private int id;
	private String meno;
	private String priezvisko;
	private String titulPred;
	private String titulZa;
	private String spolocnost;
	private String adresa;
	private String telCislo;
	private String email;
	private String web;
	
    private Color menoColor;
    private Color spolocnostColor;
    private Color adresaColor;
    private Color telCisloColor;
    private Color emailColor;
    private Color webColor;

    
	private String menoAlign;
    private String spolocnostAlign;
    private String adresaAlign;
    private String telCisloAlign;
    private String emailAlign;
    private String webAlign;
    
    private String menoFont;
    private String spolocnostFont;
    private String adresaFont;
    private String telCisloFont;
    private String emailFont;
    private String webFont;
    
	private Color colorBG;
	private String pomer;
	private String panelType;
	
	private String logoORqr;
	private String logoPath;
	private String qrPath;
	private Color qrColor;
	
	
	public Vizitka() {
		this.id = 0;
		this.meno = "Jožko";
		this.priezvisko = "Mrkvička";
		this.titulPred = "Ing.";
		this.titulZa = "PhD.";
		this.spolocnost = "Naradie s.r.o.";
		this.adresa="Mostná 1";
		this.telCislo = "+421 949 123 456";
		this.email = "mrkvicka@gmail.com";
		this.web = "naradieMrkvicky.com";
		
		this.menoColor = new Color(0,0,0);
	    this.spolocnostColor = new Color(0,0,0);
	    this.adresaColor = new Color(0,0,0);
	    this.telCisloColor = new Color(0,0,0);
	    this.emailColor = new Color(0,0,0);
	    this.webColor = new Color(0,0,0);
	    
	    this.menoAlign = "0";
	    this.spolocnostAlign = "0";
	    this.adresaAlign = "0";
	    this.telCisloAlign = "0";
	    this.emailAlign = "0";
	    this.webAlign = "0";
	    
	    this.menoFont = "4";
	    this.spolocnostFont = "4";
	    this.adresaFont = "4";
	    this.telCisloFont = "4";
	    this.emailFont = "4";
	    this.webFont = "4";
	    
	    this.colorBG=null;
	    this.pomer="0";
		this.panelType="1";
		this.logoORqr="0";
	} 
	public String getMenoFont() {
		return menoFont;
	}
	public void setMenoFont(String menoFont) {
		this.menoFont = menoFont;
	}
	public String getSpolocnostFont() {
		return spolocnostFont;
	}
	public void setSpolocnostFont(String spolocnostFont) {
		this.spolocnostFont = spolocnostFont;
	}
	public String getAdresaFont() {
		return adresaFont;
	}
	public void setAdresaFont(String adresaFont) {
		this.adresaFont = adresaFont;
	}
	public String getTelCisloFont() {
		return telCisloFont;
	}
	public void setTelCisloFont(String telCisloFont) {
		this.telCisloFont = telCisloFont;
	}
	public String getEmailFont() {
		return emailFont;
	}
	public void setEmailFont(String emailFont) {
		this.emailFont = emailFont;
	}
	public String getWebFont() {
		return webFont;
	}
	public void setWebFont(String webFont) {
		this.webFont = webFont;
	}
	public void setColors(Color menoColor, Color priezviskoColor, Color titulPredColor, Color titulZaColor, Color spolocnostColor, Color adresaColor, Color telCisloColor, Color emailColor, Color webColor) {
	    this.menoColor = menoColor;
	    this.spolocnostColor = spolocnostColor;
	    this.adresaColor = adresaColor;
	    this.telCisloColor = telCisloColor;
	    this.emailColor = emailColor;
	    this.webColor = webColor;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getPriezvisko() {
		return priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public String getTitulPred() {
		return titulPred;
	}

	public void setTitulPred(String titulPred) {
		this.titulPred = titulPred;
	}

	public String getTitulZa() {
		return titulZa;
	}

	public void setTitulZa(String titulZa) {
		this.titulZa = titulZa;
	}

	public String getSpolocnost() {
		return spolocnost;
	}

	public void setSpolocnost(String spolocnost) {
		this.spolocnost = spolocnost;
	}

	public String getTelCislo() {
		return telCislo;
	}

	public void setTelCislo(String telCislo) {
		this.telCislo = telCislo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}


	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Color getMenoColor() {
		return menoColor;
	}
	public void setMenoColor(Color menoColor) {
		this.menoColor = menoColor;
	}
	
	public Color getSpolocnostColor() {
		return spolocnostColor;
	}
	public void setSpolocnostColor(Color spolocnostColor) {
		this.spolocnostColor = spolocnostColor;
	}
	public Color getAdresaColor() {
		return adresaColor;
	} 
	public void setAdresaColor(Color adresaColor) {
		this.adresaColor = adresaColor;
	}
	public Color getTelCisloColor() {
		return telCisloColor;
	}
	public void setTelCisloColor(Color telCisloColor) {
		this.telCisloColor = telCisloColor;
	}
	public Color getEmailColor() {
		return emailColor;
	}
	public void setEmailColor(Color emailColor) {
		this.emailColor = emailColor;
	}
	public Color getWebColor() {
		return webColor;
	}
	public void setWebColor(Color webColor) {
		this.webColor = webColor;
	}
	public Color getColorBG() {
		return colorBG;
	}
	public void setColorBG(Color colorBG) {
		this.colorBG = colorBG;
	}
	public String getMenoAlign() {
		return menoAlign;
	}
	public void setMenoAlign(String menoAlign) {
		this.menoAlign = menoAlign;
	}
	public String getSpolocnostAlign() {
		return spolocnostAlign;
	}
	public void setSpolocnostAlign(String spolocnostAlign) {
		this.spolocnostAlign = spolocnostAlign;
	}
	public String getAdresaAlign() {
		return adresaAlign;
	}
	public void setAdresaAlign(String adresaAlign) {
		this.adresaAlign = adresaAlign;
	}
	public String getTelCisloAlign() {
		return telCisloAlign;
	}
	public void setTelCisloAlign(String telCisloAlign) {
		this.telCisloAlign = telCisloAlign;
	}
	public String getEmailAlign() {
		return emailAlign;
	}
	public void setEmailAlign(String emailAlign) {
		this.emailAlign = emailAlign;
	}
	public String getWebAlign() {
		return webAlign;
	}
	public void setWebAlign(String webAlign) {
		this.webAlign = webAlign;
	}
	public String getPomer() {
		return pomer;
	}
	public void setPomer(String pomer) {
		this.pomer = pomer;
	}
	public String getPanelType() {
		return panelType;
	}
	public void setPanelType(String panelType) {
		this.panelType = panelType;
	}
	public String getLogoORqr() {
		return logoORqr;
	}
	public void setLogoORqr(String logoORqr) {
		this.logoORqr = logoORqr;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getQrPath() {
		return qrPath;
	}
	public void setQrPath(String qrPath) {
		this.qrPath = qrPath;
	}

	public Color getQrColor() {
		return qrColor;
	}
	public void setQrColor(Color qrColor) {
		this.qrColor = qrColor;
	}
}
