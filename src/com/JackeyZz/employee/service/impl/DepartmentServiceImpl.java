package com.JackeyZz.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JackeyZz.employee.dao.DepartmentDao;
import com.JackeyZz.employee.domain.Department;
import com.JackeyZz.employee.domain.PageBean;
import com.JackeyZz.employee.service.DepartmentService;
/**
 * ����ҵ����ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//ע�벿�Ź����DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	//��ҳ��ѯ���ŵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;	//ÿҳ��ʾ3��
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	//ҵ��㱣�沿�ŵķ���
	public void save(Department department) {
		departmentDao.save(department);
	}

	
	//ҵ�����ݲ���id��ѯ���ŵķ���
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	//ҵ���ʵ�ֵĲ��Ÿ��·���
	public void update(Department department) {
		departmentDao.update(department);
	}

	
	//ҵ���ɾ�����ŵķ���
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
}
