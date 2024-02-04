package me.dio.creditrequestsystem.controller.dto

import jakarta.persistence.*
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.creditrequestsystem.model.Credit
import me.dio.creditrequestsystem.model.Customer
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.concurrent.timer

data class CreditDto(
    @field: NotNull(message = "Invalid input") val creditValue: BigDecimal,
    @field: Future(message = "Invalid input") val dayFirstOfInstallment: LocalDate,
    @field: Min(value = 1, message = "It's not possible include less than 1 month")
    @field: Max(value = 48, message = "It's not possible include over 48 months") val numberOfInstallments: Int,
    @field: NotNull(message = "Invalid input") val customerId: Long
) {
    fun toEntity(): Credit = Credit (
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
