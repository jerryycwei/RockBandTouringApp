package ui;

import java.util.ArrayList;

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
	 * Initialize Cities as well as the venues and accomodations
	 */
	private void initializeCities() {

		City losAngeles = new City("Los Angeles", new Circle("Los Angeles", 120, 413), system, "California", 3884000, "Sunny", new Symbol("images/weatherSunny.jpg"));
		City chicago = new City("Chicago", new Circle("Chicago", 716, 220), system, "Illinois", 2790000, "Rainy", new Symbol("images/weatherRain.jpg"));
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

		losAngeles.addAccomodation("Hilton Courtyard", "Hotel", 150);
		chicago.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		newYork.addAccomodation("Hilton Conrad", "Hotel", 150);
		kansasCity.addAccomodation("Hilton Hotel", "Hotel", 150);
		toronto.addAccomodation("Hilton Resort", "Hotel", 150);
		montreal.addAccomodation("DoubleTree by Hilton", "Hotel", 150);
		houston.addAccomodation("Embassy Suites by Hilton", "Hotel", 150);
		philadelphia.addAccomodation("Curio by Hilton", "Hotel", 150);
		phoenix.addAccomodation("Hilton Inn", "Hotel", 150);
		sanDiego.addAccomodation("Hilton House", "Hotel", 150);
		sanFrancisco.addAccomodation("Hilton Suites", "Hotel", 150);
		ottawa.addAccomodation("Hilton Grand Vacations", "Hotel", 150);
		quebecCity.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		vancouver.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		detroit.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		seattle.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		dallas.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		atlanta.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		lasVegas.addAccomodation("Hilton Garden Inn", "Hotel", 150);
		sanJose.addAccomodation("Hilton Garden Inn", "Hotel", 150);

		losAngeles.addAccomodation("Ritz-Carlton Los Angeles", "Hotel", 300);
		chicago.addAccomodation("Ritz-Carlton Chicago", "Hotel", 300);
		newYork.addAccomodation("Ritz-Carlton New York", "Hotel", 300);
		kansasCity.addAccomodation("Ritz-Carlton Kansas City", "Hotel", 300);
		toronto.addAccomodation("Ritz-Carlton Toronto", "Hotel", 300);
		montreal.addAccomodation("Ritz-Carlton Montreal", "Hotel", 300);
		houston.addAccomodation("Ritz-Carlton Houston", "Hotel", 300);
		phoenix.addAccomodation("Ritz-Carlton Phoenix", "Hotel", 300);
		philadelphia.addAccomodation("Ritz-Carlton Philadelphia", "Hotel", 300);
		sanDiego.addAccomodation("Ritz-Carlton San Diego", "Hotel", 300);
		sanFrancisco.addAccomodation("Ritz-Carlton San Francisco", "Hotel", 300);
		ottawa.addAccomodation("Ritz-Carlton Ottawa", "Hotel", 300);
		quebecCity.addAccomodation("Ritz-Carlton Quebec City", "Hotel", 300);
		vancouver.addAccomodation("Ritz-Carlton Vancouver", "Hotel", 300);
		detroit.addAccomodation("Ritz-Carlton Detroit", "Hotel", 300);
		seattle.addAccomodation("Ritz-Carlton Seattle", "Hotel", 300);
		dallas.addAccomodation("Ritz-Carlton Dallas", "Hotel", 300);
		atlanta.addAccomodation("Ritz-Carlton Atlanta", "Hotel", 300);
		lasVegas.addAccomodation("Ritz-Carlton Las Vegas", "Hotel", 300);
		sanJose.addAccomodation("Ritz-Carlton San Jose", "Hotel", 300);

		losAngeles.addAccomodation("Travelodge", "Hotel", 90);
		chicago.addAccomodation("Travelodge", "Hotel", 90);
		newYork.addAccomodation("Travelodge", "Hotel", 90);
		kansasCity.addAccomodation("Travelodge", "Hotel", 90);
		toronto.addAccomodation("Travelodge", "Hotel", 90);
		montreal.addAccomodation("Travelodge", "Hotel", 90);
		houston.addAccomodation("Travelodge", "Hotel", 90);
		phoenix.addAccomodation("Travelodge", "Hotel", 90);
		philadelphia.addAccomodation("Travelodge", "Hotel", 90);
		sanDiego.addAccomodation("Travelodge", "Hotel", 90);
		sanFrancisco.addAccomodation("Travelodge", "Hotel", 90);
		ottawa.addAccomodation("Travelodge", "Hotel", 90);
		quebecCity.addAccomodation("Travelodge", "Hotel", 90);
		vancouver.addAccomodation("Travelodge", "Hotel", 90);
		detroit.addAccomodation("Travelodge", "Hotel", 90);
		seattle.addAccomodation("Travelodge", "Hotel", 90);
		dallas.addAccomodation("Travelodge", "Hotel", 90);
		atlanta.addAccomodation("Travelodge", "Hotel", 90);
		lasVegas.addAccomodation("Travelodge", "Hotel", 90);
		sanJose.addAccomodation("Travelodge", "Hotel", 90);

		
		
		losAngeles.addVenue("Wei Field", "Stadium", 200000);
		chicago.addVenue("Wei Square Garden", "Stadium", 200000);
		newYork.addVenue("Wei Stadium", "Stadium", 200000);
		kansasCity.addVenue("Wei Gardens", "Stadium", 200000);
		toronto.addVenue("Wei Racecourse", "Stadium", 200000);
		montreal.addVenue("Stade de Wei", "Stadium", 200000);
		houston.addVenue("Wei Pitch", "Stadium", 200000);
		philadelphia.addVenue("Wei Court", "Stadium", 200000);
		phoenix.addVenue("Wei Speedway", "Stadium", 200000);
		sanDiego.addVenue("Wei Park", "Stadium", 200000);
		sanFrancisco.addVenue("Wei Circuit", "Stadium", 200000);
		ottawa.addVenue("Wei Grounds", "Stadium", 200000);
		quebecCity.addVenue("Wei Centre", "Stadium", 200000);
		vancouver.addVenue("Wei Olympic Stadium", "Stadium", 200000);
		detroit.addVenue("Wei Stadion", "Stadium", 200000);
		seattle.addVenue("Wei Sports Complex", "Stadium", 200000);
		dallas.addVenue("Wei Hippodrome", "Stadium", 200000);
		lasVegas.addVenue("Wei Racecourse", "Stadium", 200000);
		atlanta.addVenue("Wei Rink", "Stadium", 200000);
		sanJose.addVenue("Wei Arena", "Stadium", 200000);
		
		losAngeles.addVenue("Angel Stadium", "Stadium", 200000);
		chicago.addVenue("Wrigley Field", "Stadium", 200000);
		newYork.addVenue("MetLife Stadium", "Stadium", 200000);
		kansasCity.addVenue("Kansas Speedway", "Stadium", 200000);
		toronto.addVenue("Rogers Centre", "Stadium", 200000);
		montreal.addVenue("Circuit Gilles Velleneuve", "Stadium", 200000);
		houston.addVenue("Rice Stadium", "Stadium", 200000);
		philadelphia.addVenue("Lincoln Financial Field", "Stadium", 200000);
		phoenix.addVenue("Chase Field", "Stadium", 200000);
		sanDiego.addVenue("Qualcomm Stadium", "Stadium", 200000);
		sanFrancisco.addVenue("AT&T Park", "Stadium", 200000);
		ottawa.addVenue("TD Place Stadium", "Stadium", 200000);
		quebecCity.addVenue("PEPS Le Stade Exterieur", "Stadium", 200000);
		vancouver.addVenue("BC Place", "Stadium", 200000);
		detroit.addVenue("Silverdome", "Stadium", 200000);
		seattle.addVenue("CenturyLink Field", "Stadium", 200000);
		dallas.addVenue("Cotton Bowl", "Stadium", 200000);
		lasVegas.addVenue("Las Vegas Motor Speedway", "Stadium", 200000);
		atlanta.addVenue("Georgia Dome", "Stadium", 200000);
		sanJose.addVenue("SAP Center", "Stadium", 200000);
		
		losAngeles.addVenue("Dao Field", "Stadium", 200000);
		chicago.addVenue("Dao Stadium", "Stadium", 200000);
		newYork.addVenue("Dao Speedway", "Stadium", 200000);
		kansasCity.addVenue("Dao Centre", "Stadium", 200000);
		toronto.addVenue("Dao Stade", "Stadium", 200000);
		montreal.addVenue("Dao Bowl", "Stadium", 200000);
		houston.addVenue("Dao Field", "Stadium", 200000);
		philadelphia.addVenue("Dao Field", "Stadium", 200000);
		phoenix.addVenue("Dao Square", "Stadium", 200000);
		sanDiego.addVenue("Dao World", "Stadium", 200000);
		sanFrancisco.addVenue("Dao Emporium", "Stadium", 200000);
		ottawa.addVenue("Dao Rink", "Stadium", 200000);
		quebecCity.addVenue("Dao Pitch", "Stadium", 200000);
		vancouver.addVenue("Dao Place", "Stadium", 200000);
		detroit.addVenue("Dao Dome", "Stadium", 200000);
		seattle.addVenue("Dao Courts", "Stadium", 200000);
		dallas.addVenue("Dao Links", "Stadium", 200000);
		lasVegas.addVenue("Dao Motor Speedway", "Stadium", 200000);
		atlanta.addVenue("Dao Plaza", "Plaza", 200000);
		sanJose.addVenue("Dao Mall", "Mall", 200000);
		
	}

}
