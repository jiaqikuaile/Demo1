package test.issspentity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Justin.Ray
 * 1. Data retrieved from Central DataWareHouse by WebService
 * 2. Data retrieved from Authorized DataSource[ISSSP]
 */
public class RTMacData {

	private String macModelNo; 		// 产品型号
	private String sn; 				// 产品序列
	private String mbmac; 			// 有线mac
	private String wifimac; 		// 无线mac
	private String membership; 		// 会员序列号
	private String emmcId; 			// EMMC ID
	private String createDate; 		// 创建日期
	private String extDate; 		// 生产出货日期
	private String uuid; 			// UUID
	private String hmodel; 			// 硬件型号;
	private String factoryId; 		// 公司代码：NJ/YT/FS/NH/LH/BJ		南京、烟台、佛山、南海、龙华、北京
	private String contentPro; 		// 内容方代码：IQY/YouKu/PPTV
	private String shipping_model;	// 出货类型：1-新机	2-二次出货	 3-整新机
	private Date upload_date;		// 上传时间
	
	private int size; 				// 尺寸
	
	//2018.06.01:新增权益编码，权益名称，品牌编码，品牌名称四个字段
	private String cdg1201Code;    //品牌编码
	private String cdg1201Name;	//品牌名称
	
	private String cdg1306Code;	//权益编码
	private String cdg1306Name;	//权益名称

	public String getMacModelNo() {
		return macModelNo;
	}
	public void setMacModelNo(String macModelNo) {
		this.macModelNo = macModelNo;
	}

	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getMbmac() {
		return mbmac;
	}
	public void setMbmac(String mbmac) {
		this.mbmac = mbmac;
	}

	public String getWifimac() {
		return wifimac;
	}
	public void setWifimac(String wifimac) {
		this.wifimac = wifimac;
	}

	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getEmmcId() {
		return emmcId;
	}
	public void setEmmcId(String emmcId) {
		this.emmcId = emmcId;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getExtDate() {
		return extDate;
	}
	public void setExtDate(String extDate) {
		this.extDate = extDate;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getHmodel() {
		return hmodel;
	}
	public void setHmodel(String hmodel) {
		this.hmodel = hmodel;
	}

	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getContentPro() {
		return contentPro;
	}
	public void setContentPro(String contentPro) {
		this.contentPro = contentPro;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// 2017.9.26 new shipping model
	public String getShipping_model() {
		return shipping_model;
	}
	public void setShipping_model(String shipping_model) {
		this.shipping_model = shipping_model;
	}
	
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	
	public String getCdg1201Code() {
		return cdg1201Code;
	}
	public void setCdg1201Code(String cdg1201Code) {
		this.cdg1201Code = cdg1201Code;
	}
	public String getCdg1201Name() {
		return cdg1201Name;
	}
	public void setCdg1201Name(String cdg1201Name) {
		this.cdg1201Name = cdg1201Name;
	}
	public String getCdg1306Code() {
		return cdg1306Code;
	}
	public void setCdg1306Code(String cdg1306Code) {
		this.cdg1306Code = cdg1306Code;
	}
	public String getCdg1306Name() {
		return cdg1306Name;
	}
	public void setCdg1306Name(String cdg1306Name) {
		this.cdg1306Name = cdg1306Name;
	}
	
	//原始数据转dto类型
	/*public static RTMacData getMacData(RTMachineSerial machineSerial){
		if(machineSerial == null){
			return null;
		}
		RTMacData rtd = new RTMacData();
		rtd.setMacModelNo(machineSerial.getMachine_model_no());
		rtd.setSn(machineSerial.getMachine_serial_no());
		rtd.setMbmac(machineSerial.getMbmac());
		rtd.setWifimac(machineSerial.getWifimac());
		rtd.setMembership(machineSerial.getMemebership());
		rtd.setEmmcId(machineSerial.getEmmcid());
		rtd.setCreateDate(machineSerial.getCreate_date());
		rtd.setUuid(machineSerial.getId());
		rtd.setHmodel(machineSerial.getHardware_model());
		rtd.setFactoryId(machineSerial.getMacfactory_id());
		rtd.setContentPro(machineSerial.getContent_supplier());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		rtd.setExtDate(machineSerial.getExw_date() != null ? sdf.format(machineSerial.getExw_date()) : null);
		rtd.setShipping_model(machineSerial.getShipping_model());
		rtd.setUpload_date(machineSerial.getUpload_date());
		
		String sizeStr = "";
		String macModelNo = machineSerial.getMachine_model_no();
		if(Character.isDigit(macModelNo.charAt(6))){
			sizeStr = macModelNo.substring(4, 7);
		}else{
			sizeStr = macModelNo.substring(4, 6);
		}
		rtd.setSize(Integer.parseInt(sizeStr));
		return rtd;
	}*/
	
}
