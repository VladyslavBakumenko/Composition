package com.example.composition.domain.entety.repository

import com.example.composition.domain.entety.GameSettings
import com.example.composition.domain.entety.Level
import com.example.composition.domain.entety.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}