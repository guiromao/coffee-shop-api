package co.gromao.coffeeshop;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.data.repository.LocationsRepository;
import co.gromao.coffeeshop.service.FindService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Input your latitude and longitude (double values separated by a space). Example: 0.001 0.0003");
        final double latitude = scanner.nextDouble();
        final double longitude = scanner.nextDouble();

        final Coordinates userLocation = new Coordinates(latitude, longitude);

        final LocationsRepository locationsRepository = new LocationsRepository();
        final FindService findService = new FindService(locationsRepository);

        final List<ResultDto> nearestShopsResults = findService.getNearestShops(userLocation);

        System.out.println("These are the nearest coffee shops to your location " + userLocation + ":\n");
        nearestShopsResults.forEach(shop -> System.out.println(shop.getMessage()));
    }
    
}
