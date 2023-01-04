package co.gromao.coffeeshop.service;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.CoffeeShop;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.data.repository.LocationsRepository;
import co.gromao.coffeeshop.util.CalculateDistanceUtils;

import java.util.Comparator;
import java.util.List;

/**
 * Class responsible for getting the nearest coffee shops, considering the user's location.
 */
public class FindService {

    private final LocationsRepository repository;

    public FindService(LocationsRepository locationsRepository) {
        this.repository = locationsRepository;
    }

    public List<ResultDto> getNearestShops(final Coordinates userLocation) {
        return repository.findCoffeeShops().stream()
                .map(shop -> new ResultDto(shop, calculateDistance(shop, userLocation)))
                .sorted(Comparator.comparing(ResultDto::getDistanceInMetres, Comparator.naturalOrder()))
                .toList();
    }

    private Double calculateDistance(CoffeeShop coffeeShop, Coordinates location) {
        final Coordinates shopCoordinates = coffeeShop.getCoordinates();

        return CalculateDistanceUtils.calculateDistance(
                location.getLatitude(), location.getLongitude(),
                shopCoordinates.getLatitude(), shopCoordinates.getLongitude()
        );
    }

}
