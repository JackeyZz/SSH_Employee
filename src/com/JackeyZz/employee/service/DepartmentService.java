package com.JackeyZz.employee.service;

import java.util.List;

import com.JackeyZz.employee.domain.Department;
import com.JackeyZz.employee.domain.PageBean;

/**
 * 部门业务层的接口
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
