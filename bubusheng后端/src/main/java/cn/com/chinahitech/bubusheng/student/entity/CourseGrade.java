package cn.com.chinahitech.bubusheng.student.entity;

public class CourseGrade {
    private String className;

    private String teacher;

    private int courseId;

    private int grades;

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    public void setGrades(int grades)
    {
        this.grades = grades;
    }

    public String getClassName()
    {
        return className;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public int getGrades()
    {
        return grades;
    }

}
