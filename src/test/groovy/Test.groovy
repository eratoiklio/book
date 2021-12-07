import spock.lang.Specification

class Test extends Specification {
    def "pierwszy test Ady w spock"() {
        given:
            def i = 1
        when:
            ++i
        then:
            i == 2
    }
}
