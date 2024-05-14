package com.excel.springhibernate;

import java.util.List;

public interface StudentDao {
	int insertStudent(Student student);
	 Student updateStudent(Student student);
	 Student getStudent(int id);
	 Student deleteStudent(int id);
	 List<Student> selectAllStudents();
}
