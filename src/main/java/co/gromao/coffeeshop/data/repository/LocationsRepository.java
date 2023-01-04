package co.gromao.coffeeshop.data.repository;

import co.gromao.coffeeshop.data.entity.CoffeeShop;
import co.gromao.coffeeshop.data.entity.Coordinates;

import java.util.List;

// Simulating the database
public class LocationsRepository {

    private LocationsRepository() {
        // just for returning some data
    }

    public static final List<CoffeeShop> COFFEE_SHOPS = List.of(
            createCoffeeShop("Blue Lagoon", 0, 0),
            createCoffeeShop("Cinnamon Roll", 0.01, 0.0022),
            createCoffeeShop("Hot Cocoa", 0.034, -0.046),
            createCoffeeShop("Premium Cappuccino", -0.009, 0),
            createCoffeeShop("Baker Bond", -0.0035, -0.085),
            createCoffeeShop("Coffee Spot", -0.02, 0.00125),
            createCoffeeShop("Spoon Whirl", 0.09, -0.0035),
            createCoffeeShop("Less Sugar, More Love", -0.035, -0.007)
    );

    private static CoffeeShop createCoffeeShop(String name, double latitude, double longitude) {
        return new CoffeeShop(name, new Coordinates(latitude, longitude));
    }

}
