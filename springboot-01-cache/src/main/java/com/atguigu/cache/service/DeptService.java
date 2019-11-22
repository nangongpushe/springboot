package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    //明确指定使用deptCacheManager这个缓存处管理器
    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    /**
     * 缓存的数据能够存入redis
     * 第二次从缓存中查询就不能够反序列化回来
     * 因为反序列化只是配置了Employee，并没有
     * 配置Department
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门："+ id);
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    }

    //下面的代码和上面注释掉的效果是一样的，只不过使用的缓存方法不同罢了
    public Department getDeptById(Integer id){
        System.out.println("查询部门："+ id);
        Department department = departmentMapper.getDeptById(id);
        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1",department);
        return department;
    }
}
