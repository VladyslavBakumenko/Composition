package com.example.composition.data

import com.example.composition.domain.entety.GameSettings
import com.example.composition.domain.entety.Level
import com.example.composition.domain.entety.Question
import com.example.composition.domain.entety.repository.GameRepository
import kotlin.math.max
import kotlin.math.min



import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val option = HashSet<Int>()
        val rightNumber = sum - visibleNumber
        option.add(rightNumber)
        val from = max(rightNumber - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightNumber + countOfOptions)
        while (option.size < countOfOptions) {
            option.add(Random.nextInt(from, to))
        }
        return  Question(sum, visibleNumber, option.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }
        }
    }
}