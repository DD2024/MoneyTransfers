fun main() {

    val cardType = "Mastercard"
    val amount = 20000;
    var amountMonth = 600001
    var amountDay = 0

    if (excessAmountChek(amountMonth, amountDay, amount)) {
        println("Лимит превышен. Операция не может быть выполнена.")
    } else {
        println("Сумма комиссии: " + calcComission(cardType, amountMonth, amount));
    }

}

fun calcComission(cardType: String = "Мир", amountMonth: Int = 0, amount: Int): Int {

    var balancePreferential = if (75000 - amountMonth > 0) 75000 - amountMonth else 0;

    when {

        cardType == "Мир" -> return 0
        cardType == "Mastercard" -> return if (amount - balancePreferential > 0) ((amount - balancePreferential) * 0.006 + 20).toInt() else 0;
        amount * 0.0075 > 35 -> return (amount * 0.0075).toInt()
    }
    return 35
}

fun excessAmountChek(amountMonth: Int = 0, amountDay: Int = 0, amount: Int): Boolean {

    var block = false;
    when {
        amountMonth + amount > 600_000 -> block = true
        amountDay + amount > 150_000 -> block = true
    }
    return block
}
