package com.kitkat.todo.model

import com.kitkat.todo.R

enum class AuthModel private constructor(val titleResId: Int, val layoutResId: Int) {
    RED(R.string.one, R.layout.fragment_in_progress),
    BLUE(R.string.two, R.layout.fragment_completed)
}