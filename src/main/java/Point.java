
public class Point {
    private Double latitude;
    private Double longitude;

    public Point(double latitude, double longitude) {

        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
