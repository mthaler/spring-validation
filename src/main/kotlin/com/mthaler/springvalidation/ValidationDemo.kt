package com.mthaler.springvalidation

import com.mthaler.springvalidation.SingerValidationService
import com.mthaler.springvalidation.config.AppConfig
import com.mthaler.springvalidation.obj.Genre
import com.mthaler.springvalidation.obj.Singer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericApplicationContext
import java.util.function.Consumer
import javax.validation.ConstraintViolation

class ValidationDemo

private val logger: Logger = LoggerFactory.getLogger(ValidationDemo::class.java)

fun main(args: Array<String>) {
    val ctx: GenericApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val singerValidationService = ctx.getBean(
        "singerValidationService",
        SingerValidationService::class.java
    )
    val singer = Singer()
    singer.firstName = "John"
    singer.lastName = "Mayer"
    singer.genre = Genre.COUNTRY
    singer.gender = null
    validateSinger(singer, singerValidationService)
    ctx.close()
}

private fun validateSinger(singer: Singer, singerValidationService: SingerValidationService) {
    val violations = singerValidationService.validateSinger(singer)
    listViolations(violations)
}

private fun listViolations(violations: Set<ConstraintViolation<Singer>>) {
    logger.info("No. of violations: " + violations.size)
    violations.forEach(Consumer { v: ConstraintViolation<Singer> ->
        logger.info(
            "Validation error for property: " + v.propertyPath
                    + " with value: " + v.invalidValue
                    + " with error message: " + v.message
        )
    })
}