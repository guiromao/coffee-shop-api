package co.gromao.coffeeshop;

import co.gromao.coffeeshop.data.dto.ResultDto;
import co.gromao.coffeeshop.data.entity.Coordinates;
import co.gromao.coffeeshop.data.repository.LocationsRepository;
import co.gromao.coffeeshop.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntegrationTest {

    LocationsRepository repository = new LocationsRepository();
    FindService findService = new FindService(repository);

    @Test
    void testFindNearestCoffeeShops() {
        final List<ResultDto> test = findService.getNearestShops(new Coordinates(0, 0));

        Assertions.assertEquals(repository.findCoffeeShops().size(), test.size());

        for (int i = 0; i < test.size() - 1; i++) {
            double distance1 = test.get(i).getDistanceInMetres();
            double distance2 = test.get(i + 1).getDistanceInMetres();

            Assertions.assertTrue(distance1 <= distance2);
        }
    }

}
