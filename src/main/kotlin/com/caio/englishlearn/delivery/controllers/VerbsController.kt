package com.caio.englishlearn.delivery.controllers

import com.caio.englishlearn.delivery.dtos.ResponseDTO
import com.caio.englishlearn.delivery.dtos.VerbDTO
import com.caio.englishlearn.domain.VerbException
import com.caio.englishlearn.domain.service.VerbService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/verbs")
@CrossOrigin
class VerbsController {
    @Autowired
    private lateinit var verbService: VerbService

    @PostMapping
    fun createNewVerb(@RequestBody verbDTO: VerbDTO): ResponseEntity<Any> {
        val errors = this.validateErrors(verbDTO)
        if(errors.isNotEmpty()) return this.returnErrors(errors)
        return this.registerNewVerb(verbDTO, ResponseDTO())
    }

    private fun returnErrors(errors: ArrayList<String?>): ResponseEntity<Any> {
        val response = ResponseDTO<Void>()
        response.errors = errors
        return ResponseEntity.badRequest().body(response)
    }

    private fun registerNewVerb(verbDTO: VerbDTO, response: ResponseDTO<Void>): ResponseEntity<Any> {
        return try {
            this.verbService.save(verbDTO)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } catch (e: VerbException) {
            response.errors.add(e.message)
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
        }
    }

    @GetMapping
    fun getAllVerbs(): ResponseEntity<ResponseDTO<Any>> {
        val allVerbs = this.verbService.findAll()
        val response = ResponseDTO<Any>()
        response.data = allVerbs
        return ResponseEntity.ok(response)
    }

    fun validateErrors(verbDto: VerbDTO): ArrayList<String?> {
        val errors = ArrayList<String?>()
        if(verbDto.imperative.isBlank() || verbDto.imperative.isEmpty() || verbDto.imperative.length < 2) errors.add("Imperative not be empty or blank")
        if(verbDto.pastParticiple.isBlank() || verbDto.pastParticiple.isEmpty() || verbDto.pastParticiple.length < 2) errors.add("Past participle not be empty or blank")
        if(verbDto.simplePast.isBlank() || verbDto.simplePast.isEmpty() || verbDto.simplePast.length < 2) errors.add("Simple past not be empty or blank")
        if(verbDto.translation.isBlank() || verbDto.translation.isEmpty() || verbDto.translation.length < 2) errors.add("Translation not be empty or blank")
        return errors
    }
}