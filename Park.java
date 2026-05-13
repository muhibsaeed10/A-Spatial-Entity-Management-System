/**
 * Represents a Park, which is a specific type of MapFeature.
 * Includes GIS-specific attributes like acreage.
 */
public class Park extends MapFeature {
    private double acreage;
    private boolean isProtected;

    public Park(String name, double lat, double lon, double acreage, boolean isProtected) {
        super(name, lat, lon);
        this.acreage = acreage;
        this.isProtected = isProtected;
    }

    public double getAcreage() { return acreage; }
    public void setAcreage(double acreage) { this.acreage = acreage; }

    /**
     * Checks if the park qualifies as a large-scale conservation area.
     */
    public boolean isMajorConservationArea() {
        return isProtected && acreage > 500;
    }

    /**
     * Formats the park's data for a GIS report.
     */
    public String getGisReport() {
        return "GIS Report: " + getName() + " covers " + acreage + " acres.";
    }
}