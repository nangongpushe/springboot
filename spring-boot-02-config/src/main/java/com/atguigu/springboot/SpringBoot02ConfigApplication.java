package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource注解用来导入Spring的配置文件，让配置文件里面的内容生效
 * springboot里面并没有spring的配置文件，我们自己编写的配置文件也不能够自动识别；
 * 想让spring的配置文件生效，加载进来，就需要把这个注解加在下面的主配置类上
 */
//把下面的@ImportResource注解注释掉，就是为了采用springboot推荐的方式，这里已经不再导入beans.xml这个配置文件
//也即是说这个配置文件没有用了，而是要使用配置类的方式
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBoot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigApplication.class, args);
    }

    /**
     * 在xml文件里面配置端口号的写法如下
     * <server>
     *     <port>8081</port>
     * </server>
     * 以此可以与yml配置文件的写法进行对比，突出yml文件的便捷
     *
     *
     * yml配置文件的基本语法
     * k:(空格)v:表示一对键值对（空格必须有）
     * 以空格的缩进来控制层级关系；只要左对齐的一列数据都是同一个层级
     * 属性和值也是大小写敏感的
     *
     * 字面量：普通的值（数字，字符串和布尔）
     * k:v:字面直接来写
     * 字符串默认不用加上单引号或者双引号
     * 双引号不会去转义字符串里面的特殊字符；特殊字符会作为其本身想表达的意思
     * name:"zhangsan \n lisi" : 输出；zhangsan 换行 lisi
     * 单引号会转义特殊字符，特殊字符最终只是一个普通的字符串数据
     * name:"zhangsan \n lisi" : 输出；zhangsan \n lisi
     *
     * 对象，Map（属性和值）（键值对）
     * k:v:在下一行来写对象的属性和值的关系；要注意缩进
     *     对象还是k:v的方式
     *
     * friends:
     *         lastName: zhangsan
     *         age: 20
     * 也可以换成行内的写法
     * friends:{lastName: zhangsan,age: 18}
     *
     * 数组（List, Set）
     * 用-值来表示数组中的一个元素
     * pets:
     *  - cat
     *  - pig
     *  - dog
     *
     * 行内写法
     * pets: [cat,pig,dog]
     *
     */

}
