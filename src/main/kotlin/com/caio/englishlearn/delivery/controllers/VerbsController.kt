package com.caio.englishlearn.delivery.controllers

import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.domain.service.VerbService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/verbs")
class VerbsController {
    @Autowired
    private lateinit var verbService: VerbService

    @PostMapping
    fun createNewVerb(@RequestBody verbDTO: VerbDTO): ResponseEntity<HttpStatus> {
        this.verbService.save(verbDTO)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}