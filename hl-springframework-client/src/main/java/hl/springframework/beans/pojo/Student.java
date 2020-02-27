package hl.springframework.beans.pojo;

/**
 * @author Hailin
 * @date 2020/2/21
 */
public class Student {

    private String name;

    private Course course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
