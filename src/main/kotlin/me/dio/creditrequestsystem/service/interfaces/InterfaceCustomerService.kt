package me.dio.creditrequestsystem.service.interfaces

import me.dio.creditrequestsystem.model.Customer

interface InterfaceCustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}