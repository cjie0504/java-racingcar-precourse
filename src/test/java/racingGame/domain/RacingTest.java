package racingGame.domain;

import org.junit.jupiter.api.Test;
import racingGame.service.Racing;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingTest { @Test
    public void 레이싱_결과_검증(){
        List<Car> cars = Arrays.asList(
                new Car("CAR1",5),
                new Car("CAR2",2),
                new Car("CAR3",1)
        );
        List<String> winCar = Racing.findWinCar(cars,5);
        assertThat(winCar.get(0)).isEqualTo("CAR1");
    }

    @Test
    public void 레이싱_공동우승_검증(){
        List<Car> cars = Arrays.asList(
                new Car("CAR1",5),
                new Car("CAR2",5),
                new Car("CAR3",1)
        );
        List<String> winCar = Racing.findWinCar(cars,5);
        assertThat(winCar.size()).isEqualTo(2);
    }
}
