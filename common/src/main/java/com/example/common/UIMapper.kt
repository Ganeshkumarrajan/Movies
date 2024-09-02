package com.example.common

interface UIMapper<in I, out O> {
    fun toUiModel(entity: I): O
}