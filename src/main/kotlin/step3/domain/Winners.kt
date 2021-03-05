package step3.domain

class Winners(val winners: List<Record>) : List<Record> by winners {
    override fun toString(): String {
        return winners.joinToString { it.name }
    }
}