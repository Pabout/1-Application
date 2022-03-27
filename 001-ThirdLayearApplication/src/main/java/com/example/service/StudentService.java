package com.example.service;

import com.example.vo.PageInfo;
import com.example.entity.Student;

//业务层接口
public interface StudentService {

    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
