package test.seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.seminars.third.hw.MainHW;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @ParameterizedTest
    @ValueSource(ints = {25, 57, 100})
    void checkNumBetween(int n){
        assertThat(mainHW.numberInInterval(n)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, 24, 101})
    void checkNumNotBetween(int n){
        assertThat(mainHW.numberInInterval(n)).isEqualTo(false);
    }

}
