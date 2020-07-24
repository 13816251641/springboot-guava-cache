package com.lujieni.springbootguavacache.cache.guava;

/**
 * @author 陈宇霖
 * @version V1.0
 * @Title ITTLGuavaCacheProvider
 * @Package com.hoau.pisces.cache.guava
 * @Description 定时失效缓存数据提供者
 * @date 2018/1/22 09:17
 */
public interface ITTLGuavaCacheProvider<K, V> {

    /**
     * 根据key获取缓存数据的获取方法
     * @param key
     * @return
     * @author 陈宇霖
     * @date 2018年01月22日09:18:27
     */
    V get(K key);
}
