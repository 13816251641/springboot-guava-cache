package com.lujieni.springbootguavacache.dao;

import com.lujieni.springbootguavacache.damain.po.StudentPO;
import com.lujieni.springbootguavacache.damain.vo.StudentVO;
import com.lujieni.springbootguavacache.mybatis.basedao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends BaseDao<StudentPO> {
        /**
         * 在接口中如果方法的入参只有一个参数,那么无论你起
         * 什么名字,在对应的xml中随便拿一个#{随便}即可对上,
         * 因为你只有一个入参
         * @param name123
         */
        List<StudentVO> findStudentByName(String name123);

        /**
         * 如果入参是多个字段的话,arg是从0开始 param是从1开始
         * Available parameters are [arg0,arg1,param1,param2]
         *
         * 当然更为推荐的是使用@Param指定入参的名称
         *
         * 根据id批量更新gender字段
         * @param id
         * @param gender
         * @return
         */
        Integer updateGenderByIdInBatch(@Param("id") List<String> id, @Param("gender") String gender);

        /**
         * 根据名字模糊查询
         * @param name
         * @return
         */
        List<StudentPO> searchByName(@Param("name") String name);

}
