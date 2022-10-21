import at.htl.Pupil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class Test1 {
    @Test
    void AssertDouble() {
        assertThat(1.2).isEqualTo(1, withPrecision(1d));
    }

    @Test
    void TestBoolean() {
        assertThat(1 < 2).isTrue();
        assertThat(12 == 13).isFalse();
    }

    @Test
    void AssertObjects() {
        Pupil pupil1 = new Pupil("Max", "Mustermann", 32);
        Pupil pupil2 = new Pupil("Max", "Mustermann", 32);

        assertThat(pupil1).isEqualTo(pupil2);
        assertThat(pupil1).isEqualToComparingFieldByField(pupil2);
    }

    @Test
    void AssertDate() {
        LocalDate date = LocalDate.of(2024, 12, 1);

        assertThat(date).isAfter(LocalDate.now());
        assertThat(date).isBefore(LocalDate.now());
        assertThat(date).isEqualTo(LocalDate.now());
    }

    @Test
    void AssertFiles() {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        assertThat(file1).exists();
        assertThat(file1).hasSameContentAs(file2);
        assertThat(file1).canRead();
        assertThat(file1).canWrite();
    }

    @Test
    void AssertStreams() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.stream()).contains(1);
        assertThat(list.stream()).isNotEmpty();
        assertThat(list.stream()).hasSize(3);
    }
}
