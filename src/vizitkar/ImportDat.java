package vizitkar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportDat {
	
	public ImportDat(){
		
	}
	/**
	 * Táto trieda slúži na importovanie dát
	 * */
	
	/**
	 * Táto metóda slúži na prehľadávanie dát vybranej vizitky, vybraná vizitka sa spustí v triede App na jej ďalšie spracovanie
	 * 
	 * @param selectedNazov názov vizitky
	 * 
	 * 
	 * */
	public void prehladavanieDat() {
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

			Vizitka vizitka = new Vizitka();
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				boolean firstLine = true;

				while ((line = reader.readLine()) != null) {
					if (firstLine) {
						firstLine = false;
						continue;
					}

					String[] data = line.split("_", -1);
					int id = Integer.parseInt(data[0]);

					switch (id) {
					case 0:
						vizitka.setMeno(data[2]);
						vizitka.setPriezvisko(data[3]);
						vizitka.setTitulPred(data[4]);
						vizitka.setTitulZa(data[5]);
						vizitka.setSpolocnost(data[6]);
						vizitka.setTelCislo(data[7]);
						vizitka.setEmail(data[8]);
						vizitka.setWeb(data[9]);
						vizitka.setAdresa(data[10]);
						break;

					case 1:
						vizitka.setMenoColor(decodeColor(data[2]));
						vizitka.setSpolocnostColor(decodeColor(data[3]));
						vizitka.setTelCisloColor(decodeColor(data[4]));
						vizitka.setEmailColor(decodeColor(data[5]));
						vizitka.setWebColor(decodeColor(data[6]));
						vizitka.setAdresaColor(decodeColor(data[7]));
						break;
					case 2:
						vizitka.setMenoAlign(data[2]);
						vizitka.setSpolocnostAlign(data[3]);
						vizitka.setTelCisloAlign(data[4]);
						vizitka.setEmailAlign(data[5]);
						vizitka.setWebAlign(data[6]);
						vizitka.setAdresaAlign(data[7]);
						break;
					case 3:
						vizitka.setMenoFont(data[2]);
						vizitka.setSpolocnostFont(data[3]);
						vizitka.setTelCisloFont(data[4]);
						vizitka.setEmailFont(data[5]);
						vizitka.setWebFont(data[6]);
						vizitka.setAdresaFont(data[7]);
						break;
					case 4:
						vizitka.setColorBG(decodeColor(data[2]));
						break;
					case 5:
						vizitka.setPomer(data[2]);
						break;
					case 6:
						vizitka.setPanelType(data[2]);
						break;
					case 7:
						vizitka.setLogoORqr(data[2]);
						if (vizitka.getLogoORqr().equals("1")) {
							vizitka.setLogoPath(data[3]);
							break;
						} else if (vizitka.getLogoORqr().equals("2")) {
							vizitka.setQrColor(decodeColor(data[3]));
							break;
						}

					}
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error saving to CSV: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			App app = new App(vizitka);

			app.setVisible(true);
		}

	}
	/**
	 * Táto metóda slúži na prepísanie farby z dát (pretože mi inak nebralo danú farbu)
	 * 
	 * @param colorString reťazec danej farby, ktorú chceme prepísať na Color
	 * @return vracia prepísanú farbu
	 * 
	 * */
	private Color decodeColor(String colorString) {
		try {
			if (colorString == null) {
				return new Color(255, 255, 255);
			}
			Pattern pattern = Pattern.compile("java.awt.Color\\[r=(\\d+),g=(\\d+),b=(\\d+)\\]");
			Matcher matcher = pattern.matcher(colorString);

			if (matcher.find()) {
				int r = Integer.parseInt(matcher.group(1));
				int g = Integer.parseInt(matcher.group(2));
				int b = Integer.parseInt(matcher.group(3));
				return new Color(r, g, b);
			}
		} catch (Exception e) {
			System.err.println("Error decoding color: " + colorString + " - " + e.getMessage());
		}

		return Color.BLACK; // Default color in case of an error
	}
}
