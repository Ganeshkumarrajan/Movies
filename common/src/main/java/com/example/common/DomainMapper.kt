package com.example.common


interface DomainMapper<in I, out O> {
    fun toDomain(entity:I):O
}
