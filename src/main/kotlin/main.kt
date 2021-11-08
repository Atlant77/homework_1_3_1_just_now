fun main(){
    val timeFromLastVisit = 7204 //Количество секунд с последнего визита

    println("был(а) " + agoToText(timeFromLastVisit))
}

fun agoToText(timeFromLastVisit: Int): String {
    val stringFromLastVisit = when {
        timeFromLastVisit <= 60 -> return "только что" //если меньше минуты

        timeFromLastVisit in 61 .. (60 * 60) -> return "${timeFromLastVisit/60} " +
                minuteToText(timeFromLastVisit/60) + " назад" //проверка если меньше часа

        timeFromLastVisit in (60 * 60+1) .. (24 * 60 * 60) -> return "${timeFromLastVisit/3600} " +
                hoursToText(timeFromLastVisit/3600) + " назад" //проверка если от часа до суток

        timeFromLastVisit in (24 * 60 * 60 + 1) .. (24 * 60 * 60 * 2) -> return "сегодня" //от суток до двух

        timeFromLastVisit in (24 * 60 * 60 * 2 + 1) .. (24 * 60 * 60 * 3) -> return "вчера" //от двух суток до трёх

        else -> return "давно"
    }
}

fun minuteToText(minuteFromLastVisit: Int): String {
    val minuteFromLastVisit = when(minuteFromLastVisit){
        1, 21, 31, 41, 51 -> return "минуту"
        in 2 .. 4 -> return "минуты"
        else -> return "минут"
    }
}

fun hoursToText(hoursFromLastVisit: Int): String {
    val hoursFromLastVisit = when(hoursFromLastVisit){
        1, 21 -> return "час"
        in 2 .. 4 -> return "часа"
        else -> return "часов"
    }
}