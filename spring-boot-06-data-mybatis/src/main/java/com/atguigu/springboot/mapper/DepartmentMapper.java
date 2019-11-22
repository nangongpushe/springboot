package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
//注释掉下面的注解是因为在主配置类上面有@MapperScan(value = "com.atguigu.springboot.mapper")这个注解
//因为在mapper多的情况下，在每一个mapper上都写上@Mapper这个注解太过麻烦，所以直接用包扫描替代了
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
