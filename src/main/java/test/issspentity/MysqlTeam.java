package test.issspentity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



/**用于封装团信息:
 * 业务:一个项目下可以有多个团
 * 表关系:one2many
 * 表设计:关联字段projectId
 * 应该添加多的一端,例如在tms_teams表中添加projectId
 * */
public class MysqlTeam implements Serializable{
	private static final long serialVersionUID = 368009064732092303L;
   private String id;
   private String name;
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
@Override
public String toString() {
	return "MysqlTeam [id=" + id + ", name=" + name + "]";
}
   
    
}
