package me.dio.creditrequestsystem.service.interfaces

import me.dio.creditrequestsystem.model.Credit
import java.util.*

interface InterfaceCreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long):List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}