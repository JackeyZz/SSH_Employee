package com.JackeyZz.employee.dao;

import java.util.List;

import com.JackeyZz.employee.domain.Department;

/*
 * ���Ź����DAO��ӿ�
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
