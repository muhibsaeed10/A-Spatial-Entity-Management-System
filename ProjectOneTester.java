import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description: 
 * As a GIS Specialist trainee, I have developed GeoManager. 
 * This program organizes geographic data using Object-Oriented principles.
 * It allows for the storage of generic MapFeatures and specific Park entities 
 * in a sorted Collection, enabling basic spatial data management.
 */
public class ProjectOneTester {
    public static void main(String[] args) {
        // collections requirement
        ArrayList<MapFeature> myMap = new ArrayList<>();

        // Demonstrate polymorphism and inheritance
        myMap.add(new MapFeature("Town Hall", 43.6532, -79.3832));
        myMap.add(new Park("High Park", 43.6465, -79.4637, 398.8, true));
        myMap.add(new Park("Algonquin", 45.5539, -78.4750, 1884126.0, true));

        System.out.println("--- Unsorted GIS Data ---");
        for (MapFeature f : myMap) {
            System.out.println(f);
        }

        // Sorting using the Comparable interface implementation
        Collections.sort(myMap);

        System.out.println("\n--- Alphabetically Sorted GIS Data ---");
        for (MapFeature f : myMap) {
            System.out.println(f.getName());
        }

        // Demonstrating specific Subclass methods
        System.out.println("\n--- Conservation Analysis ---");
        for (MapFeature f : myMap) {
            if (f instanceof Park) {
                Park p = (Park) f;
                if (p.isMajorConservationArea()) {
                    System.out.println(p.getName() + " is a Major Conservation Area.");
                }
            }
        }
    }
}