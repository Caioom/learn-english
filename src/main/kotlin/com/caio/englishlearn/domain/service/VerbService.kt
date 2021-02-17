package com.caio.englishlearn.domain.service

import com.caio.englishlearn.delivery.dtos.VerbDTO

interface VerbService {
    fun save(verbDto: VerbDTO)
    fun findAll(): List<VerbDTO>
}