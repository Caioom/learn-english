package com.caio.englishlearn.delivery.dtos

import java.util.*

data class ResponseDTO<T>(
        var data: T? = null,
        var errors: ArrayList<String?> = ArrayList()
)
