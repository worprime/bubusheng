package cn.com.chinahitech.bubusheng.student.entity;

public class CourseTest {

    private String courseName;

    private String teacher;

    private String testOpen;

    private String ddl;

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public void setTestOpen(String testOpen)
    {
        this.testOpen = testOpen;
    }

    public void setDdl(String ddl)
    {
        this.ddl = ddl;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public String getTestOpen()
    {
        return testOpen;
    }

    public String getDdl()
    {
        return ddl;
    }
}
