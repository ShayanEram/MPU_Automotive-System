import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelematicsSystem implements Runnable {
    @Override
    public void run() {
        trackVehicle();
        remoteDiagnostics();
        emergencyAssistance();
    }

    public void trackVehicle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tracking vehicle location...");
        LocationResponse locationResponse = getVehicleLocation();
        System.out.println(locationResponse);
    }

    private static final String apiUrl = "http://ip-api.com/json/";
    private static final String ipAddress = "24.48.0.1";
    private static LocationResponse getVehicleLocation() {
        LocationResponse locationResponse = new LocationResponse();
        try
        {
            URL url = new URL(apiUrl + ipAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            StringBuilder responseBuilder = new StringBuilder();

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                responseBuilder.append(output);
            }

            reader.close();

            String response = responseBuilder.toString();
            locationResponse = parseJason(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return locationResponse;
    }

    public void remoteDiagnostics() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Performing remote diagnostics...");

        VehicleDiagnostics vehicleDiagnostics = new VehicleDiagnostics();
        vehicleDiagnostics.run();
    }

    public void emergencyAssistance() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Providing emergency assistance...");
    }

    private static LocationResponse parseJason(String json)
    {
        LocationResponse locationResponse = new LocationResponse();

        locationResponse.setQuery(getJsonValue(json, "query"));
        locationResponse.setStatus(getJsonValue(json, "status"));
        locationResponse.setCountry(getJsonValue(json, "country"));
        locationResponse.setCountryCode(getJsonValue(json, "countryCode"));
        locationResponse.setRegion(getJsonValue(json, "region"));
        locationResponse.setRegionName(getJsonValue(json, "regionName"));
        locationResponse.setCity(getJsonValue(json, "city"));
        locationResponse.setZip(getJsonValue(json, "zip"));
        locationResponse.setLat(Double.parseDouble(getJsonValue(json, "lat")));
        locationResponse.setLon(Double.parseDouble(getJsonValue(json, "lon")));
        locationResponse.setTimezone(getJsonValue(json, "timezone"));
        locationResponse.setIsp(getJsonValue(json, "isp"));
        locationResponse.setOrg(getJsonValue(json, "org"));
        locationResponse.setAs(getJsonValue(json, "as"));

        return locationResponse;
    }

    private static String getJsonValue(String json, String key)
    {
        String keyPattern = "\"" + key + "\":";
        int startIndex = json.indexOf(keyPattern) + keyPattern.length();
        int endIndex = json.indexOf(",", startIndex);
        if(endIndex == -1)
        {
            endIndex = json.indexOf("}", startIndex);
        }

        String value = json.substring(startIndex, endIndex).trim();

        if(value.startsWith("\""))
        {
            value = value.substring(1, value.length() - 1);
        }

        return value;
    }
}

class LocationResponse {
    private String query;
    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String zip;
    private double lat;
    private double lon;
    private String timezone;
    private String isp;
    private String org;
    private String as;

    // Getters and setters
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    @Override
    public String toString() {
        return "LocationResponse{" +
                "query='" + query + '\'' +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", region='" + region + '\'' +
                ", regionName='" + regionName + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", isp='" + isp + '\'' +
                ", org='" + org + '\'' +
                ", as='" + as + '\'' +
                '}';
    }
}
