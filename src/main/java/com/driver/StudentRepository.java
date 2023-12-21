package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashmap=new HashMap<>();
    HashMap<String,Teacher> teacherHashMap=new HashMap<>();

    HashMap<String, List<String>> studentTeacherPair=new HashMap<>();
    public void addStudent(Student student){
        studentHashmap.put(student.getName(), student);

    }
    public void addTeacher( Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        if(studentTeacherPair.containsKey(teacher)){
            studentTeacherPair.get(teacher).add(student);
        }
        else {
            List<String> studentList=new ArrayList<>();
            studentList.add(student);
            studentTeacherPair.put(teacher,studentList);

        }
    }
    public Student getStudentByName(String name){
        return studentHashmap.get(name);

    }
    public Teacher getTeacherByName(String name){

        return teacherHashMap.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentTeacherPair.get(teacher);

    }
    public HashMap<String,Student> getAllStudents(){
        return studentHashmap;
    }
    public void deleteTeacherByName(String teacher){
        teacherHashMap.remove(teacher);
        studentTeacherPair.remove(teacher);

    }
    public void deleteAllTeachers(){
        teacherHashMap.clear();
        studentTeacherPair.clear();
    }
}
