package co.gromao.coffeeshop.data.repository;

import co.gromao.coffeeshop.data.entity.CoffeeShop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LocationsRepositoryTest {

    LocationsRepository repository;

    @BeforeEach
    void setup() {
        repository = new LocationsRepository();
    }

    @Test
    void testFindCoffeeShops() {
        final List<CoffeeShop> test = repository.findCoffeeShops();

        Assertions.assertEquals(LocationsRepository.COFFEE_SHOPS, test);
    }

}
