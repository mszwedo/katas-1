package com.lesd.poker

import spock.lang.Specification

class PokerHandEvaluatorSpec extends Specification
{
    def "evaluate All Hands Test"() {

        def evaluator = new PokerHandEvaluator();

        when:
        def result = evaluator.evaluate(HandFactory.createHand(hand))

        then:
        result.handType == pokerHandType
        result.orderedRankList == rankList

        where:
        hand             | pokerHandType              | rankList
        "2H 3D 5S 9C KD" | PokerHandType.HIGHCARD     | [Rank.KING, Rank.NINE, Rank.FIVE, Rank.THREE, Rank.TWO]
        "2H 2D 5S 9C KD" | PokerHandType.PAIR         | [Rank.TWO, Rank.KING, Rank.NINE, Rank.FIVE]
        "2H 2D 5S 5C KD" | PokerHandType.TWOPAIR      | [Rank.FIVE, Rank.TWO, Rank.KING]
        "2H 2D 2S 9C KD" | PokerHandType.THREEOFAKIND | [Rank.TWO, Rank.KING, Rank.NINE]
        "2H 3D 4S 5C 6D" | PokerHandType.STRAIGHT     | [Rank.SIX]
    }
}