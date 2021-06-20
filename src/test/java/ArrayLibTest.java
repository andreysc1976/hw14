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
                Arguments.of(new int[]{1,2,3,1,2,3},new int[]{2,4,3,4,1,2,3,1,2,3}),
                Arguments.of(new int[]{1,2,2,3},new int[]{4,1,2,2,3}),
                Arguments.of(new int[]{1},new int[]{1,2,3,4,1}),
                Arguments.of(new int[]{},new int[]{1,2,3,4})
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
                Arguments.of(true,new int []{1,2,3,4,1,1,2,2,1,4}),
                Arguments.of(true,new int []{2,2,2,1,4,2,2,2,2}),
                Arguments.of(true,new int []{4,2,2,3,2,3,1}),
                Arguments.of(true,new int []{1,2,2,3,3,5,6,8}),
                Arguments.of(true,new int []{4}),
                Arguments.of(false,new int []{})

        );
    }
}