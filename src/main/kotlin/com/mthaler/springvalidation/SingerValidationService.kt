package com.mthaler.springvalidation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.validation.ConstraintViolation
import javax.validation.Validator

@Service("singerValidationService")
class SingerValidationService {

    @Autowired
    private lateinit var validator: Validator

    fun validateSinger(singer: Singer): Set<ConstraintViolation<Singer>> {
        return validator.validate(singer)
    }
}