package com.caio.englishlearn.domain.mappers

import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.integration.entities.VerbEntity

class VerbMapper {
    fun toVerbEntity(verbDto: VerbDTO): VerbEntity {
       val verbEntity = VerbEntity()
       verbEntity.id = verbDto.id
       verbEntity.imperative = verbDto.imperative
       verbEntity.simplePast = verbDto.simplePast
       verbEntity.pastParticiple = verbDto.pastParticiple
       verbEntity.translation = verbDto.translation
       return verbEntity
    }

    fun toVerbDto(verbEntity: VerbEntity): VerbDTO {
        val verbDto = VerbDTO()
        verbDto.id = verbEntity.id
        verbDto.imperative = verbEntity.imperative
        verbDto.simplePast = verbEntity.simplePast
        verbDto.pastParticiple = verbEntity.pastParticiple
        verbDto.translation = verbEntity.translation
        return verbDto
    }
}