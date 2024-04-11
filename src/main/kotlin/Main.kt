fun main(args: Array<String>) {

    var amount = 50;
    var generalCommission = amount * 0.75
    var commission = if(generalCommission>35) generalCommission else 35;

    println(commission);

}