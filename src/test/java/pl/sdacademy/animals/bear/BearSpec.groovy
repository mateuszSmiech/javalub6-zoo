package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import pl.sdacademy.animals.time.BearClock
import pl.sdacademy.animals.time.Clock
import pl.sdacademy.animals.time.ClockFake
import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)
        bear.eat(1)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        def clock = new BearClock()
        clock.getCurrentTime()
        def bear = new BlackBear(3, clock)
        bear.eat(2)
        clock.setDate(DateTime.parse("2017-12-14T21:39:45.618-08:00"))


        when:
        def result = bear.isAlive()

        then:
        !result
    }

    def "After meal weight increase for eaten value"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)
        bear.eat(3)
        when:
        weight = bear.getWeight()

        then:
        weight == 6
    }

    def "After Bear drinks water, weight increases for 3/4 drank liquid"() {
        given:
        double weight = 3
        Bear bear = new BlackBear(weight)
        bear.drink(1)

        when:
        double result = bear.getWeight()

        then:
        result == 3.75
    }

    def "After bear poops his weight decrease for 5%"() {
        given:
        double weight = 10
        Bear bear = new BlackBear(weight)
        bear.poop()

        when:
        double result = bear.getWeight()

        then:
        result == 9.5
    }

    def "Bear is resurrected when he gets food"() {
        given:
        def clock = Mock(BearClock)
        clock.currentTime >> DateTime.now().plusDays(11)
        def bear = new BlackBear(3, clock)
        bear.eat(2)

        when:
        def result = bear.isAlive()

        then:
        result
    }

}
