package model;

import java.util.Objects;

public class User {

    private long id;
    private String password;
    private String name;
    private String country;
    private Integer age;

    public User() {}

    public User(String name, String password, String country, int age) {
        this.setName(name);
        this.setCountry(country);
        this.setPassword(password);
        this.setAge(age);
    }


    public User(Long id, String name, String password, String country, Integer age) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
        this.setCountry(country);
        this.setAge(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return String.format("id => %s\nname => %s\ncountry => %s\n", id, name, country);
    }
}
