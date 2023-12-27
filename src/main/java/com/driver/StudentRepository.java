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
    public StudentRepository(){

    }
    public void addStudent(Student student){
        this.studentHashmap.put(student.getName(), student);

    }
    public void addTeacher( Teacher teacher){
        this.teacherHashMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        Student student1=this.studentHashmap.get(student);
        Teacher temp=this.teacherHashMap.get(teacher);
        if(this.studentTeacherPair.containsKey(temp)){
            this.studentTeacherPair.get(temp).add(student1);
        }
        else {
            List<Student> studentList=new ArrayList<>();
            studentList.add(student1);
            this.studentTeacherPair.put(temp,studentList);

        }
    }
    public Student getStudentByName(String name){
        return this.studentHashmap.get(name);


    }
    public Teacher getTeacherByName(String name){

        return this.teacherHashMap.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
         List<Student> temp= this.studentTeacherPair.get(this.teacherHashMap.get(teacher));
        List<String> ans=new ArrayList<>();
        for(Student i:temp){
            ans.add(i.getName());
        }
        return ans;


    }
    public HashMap<String,Student> getAllStudents(){
        return this.studentHashmap;
    }
    public void deleteTeacherByName(String teacher){

        List<Student> temp=this.studentTeacherPair.get(this.teacherHashMap.get(teacher));
        for(Student str:temp){

            this.studentHashmap.remove(str.getName());

        }

        this.studentTeacherPair.remove(this.teacherHashMap.get(teacher));
        this.teacherHashMap.remove(teacher);

    }
    public void deleteAllTeachers(){
        this.teacherHashMap.clear();
        for(Teacher i:this.studentTeacherPair.keySet()){

                List<Student> temp=this.studentTeacherPair.get(i);

             for(Student str:temp){

                this.studentHashmap.remove(str.getName());

            }
        }
        this.studentTeacherPair.clear();
    }
}
