package com.example.movielist.data.mapper

interface DomainMapper<in I, out O> {
    fun toDomain(entity:I):O
}