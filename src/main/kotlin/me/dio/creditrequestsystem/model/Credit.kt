package me.dio.creditrequestsystem.model

import jakarta.persistence.*
import me.dio.creditrequestsystem.model.enum.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
// @Table(name = "Credito")
data class Credit(
    @Column(nullable = false, unique = true)
    var creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    val numberOfInstallments: Int = 0,
    @Enumerated(value = EnumType.STRING)
    val status: Status = Status.IN_PROGRESS,
    @ManyToOne
    val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    )