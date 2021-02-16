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
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class VerbServiceImplTest {

    @InjectMockKs
    private var verbService = VerbServiceImpl()

    @MockK
    private lateinit var verbRepository: VerbRepository

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should save new verb in three tenses`() {
        val verbEntity = VerbEntity(id = 1, imperative = "be",
            simplePast = "was/were", pastParticiple = "been", translation = "ser/estar")
        val verbDto = VerbDTO(id = 1, imperative = "be",
            simplePast = "was/were", pastParticiple = "been", translation = "ser/estar")

        every { verbRepository.save(verbEntity) } returns verbEntity

        this.verbService.save(verbDto)

        verify { verbRepository.save(verbEntity) }
        confirmVerified(verbRepository)
    }
}