package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class StudentService {
    StudentRepository repoObj=new StudentRepository();

        public void addStudent(Student student){
            repoObj.addStudent(student);


        }
        public void addTeacher( Teacher teacher){
            repoObj.addTeacher(teacher);


        }
        public void addStudentTeacherPair(String student,String teacher){
            repoObj.addStudentTeacherPair(student,teacher);
        }

        public Student getStudentByName(String name){
            Student studentObj=repoObj.getStudentByName(name);

            return studentObj;
        }
        public Teacher getTeacherByName(String name){
            Teacher teacherObj=repoObj.getTeacherByName(name);
            return teacherObj;
        }
        public List<String> getStudentsByTeacherName(String teacher){
            List<String> listObj=repoObj.getStudentsByTeacherName(teacher);
             return listObj;

        }
        public List<String> getAllStudents(){
            HashMap<String,Student> hmap=repoObj.getAllStudents();
            List<String> allStudent=new ArrayList<>();

            for(String name: hmap.keySet()){
                allStudent.add(name);
            }
            return allStudent;

        }
        public void deleteTeacherByName(String teacher){
            repoObj.deleteTeacherByName(teacher);
        }
        public void deleteAllTeachers(){
            repoObj.deleteAllTeachers();
        }


}
