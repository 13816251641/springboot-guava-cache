package com.lujieni.springbootguavacache.cache.guava.student;

import com.lujieni.springbootguavacache.cache.guava.ITTLGuavaCacheProvider;
import com.lujieni.springbootguavacache.damain.vo.StudentVO;
import com.lujieni.springbootguavacache.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGuavaCacheProvider implements ITTLGuavaCacheProvider<String, List<StudentVO>> {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<StudentVO> get(String key) {
        return studentDao.findStudentByName(key);
    }
}