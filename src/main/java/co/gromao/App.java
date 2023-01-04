package co.gromao;

import co.gromao.data.dto.ResultDto;
import co.gromao.data.entity.Coordinates;
import co.gromao.service.FindService;

import java.util.List;

public class App {

    public static void main(String[] args) {
        final Coordinates userLocation = new Coordinates(-0.003, 0);
        final double maxWalkingDistanceInMetres = 2500;

        final FindService findService = new FindService();
        final List<ResultDto> nearestShopsResults = findService.getNearestShops(userLocation, maxWalkingDistanceInMetres);

        System.out.println("These are the nearest coffee shops to your location " + userLocation + ":\n");
        nearestShopsResults.forEach(shop -> System.out.println(shop.getMessage()));
    }
    
}
