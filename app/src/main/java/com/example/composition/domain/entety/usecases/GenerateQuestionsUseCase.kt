package com.example.composition.domain.entety.usecases

import com.example.composition.domain.entety.GameSettings
import com.example.composition.domain.entety.Question
import com.example.composition.domain.entety.repository.GameRepository

class GenerateQuestionsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}