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

		losAngeles.addAccomodation("Hilton", "Hotel", 150);
		chicago.addAccomodation("Hilton", "Hotel", 150);
		newYork.addAccomodation("Hilton", "Hotel", 150);
		kansasCity.addAccomodation("Hilton", "Hotel", 150);
		toronto.addAccomodation("Hilton", "Hotel", 150);
		montreal.addAccomodation("Hilton", "Hotel", 150);
		houston.addAccomodation("Hilton", "Hotel", 150);
		philadelphia.addAccomodation("Hilton", "Hotel", 150);
		phoenix.addAccomodation("Hilton", "Hotel", 150);
		sanDiego.addAccomodation("Hilton", "Hotel", 150);
		sanFrancisco.addAccomodation("Hilton", "Hotel", 150);
		ottawa.addAccomodation("Hilton", "Hotel", 150);
		quebecCity.addAccomodation("Hilton", "Hotel", 150);
		vancouver.addAccomodation("Hilton", "Hotel", 150);
		detroit.addAccomodation("Hilton", "Hotel", 150);
		seattle.addAccomodation("Hilton", "Hotel", 150);
		dallas.addAccomodation("Hilton", "Hotel", 150);
		atlanta.addAccomodation("Hilton", "Hotel", 150);
		lasVegas.addAccomodation("Hilton", "Hotel", 150);
		sanJose.addAccomodation("Hilton", "Hotel", 150);

		losAngeles.addVenue("Wei", "Stadium", 200000);
		chicago.addVenue("Wei", "Stadium", 200000);
		newYork.addVenue("Wei", "Stadium", 200000);
		kansasCity.addVenue("Wei", "Stadium", 200000);
		toronto.addVenue("Wei", "Stadium", 200000);
		montreal.addVenue("Wei", "Stadium", 200000);
		houston.addVenue("Wei", "Stadium", 200000);
		philadelphia.addVenue("Wei", "Stadium", 200000);
		phoenix.addVenue("Wei", "Stadium", 200000);
		sanDiego.addVenue("Wei", "Stadium", 200000);
		sanFrancisco.addVenue("Wei", "Stadium", 200000);
		ottawa.addVenue("Wei", "Stadium", 200000);
		quebecCity.addVenue("Wei", "Stadium", 200000);
		vancouver.addVenue("Wei", "Stadium", 200000);
		detroit.addVenue("Wei", "Stadium", 200000);
		seattle.addVenue("Wei", "Stadium", 200000);
		dallas.addVenue("Wei", "Stadium", 200000);
		lasVegas.addVenue("Wei", "Stadium", 200000);
		atlanta.addVenue("Wei", "Stadium", 200000);
		sanJose.addVenue("Wei", "Stadium", 200000);
	}

}
