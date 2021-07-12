package ru.sumin.jetpackstart.domain

data class Question(
    val sum: Int,
    val visibleNumber: Int,
    val answers: List<Int>
) {

    val rightAnswer: Int
        get() = sum - visibleNumber
}
