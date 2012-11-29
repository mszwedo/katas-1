package com.lesd.poker

import spock.lang.Specification

class HandFactorySpec extends Specification {

    def "create hand test"() {

        when:
        PokerHand hand = HandFactory.createHand("2H 3D 5S 9C KD");

        then:
        hand.getCards().size() == 5
        hand.getCards().get(0).getRank() == Rank.TWO
        hand.getCards().get(0).getSuit() == Suit.HEARTS
    }
}
