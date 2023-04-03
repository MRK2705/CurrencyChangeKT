package arquitectura.software.demo.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import arquitectura.software.demo.bl.CurrencyBl
import arquitectura.software.demo.decorator.MultiChangeDecorator
import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/currency")

class CurrencyApi(private val currencyBl: CurrencyBl, private val currencyService: MultiChangeDecorator) {

    @GetMapping("/obtain")
    fun obtain(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<Any> {
        val currencyDto = currencyBl.obtain(from, to, amount)
        //val responseDto = ResponseDto<Any>(currencyDto, true, "Success")
        return ResponseEntity.ok(currencyDto)
    }

    @GetMapping("/list")
    fun getConvertions(@RequestParam page: Int, @RequestParam size: Int) : Any {
        val convertions = currencyBl.getListOfConvertions(page, size);
        return ResponseEntity.ok(convertions)
    }

    @GetMapping("/multi-obtain")
    fun multiObtain(@RequestParam from: String, @RequestParam toList: List<String>, @RequestParam amount: BigDecimal): ResponseEntity<Any> {
        val currencyDtoList = currencyService.multiObtain(from, toList, amount)
        return ResponseEntity.ok(currencyDtoList)
    }

    @GetMapping("/multi-obtain1")
    fun multiObtain(@RequestParam toFrom: List<String>, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<Any> {
        val currencyDtoList = currencyService.multiObtain(toFrom, to, amount)
        return ResponseEntity.ok(currencyDtoList)
    }

}