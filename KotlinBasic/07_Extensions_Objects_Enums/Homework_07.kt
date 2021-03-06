import classes_07.Currencies
import classes_07.Wallets

fun main() {
    val wallet1 = Wallets.VirtualWallet
    val wallet2 = Wallets.RealWallet
    wallet1.addMoney(Currencies.RUS_ROUBLES, 123.20)
    wallet2.addMoney(Currencies.RUS_ROUBLES, 100, 23)
    println("Деньги в долларах в кошельке №1: " +
            "${wallet1.moneyInUSD(CurrencyConverter.rusRoubleExchange, CurrencyConverter.euroExchange)}")
    println("Деньги в долларах в кошельке №2: " +
            "${wallet2.moneyInUSD(CurrencyConverter.rusRoubleExchange, CurrencyConverter.euroExchange)}")

    println("Валюта конвертированная в доллары: ${Currencies.RUS_ROUBLES.convertToUsd(15)}")
    println("Валюта конвертированная в доллары: ${Currencies.US_DOLLARS.convertToUsd(15)}")
    println("Валюта конвертированная в доллары: ${Currencies.EUROS.convertToUsd(15)}")

    println(Currencies.RUS_ROUBLES.expandFunctionality)
    println(Currencies.EUROS.expandFunctionality)
    println(Currencies.US_DOLLARS.expandFunctionality)
}

object CurrencyConverter {
    const val rusRoubleExchange = 73.98
    const val euroExchange = 0.84
}