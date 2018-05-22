package SortingitAllout;

public class City {

	public String COUNTRYCODE;
	public String CITYNAME;
	public String CITYREGION;
	public int CITYPOPULATION;
	public double CITYLATITUDE;
	public double CITYLONGITUDE;

	public City(String CountryCode, String City_Region, String City_name, int City_Population, double City_latitude,
			double City_longitude) { // City data format constructor
		COUNTRYCODE = CountryCode;
		CITYNAME = City_name;
		CITYREGION = City_Region;
		CITYPOPULATION = City_Population;
		CITYLATITUDE = City_latitude;
		CITYLONGITUDE = City_longitude;
	}

	public String toString() { // Create String with following

		String S = "";
		S += CITYNAME;
		S += ",";
		S += CITYPOPULATION;
		S += ",";
		S += CITYLATITUDE;
		S += ",";
		S += CITYLONGITUDE;

		return S;
	}
	public int compareToCity(City C){ // Compare names of citites 
		return (CITYNAME.toLowerCase().compareTo(C.CITYNAME.toLowerCase()));
	}
	public int compareToPop(City C){ //Compare populations of cities 
		return CITYPOPULATION - C.CITYPOPULATION;
	}
	public double compareToLat(City C){
		return  CITYLATITUDE - C.CITYLATITUDE;
	}
}
