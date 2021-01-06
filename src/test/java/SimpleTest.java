import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by chenjun on 2020-04-11 22:29
 */
public class SimpleTest {

    @Test
    public void test() {
        Student student = new Student();
        student.setCode("123");
        student.setName("afasd");
        Set<Student> students = new HashSet<>();
        students.add(student);
        System.out.println(students.size());
        student.setCode("124");
        students.add(student);
        System.out.println(students.size());
    }

    @Test
    public void test1(){
        System.out.println(2<<3);
    }




    public class Student {
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(code, student.code) && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, name);
        }
    }
}
