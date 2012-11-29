package com.lesd.poker

import spock.lang.Specification

class CardSpec extends Specification {

    def "card equal test"() {
        Card card1 = CardFactory.createCard("2D");
        Card card2 = CardFactory.createCard("2D");

        expect: card1 == card2
    }

    def "card not equal test"() {
        Card card1 = CardFactory.createCard("2D");
        Card card2 = CardFactory.createCard("4D");
        Card card3 = CardFactory.createCard("2H");

        expect:
        card1 != card2
        card1 != card3
    }
}
