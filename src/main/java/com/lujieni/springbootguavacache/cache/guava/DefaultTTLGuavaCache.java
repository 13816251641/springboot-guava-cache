package com.lujieni.springbootguavacache.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * @param <V>
 * @author 高佳
 * @ClassName: DefaultTTLRedisCache
 * @Description: TTL类型的缓存
 * @date 2015年4月22日 下午1:31:57
 */
@Data
@Slf4j
public class DefaultTTLGuavaCache<K, V> implements InitializingBean {

    /**
     * 日志类
     */
    private static final Log logger = LogFactory.getLog(DefaultTTLGuavaCache.class);

    /**
     * 数据提供者
     */
    protected ITTLGuavaCacheProvider<K, V> cacheProvider;

    /**
     * 超时时间,单位秒,默认10分钟
     */
    protected int timeOut = 10 * 60;

    /**
     * 缓存最大容量
     */
    protected int cacheMaximumSize;

    /**
     * 缓存实例
     */
    private LoadingCache<K, V> cache;

    /**
     * 从缓存获取数据方法
     * @param key
     * @return
     */
    public V get(K key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            logger.error(e);
        }
        return null;
    }

    /**
     * 失效指定数据
     * @param key
     * @author 陈宇霖
     * @date 2018年01月22日09:27:24
     */
    public void invalidate(K key) {
        cache.invalidate(key);
    }

    /**
     * 失效此缓存中所有数据，在数据更新时使用
     */
    public void invalidateAll() {
        cache.invalidateAll();
    }

    /**
     * 缓存实例
     * @return
     * @author 陈宇霖
     * @date 2018年01月22日09:20:28
     */
    public LoadingCache<K, V> initCache() {
        if (cache == null) {
            synchronized (this) {
                cache = CacheBuilder.newBuilder()
                        .maximumSize(getCacheMaximumSize())
                        .expireAfterWrite(getTimeOut(), TimeUnit.SECONDS)
                        .build(new CacheLoader<K, V>() {
                            @Override
                            public V load(K key) throws Exception {
                                return cacheProvider.get(key);
                            }
                        });
            }
        }
        return cache;
    }

    /**
     * 设置完相关属性之后初始化缓存
     * @throws Exception
     * @author 陈宇霖
     * @date 2018年01月22日09:24:57
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        initCache();
    }
}
