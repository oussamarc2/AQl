package org.emp.gl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullNameShouldReturnFirstNameAndLastName() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void isAdultShouldReturnTrueForAge18OrMore() {
        Person adult = new Person("Alice", "Smith", 18);
        assertTrue(adult.isAdult());

        Person olderAdult = new Person("Bob", "Brown", 30);
        assertTrue(olderAdult.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseForAgeLessThan18() {
        Person minor = new Person("Charlie", "Young", 17);
        assertFalse(minor.isAdult());


    }
}

