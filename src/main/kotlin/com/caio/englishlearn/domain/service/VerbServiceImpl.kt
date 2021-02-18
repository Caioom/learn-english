package com.caio.englishlearn.domain.service

import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.domain.VerbException
import com.caio.englishlearn.domain.mappers.VerbMapper
import com.caio.englishlearn.integration.entities.VerbEntity
import com.caio.englishlearn.integration.repositories.VerbRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class VerbServiceImpl : VerbService {
    @Autowired
    lateinit var verbRepository: VerbRepository

    private val verbMapper: VerbMapper = VerbMapper()

    override fun save(verbDto: VerbDTO) {
        val verbEntity: VerbEntity = this.verbMapper.toVerbEntity(verbDto)
        this.verifyIfVerbExists(verbEntity)
        this.verbRepository.save(verbEntity)
    }

    private fun verifyIfVerbExists(verb: VerbEntity) {
        this.verbRepository
                .findByImperative(verb.imperative)
                .ifPresent{throw VerbException("This verb already exists")}
    }

    override fun findAll(): List<VerbDTO> {
        val allVerbs = this.verbRepository.findAll()
        return allVerbs.stream()
                .map { this.verbMapper.toVerbDto(it) }
                .collect(Collectors.toList())
    }
}