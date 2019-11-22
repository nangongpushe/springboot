package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//在这类上面加上这个注解后，那么在方法上面就可以不再加了
@CacheConfig(cacheNames = "emp"/*,cacheManager = "employeeCacheManager"*/)
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将运行的结果进行缓存，以后再要相同的数据，直接从缓存中获取，不必调用方法
     * 注意：要使用缓存技术前提是把实体类实现序列化接口
     * cacheNames/value:指定缓存组件的名字，这两个用哪个都行，是返回结果放在缓存中，也可以指定多个缓存
     * key:缓存数据使用的key，可以用它来指定，默认是使用方法的返回值
     * KeyGenerator:key的生成器，可以自己指定key的生成器的组件id，它和key可以二选一来达到目的
     * cacheManager:指定缓存器，或者cacheResolver指定获取解析器
     * condition:指定符合条件下才会缓存
     * unless:否定缓存，当unless指定的条件为true时就不会缓存
     * sync:是否使用异步模式
     * 运行时机：这个注解是在调用方法之前先来判断缓存中有没有要查找的数据的
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"}/*,keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工号");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut:既调用方法又更新缓存数据，达到同步更新缓存的目的
     * 修改了数据库的某个数据，同时又更新缓存
     * 运行时机：
     *          1，先调用目标方法
     *          2，将目标方法的结果缓存起来
     *  这个想要起作用的话，前提必须是key的值和缓存时候用的一样
     *  运行时机：方法调用之后
     * @param employee
     * @return
     */
    @CachePut(/*value = "emp",*/key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * key:指定清除的数据
     * allEntries:表示把缓存中的数据全删了
     * beforeInvocation:表示缓存的清除是否在方法执行之前执行，默认是false，即方法执行之后执行，也可以改为true表示
     * 方法执行之前执行，这在方法是否出现异常之时非常有用
     * @param id
     */
    @CacheEvict(value = "emp",/*key = "#id",*/allEntries = true/*,beforeInvocation = true*/)
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
//        employeeMapper.deleteEmp(id);
    }

    /**
     * 这里如果用lastName来查的话还是会去查数据库的，因为有@CachePut注解在，它保证了方法一定要执行，所以会查数据库的
     * @param lastName
     * @return
     */
    @Caching(
        cacheable = {
          @Cacheable(/*value = "emp",*/key="#lastName")
        },
        put = {
                @CachePut(/*value = "emp",*/key = "#result.id"),
                @CachePut(/*value = "emp",*/key = "#result.email")
        }
    )
    public Employee getEmpByLastName(String lastName){
       return employeeMapper.getEmpByLastName(lastName);
    }
}
