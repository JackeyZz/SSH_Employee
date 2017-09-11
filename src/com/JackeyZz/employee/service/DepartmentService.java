package com.JackeyZz.employee.service;

import java.util.List;

import com.JackeyZz.employee.domain.Department;
import com.JackeyZz.employee.domain.PageBean;

/**
 * ����ҵ���Ľӿ�
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
