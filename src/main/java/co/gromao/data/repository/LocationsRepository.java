package co.gromao.data.repository;

import co.gromao.data.entity.CoffeeShop;
import co.gromao.data.entity.Coordinates;

import java.util.List;

// Simulating the database
public class LocationsRepository {

    private LocationsRepository() {
        // just for returning some data
    }

    public static final List<CoffeeShop> COFFEE_SHOPS = List.of(
            createCoffeeShop("Blue Lagoon", 0.002, 0.001),
            createCoffeeShop("Cinnamon Roll", 0.1, 0.22),
            createCoffeeShop("Hot Cocoa", 0.034, -0.046),
            createCoffeeShop("Premium Cappuccino", -0.009, 0),
            createCoffeeShop("Baker Bond", -0.035, -0.085),
            createCoffeeShop("Coffee Spot", -0.02, 0.0125),
            createCoffeeShop("Spoon Whirl", 0.09, -0.035),
            createCoffeeShop("Less Sugar, More Love", -0.035, -0.07)
    );

    private static CoffeeShop createCoffeeShop(String name, double latitude, double longitude) {
        return new CoffeeShop(name, new Coordinates(latitude, longitude));
    }

}
