package test.macentity;

import java.util.Date;

public class Subject {
 private String id;
 private String mailSubject;
 private String status;
 private String remark;
 private String classPath;
 private String subjectContent;
 private Date createTime;
 private Date modifyTime;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMailSubject() {
	return mailSubject;
}
public void setMailSubject(String mailSubject) {
	this.mailSubject = mailSubject;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getClassPath() {
	return classPath;
}
public void setClassPath(String classPath) {
	this.classPath = classPath;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Date getModifyTime() {
	return modifyTime;
}
public void setModifyTime(Date modifyTime) {
	this.modifyTime = modifyTime;
}

public String getSubjectContent() {
	return subjectContent;
}
public void setSubjectContent(String subjectContent) {
	this.subjectContent = subjectContent;
}
@Override
public String toString() {
	return "Subject [id=" + id + ", mailSubject=" + mailSubject + ", status=" + status + ", remark=" + remark
			+ ", classPath=" + classPath + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
}
 
}
