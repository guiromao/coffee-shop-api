package co.gromao.coffeeshop.data.dto;

import co.gromao.coffeeshop.data.entity.CoffeeShop;
import co.gromao.coffeeshop.data.entity.Coordinates;

import java.util.Objects;

public class ResultDto {

    private final CoffeeShop coffeeShop;
    private final Double distanceInMetres;

    public ResultDto(CoffeeShop coffeeShop, Double distanceToUserInMetres) {
        this.coffeeShop = coffeeShop;
        this.distanceInMetres = distanceToUserInMetres;
    }

    public String getMessage() {
        final Coordinates shopCoordinates = coffeeShop.getCoordinates();

        return String.format("%s located in: %s | Distance: %.2f metres. ",
                coffeeShop.getName(), shopCoordinates, distanceInMetres);
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public Double getDistanceInMetres() {
        return distanceInMetres;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "coffeeShop=" + coffeeShop +
                ", distanceToUserInMetres=" + distanceInMetres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultDto resultDto = (ResultDto) o;
        return Objects.equals(coffeeShop, resultDto.coffeeShop) && Objects.equals(distanceInMetres, resultDto.distanceInMetres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeShop, distanceInMetres);
    }

}
