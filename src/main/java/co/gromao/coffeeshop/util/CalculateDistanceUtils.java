package co.gromao.coffeeshop.util;

public class CalculateDistanceUtils {

    private CalculateDistanceUtils() {
        // no instantiation
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double radius = 6378100; // Radius of Earth in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) *
                Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return radius * c;
    }

}
