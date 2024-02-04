package me.dio.creditrequestsystem.service

import me.dio.creditrequestsystem.exception.BusinessException
import me.dio.creditrequestsystem.model.Customer
import me.dio.creditrequestsystem.repository.CustomerRepository
import me.dio.creditrequestsystem.service.interfaces.InterfaceCustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository
): InterfaceCustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        val customer : Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}