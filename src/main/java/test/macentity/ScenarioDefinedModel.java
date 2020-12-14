package test.macentity;

/**
 * RT_SCENARIO_DEFINED	业务场景配置表
 * @author lzj
 *
 */
public class ScenarioDefinedModel {
	
	private String id;
	private String subjectId;	//邮件模板Id
	private String mailConfigId;	//服务邮箱配置id
	private String identifyCode;	//识别码
	private String classPath;	//类路径
	private String remark;	//备注
	private String status;	//状态（Valid/invalid/discard	有效的/无效的/已废弃）
	private String createTime;	//创建时间
	private String modifyTime;	//修改时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getMailConfigId() {
		return mailConfigId;
	}
	public void setMailConfigId(String mailConfigId) {
		this.mailConfigId = mailConfigId;
	}
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "ScenarioDefinedModel [id=" + id + ", subjectId=" + subjectId + ", mailConfigId=" + mailConfigId
				+ ", identifyCode=" + identifyCode + ", classPath=" + classPath + ", remark=" + remark + ", status="
				+ status + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	

}
