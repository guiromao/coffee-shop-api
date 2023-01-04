package co.gromao.data.entity;

import java.util.Objects;

public class CoffeeShop {

    private final String name;
    private final Coordinates coordinates;

    public CoffeeShop(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "CoffeeShop{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoffeeShop that = (CoffeeShop) o;
        return Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates);
    }

}

