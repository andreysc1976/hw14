import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayLibTest {

    @ParameterizedTest
    @MethodSource("arrayForNextFourTests")
    void nextFourArray(int[] resultArrat, int[] testArray) {
        Assertions.assertArrayEquals(resultArrat,ArrayLib.nextFourArray(testArray));
    }

    private static Stream<Arguments> arrayForNextFourTests(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3,1,2,3},new int[]{2,4,3,4,1,2,3,1,2,3}), //тест на четыре в "середине" массива
                Arguments.of(new int[]{1,2,2,3},new int[]{4,1,2,2,3}), //тест 4 на первом месте и одна
                Arguments.of(new int[]{1},new int[]{1,2,3,4,1}), //тест на 4 на предпоследнем месте, когда в результате массив из одного элеменьа
                Arguments.of(new int[]{},new int[]{1,2,3,4}) //тест на 4 на последем месте, когда резултьтат массив нулевой длины
        );
    }

    @Test
    void nextFourArrayRunTimeException(){
        Assertions.assertThrows(RuntimeException.class,()->ArrayLib.nextFourArray(new int[]{1,2,3,1,2,3,3,2,1}));
    }



    @ParameterizedTest
    @MethodSource("parametrsForCheckForOneAndFour")
    void checkForOneAndFour(boolean result, int[] inputArray) {
        Assertions.assertEquals(result,ArrayLib.checkForOneAndFour(inputArray));
    }

    private static Stream<Arguments> parametrsForCheckForOneAndFour(){
        return Stream.of(
                Arguments.of(true,new int []{1,2,3,4,1,1,2,2,1,4}),//обычный вариант
                Arguments.of(true,new int []{2,2,2,1,4,2,2,2,2}),//1 и 4 рядом в центре
                Arguments.of(true,new int []{4,2,2,3,2,3,1}),//4 в начале, 1 в конце
                Arguments.of(true,new int []{1,2,2,3,3,5,6,8}), //одно значение в начале
                Arguments.of(false,new int []{5,2,2,3,3,5,6,8}), //ни одного значения в массиве
                Arguments.of(true,new int []{4}),//только одно правильное значение
                Arguments.of(false,new int []{})//пустой массив

        );
    }
}