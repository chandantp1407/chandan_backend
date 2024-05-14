package com.excel.springhibernate;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentImpl implements StudentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	@Override
	public int insertStudent(Student student) {
		int i=  (int) hibernateTemplate.save(student);
		return i;
	}

	@Transactional
	@Override
	public Student updateStudent(Student student) {
		//		String update="update Student set name=? where id=?";
		hibernateTemplate.saveOrUpdate(student);
		return student;


	}

	@Override
	public Student getStudent(int id) {
		Student student=hibernateTemplate.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public Student deleteStudent(int id) {
		Student del	=hibernateTemplate.get(Student.class,id);
		hibernateTemplate.delete(del);
		return del;

	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students=hibernateTemplate.loadAll(Student.class);
		return students;
	}

}
