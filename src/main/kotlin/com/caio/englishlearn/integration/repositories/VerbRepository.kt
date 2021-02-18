package com.caio.englishlearn.integration.repositories

import com.caio.englishlearn.integration.entities.VerbEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VerbRepository : JpaRepository<VerbEntity, Int> {
    fun findByImperative(verb: String): Optional<VerbEntity>
}