package arquitectura.software.demo.inter

import arquitectura.software.demo.dto.CurrencyDto
import java.math.BigDecimal

interface CurrencyService {

    fun obtain(from: String, to: String, amount: BigDecimal): CurrencyDto

}