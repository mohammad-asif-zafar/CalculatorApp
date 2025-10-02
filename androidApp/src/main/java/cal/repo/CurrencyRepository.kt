package cal.repo

import cal.constants.CurrencyCode


interface CurrencyRepository {
    suspend fun getAllCurrencies(): List<CurrencyCode>
}

class DefaultCurrencyRepository : CurrencyRepository {
    override suspend fun getAllCurrencies(): List<CurrencyCode> = CurrencyCode.values().toList()
}