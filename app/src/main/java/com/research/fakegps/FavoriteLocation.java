package com.research.fakegps;

/** Represents a saved favorite location entry. */
public class FavoriteLocation {

    private long id;
    private String name;
    private double latitude;
    private double longitude;

    public FavoriteLocation(long id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId()          { return id; }
    public String getName()      { return name; }
    public double getLatitude()  { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public String toString() {
        return String.format("%s (%.5f, %.5f)", name, latitude, longitude);
    }
}
