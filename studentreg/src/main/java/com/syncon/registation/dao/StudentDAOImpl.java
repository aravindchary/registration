package com.syncon.registation.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syncon.registation.model.Student;

@Repository
public class StudentDAOImpl implements IStudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Student student) {
		System.out.println("Calling dao..");
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
		
	}

	@Override
	public void update(Student student) {
		System.out.println("Calling dao..");
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Student order by id desc").list();
	}

	@Override
	public Student findById(int id) {
		Session session = sessionFactory.openSession();
		Student stud = (Student) session.get(Student.class, id);
		return stud;
	}
	
	
	@Override
	public int delete(int id) {
		Session session  = sessionFactory.openSession();
		String deleteQuery = "delete from Student where id = :namedId";
		Query q = session.createQuery(deleteQuery).setParameter("namedId", id);
		int val = q.executeUpdate();
		System.out.println("deleted entities : "+val);
		return val;
	}
	
	/**
	 * this method will return student record if it exists with username
	 * @param userName
	 * @return
	 */
	@Override
	public Student findStudentByUserName(String userName2) {
		String query = "from Student where userName = :userName1";// named parameter
		Session session = sessionFactory.openSession();
		Query namedQuery = session.createQuery(query).setParameter("userName1", userName2);
		List<Student> studentList = namedQuery.list();
		if(studentList != null && studentList.size() > 0) {
			return studentList.get(0);
		}else {
			return null;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
