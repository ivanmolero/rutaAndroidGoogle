package com.imolerodev.a03courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceCourseNameId: Int,
    val size: Int,
    @DrawableRes val imageResourceId: Int,
)
