package racingGame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void 차_사이즈_검증() {
        List<Car> cars = Arrays.asList(
                new Car("CAR_1", 5),
                new Car("CAR_2", 2),
                new Car("CAR_3", 1)
        );
        Cars Cars = new Cars(cars);
        assertThat(Cars.getCars().size()).isEqualTo(3);
    }
}
