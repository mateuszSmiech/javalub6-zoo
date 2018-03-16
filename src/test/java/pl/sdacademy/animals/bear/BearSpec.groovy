package pl.sdacademy.animals.bear

import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)
        bear.eat(1)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {

    }

    def "After meal weight increase for eaten value"() {
        given:
        int weight = 3
        Bear bear = new BlackBear(weight)

        when:
        int result = bear.eat(3)

        then:
        result == 6

    }

    def "After Bear drinks water, weight increases for 3/4 drank liquid"() {
        given:
        int weight = 3
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

    def "Bear is not alive when his weight is equal to 0"() {
        given:
        int weight = 0
        Bear bear = new BlackBear(weight)

        when:
        boolean result = bear.isAlive()

        then:
        !result
    }

    def "Bear is resurrected when he gets food"() {
        given:
        int weight = 0
        Bear bear = new BlackBear(weight)
        bear.eat(2)

        when:
        boolean result = bear.isAlive()

        then:
        result
    }


}
