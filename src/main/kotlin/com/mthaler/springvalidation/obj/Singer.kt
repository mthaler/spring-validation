package com.mthaler.springvalidation.obj

import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

class Singer {

    @NotNull
    @Size(min = 2, max = 60)
    var firstName: String? = null
    var lastName: String? = null

    @NotNull
    var genre: Genre? = null
    var gender: Gender? = null

    @AssertTrue(message = "Country Singer should have gender and last name defined")
    fun isCountrySinger():  Boolean {
        var result = true
        if (genre != null &&
            genre == Genre.COUNTRY && (gender == null || lastName == null)
        ) {
            result = false
        }
        return result
    }
}