package co.gromao.service;

import co.gromao.data.dto.ResultDto;
import co.gromao.data.entity.CoffeeShop;
import co.gromao.data.entity.Coordinates;
import co.gromao.data.repository.LocationsRepository;
import co.gromao.util.CalculateDistanceUtils;

import java.util.Comparator;
import java.util.List;

public class FindService {

    public FindService() {
        // general constructor
    }

    public List<ResultDto> getNearestShops(final Coordinates userLocation, final double maximumWalkingDistance) {
        return LocationsRepository.COFFEE_SHOPS.stream()
                .map(shop -> new ResultDto(shop, calculateDistance(shop, userLocation)))
                .filter(result -> result.getDistanceToUserInMetres() <= maximumWalkingDistance)
                .sorted(Comparator.comparing(ResultDto::getDistanceToUserInMetres, Comparator.naturalOrder()))
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
