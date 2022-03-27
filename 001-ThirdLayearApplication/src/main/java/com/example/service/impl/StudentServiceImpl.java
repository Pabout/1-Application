package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImpl;
import com.example.vo.PageInfo;
import com.example.entity.Student;
import com.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    //业务逻辑层依赖数据访问层
    StudentDao studentDao=new StudentDaoImpl();

    @Override
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        int totalCount=studentDao.getTotalCount();
        List<Student> list=studentDao.getList(pageNo,pageSize);

        PageInfo<Student> PageInfo = new PageInfo<>(totalCount,pageSize,pageNo,list);
        return null;
    }
}
