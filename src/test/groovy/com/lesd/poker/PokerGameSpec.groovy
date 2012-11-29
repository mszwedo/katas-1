package com.lesd.poker

import spock.lang.Specification


class PokerGameSpec extends Specification {

    def "winner test"() {

        def pokerHand1 = HandFactory.createHand(hand1)
        def pokerHand2 = HandFactory.createHand(hand2)
        def game = new PokerGame(pokerHand1, pokerHand2)

        expect:
        result == game.winner()

        where:
        hand1            | hand2            | result
        //HighCard
        "2H 3D 5S 9C KD" | "KH 2D 6S 8C AD" | Winner.PLAYER2
        "2H 3D 5S 9C AD" | "KH 2D 6S 8C QD" | Winner.PLAYER1
        "KD 3D 5S 9C AD" | "KH 2D 6S 8C AS" | Winner.PLAYER1
        "2H 3H 5H 9H KH" | "2D 3D 5D 9D KD" | Winner.TIE
        //Pair Beats High Card
        "2H 2D 5H 9H KH" | "2S 3D 5D 9D KD" | Winner.PLAYER1
        //High Pair Beats Low Pair
        "2S 2D 5D 9D KD" | "3H 3D 5H 9H QH" | Winner.PLAYER2

    }
}
