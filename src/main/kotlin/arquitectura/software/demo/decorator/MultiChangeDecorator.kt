package arquitectura.software.demo.decorator

import arquitectura.software.demo.dto.CurrencyDto
import arquitectura.software.demo.inter.CurrencyService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class MultiChangeDecorator(@Qualifier("currencyBl") private val currencyService: CurrencyService) : CurrencyServiceDecorator(currencyService) {

    override fun obtain(from: String, to: String, amount: BigDecimal): CurrencyDto {
        return currencyService.obtain(from, to, amount)
    }

    fun multiObtain(from: String, toList: List<String>, amount: BigDecimal): List<CurrencyDto> {
        val currencyDtoList = mutableListOf<CurrencyDto>()
        for (to in toList) {
            val currencyDto = currencyService.obtain(from, to, amount)
            currencyDtoList.add(currencyDto)
        }
        return currencyDtoList
    }

    fun multiObtain(toFrom: List<String>, to: String, amount: BigDecimal): List<CurrencyDto> {
        val currencyDtoList = mutableListOf<CurrencyDto>()
        for (from in toFrom) {
            val currencyDto = currencyService.obtain(from, to, amount)
            currencyDtoList.add(currencyDto)
        }
        return currencyDtoList
    }


}