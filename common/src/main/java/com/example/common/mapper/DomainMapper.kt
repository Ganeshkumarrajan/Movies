package com.example.common.mapper


interface DomainMapper<in I, out O> {
    fun toDomain(entity: I): O
}
