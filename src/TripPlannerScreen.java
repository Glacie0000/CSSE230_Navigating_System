import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class TripPlannerScreen extends JFrame{
	
	public ArrayList<String> citiesByCar = new ArrayList<String>(Arrays.asList("New York City", "Baltimore", "Philadelphia", "Boston"));
	public ArrayList<String> citiesByPlane = new ArrayList<String>(Arrays.asList("New York City", "San Diego", "Beijing", "Paris", "Frankfurt", "Barcelona", "Cancun", "Rome", "Tokyo", "Dubai"));
	public ArrayList<String> citiesByBus = new ArrayList<String>(Arrays.asList("Toronto", "Chicago", "New York", "Atlanta", "Indianapolis", "Dallas", "New Orleans"));
	public ArrayList<String> citiesByTrain= new ArrayList<String>(Arrays.asList("Philadelphia", "New York", "Baltimore", "Richmond", "Williamsburg"));
	
	public HashMap<String, String> foodPlaces = new HashMap<String, String>(){{
		put("New York City", "Ugly Baby"); put("Baltimore", "True Chesapeake Oyster Co"); put("Philadelphia", "Suraya"); 
		put("Boston", "Neptune Oyster"); put("San Diego", "Jeune et Jolie"); put("Beijing", "The View 3912"); put("Paris", "Le Boullion Chartier"); put("Frankfurt", "Ariston"); 
		put("Barcelona", "Buneos Aires"); put("Cancun", "Porfirio's Cancun"); put("Rome", "Otello"); put("Tokyo", "Gonpachi Nishiazabu"); put("Toronto", "360 Restaurant");
		put("Chicago", "The Purple Pig"); put("Indianapolis", "The Garden Table"); put("Dallas", "Five Sixty"); put("New Orleans", "Commander's Palace");
		put("Richmond", "Stella's"); put("Williamsburg", "Food For Thought"); put("Dubai", "Al Dawaar"); 
	}};
	public HashMap<String, String> historicalPlaces = new HashMap<String, String>(){{
		put("New York City", "Ellis Island"); put("Baltimore", "Libery Bell Center"); put("Philadelphia", "Independence Hall"); 
		put("Boston", "Freedom Trail"); put("San Diego", "USS Midway Mueseum"); put("Beijing", "Forbidden City"); put("Paris", "Arc De Triomphe"); put("Frankfurt", "Mercedez-Benz Museum"); 
		put("Barcelona", "Montjuic Castle"); put("Cancun", "Mayan Museum"); put("Rome", "Colosseum"); put("Tokyo", "Samurai Museum"); put("Toronto", "Casa Loma");
		put("Chicago", "Field Museum"); put("Indianapolis", "Indiana War Memorial"); put("Dallas", "Six Floor Museum"); put("New Orleans", "Jackson Square");
		put("Richmond", "Historic Jamestown"); put("Williamsburg", "Jamestown Settlement"); put("Dubai", "Etihad Museum");
	}};
	public HashMap<String, String> languagePlaces = new HashMap<String, String>(){{
		put("New York City", "Spanish"); put("San Diego", "Any Language"); put("Beijing", "Mandarin"); put("Paris", "French"); put("Frankfurt", "German"); 
		put("Barcelona", "Catalan"); put("Cancun", "Spanish"); put("Rome", "Italian"); put("Tokyo", "Japenese"); put("New Orleans", "French"); put("Dubai", "Arabic");
	}};
	public HashMap<String, String> ridePlaces = new HashMap<String, String>(){{
		put("New York City", "Luna Park"); put("Baltimore", "Adventure Park"); put("Philadelphia", "Sky Zone"); 
		put("Boston", "Sky Zone"); put("San Diego", "Sea World"); put("Beijing", "Olympic Park"); put("Paris", "Jardin d'Acclimataion");  
		put("Barcelona", "Tibidabo"); put("Cancun", "Parque Maya Tours"); put("Rome", "Oasi"); put("Tokyo", "Joypolis"); put("Toronto", "Centreville");
		put("Chicago", "Field Museum"); put("Indianapolis", "Indiana War Memorial"); put("Dallas", "Six Floor Museum"); put("New Orleans", "Jackson Square"); put("Dubai", "Bollywood Parks");
	}};
	public HashMap<String, String> shopPlaces = new HashMap<String, String>(){{
		put("New York City", "Manhattan Mall"); put("Baltimore", "Waverly"); put("Philadelphia", "Libery Place"); 
		put("Boston", "Prudential Center"); put("San Diego", "Mesa"); put("Beijing", "New World"); put("Paris", "Carrousel de Louvre"); put("Frankfurt", "MyZeil"); 
		put("Barcelona", "Maremagnum"); put("Cancun", "Forum By Sea"); put("Rome", "Portia de Roma"); put("Tokyo", "DiverCity"); put("Toronto", "Yorkdale");
		put("Chicago", "Addison Mall"); put("Indianapolis", "Circle Center"); put("Dallas", "Galleria"); put("New Orleans", "Canal Place"); put("Dubai", "Dubai Mall"); 
	}};
	public HashMap<String, String> naturePlaces = new HashMap<String, String>(){{
		put("New York City", "The Ramble"); put("Baltimore", "Lake Roland"); put("Philadelphia", "FairMount Park"); 
		put("Boston", "Breakheart Reservation"); put("San Diego", "Los Penasquitos Canyon"); put("Beijing", "Fragrant Hills"); put("Paris", "Jardin de Tuileries"); put("Frankfurt", "Schwanheimer Dune"); 
		put("Barcelona", "Collserola"); put("Cancun", "Xcaret"); put("Rome", "Villa Ada"); put("Tokyo", "Meiji Shrine"); put("Toronto", "Mono Cliffs");
		put("Chicago", "Morton Arboretum"); put("Richmond", "Maymont"); put("Williamsburg", "Redoubt Park"); put("Dubai", "Ras Al Khor"); 
	}};
	
	static final Font choiceFont2 = new Font("High Tower Text", Font.PLAIN, 20);
	static final Font choiceFont = new Font("High Tower Text", Font.PLAIN, 30);
	static final Font labelFont = new Font("High Tower Text", Font.BOLD | Font.ITALIC, 40);
	static final Font questionFont = new Font("High Tower Text", Font.ITALIC, 30);
	
	JLabel plannerLabel;
	
	public String vType;
	public String actType;
	
	public TripPlannerScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel welcomeLabel = new JLabel("<html><u>Plan Your Next Trip!</u></html>");
		welcomeLabel.setBorder(new EmptyBorder(0, 320, 0, 0));
		welcomeLabel.setBackground(Color.BLACK);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setOpaque(true);
		welcomeLabel.setFont(labelFont);
		getContentPane().add(welcomeLabel);
		
		JLabel methodLabel = new JLabel("What method of transportation are you planning to use?");
		methodLabel.setBackground(Color.BLACK);
		methodLabel.setForeground(Color.WHITE);
		methodLabel.setOpaque(true);
		methodLabel.setFont(questionFont);
		getContentPane().add(methodLabel);
		
		JPanel vehicle = new JPanel();
		getContentPane().add(vehicle);
		vehicle.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton carButton = new JRadioButton("Car");
		carButton.setFont(choiceFont);
		carButton.addActionListener(new HowActionListener(carButton));
		vehicle.add(carButton);
		
		JRadioButton planeButton = new JRadioButton("Plane");
		planeButton.addActionListener(new HowActionListener(planeButton));
		planeButton.setFont(choiceFont);
		vehicle.add(planeButton);
		
		JRadioButton busButton = new JRadioButton("Bus");
		busButton.setFont(choiceFont);
		busButton.addActionListener(new HowActionListener(busButton));
		vehicle.add(busButton);
		
		JRadioButton trainButton = new JRadioButton("Train");
		trainButton.setFont(choiceFont);
		trainButton.addActionListener(new HowActionListener(trainButton));
		vehicle.add(trainButton);
		
		ButtonGroup vehicleGroup = new ButtonGroup();
		vehicleGroup.add(trainButton); vehicleGroup.add(busButton); vehicleGroup.add(planeButton);
		vehicleGroup.add(carButton); 
 
		JLabel typeLabel = new JLabel("What would you like to do on your trip?");
		typeLabel.setBackground(Color.BLACK);
		typeLabel.setForeground(Color.WHITE);
		typeLabel.setOpaque(true);
		typeLabel.setFont(questionFont);
		getContentPane().add(typeLabel);
		
		JPanel choice = new JPanel();
		getContentPane().add(choice);
		choice.setLayout(new GridLayout(0, 6, 0, 0));
		
		JRadioButton food = new JRadioButton("<html>Eat Top <br/> Notch Food</html>");
		food.addActionListener(new WhatActionListener(food));
		food.setFont(choiceFont2);
		choice.add(food);
		
		JRadioButton history = new JRadioButton("<html>Visit Historical <br/> Sites</html>");
		history.addActionListener(new WhatActionListener(history));
		history.setFont(choiceFont2);
		choice.add(history);
		
		JRadioButton language = new JRadioButton("<html>Learn A New<br/> Language</html>");
		language.setFont(choiceFont2);
		language.addActionListener(new WhatActionListener(language));
		choice.add(language);
		
		JRadioButton fun = new JRadioButton("<html> Ride <br/> Rides</html>");
		fun.setFont(choiceFont2);
		fun.addActionListener(new WhatActionListener(fun));
		choice.add(fun);
		
		JRadioButton shop = new JRadioButton("<html> Go<br/> Shopping</html>");
		shop.setFont(choiceFont2);
		shop.addActionListener(new WhatActionListener(shop));
		choice.add(shop);
		
		JRadioButton nature = new JRadioButton("<html>Become One<br/> with Nature</html>");
		nature.setFont(choiceFont2);
		nature.addActionListener(new WhatActionListener(nature));
		choice.add(nature);
		
		ButtonGroup choices = new ButtonGroup();
		choices.add(nature);choices.add(shop); choices.add(fun); 
		choices.add(language); choices.add(history); choices.add(food);
		
		JPanel resultPanel = new JPanel();
		getContentPane().add(resultPanel);
		resultPanel.setLayout(null);
		
		plannerLabel = new JLabel("Trip Planner 3000 is calculating your next trip...");
		plannerLabel.setBounds(150, 5, 650, 50);
		plannerLabel.setBackground(Color.BLACK);
		plannerLabel.setForeground(Color.WHITE);
		plannerLabel.setOpaque(true);
		plannerLabel.setFont(new Font("High Tower Text", Font.ITALIC | Font.BOLD, 20));
		resultPanel.add(plannerLabel);
		
		JButton backButton = new JButton("Return to Home Screen");
		backButton.setFont(choiceFont2);
		backButton.setBackground(Color.YELLOW);
		backButton.setBounds(740, 75, 250, 30);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NavigationScreen();
			}
		});
		resultPanel.add(backButton);
		
		setResizable(false);
		setVisible(true);
		
	}
	
	public void updateTripCalculator() {
		String where = null;
		String what = null;
		
		if(vType == null || actType == null) {
			return;
		}
		
		if(actType.equals("<html>Eat Top <br/> Notch Food</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(foodPlaces.containsKey(k)) {
						what = foodPlaces.get(k);
						foodPlaces.remove(k);
					}
				}
			} else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(foodPlaces.containsKey(b)) {
						what = foodPlaces.get(b);
						foodPlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(foodPlaces.containsKey(h)) {
						what = foodPlaces.get(h);
						foodPlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(foodPlaces.containsKey(t)) {
						what = foodPlaces.get(t);
						foodPlaces.remove(t);
					}
				}
			}
		}else if(actType.equals("<html>Visit Historical <br/> Sites</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(historicalPlaces.containsKey(k)) {
						what = historicalPlaces.get(k);
						historicalPlaces.remove(k);
					}
				}
			}else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(historicalPlaces.containsKey(b)) {
						what = historicalPlaces.get(b);
						historicalPlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(historicalPlaces.containsKey(h)) {
						what = historicalPlaces.get(h);
						historicalPlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(historicalPlaces.containsKey(t)) {
						what = historicalPlaces.get(t);
						historicalPlaces.remove(t);
					}
				}
			}
			
		}else if(actType.equals("<html>Learn A New<br/> Language</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(languagePlaces.containsKey(k)) {
						what = languagePlaces.get(k);
						languagePlaces.remove(k);
					}
				}
			} else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(languagePlaces.containsKey(b)) {
						what = languagePlaces.get(b);
						languagePlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(languagePlaces.containsKey(h)) {
						what = languagePlaces.get(h);
						languagePlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(languagePlaces.containsKey(t)) {
						what = languagePlaces.get(t);
						languagePlaces.remove(t);
					}
				}
			}
			
		}else if(actType.equals("<html> Ride <br/> Rides</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(ridePlaces.containsKey(k)) {
						what = ridePlaces.get(k);
						ridePlaces.remove(k);
					}
				}
			} else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(ridePlaces.containsKey(b)) {
						what = ridePlaces.get(b);
						ridePlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(ridePlaces.containsKey(h)) {
						what = ridePlaces.get(h);
						ridePlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(ridePlaces.containsKey(t)) {
						what = ridePlaces.get(t);
						ridePlaces.remove(t);
					}
				}
			}
			
		}else if(actType.equals("<html> Go<br/> Shopping</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(shopPlaces.containsKey(k)) {
						what = shopPlaces.get(k);
						shopPlaces.remove(k);
					}
				}
			} else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(shopPlaces.containsKey(b)) {
						what = shopPlaces.get(b);
						shopPlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(shopPlaces.containsKey(h)) {
						what = shopPlaces.get(h);
						shopPlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(shopPlaces.containsKey(t)) {
						what = shopPlaces.get(t);
						shopPlaces.remove(t);
					}
				}
			}
		}else if(actType.equals("<html>Become One<br/> with Nature</html>")) {
			if(vType.equals("Car")) {
				for(String k : citiesByCar) {
					where = k;
					if(naturePlaces.containsKey(k)) {
						what = naturePlaces.get(k);
						naturePlaces.remove(k);
					}
				}
			} else if(vType.equals("Bus")) {
				for(String b : citiesByBus) {
					where = b;
					if(naturePlaces.containsKey(b)) {
						what = naturePlaces.get(b);
						naturePlaces.remove(b);
					}
				}
			} else if(vType.equals("Plane")) {
				for(String h : citiesByPlane) {
					where = h;
					if(naturePlaces.containsKey(h)) {
						what = naturePlaces.get(h);
						naturePlaces.remove(h);
					}
				}
			} else if(vType.equals("Train")) {
				for(String t: citiesByTrain) {
					where = t;
					if(naturePlaces.containsKey(t)) {
						what = naturePlaces.get(t);
						naturePlaces.remove(t);
					}
				}
			}
		}
		
		if(what == null || where == null) {
			return;
		}
		if(citiesByCar.contains(where)) {
			citiesByCar.remove(where);
		}
		if(citiesByTrain.contains(where)) {
			citiesByTrain.remove(where);
		}
		if(citiesByBus.contains(where)) {
			citiesByBus.remove(where);
		}
		if(citiesByPlane.contains(where)) {
			citiesByPlane.remove(where);
		}
		
		plannerLabel.setText("Trip Planner 3000 caluculate this: " + where + " for " + what);
	}
	
	public class WhatActionListener implements ActionListener{
		
		JRadioButton activity;
		
		public WhatActionListener(JRadioButton a) {
			this.activity = a;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			actType = activity.getText();
			System.out.println(citiesByCar.toString());
			updateTripCalculator();
		}
	}
	
	public class HowActionListener implements ActionListener{
		
		JRadioButton transport;
		
		public HowActionListener(JRadioButton t) {
			this.transport = t;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			vType = transport.getText();
			updateTripCalculator();
		}
	}

}
