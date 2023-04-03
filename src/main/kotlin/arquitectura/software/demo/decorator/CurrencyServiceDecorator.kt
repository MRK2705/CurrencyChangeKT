package arquitectura.software.demo.decorator

import arquitectura.software.demo.dto.CurrencyDto
import arquitectura.software.demo.inter.CurrencyService
import java.math.BigDecimal

abstract class CurrencyServiceDecorator (private val currencyService: CurrencyService): CurrencyService {
    override fun obtain(from: String, to: String, amount: BigDecimal): CurrencyDto {
        return currencyService.obtain(from, to, amount)
    }
}
