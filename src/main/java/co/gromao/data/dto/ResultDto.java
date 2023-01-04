package co.gromao.data.dto;

import co.gromao.data.entity.CoffeeShop;
import co.gromao.data.entity.Coordinates;

import java.util.Objects;

public class ResultDto {

    private final CoffeeShop coffeeShop;
    private final Double distanceToUserInMetres;

    public ResultDto(CoffeeShop coffeeShop, Double distanceToUserInMetres) {
        this.coffeeShop = coffeeShop;
        this.distanceToUserInMetres = distanceToUserInMetres;
    }

    public String getMessage() {
        final Coordinates shopCoordinates = coffeeShop.getCoordinates();

        return String.format("%s located in: %s | Distance: %.2f metres. ",
                coffeeShop.getName(), shopCoordinates, distanceToUserInMetres);
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public Double getDistanceToUserInMetres() {
        return distanceToUserInMetres;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "coffeeShop=" + coffeeShop +
                ", distanceToUserInMetres=" + distanceToUserInMetres +
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
        return Objects.equals(coffeeShop, resultDto.coffeeShop) && Objects.equals(distanceToUserInMetres, resultDto.distanceToUserInMetres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeShop, distanceToUserInMetres);
    }

}
