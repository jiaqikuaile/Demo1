package test.macentity;

/**
 * 联系人信息表-RT_MAC_CONTACT
 * @author Leif
 *
 */
public class MacContactModel {
	
	private String id;
	private String mailAdr;	//邮件地址
	private String sendType;	//默认发送类型（主送/抄送TO/CC）
	private String contactName;	//联系人姓名
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
	public String getMailAdr() {
		return mailAdr;
	}
	public void setMailAdr(String mailAdr) {
		this.mailAdr = mailAdr;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
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
		return "MacContactModel [id=" + id + ", mailAdr=" + mailAdr + ", sendType=" + sendType + ", contactName="
				+ contactName + ", remark=" + remark + ", status=" + status + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + "]";
	}
	
}
