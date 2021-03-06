package com.JackeyZz.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JackeyZz.employee.dao.DepartmentDao;
import com.JackeyZz.employee.domain.Department;
import com.JackeyZz.employee.domain.PageBean;
import com.JackeyZz.employee.service.DepartmentService;
/**
 * 部门业务层的实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//注入部门管理的DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	//分页查询部门的方法
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;	//每页显示3条
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	//业务层保存部门的方法
	public void save(Department department) {
		departmentDao.save(department);
	}

	
	//业务层根据部门id查询部门的方法
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}

	//业务层实现的部门更新方法
	public void update(Department department) {
		departmentDao.update(department);
	}

	
	//业务层删除部门的方法
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
}
