package com.caio.englishlearn.domain.service

import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.integration.entities.VerbEntity
import com.caio.englishlearn.integration.repositories.VerbRepository
import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class VerbServiceImplTest {

    @InjectMockKs
    private var verbService = VerbServiceImpl()

    @MockK
    private lateinit var verbRepository: VerbRepository

    private val verbEntity = VerbEntity(id = 1, imperative = "be",
            simplePast = "was/were", pastParticiple = "been", translation = "ser/estar")

    private val verbDto = VerbDTO(id = 1, imperative = "be",
            simplePast = "was/were", pastParticiple = "been", translation = "ser/estar")

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should save new verb in three tenses`() {
        every { verbRepository.save(verbEntity) } returns this.verbEntity

        this.verbService.save(this.verbDto)

        verify { verbRepository.save(verbEntity) }
        confirmVerified(verbRepository)
    }

    @Test
    fun `should return all verbs of database`() {
        every { verbRepository.findAll() } returns listOf(this.verbEntity)

        val allVerbs: List<Any> = this.verbService.findAll()
        Assertions.assertThat(allVerbs).isEqualTo(listOf(this.verbDto))
    }
}