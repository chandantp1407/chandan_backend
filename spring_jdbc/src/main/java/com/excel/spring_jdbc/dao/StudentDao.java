package com.excel.spring_jdbc.dao;

import java.util.List;

import com.excel.spring_jdbc.entity.Student;

public interface StudentDao {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
	List<Student> selectAllStudent();
	int selectStudent(Student student);
}
