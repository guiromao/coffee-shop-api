package co.gromao.coffeeshop;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.service.FindService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Input your latitude and longitude (double values separated by a space). Example: 0.001 0.0003");
        final double latitude = scanner.nextDouble();
        final double longitude = scanner.nextDouble();

        System.out.println("Input your maximum walking distance, from where you're located (in metres). Example: 4000");
        final double maxWalkingDistanceInMetres = scanner.nextDouble();

        final Coordinates userLocation = new Coordinates(latitude, longitude);

        final FindService findService = new FindService();
        final List<ResultDto> nearestShopsResults = findService.getNearestShops(userLocation, maxWalkingDistanceInMetres);

        System.out.println("These are the nearest coffee shops to your location " + userLocation + ":\n");
        nearestShopsResults.forEach(shop -> System.out.println(shop.getMessage()));
    }
    
}