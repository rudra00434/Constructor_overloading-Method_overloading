class WeatherStation {
    // Private fields
    private double temperature; // in Celsius
    private String location;
    private int humidity; // percentage

    // ------------------- Constructors -------------------
    // No-arg constructor
    public WeatherStation() {
        this(0.0, "Unknown", 0); // default values
    }

    // Constructor with temperature and location
    public WeatherStation(double temperature, String location) {
        this(temperature, location, 0); // default humidity = 0
    }

    // Constructor with all fields (with validation)
    public WeatherStation(double temperature, String location, int humidity) {
        setTemperature(temperature);
        setLocation(location);
        setHumidity(humidity);
    }

    // ------------------- Getters and Setters -------------------
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature >= -50 && temperature <= 50) {
            this.temperature = temperature;
        } else {
            System.out.println("Invalid temperature! Must be between -50 and 50.");
            this.temperature = 0.0;
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location != null && !location.trim().isEmpty()) {
            this.location = location;
        } else {
            System.out.println("Invalid location! Setting default.");
            this.location = "Unknown";
        }
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        if (humidity >= 0 && humidity <= 100) {
            this.humidity = humidity;
        } else {
            System.out.println("Invalid humidity! Must be 0-100.");
            this.humidity = 0;
        }
    }

    // ------------------- Overloaded Methods -------------------
    // Return only temperature
    public double reportWeather() {
        return temperature;
    }

    // Return full formatted weather details
    public String reportWeather(boolean fullReport) {
        if (fullReport) {
            return "Location: " + location +
                   ", Temperature: " + temperature + "°C" +
                   ", Humidity: " + humidity + "%";
        } else {
            return "Temperature: " + temperature + "°C";
        }
    }
}

// ------------------- Main Class -------------------
public class Weather {
    public static void main(String[] args) {
        // Using constructor with temperature and location
        WeatherStation ws1 = new WeatherStation(25.5, "Kolkata");

        // Using constructor with all fields
        WeatherStation ws2 = new WeatherStation(30.2, "Delhi", 60);

        // Testing reportWeather methods
        System.out.println("WS1 Temperature: " + ws1.reportWeather());
        System.out.println("WS1 Full Report: " + ws1.reportWeather(true));

        System.out.println("WS2 Temperature: " + ws2.reportWeather());
        System.out.println("WS2 Full Report: " + ws2.reportWeather(true));
    }
}
