package com.JackeyZz.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.JackeyZz.employee.dao.DepartmentDao;
import com.JackeyZz.employee.domain.Department;
import com.JackeyZz.employee.domain.Employee;
import com.JackeyZz.employee.util.HibernateUtil;
/*
 * ���Ź���DAO���ʵ����
 */
public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	
	//ͳ���ܵ���Ŀ
	public int findCount() {
		String hql = "select count(*) from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.setCacheable(true).uniqueResult()).intValue();
		if(count > 0 ) {
			//System.out.println(count);
			return count;
		}
		hibernateUtil.closeSession(session);
		return 0;
	}

	@SuppressWarnings("unchecked")
	
	//��ѯÿҳ��ʾ������
	public List<Department> findByPage(int begin, int pageSize) {
		String hql = "from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//������λ�ð󶨲�ѯ����
		System.out.println(begin);
		System.out.println(pageSize);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}

	
	//DAO��ʵ�ִ洢���ŵķ���
	public void save(Department department) {
		session = hibernateUtil.getSession();
		session.save(department);
		hibernateUtil.closeSession(session);
	}

	
	//DAO�и��ݲ���id��ѯ����
	public Department findById(Integer did) {
		session = hibernateUtil.getSession();
		Department department = (Department) session.get(Department.class, did);
		hibernateUtil.closeSession(session);
		return department;
	}

	
	//DAO���޸Ĳ��ŵķ���
	public void update(Department department) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(department);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	
	//DAO��ɾ�����ŵķ���
	public void delete(Department department) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(department);
		transaction.commit(); 
		hibernateUtil.closeSession(session);
	}

	
	//��ѯ���в��ŵķ���
	public List<Department> findAll() {
		String hql = "from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Department> list = query.list(); 
		hibernateUtil.closeSession(session);
		return list;
	}
}
