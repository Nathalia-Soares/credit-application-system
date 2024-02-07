package me.dio.creditrequestsystem

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import me.dio.creditrequestsystem.exception.BusinessException
import me.dio.creditrequestsystem.model.Address
import me.dio.creditrequestsystem.model.Customer
import me.dio.creditrequestsystem.repository.CustomerRepository
import me.dio.creditrequestsystem.service.CustomerService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*
import java.util.Random

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CreditRequestSystemApplicationTests {

    @Test
    fun contextLoads() {
    }
}
