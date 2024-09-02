package com.example.common.mapper

interface UIMapper<in I, out O> {
    fun toUiModel(entity: I): O
}