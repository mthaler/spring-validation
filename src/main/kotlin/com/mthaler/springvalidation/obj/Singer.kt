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
    private var genre: Genre? = null
    private var gender: Gender? = null

    fun isCountrySinger(): @AssertTrue(message = "Country Singer should have gender and last name defined") Boolean {
        var result = true
        if (genre != null &&
            genre == Genre.COUNTRY && (gender == null || lastName == null)
        ) {
            result = false
        }
        return result
    }
}