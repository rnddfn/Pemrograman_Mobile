package com.example.retrofit.common.data

interface ApiMapper<Domain, Entity> {
    fun mapToDomain(apiDto: Entity): Domain
}