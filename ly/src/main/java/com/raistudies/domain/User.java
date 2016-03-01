package com.raistudies.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "db_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 3647233284813657927L;
	@Id
	@GeneratedValue(generator = "system-uuid")  //使用uuid生成主键的方式  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")   
    @Column(length=64)
	private String id;
	@Basic
	@Column( name = "name" )
	private String name = null;
	@Basic
	private String standard = null;
	@Basic
	private String age;
	@Basic
	private String sex = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", standard=" + standard + ", age=" + age
				+ ", sex=" + sex + "]";
	}
}
