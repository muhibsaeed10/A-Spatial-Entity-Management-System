# GeoManager — Spatial Entity Management System

> **Course:** CPS209 — Computer Science II (Object-Oriented Programming)  
> **Project:** Project #1: Choose Your Own Adventure  
> **Domain Focus:** Geographic Information Systems (GIS) & Spatial Data Modeling

---

## 🗺️ Project Overview & Problem Description

Managing spatial data requires a structured way to represent real-world entities within a coordinate system. **GeoManager** is an Object-Oriented Java application designed to catalog, analyze, and manage geographic features like points of interest (POIs), landmarks, and municipal assets, alongside complex regional polygons like conservation zones and public parks. 

In GIS pipelines, raw geographic data must be structured cleanly before analysis can take place. This project solves the core problem of organizing multi-layered spatial data by type, verifying spatial locations, and automating calculations like environmental acreage thresholds. By employing true Object-Oriented principles, the software abstracts shared geographical properties (names, absolute coordinates) while preserving the unique attributes of specialized structures (e.g., environmental protection statuses and land dimensions).

---

## 🛠️ System Architecture & OOP Breakdown

The architecture mirrors professional GIS entity frameworks, strictly following the academic requirements of CPS209:

┌────────────────────────────────────────────────────────┐
│                      MapFeature                        │◄─── (Superclass)
├────────────────────────────────────────────────────────┤
│ - name: String                                         │
│ - latitude: double                                     │
│ - longitude: double                                    │
├────────────────────────────────────────────────────────┤
│ + MapFeature(name) [Overloaded]                        │
│ + MapFeature(name, lat, lon)                           │
│ + compareTo(other): int (Alphabetical sorting)         │
│ + equals(obj): boolean (Spatial collision checking)    │
└────────────────────────────▲───────────────────────────┘
│
│ (extends / "kind-of")
┌──────────────┴──────────────┐
│            Park             │◄─── (Subclass)
├─────────────────────────────┤
│ - acreage: double           │
│ - isProtected: boolean      │
├─────────────────────────────┤
│ + isMajorConservationArea() │
│ + getGisReport(): String    │
└─────────────────────────────┘

### Class Roles & Specifications

1. **`MapFeature` (Superclass)**
   * **Purpose:** The base spatial record representing any single localized point or vector landmark.
   * **Encapsulation:** Protects positional states (`latitude`, `longitude`, `name`) behind explicit private access modifiers paired with public accessors/mutators.
   * **Polymorphic Behaviors:** * Overloads its constructors to seamlessly ingest minimal text identifiers or fully formed geometric coordinates.
     * Overrides `.toString()` to compile structural coordinate outputs formatted for immediate terminal logs.
     * Overrides `.equals()` to perform point-collision verification (checking if two features inhabit matching geometric coordinates).
     * Implements `Comparable<MapFeature>` to enable native alphanumeric indexing.

2. **`Park` (Subclass)**
   * **Purpose:** Represents specialized environmental properties requiring complex metadata tracking.
   * **Inheritance:** Explicitly models a `"kind-of"` hierarchical relationship with `MapFeature`.
   * **Domain Logic:** Introduces conditional evaluation engines (`isMajorConservationArea()`) and localized text compiling functions (`getGisReport()`).

3. **`ProjectOneTester` (Driver Class)**
   * **Purpose:** Houses the standalone `main()` method acting as an automated test harness.
   * **Collection Lifecycle:** Initializes an active `ArrayList<MapFeature>` buffer, tests heterogeneous data casting, orchestrates automated collection sort queries, and evaluates sub-typed geometric conditions.

---

## 📋 Requirement Tracking Matrix

| Requirement Block | Specification Checklist | Project Implementation Verification | Status |
| :--- | :--- | :--- | :---: |
| **OOP Core** | Inheritance ("kind-of" relationship) | `Park` cleanly extends `MapFeature` inheriting core geographic attributes. | **Passed** |
| **OOP Core** | Accessors & Mutators | All properties are explicitly `private`; accessible only via safe getter/setter methods. | **Passed** |
| **OOP Core** | Constructor Overloading | `MapFeature` exposes both single-parameter and multi-parameter geographic constructors. | **Passed** |
| **OOP Core** | Custom Methods | Added `isMajorConservationArea()` to perform specialized data tasks. | **Passed** |
| **OOP Core** | Overriding (`toString` / `equals`) | Overrode `.toString()` for coordinates and `.equals()` for exact spatial point matching. | **Passed** |
| **OOP Core** | Interface Implementation | Implements `Comparable<MapFeature>` to support native, reliable library sorting. | **Passed** |
| **OOP Core** | Collections Framework | Data layers are held and traversed using a dynamically sized `ArrayList<MapFeature>`. | **Passed** |
| **Non-OOP** | Line Count Threshold | Exceeds 100 lines of highly optimized, non-redundant, well-designed code. | **Passed** |
| **Non-OOP** | Javadoc & Code Comments | Every method signature is explicitly documented with functional Javadoc blocks. | **Passed** |
| **Non-OOP** | Isolated Driver File | Driver class (`ProjectOneTester`) contains **only** the required `main()` execution code. | **Passed** |

---

## 🚀 Compilation & Local Execution

This solution runs on standard Java environments and is deliberately kept decoupled from third-party package namespaces to facilitate quick grading and zero classpath configuration mismatches across grading terminals.

### Step 1: Verify Environment
Ensure your local terminal path has access to the standard Java Development Kit compiler:
```bash
java -version
javac -version
```

### Step 2: Compile Files
Compile all project workspace source sheets concurrently inside your destination workspace folder:
```bash
javac MapFeature.java Park.java ProjectOneTester.java
```

### Step 3: Run the Driver
Execute the compiled test suite runner entry point:
```bash
java ProjectOneTester
```

### Expected Output
When execution successfully starts up, the test driver will output organized spatial summaries reflecting data arrays before sorting, after collection sorting, and through deep conditional filtering:
```text
--- Unsorted GIS Data ---
Town Hall (Lat: 43.6532, Lon: -79.3832)
High Park (Lat: 43.6465, Lon: -79.4637)
Algonquin (Lat: 45.5539, Lon: -78.4750)

--- Alphabetically Sorted GIS Data ---
Algonquin
High Park
Town Hall

--- Conservation Analysis ---
Algonquin is a Major Conservation Area.
