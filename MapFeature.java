/**
 * Represents a generic geographic feature on a map.
 * This class handles basic spatial data like coordinates and names.
 */
public class MapFeature implements Comparable<MapFeature> {
    private String name;
    private double latitude;
    private double longitude;

    /**
     * Constructor for a feature with unknown coordinates.
     */
    public MapFeature(String name) {
        this.name = name;
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    /**
     * Overloaded constructor for a feature with specific coordinates.
     */
    public MapFeature(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Accessors and Mutators
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    /**
     * Overrides toString to provide a readable map coordinate format.
     */
    @Override
    public String toString() {
        return String.format("%s (Lat: %.4f, Lon: %.4f)", name, latitude, longitude);
    }

    /**
     * Overrides equals to compare features based on their spatial location.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MapFeature)) return false;
        MapFeature other = (MapFeature) obj;
        return this.latitude == other.latitude && this.longitude == other.longitude;
    }

    /**
     * Implements Comparable to allow sorting features by name.
     */
    @Override
    public int compareTo(MapFeature other) {
        return this.name.compareTo(other.getName());
    }
}