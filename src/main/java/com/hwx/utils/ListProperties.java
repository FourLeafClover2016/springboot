package com.hwx.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

/**
 * @author: Huawei Xie
 * @date: 2019/5/6
 */
@Configuration
@PropertySource("classpath:listmap.properties")
@ConfigurationProperties(prefix = "http.url")
public class ListProperties {
    private List<String> list = new ArrayList<>();

    private List<String> apple = new ArrayList<>();

    private Map<String, String> people = new HashMap<>();

    private Map<String, String> student = new HashMap<>();

    private Set<String> set = new HashSet<>();

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getApple() {
        return apple;
    }

    public void setApple(List<String> apple) {
        this.apple = apple;
    }

    public Map<String, String> getStudent() {
        return student;
    }

    public void setStudent(Map<String, String> student) {
        this.student = student;
    }

    public Map<String, String> getPeople() {
        return people;
    }

    public void setPeople(Map<String, String> people) {
        this.people = people;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
