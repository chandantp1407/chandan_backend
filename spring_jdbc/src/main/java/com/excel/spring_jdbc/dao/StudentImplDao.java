package com.excel.spring_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.excel.spring_jdbc.entity.Student;

@Component("studentDao")
public class StudentImplDao implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertStudent(Student student) {
		String query="insert into Student(id,name,city) Values(?,?,?)";
		return jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	}

	@Override
	public int updateStudent(Student student) {
		String query1="update Student set name=?,city=? where id=?";
		return jdbcTemplate.update(query1,student.getName(),student.getCity(),student.getId());
	}

	@Override
	public int deleteStudent(Student student) {
		String query2="delete from Student where id=?";

		return jdbcTemplate.update(query2,student.getId());
	}

	@Override
	public List<Student> selectAllStudent() {
		String lis="select * from Student";
		return jdbcTemplate.query(lis, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s1=new Student();
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setCity(rs.getString(3));
				return s1;
			}

		});
	}

	@Override
	public int selectStudent(Student student) {
		String select="select * from Student where id=?";
		
		return 0;
	}

}
