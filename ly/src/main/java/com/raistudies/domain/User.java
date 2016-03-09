package com.raistudies.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.jdbc.core.RowMapper;

@Entity
@Table(name = "db_user")
public class User implements RowMapper<User>, Serializable{
	
	private static final long serialVersionUID = 3647233284813657927L;
	@Id
	@GeneratedValue(generator = "system-uuid")  //使用uuid生成主键的方式  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")   
    @Column(length=32)
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
		return "User [id="+id+"+name=" + name + ", standard=" + standard + ", age=" + age
				+ ", sex=" + sex + "]";
	}
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setSex(rs.getString(sex));
		user.setId(rs.getString(id));
		user.setAge(rs.getString(age));
		user.setStandard(rs.getString(standard));
		
		return user;
	}
}
