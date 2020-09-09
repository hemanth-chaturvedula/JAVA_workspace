package com.base.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
import com.base.beans.Athlete;

public class AthleteDao {
	JdbcTemplate template;    
    private int getMaxId() {
    	String sql = "select max(athlete_id) from thlete;";
    	return template.queryForObject(sql,Integer.class);
    }
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Athlete a){
		a.setId(getMaxId()+1);
	    String sql="insert into athlete(athlete_id, athlete_name,athlete_gender, category, athlete_email, athlete_mobile)  values('"+a.getId()+"',"+a.getName()+",'"+a.getGender()+",'"+a.getCategory()+",'"+a.getEmail()+",'"+a.getMobile_number()+"')";    
	    return template.update(sql);    
	}    
	public int update(Athlete a){    
	    String sql="update athlete set athlete_name='"+a.getName()+"', athlete_gender="+a.getGender()+",category='"+a.getCategory()+",athlete_email='"+a.getEmail()+",athlete_mobile='"+a.getMobile_number()+"' where athlete_id="+a.getId()+"";    
	    return template.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from athlete where athlete_id="+id+"";    
	    return template.update(sql);    
	}    
	public Athlete getAthleteById(int id){    
	    String sql="select * from athlete where athlete_id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Athlete>(Athlete.class));    
	}
	public List<Athlete> getAthletes(){    
	    return template.query("select * from athlete",new RowMapper<Athlete>(){    
	        public Athlete mapRow(ResultSet rs, int row) throws SQLException {    
	            Athlete e=new Athlete();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setGender(rs.getString(3));
	            e.setCategory(rs.getString(4));
	            e.setEmail(rs.getString(5));
	            e.setMobile_number(rs.getLong(6));
	            return e;    
	        }    
	    });    
	}    
}