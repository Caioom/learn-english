package com.caio.englishlearn.domain.service

import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.domain.mappers.VerbMapper
import com.caio.englishlearn.integration.entities.VerbEntity
import com.caio.englishlearn.integration.repositories.VerbRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VerbServiceImpl : VerbService {
    @Autowired
    lateinit var verbRepository: VerbRepository

    private val verbMapper: VerbMapper = VerbMapper()

    override fun save(verbDto: VerbDTO) {
        val verbEntity: VerbEntity = this.verbMapper.toVerbEntity(verbDto)
        this.verbRepository.save(verbEntity)
    }
}