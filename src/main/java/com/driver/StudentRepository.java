package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashmap=new HashMap<>();
    HashMap<String,Teacher> teacherHashMap=new HashMap<>();

    HashMap<Teacher, List<Student>> studentTeacherPair=new HashMap<>();
    public void addStudent(Student student){
        studentHashmap.put(student.getName(), student);

    }
    public void addTeacher( Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        Student student1=studentHashmap.get(student);
        Teacher temp=teacherHashMap.get(teacher);
        if(studentTeacherPair.containsKey(temp)){
            studentTeacherPair.get(temp).add(student1);
        }
        else {
            List<Student> studentList=new ArrayList<>();
            studentList.add(student1);
            studentTeacherPair.put(temp,studentList);

        }
    }
    public Student getStudentByName(String name){
        return studentHashmap.get(name);

    }
    public Teacher getTeacherByName(String name){

        return teacherHashMap.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
         List<Student> temp= studentTeacherPair.get(teacherHashMap.get(teacher));
        List<String> ans=new ArrayList<>();
        for(Student i:temp){
            ans.add(i.getName());
        }
        return ans;


    }
    public HashMap<String,Student> getAllStudents(){
        return studentHashmap;
    }
    public void deleteTeacherByName(String teacher){
        teacherHashMap.remove(teacher);
        studentTeacherPair.remove(teacherHashMap.get(teacher));

    }
    public void deleteAllTeachers(){
        teacherHashMap.clear();
        studentTeacherPair.clear();
    }
}
