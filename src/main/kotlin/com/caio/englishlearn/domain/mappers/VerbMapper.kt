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
}