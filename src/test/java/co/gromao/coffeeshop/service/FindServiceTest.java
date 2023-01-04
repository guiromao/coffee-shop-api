package co.gromao.coffeeshop.service;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.CoffeeShop;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.data.repository.LocationsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        final List<ResultDto> test = findService.getNearestShops(userLocation);

        Assertions.assertEquals(shops.size(), test.size());

        for (int i = 0; i < shops.size() - 1; i++) {
            ResultDto result1 = test.get(i);
            ResultDto result2 = test.get(i + 1);

            Assertions.assertTrue(result1.getDistanceToUserInMetres() <= result2.getDistanceToUserInMetres());
        }
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
