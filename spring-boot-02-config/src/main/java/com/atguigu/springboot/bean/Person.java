package com.atguigu.springboot.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties用来告诉springboot将本类中的所有属性
 * 与配置文件中的相关配置进行绑定
 * prefix = "person"；配置文件中那个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能够容器提供的@ConfigurationProperties功能
 * 因此必须要加上@Component这个注解，否则的话@ConfigurationProperties会被标红的
 */

@Component
//除了使用@ConfigurationProperties注解来绑定配置文件来获取值的方法外还可以用下面@Value注解，在此将其注释掉，用下面的来绑定值
/**
 * @ConfigurationProperties和@Value的比较
 * @ConfigurationProperties批量注入配置文件中的属性，但是@Value只能够一个一个的注入
 * @ConfigurationProperties支持松散语法绑定，而@Value不支持，也就是说当配置文件中的写法为person.last-name=张三时
 * 使用@Value注解进行配置时只能够这样写@Value("${person.last-name}")，而不能够写成这样@Value("${person.lastName}")，
 * 否则就会报错。但是@ConfigurationProperties就能够做到，例如private String lastName这样写也不会报错
 * @Value支持这种写法@Value("#{11*2}")，但是@ConfigurationProperties不支持，如果在配置文件里面这样写的话person.age=#{11*2}，
 * 是会报错的，也就是说@ConfigurationProperties不支持SpEL，@Value支持
 *
 * @ConfigurationProperties支持JSR303数据校验，例如下面加上了@Validated这个注解，然后在 private String lastName;上加上@Email
 * 这个注解，那么lastName的填写格式就得按照邮箱的格式，否则就会报错，但是在@Value这个注解下，这个校验是不起作用的，也就是说@Value
 * 并不支持JSR303数据校验
 *
 * @Value注解并不支持复杂类型的封装，在下面的private Map<String, Object> maps;上加注解@Value("${person.maps}")并不能够带过来值
 * 会报错的
 *
 */
/**
 *@PropertySource(value = {"classpath:person.properties"})用来加载指定的配置文件
 */
//@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

//    @Value("${person.last-name}")
//    @Email
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
