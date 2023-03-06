package arquitectura.software.demo.api

import arquitectura.software.demo.dto.CurrencyDto
import arquitectura.software.demo.dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import arquitectura.software.demo.bl.CurrencyBl
import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/currency")
class CurrencyApi(private val currencyBl: CurrencyBl) {

    @GetMapping("/obtain")
    fun obtain(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<Any> {
        val currencyDto = currencyBl.obtain(from, to, amount)
        //val responseDto = ResponseDto<Any>(currencyDto, true, "Success")
        return ResponseEntity.ok(currencyDto)
    }
}