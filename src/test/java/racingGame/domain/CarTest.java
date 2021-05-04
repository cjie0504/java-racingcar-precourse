package racingGame.domain;

import org.junit.jupiter.api.Test;
import racingGame.exception.InputException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void 차_이름_빈값_검증() {
        assertThatThrownBy(() ->
                new Car(" ", 5)
        ).isInstanceOf(InputException.class)
                .hasMessageContaining("자동차 이름이 빈값입니다.");
    }

}
