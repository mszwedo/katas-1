package com.lesd.poker

import spock.lang.Specification
import static com.lesd.poker.PokerHandType.HIGHCARD;
import static com.lesd.poker.PokerHandType.PAIR;
import static com.lesd.poker.Rank.EIGHT;
import static com.lesd.poker.Rank.KING;
import static com.lesd.poker.Rank.NINE;
import static com.lesd.poker.Rank.SEVEN;
import static com.lesd.poker.Rank.SIX;


class PokerHandResultComparatorSpec extends Specification {

    def "test compare works"() {

        def result1 = new PokerHandResult(pokerHandType1, orderedRankList1);
        def result2 = new PokerHandResult(pokerHandType2, orderedRankList2);
        def pokerHandResultComparator = new PokerHandResultComparator();

        expect:
        result == pokerHandResultComparator.compare(result1, result2)

        where:
        result | pokerHandType1 | pokerHandType2 | orderedRankList1          | orderedRankList2
        //Check hand type
        -1      | HIGHCARD       | PAIR           | []                        | []
        1       | PAIR           | HIGHCARD       | []                        | []
        //Check Tie
        0       | PAIR           | PAIR           | [KING, EIGHT, SEVEN, SIX] | [KING, EIGHT, SEVEN, SIX]
        //Check rank is checked second
        1       | PAIR           | PAIR           | [KING, NINE, SEVEN, SIX]  | [KING, EIGHT, SEVEN, SIX]
        -1      | PAIR           | PAIR           | [KING, EIGHT, SEVEN, SIX] | [KING, NINE, SEVEN, SIX]
    }
}
