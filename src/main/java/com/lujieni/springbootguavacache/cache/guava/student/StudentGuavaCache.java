package com.lujieni.springbootguavacache.cache.guava.student;

import com.lujieni.springbootguavacache.cache.guava.DefaultTTLGuavaCache;
import com.lujieni.springbootguavacache.damain.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentGuavaCache extends DefaultTTLGuavaCache<String, List<StudentVO>> {

    @Autowired
    private StudentGuavaCacheProvider studentGuavaCacheProvider;

    @Override
    public void afterPropertiesSet() throws Exception {
        setCacheMaximumSize(20000);
        setCacheProvider(studentGuavaCacheProvider);
        setTimeOut(10 * 60);
        super.afterPropertiesSet();
    }
}