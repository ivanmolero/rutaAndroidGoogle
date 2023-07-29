import kotlin.math.min

/*
 * séptimo ejercicio, Special auction
 */

fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Fill in the code.
    return bid?.amount ?: minimumPrice
//    return if (bid == null) minimumPrice else {
//        if (bid.amount > minimumPrice) bid.amount else minimumPrice
//    }
}