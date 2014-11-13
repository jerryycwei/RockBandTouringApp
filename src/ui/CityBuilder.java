package ui;

import java.util.ArrayList;
import java.util.Random;

import metamodel.Circle;
import metamodel.City;
import metamodel.MapSystem;
import metamodel.Symbol;


public class CityBuilder {

	private MapSystem system;

	/**
	 * ArrayList of all Cities added in initializeCities()
	 */
	private ArrayList<City> cities = new ArrayList<City>();

	public CityBuilder(MapSystem system){
		this.system = system;
		initializeCities();
	}

	public ArrayList<City> getCities(){
		return cities;
	}

	/**
	 * Initialize Cities as well as the venues and accommodations
	 */
	private void initializeCities() {
		
		Random generator = new Random();

		City losAngeles = new City("Los Angeles", new Circle("Los Angeles", 120, 413), system, "Los Angeles", 3884000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City chicago = new City("Chicago", new Circle("Chicago", 716, 220), system, "Chicago", 2790000, "Rainy", new Symbol("images/weatherRain.jpg"));
		City kansasCity = new City("Kansas City", new Circle("Kansas City", 581, 291), system, "Kansas", 467000, "Tornado", new Symbol("images/weatherTornado.jpg"));
		City newYork = new City("New York City", new Circle("New York City", 981, 250), system, "New York", 8400000, "Snow", new Symbol("images/weatherSnow.jpg"));
		City toronto = new City("Toronto", new Circle("Toronto", 876, 173), system, "Toronto", 2500000, "Snow", new Symbol("images/weatherSnow.jpg"));
		City montreal = new City("Montreal", new Circle("Montreal", 989, 123), system, "Montreal", 1600000, "Snow", new Symbol("images/weatherSnow.jpg"));
		City houston = new City("Houston", new Circle("Houston", 565, 512), system, "Houston", 2196000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City philadelphia = new City("Philadelphia", new Circle("Philadelphia", 959, 270), system, "Philadelphia", 1553000, "Rainy", new Symbol("images/weatherRain.jpg"));
		City phoenix = new City("Phoenix", new Circle("Phoenix", 241, 428), system, "Phoenix", 1513000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City sanDiego = new City("San Diego", new Circle("San Diego", 141, 445), system, "San Diego", 1356000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City sanFrancisco = new City("San Francisco", new Circle("San Francisco", 38, 324), system, "San Francisco", 837442, "Rainy", new Symbol("images/weatherRain.jpg"));
		City ottawa = new City("Ottawa", new Circle("Ottawa", 948, 124), system, "Ottawa", 883391, "Snow", new Symbol("images/weatherSnow.jpg"));
		City quebecCity = new City("Quebec City", new Circle("Quebec City", 1034, 86), system, "Quebec City", 491140, "Snow", new Symbol("images/weatherSnow.jpg"));
		City vancouver = new City("Vancouver", new Circle("Vancouver", 26, 14), system, "Vancouver", 578040, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City detroit = new City("Detroit", new Circle("Detroit", 804, 208), system, "Detroit", 688701, "Snow", new Symbol("images/weatherSnow.jpg"));
		City seattle = new City("Seattle", new Circle("Seattle", 40, 63), system, "Seattle", 652405, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City dallas = new City("Dallas", new Circle("Dallas", 537, 443), system, "Dallas", 1258000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City atlanta = new City("Atlanta", new Circle("Atlanta", 779, 420), system, "Atlanta", 447841, "Rainy", new Symbol("images/weatherRain.jpg"));
		City lasVegas = new City("Las Vegas", new Circle("Las Vegas", 181, 363), system, "Las Vegas", 603488, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City sanJose = new City("San Jose", new Circle("San Jose", 49, 335), system, "San Jose", 998537, "Sunny", new Symbol("images/weatherSunny.jpg"));

		cities.add(losAngeles);
		cities.add(chicago);
		cities.add(kansasCity);
		cities.add(newYork);
		cities.add(toronto);
		cities.add(montreal);
		cities.add(houston);
		cities.add(philadelphia);
		cities.add(phoenix);
		cities.add(sanDiego);
		cities.add(sanFrancisco);
		cities.add(ottawa);
		cities.add(quebecCity);
		cities.add(vancouver);
		cities.add(detroit);
		cities.add(seattle);
		cities.add(dallas);
		cities.add(atlanta);
		cities.add(lasVegas);
		cities.add(sanJose);

		
		losAngeles.addAccommodation("Hilton Courtyard", "Hotel", generator.nextInt(100) + 150);
		chicago.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		newYork.addAccommodation("Hilton Conrad", "Hotel", generator.nextInt(100) + 150);
		kansasCity.addAccommodation("Hilton Hotel", "Hotel", generator.nextInt(100) + 150);
		toronto.addAccommodation("Hilton Resort", "Hotel", generator.nextInt(100) + 150);
		montreal.addAccommodation("DoubleTree by Hilton", "Hotel", generator.nextInt(100) + 150);
		houston.addAccommodation("Embassy Suites by Hilton", "Hotel", generator.nextInt(100) + 150);
		philadelphia.addAccommodation("Curio by Hilton", "Hotel", generator.nextInt(100) + 150);
		phoenix.addAccommodation("Hilton Inn", "Hotel", generator.nextInt(100) + 150);
		sanDiego.addAccommodation("Hilton House", "Hotel", generator.nextInt(100) + 150);
		sanFrancisco.addAccommodation("Hilton Suites", "Hotel", generator.nextInt(100) + 150);
		ottawa.addAccommodation("Hilton Grand Vacations", "Hotel", generator.nextInt(100) + 150);
		quebecCity.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		vancouver.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		detroit.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		seattle.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		dallas.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		atlanta.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		lasVegas.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);
		sanJose.addAccommodation("Hilton Garden Inn", "Hotel", generator.nextInt(100) + 150);

		losAngeles.addAccommodation("Ritz-Carlton Los Angeles", "Hotel", generator.nextInt(200) + 300);
		chicago.addAccommodation("Ritz-Carlton Chicago", "Hotel", generator.nextInt(200) + 300);
		newYork.addAccommodation("Ritz-Carlton New York", "Hotel", generator.nextInt(200) + 300);
		kansasCity.addAccommodation("Ritz-Carlton Kansas City", "Hotel", generator.nextInt(200) + 300);
		toronto.addAccommodation("Ritz-Carlton Toronto", "Hotel", generator.nextInt(200) + 300);
		montreal.addAccommodation("Ritz-Carlton Montreal", "Hotel", generator.nextInt(200) + 300);
		houston.addAccommodation("Ritz-Carlton Houston", "Hotel", generator.nextInt(200) + 300);
		phoenix.addAccommodation("Ritz-Carlton Phoenix", "Hotel", generator.nextInt(200) + 300);
		philadelphia.addAccommodation("Ritz-Carlton Philadelphia", "Hotel", generator.nextInt(200) + 300);
		sanDiego.addAccommodation("Ritz-Carlton San Diego", "Hotel", generator.nextInt(200) + 300);
		sanFrancisco.addAccommodation("Ritz-Carlton San Francisco", "Hotel", generator.nextInt(200) + 300);
		ottawa.addAccommodation("Ritz-Carlton Ottawa", "Hotel", generator.nextInt(200) + 300);
		quebecCity.addAccommodation("Ritz-Carlton Quebec City", "Hotel", generator.nextInt(200) + 300);
		vancouver.addAccommodation("Ritz-Carlton Vancouver", "Hotel", generator.nextInt(200) + 300);
		detroit.addAccommodation("Ritz-Carlton Detroit", "Hotel", generator.nextInt(200) + 300);
		seattle.addAccommodation("Ritz-Carlton Seattle", "Hotel", generator.nextInt(200) + 300);
		dallas.addAccommodation("Ritz-Carlton Dallas", "Hotel", generator.nextInt(200) + 300);
		atlanta.addAccommodation("Ritz-Carlton Atlanta", "Hotel", generator.nextInt(200) + 300);
		lasVegas.addAccommodation("Ritz-Carlton Las Vegas", "Hotel", generator.nextInt(200) + 300);
		sanJose.addAccommodation("Ritz-Carlton San Jose", "Hotel", generator.nextInt(200) + 300);

		losAngeles.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		chicago.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		newYork.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		kansasCity.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		toronto.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		montreal.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		houston.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		phoenix.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		philadelphia.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		sanDiego.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		sanFrancisco.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		ottawa.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		quebecCity.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		vancouver.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		detroit.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		seattle.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		dallas.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		atlanta.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		lasVegas.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);
		sanJose.addAccommodation("Travelodge", "Hotel", generator.nextInt(60) + 70);

		
		
		losAngeles.addVenue("Wei Field", "Stadium", generator.nextInt(500000) + 1000000);
		chicago.addVenue("Wei Square Garden", "Stadium", generator.nextInt(500000) + 1000000);
		newYork.addVenue("Wei Stadium", "Stadium", generator.nextInt(500000) + 1000000);
		kansasCity.addVenue("Wei Gardens", "Stadium", generator.nextInt(500000) + 1000000);
		toronto.addVenue("Wei Racecourse", "Stadium", generator.nextInt(500000) + 1000000);
		montreal.addVenue("Stade de Wei", "Stadium", generator.nextInt(500000) + 1000000);
		houston.addVenue("Wei Pitch", "Stadium", generator.nextInt(500000) + 1000000);
		philadelphia.addVenue("Wei Court", "Stadium", generator.nextInt(500000) + 1000000);
		phoenix.addVenue("Wei Speedway", "Stadium", generator.nextInt(500000) + 1000000);
		sanDiego.addVenue("Wei Park", "Stadium", generator.nextInt(500000) + 1000000);
		sanFrancisco.addVenue("Wei Circuit", "Stadium", generator.nextInt(500000) + 1000000);
		ottawa.addVenue("Wei Grounds", "Stadium", generator.nextInt(500000) + 1000000);
		quebecCity.addVenue("Wei Centre", "Stadium", generator.nextInt(500000) + 1000000);
		vancouver.addVenue("Wei Olympic Stadium", "Stadium", generator.nextInt(500000) + 1000000);
		detroit.addVenue("Wei Stadion", "Stadium", generator.nextInt(500000) + 1000000);
		seattle.addVenue("Wei Sports Complex", "Stadium", generator.nextInt(500000) + 1000000);
		dallas.addVenue("Wei Hippodrome", "Stadium", generator.nextInt(500000) + 1000000);
		lasVegas.addVenue("Wei Racecourse", "Stadium", generator.nextInt(500000) + 1000000);
		atlanta.addVenue("Wei Rink", "Stadium", generator.nextInt(500000) + 1000000);
		sanJose.addVenue("Wei Arena", "Stadium", generator.nextInt(500000) + 1000000);
		
		losAngeles.addVenue("Angel Stadium", "Stadium", generator.nextInt(50000) + 100000);
		chicago.addVenue("Wrigley Field", "Stadium", generator.nextInt(50000) + 100000);
		newYork.addVenue("MetLife Stadium", "Stadium", generator.nextInt(50000) + 100000);
		kansasCity.addVenue("Kansas Speedway", "Stadium", generator.nextInt(50000) + 100000);
		toronto.addVenue("Rogers Centre", "Stadium", generator.nextInt(50000) + 100000);
		montreal.addVenue("Circuit Gilles Velleneuve", "Stadium", generator.nextInt(50000) + 100000);
		houston.addVenue("Rice Stadium", "Stadium", generator.nextInt(50000) + 100000);
		philadelphia.addVenue("Lincoln Financial Field", "Stadium", generator.nextInt(50000) + 100000);
		phoenix.addVenue("Chase Field", "Stadium", generator.nextInt(50000) + 100000);
		sanDiego.addVenue("Qualcomm Stadium", "Stadium", generator.nextInt(50000) + 100000);
		sanFrancisco.addVenue("AT&T Park", "Stadium", generator.nextInt(50000) + 100000);
		ottawa.addVenue("TD Place Stadium", "Stadium", generator.nextInt(50000) + 100000);
		quebecCity.addVenue("PEPS Le Stade Exterieur", "Stadium", generator.nextInt(50000) + 100000);
		vancouver.addVenue("BC Place", "Stadium", generator.nextInt(50000) + 100000);
		detroit.addVenue("Silverdome", "Stadium", generator.nextInt(50000) + 100000);
		seattle.addVenue("CenturyLink Field", "Stadium", generator.nextInt(50000) + 100000);
		dallas.addVenue("Cotton Bowl", "Stadium", generator.nextInt(50000) + 100000);
		lasVegas.addVenue("Las Vegas Motor Speedway", "Stadium", generator.nextInt(50000) + 100000);
		atlanta.addVenue("Georgia Dome", "Stadium", generator.nextInt(50000) + 100000);
		sanJose.addVenue("SAP Center", "Stadium", generator.nextInt(50000) + 100000);
		
		losAngeles.addVenue("Dao Field", "Stadium", generator.nextInt(5000) + 10000);
		chicago.addVenue("Dao Stadium", "Stadium", generator.nextInt(5000) + 10000);
		newYork.addVenue("Dao Speedway", "Stadium", generator.nextInt(5000) + 10000);
		kansasCity.addVenue("Dao Centre", "Stadium", generator.nextInt(5000) + 10000);
		toronto.addVenue("Dao Stade", "Stadium", generator.nextInt(5000) + 10000);
		montreal.addVenue("Dao Bowl", "Stadium", generator.nextInt(5000) + 10000);
		houston.addVenue("Dao Field", "Stadium", generator.nextInt(5000) + 10000);
		philadelphia.addVenue("Dao Field", "Stadium", generator.nextInt(5000) + 10000);
		phoenix.addVenue("Dao Square", "Stadium", generator.nextInt(5000) + 10000);
		sanDiego.addVenue("Dao World", "Stadium", generator.nextInt(5000) + 10000);
		sanFrancisco.addVenue("Dao Emporium", "Stadium", generator.nextInt(5000) + 10000);
		ottawa.addVenue("Dao Rink", "Stadium", generator.nextInt(5000) + 10000);
		quebecCity.addVenue("Dao Pitch", "Stadium", generator.nextInt(5000) + 10000);
		vancouver.addVenue("Dao Place", "Stadium", generator.nextInt(5000) + 10000);
		detroit.addVenue("Dao Dome", "Stadium", generator.nextInt(5000) + 10000);
		seattle.addVenue("Dao Courts", "Stadium", generator.nextInt(5000) + 10000);
		dallas.addVenue("Dao Links", "Stadium", generator.nextInt(5000) + 10000);
		lasVegas.addVenue("Dao Motor Speedway", "Stadium", generator.nextInt(5000) + 10000);
		atlanta.addVenue("Dao Plaza", "Plaza", generator.nextInt(5000) + 10000);
		sanJose.addVenue("Dao Mall", "Mall", generator.nextInt(5000) + 10000);
		
	}

}
