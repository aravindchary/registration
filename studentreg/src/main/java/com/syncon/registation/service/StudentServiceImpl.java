package com.syncon.registation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syncon.registation.dao.IStudentDAO;
import com.syncon.registation.model.Student;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDAO studentDao;

	@Override
	@Transactional
	public void save(Student student) throws Exception{
		if(student.getId() == null) {
			Student duplicateStudent = studentDao.findStudentByUserName(student.getUserName());
			if(duplicateStudent != null) {
				throw new Exception("Duplicate student with user name : "+student.getUserName()+" exists...");
			}
		}
		student = setCommunity(student);
		studentDao.save(student);
	}
	
	
	/**
	 * Here we will set Community values to student object
	 * @param student
	 */
	private Student setCommunity(Student student) {
		String community = "";
		if(student.getCommunity1() != null && student.getCommunity1().length() > 0) {
			community = student.getCommunity1();
		}
		
		if(student.getCommunity2() != null && student.getCommunity2().length() > 0) {
			if(community.length() > 0) {
				community = community+",";
			}
			community = community+student.getCommunity2();
		}
		
		if(student.getCommunity3() != null && student.getCommunity3().length() > 0) {
			if(community.length() > 0) {
				community = community+",";
			}
			community = community+student.getCommunity3();
		}
		student.setCommunity(community);
		return student;
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	private Student splitCommunityAndSetCommunityVlues(Student student) {
		if(student.getCommunity() != null && student.getCommunity().length() > 0) {
			String communityValues[] =  student.getCommunity().split(",");
			for(int i=0 ; i < communityValues.length ; i++) {
				String commun = communityValues[i];
				System.out.println(commun);
				if("Spring".equals(commun)) {
					student.setCommunity1(commun);
				}else if("Structs".equals(commun)) {
					student.setCommunity2(commun);
				}else if("Hibernate".equals(commun)) {
					student.setCommunity3(commun);
				}
			}
		}
		return student;
	}
	
	@Override
	public Student findById(int id) {
		Student student =  studentDao.findById(id);

		student = splitCommunityAndSetCommunityVlues(student);
		
		return student;
		
	}

	@Override
	public int delete(int id) throws Exception{
		int returnValue = studentDao.delete(id);
		if(returnValue == 0) {
			throw new Exception("No record found to delete...");
		}else {
			return returnValue;
		}
	}

	
}
