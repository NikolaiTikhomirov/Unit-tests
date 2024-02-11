package test.seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.seminars.third.hw.MainHW;

import static org.assertj.core.api.Assertions.assertThat;
// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainHWTest {
    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).

    MainHW mainHW;

    @BeforeEach
    void setup(){
        mainHW = new MainHW();
    }

    @Test
    void checkEvenNum(){
        assertThat(mainHW.evenOddNumber(2)).isEqualTo(true);
    }

    @Test
    void checkNotEvenNum(){
        assertThat(mainHW.evenOddNumber(1)).isEqualTo(false);
    }


    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    @Test
    void checkNumBetween(){
        assertThat(mainHW.numberInInterval(27)).isEqualTo(true);
    }

    @Test
    void checkNumNotBetween(){
        assertThat(mainHW.numberInInterval(17)).isEqualTo(false);
    }

}
