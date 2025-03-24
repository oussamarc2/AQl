package org.emp.gl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullNameShouldReturnFirstNameAndLastName() {
        Person person = new Person("oussama", "rebidj", 25);
        assertEquals("oussama rebidj", person.getFullName());
    }

    @Test
    void isAdultShouldReturnTrueForAge18OrMore() {
        Person adult = new Person("fateh", "youcef", 18);
        assertTrue(adult.isAdult());

        Person olderAdult = new Person("adem", "raggam", 30);
        assertTrue(olderAdult.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseForAgeLessThan18() {
        Person minor = new Person("bouchmal", "lakhder", 17);
        assertFalse(minor.isAdult());


    }
}

