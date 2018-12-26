package com.shangyu.home.pojo;

import java.util.List;

/**
 * 封装前端复杂参数的实体类
 */
public class PersonPojo {
    private String name;
    private Integer province;
    private Integer sex;
    private List<Integer> hobbyList;

    public List<Integer> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Integer> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonPojo{" +
                "name='" + name + '\'' +
                ", province=" + province +
                ", sex=" + sex +
                ", hobbyList=" + hobbyList +
                '}';
    }
}
