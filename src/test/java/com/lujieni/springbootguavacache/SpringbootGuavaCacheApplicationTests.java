package com.lujieni.springbootguavacache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lujieni.springbootguavacache.cache.guava.student.StudentGuavaCache;
import com.lujieni.springbootguavacache.damain.vo.StudentVO;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootGuavaCacheApplication.class)
public class SpringbootGuavaCacheApplicationTests {
    @Autowired
    private StudentGuavaCache studentGuavaCache;

    @Test
    public void test(){
        List<StudentVO> result1 = studentGuavaCache.get("范玮琪4");//k:范玮琪4 v:null
        System.out.println(result1);

        List<StudentVO> result2 = studentGuavaCache.get("范玮琪4");
        System.out.println(result2);
    }

    /**
     * guava的cache的比较标准是:
     * 先比较对象的hashCode方法,hashCode方法不同就不同
     * 如果hashCode相同再比较equals方法,如果equals相同那么就是相同的对象
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        LoadingCache<Domain, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<Domain, String>() {
            @Override
            public String load(Domain key) throws Exception {
                return "default";
            }
        });
        System.out.println(cache.get(new Domain(25)));
        System.out.println(cache.get(new Domain(30)));
        System.out.println(Domain.class.getName());
    }
}

@Data
class Domain{
    private Integer age;

    @Override
    public boolean equals(Object o) {
       return true;
    }

    public Domain(Integer age){
        this.age = age;
    }

    @Override
    public int hashCode() {
       return 2;
    }
}
