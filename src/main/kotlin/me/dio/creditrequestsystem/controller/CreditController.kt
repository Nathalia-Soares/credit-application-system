package me.dio.creditrequestsystem.controller

import jakarta.validation.Valid
import me.dio.creditrequestsystem.controller.dto.CreditViewList
import me.dio.creditrequestsystem.controller.dto.CreditDto
import me.dio.creditrequestsystem.controller.dto.CreditView
import me.dio.creditrequestsystem.model.Credit
import me.dio.creditrequestsystem.service.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto : CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long) : ResponseEntity<List<CreditViewList>> {
        val creditViewList: List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream().map {credit : Credit -> CreditViewList(credit)}
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode: UUID) : ResponseEntity<CreditView> {
        val credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}