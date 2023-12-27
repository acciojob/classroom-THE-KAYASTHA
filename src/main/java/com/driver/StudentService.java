package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class StudentService {
    StudentRepository repoObj=new StudentRepository();

    public StudentService(){

    }
        public void addStudent(Student student){
            this.repoObj.addStudent(student);


        }
        public void addTeacher( Teacher teacher){
            this.repoObj.addTeacher(teacher);


        }
        public void addStudentTeacherPair(String student,String teacher){
            repoObj.addStudentTeacherPair(student,teacher);
        }

        public Student getStudentByName(String name){
            Student studentObj=this.repoObj.getStudentByName(name);

            return studentObj;
        }
        public Teacher getTeacherByName(String name){
            Teacher teacherObj=this.repoObj.getTeacherByName(name);
            return teacherObj;
        }
        public List<String> getStudentsByTeacherName(String teacher){
            List<String> listObj=this.repoObj.getStudentsByTeacherName(teacher);
             return listObj;

        }
        public List<String> getAllStudents(){
            HashMap<String,Student> hmap=this.repoObj.getAllStudents();
            List<String> allStudent=new ArrayList<>();

            for(String name: hmap.keySet()){
                allStudent.add(name);
            }
            return allStudent;

        }
        public void deleteTeacherByName(String teacher){
            this.repoObj.deleteTeacherByName(teacher);
        }
        public void deleteAllTeachers(){
            this.repoObj.deleteAllTeachers();
        }


}
