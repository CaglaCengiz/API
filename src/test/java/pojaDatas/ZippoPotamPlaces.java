package pojaDatas;

public class ZippoPotamPlaces {
    /*
                "places": [
            {
                "place name": "Maltepe Mah.",
                    "longitude": "32.3609",
                    "state": "İstanbul",
                    "state abbreviation": "34",
                    "latitude": "40.1589"
            }*/
    /*
    pojo :plain old java Object pojo class niçin kullanılır:
    expected data veya actual data ları depolamak için yani tutmak için kullanıyoruz

    1) fieldlar -->vareble  private -->her bir json için
    2)parametresiz constructor
    3)parametreli constructor
    4)getter ve setter
    5)toString()

     */
    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    public ZippoPotamPlaces() {
    }

    public ZippoPotamPlaces(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
