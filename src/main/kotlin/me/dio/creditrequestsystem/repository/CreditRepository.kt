package me.dio.creditrequestsystem.repository

import me.dio.creditrequestsystem.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
}