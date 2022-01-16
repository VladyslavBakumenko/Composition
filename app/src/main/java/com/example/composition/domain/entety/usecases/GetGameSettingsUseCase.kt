package com.example.composition.domain.entety.usecases

import com.example.composition.domain.entety.GameSettings
import com.example.composition.domain.entety.Level
import com.example.composition.domain.entety.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings{
        return repository.getGameSettings(level)
    }
}