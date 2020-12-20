package fr.o80.aoc.day20.part2

import fr.o80.aoc.day20.Day20
import fr.o80.aoc.day20.exercise_d20
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day20Part2UnitTest {

    private val day = Day20()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Int) {
        // when
        val result = day.part2(day.parse2(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d20_p2_1, result_d20_p2_1),
                Arguments.of(exercise_d20, 1841),
            )
        }

    }

}
