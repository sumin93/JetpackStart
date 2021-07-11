package ru.sumin.jetpackstart

import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

data class Question(
    val sum: Int,
    val visibleNumber: Int,
    val answers: Set<Int>
) {

    val rightAnswer: Int
        get() = sum - visibleNumber

    companion object {

        private const val MIN_SUM = 2
        private const val MIN_VISIBLE_NUMBER = 1
        private const val COUNT_OF_ANSWERS = 6

        fun generateQuestion(maxValue: Int): Question {
            val sum = Random.nextInt(MIN_SUM, maxValue + 1)
            val visibleNumber = Random.nextInt(MIN_VISIBLE_NUMBER, sum)
            val options = HashSet<Int>()
            val rightAnswer = sum - visibleNumber
            options.add(rightAnswer)
            while (options.size < COUNT_OF_ANSWERS) {
                val from = max(MIN_VISIBLE_NUMBER, rightAnswer - COUNT_OF_ANSWERS)
                val to = min(rightAnswer + COUNT_OF_ANSWERS, maxValue)
                options.add(Random.nextInt(from, to + 1))
            }
            return Question(sum, visibleNumber, options)
        }
    }
}
