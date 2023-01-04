package co.gromao.coffeeshop.service;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.CoffeeShop;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.data.repository.LocationsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindServiceTest {

    LocationsRepository locationsRepository;

    FindService findService;

    @BeforeEach
    void setup() {
        locationsRepository = mock(LocationsRepository.class);

        findService = new FindService(locationsRepository);
    }

    @Test
    void testGetNearestCoffeeShops() {
        final List<CoffeeShop> shops = coffeeShops();
        final Coordinates userLocation = new Coordinates(0, 0);

        when(locationsRepository.findCoffeeShops()).thenReturn(shops);

        final List<ResultDto> test = findService.getNearestShops(userLocation, 1000);

        Assertions.assertEquals(2, test.size());
        Assertions.assertEquals(
                Set.of("Coffee 1", "Coffee 2"),
                test.stream().map(ResultDto::getCoffeeShop).map(CoffeeShop::getName).collect(Collectors.toSet())
        );
    }

    private List<CoffeeShop> coffeeShops() {
        return List.of(
                createCoffeeShop("Coffee 1", 0, 0),
                createCoffeeShop("Coffee 2", 0, 0),
                createCoffeeShop("Coffee 3", 1, 1),
                createCoffeeShop("Coffee 4", 2, 2),
                createCoffeeShop("Coffee 5", 3, 3)
        );
    }

    private CoffeeShop createCoffeeShop(String name, double latitude, double longitude) {
        return new CoffeeShop(name, new Coordinates(latitude, longitude));
    }

}
