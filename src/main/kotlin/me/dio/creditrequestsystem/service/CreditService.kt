package me.dio.creditrequestsystem.service

import me.dio.creditrequestsystem.model.Credit
import me.dio.creditrequestsystem.repository.CreditRepository
import me.dio.creditrequestsystem.service.interfaces.InterfaceCreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): InterfaceCreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            val customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Credit Code $creditCode not found"))
        return if(credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}