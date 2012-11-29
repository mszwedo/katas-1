package com.lesd.poker

import spock.lang.Specification


class CardFactorySpec extends Specification{

    def "test card creation"() {

        when:
        Card card = CardFactory.createCard(cardString)

        then:
        rank == card.getRank()
        suit == card.getSuit()

        where:
        cardString  | rank       | suit
        "2H"        | Rank.TWO   | Suit.HEARTS
        "3H"        | Rank.THREE | Suit.HEARTS
        "KD"        | Rank.KING  | Suit.DIAMONDS
    }
}
