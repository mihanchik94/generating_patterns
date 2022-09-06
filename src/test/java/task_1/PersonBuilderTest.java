package task_1;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.*;

class PersonBuilderTest {
    private final Person parent = new PersonBuilder().setName("Игорь").setSurname("Иванов").setAge(19).setAddress("Новгород").build();
    private final Person child = parent.newChildBuilder().setName("Федор").build();

    @Test
    public void whenChildHasNameAndGetSurname() {
        assertThat(child.getSurname()).isEqualTo("Иванов");
    }

    @Test
    public void whenChildHasNameAndGetAddress() {
        assertThat(child.getAddress()).isEqualTo("Новгород");
    }

    @Test
    public void whenChildHasNameAndGetAge() {
        assertThat(child.getAge()).isEqualTo(OptionalInt.of(0));
    }

    @Test
    public void whenHappyBirthday() {
        child.happyBirthday();
        assertThat(child.getAge()).isEqualTo(OptionalInt.of(1));
    }

    @Test
    public void whenNameIsNull() {
        assertThatThrownBy(() -> parent.newChildBuilder().build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name or surname was not specified");
    }

    @Test
    public void whenAgeIsNegative() {
        assertThatThrownBy(() -> parent.newChildBuilder().setName("Vanya").setAge(-7).build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Age can't be negative");
    }
}