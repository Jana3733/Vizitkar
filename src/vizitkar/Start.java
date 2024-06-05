package vizitkar;

import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.TitledBorder;

public class Start extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelOptionsButtons;
	private JScrollPane scrollPane;
	private JPanel panelVizitky;

	private JButton btnVymazat;
	private JButton btnOtvor;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNovaVizitka;
	private JPanel panelLogoMain;
	private JLabel lblNewLabel_1;
	private JPanel panelOptions;
	private JPanel panelList;
	private JPanel panel_1;
	private JTextField txtNazovvizitky;
	private ArrayList<JPanel> listPanelovVizitiek = new ArrayList<JPanel>();
	private JPanel selectedVizitka;
	private JLabel lblNewLabel;
	private JComboBox comboBoxSort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatDarkLaf());
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Vytvára hlavný frame
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(48, 50, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelOptions = new JPanel();
		panelOptions.setBackground(new Color(60, 63, 65));
		contentPane.add(panelOptions, BorderLayout.NORTH);
		panelOptions.setLayout(new BorderLayout(0, 1));

		panelLogoMain = new JPanel();
		panelLogoMain.setBorder(null);
		panelOptions.add(panelLogoMain, BorderLayout.NORTH);
		panelLogoMain.setBackground(new Color(36, 37, 38));
		panelLogoMain.setLayout(new GridLayout(0, 1, 0, 0));

		lblNewLabel_1 = new JLabel("Vizitky");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBorder(new EmptyBorder(5, 10, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Corbel Light", Font.PLAIN, 30));
		lblNewLabel_1.setBackground(new Color(133, 166, 192));
		panelLogoMain.add(lblNewLabel_1);

		panelOptionsButtons = new JPanel();
		panelOptionsButtons.setBorder(new EmptyBorder(10, 0, 4, 0));
		panelOptionsButtons.setBackground(new Color(36, 37, 38));
		panelOptions.add(panelOptionsButtons, BorderLayout.SOUTH);
		panelOptionsButtons.setForeground(new Color(0, 0, 0));

		btnVymazat = new JButton("Vymazať");
		btnVymazat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Component comp : selectedVizitka.getComponents()) {
						if (comp instanceof JTextField) {
							JTextField textField = (JTextField) comp;
							String str = textField.getText();
							int option = JOptionPane.showConfirmDialog(null, "Určite chcete vymazať tento súbor?",
									"Súbor " + str, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (option == JOptionPane.YES_OPTION) {
								vymazanieDat(str);
							}
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Nebol vybratý súbor ", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panelOptionsButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));

		btnNovaVizitka = new JButton("Nová vizitka");
		btnNovaVizitka.setBackground(new Color(0, 64, 128));
		btnNovaVizitka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App app = new App();
				app.setVisible(true);
				dispose();
			}
		});
		
		lblNewLabel = new JLabel("Zoradiť podľa:");
		panelOptionsButtons.add(lblNewLabel);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nacitanieDat(comboBoxSort.getSelectedIndex());
			}
		});
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"najstaršie", "najnovšie", "A-Z", "Z-A"}));
		comboBoxSort.setSelectedIndex(0);
		panelOptionsButtons.add(comboBoxSort);
		panelOptionsButtons.add(btnNovaVizitka);
		panelOptionsButtons.add(btnVymazat);
		btnOtvor = new JButton("Otvoriť");
		btnOtvor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Component comp : selectedVizitka.getComponents()) {
						if (comp instanceof JTextField) {
							JTextField textField = (JTextField) comp;
							String str = textField.getText();
							prehladavanieDat(str);
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Nebol vybratý súbor ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelOptionsButtons.add(btnOtvor);

		panelList = new JPanel();
		contentPane.add(panelList, BorderLayout.CENTER);
		panelList.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelList.add(scrollPane);

		panelVizitky = new JPanel();
		panelVizitky.setBackground(new Color(36, 37, 38));
		scrollPane.setViewportView(panelVizitky);
		panelVizitky.setLayout(new GridLayout(20, 1, 0, 2));
		nacitanieDat(0);
		

	}
	/** 
	 * Táto metóda slúži na načítanie dát zo súboru Data.csv a následne ukáže TextField-y s už vytvorenými vizitkami
	 * 
	 * @param int cislo - slúži na sortovanie súborov
	 * 
	 * */
	private boolean nacitanieDat(int cislo) {
	    String filePath = "Data.csv";
	    File file = new File(filePath);
	    if (!file.exists()) {
	        System.out.println("File does not exist.");
	        return true;
	    }

	    List<String[]> records = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        boolean firstLine = true;

	        while ((line = reader.readLine()) != null) {
	            if (firstLine) {
	                firstLine = false;
	                continue;
	            }
	            String[] data = line.split(",");
	            if (data.length >= 3) {
	                records.add(data);
	            } else {
	                System.err.println("Skipping invalid line: " + line);
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading from CSV file: " + e.getMessage());
	        return true;
	    }

	    switch (cislo) {
	        case 0:
	            break;
	        case 1:
	            Collections.reverse(records);
	            break;
	        case 2:
	            records.sort(Comparator.comparing(record -> record[1]));
	            break;
	        case 3:
	            records.sort(Comparator.comparing(record -> record[1], Comparator.reverseOrder()));
	            break;
	    }

	    if (panelVizitky == null) {
	        return true;
	    }

	    panelVizitky.removeAll();
	    listPanelovVizitiek.clear();

	    for (String[] record : records) {
	        String nazov = record[1];

	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(60, 63, 65));
	        panel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                Color color = new Color(60, 63, 65);
	                if (panel.getBackground().equals(color)) {
	                    unselectedVizitka();
	                    setSelectedVizitka(panel);
	                    panel.setBackground(new Color(48, 50, 52));
	                } else {
	                    unselectedVizitka();
	                    setSelectedVizitka(panel);
	                    panel.setBackground(new Color(60, 63, 65));
	                }
	            }
	        });
	        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        panel.setAlignmentX(FlowLayout.LEFT);
	        panelVizitky.add(panel);
	        listPanelovVizitiek.add(panel);
	        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

	        JTextField txtNazovvizitky = new JTextField();
	        txtNazovvizitky.setBorder(new EmptyBorder(0, 10, 0, 0));
	        txtNazovvizitky.setHorizontalAlignment(SwingConstants.LEFT);
	        txtNazovvizitky.setForeground(new Color(255, 255, 255));
	        txtNazovvizitky.setDisabledTextColor(new Color(255, 255, 255));
	        txtNazovvizitky.setEditable(false);
	        txtNazovvizitky.setEnabled(false);
	        txtNazovvizitky.setText(nazov);
	        panel.add(txtNazovvizitky);
	        txtNazovvizitky.setColumns(10);

	        validate();
	        repaint();
	    }

	    return true;
	}


	public void setSelectedVizitka(JPanel panel) {
		this.selectedVizitka = panel;
	}
	
	public void unselectedVizitka() {
		Color color = new Color(48, 50, 52);
		for (JPanel x : listPanelovVizitiek) {
			if (x.getBackground().equals(color)) {
				setSelectedVizitka(null);
				x.setBackground(new Color(60, 63, 65));
			}
		}
	}
	/**
	 * Táto metóda slúži na prehľadávanie dát vybranej vizitky, vybraná vizitka sa spustí v triede App na jej ďalšie spracovanie
	 * 
	 * @param selectedNazov názov vizitky
	 * 
	 * 
	 * */
	public void prehladavanieDat(String selectedNazov) {
		String filePathData = "Data.csv";
		String filePath = "";

		try (BufferedReader readerData = new BufferedReader(new FileReader(filePathData))) {
			String lineData;
			boolean firstLineData = true;

			while ((lineData = readerData.readLine()) != null) {
				if (firstLineData) {
					firstLineData = false;
					continue;
				}

				String[] data = lineData.split(",", -1);
				if (data[1].equals(selectedNazov)) {
					filePath = data[2];
					break;
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading from Data.csv: " + e.getMessage());
			return;
		}

		if (filePath.isEmpty()) {
			System.out.println("No CSV file path found for the selected Vizitka.");
			return;
		}

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
			System.err.println("Error reading from the CSV file: " + e.getMessage());
			return;
		}
		App app = new App(vizitka);

		app.setVisible(true);
		app.setOpened(true);
		app.setOpenedVizitkaNazov(selectedNazov);

		Start.this.dispose();
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
			if (colorString==null) {
				return new Color(255,255,255);
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

		return Color.BLACK; 
	}
	/**
	 * Metóda na vymazávanie dát (vymaže aj daný súbor v počítači aj v Data.csv)
	 * 
	 * @param selectedNazov názov vizitky, ktorú chceme vymazať
	 * 
	 * */
	public void vymazanieDat(String selectedNazov) {
	    String filePath = "Data.csv";
	    File dataFile = new File(filePath);
	    ArrayList<String> lines = new ArrayList<>();
	    String fileToDeletePath = "";
	    String header = "";

	    try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
	        boolean isFirstLine = true;

	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (isFirstLine) {
	                header = line;
	                lines.add(header);
	                isFirstLine = false;
	                continue;
	            }

	            String[] data = line.split(",");
	            if (data[1].equals(selectedNazov)) {
	                fileToDeletePath = data[2];
	            } else {
	                lines.add(line);
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading from CSV file: " + e.getMessage());
	        return;
	    }

	    if (!fileToDeletePath.isEmpty()) {
	        File fileToDelete = new File(fileToDeletePath);
	        if (fileToDelete.exists()) {
	            if (!fileToDelete.delete()) {
	                System.err.println("Error deleting the file: " + fileToDeletePath);
	            }
	        }
	    }

	    try (PrintWriter writer = new PrintWriter(new FileWriter(dataFile))) {
	        for (String line : lines) {
	            writer.println(line);
	        }
	    } catch (IOException e) {
	        System.err.println("Error writing to CSV file: " + e.getMessage());
	    }

	    setVisible(false);
	    contentPane.setVisible(false);

	    Start newStart = new Start();
	    newStart.setVisible(true);
	}



	
	

}
