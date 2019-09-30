package seedu.jarvis.commons.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;

/**
 * @author ryanYtan
 */
public class CourseUtilTest {
    public static String[] VALID_COURSE_CODES = {
            "MA1511",
            "CS3230",
            "CS1101S",
            "ST2334",
            "ALS1020"
    };

    public static String[] INVALID_COURSE_CODES = {
            "MA1234",
            "ESP1107",
            "",
            "JSKD23424",
            "wekjfhqweikfh",
            "garbage values",
            "CS9999",
            "CS50123",
            "MA15101",
            "MA1511-1",
            "MA1511-2",
            "\\asd'\\sd;",
            "???",
    };

    public static String[] VALID_COURSE_CODES_NO_PREREQ = {
            "MA1511",
            "MA1505",
            "CS1231",
            "ME1102",
            "LC1001A",
            "LC1004",
            "SSA1202"
    };

    @Test
    public void getCourseJsonString_validInput_doesNotThrowException() {
        for (String course : VALID_COURSE_CODES) {
            assertDoesNotThrow(() -> CourseUtil.getCourseJsonString(course));
        }
    }


    @Test
    public void getCourseJsonString_invalidInput_throwsIOException() {
        for (String course : INVALID_COURSE_CODES) {
            assertThrows(IOException.class,
                    () -> CourseUtil.getCourseJsonString(course));
        }
    }

    @Test
    public void getJsonMap_validInput_doesNotThrowException() {
        for (String course : VALID_COURSE_CODES) {
            assertDoesNotThrow(() -> CourseUtil.getCourseMap(course));
        }
    }

    @Test
    public void getJsonMap_invalidInput_throwsIOException() {
        for (String course : INVALID_COURSE_CODES) {
            assertThrows(IOException.class,
                    () -> CourseUtil.getCourseJsonString(course));
        }
    }

    @Test
    public void getCourse_validInput_success() {
        for (String course : VALID_COURSE_CODES) {
            assertDoesNotThrow(() -> CourseUtil.getCourse(course));
        }
    }

    @Test
    public void getCourse_invalidInput_throwsIOException() {
        for (String course : INVALID_COURSE_CODES) {
            assertThrows(IOException.class, () -> CourseUtil.getCourse(course));
        }
    }
}
