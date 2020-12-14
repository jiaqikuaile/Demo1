package test.util;

import java.util.List;

import test.macentity.MacContactModel;



/**
 * @author Justin.Ray
 * MAC报备主配置文件
 */
public class CFMacCore {
	private static final String OP_LVL_QA = "QA";
	private static final String OP_LVL_PD = "PD";
	
	private static final int MNT_LVL_NONE = 0;
	private static final int MNT_LVL_ONE = 1;
	private static final int MNT_LVL_TWO = 2;
	
	private static final String DEF_TIME = "080000";
	
	// **************************** 配置部分
	private int monitorLevel = MNT_LVL_NONE;		// 0/1/2/3 	作业监控/数据异常处理 级别 
	
	private boolean analyseEnable = false;			// [作业开关]日运营统计作业
	
	//2018.02.28
	private String operationLevel = OP_LVL_QA;		// QA/PD
	private List<MacContactModel> receivers4qa = null;
	private String startDate;
	private String endDate;
	private String startTime = DEF_TIME;
	private String endTime = DEF_TIME;
	 
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOperationLevel() {
		return operationLevel;
	}
	public void setOperationLevel(String operationLevel) {
		this.operationLevel = operationLevel;
	}
	public int getMonitorLevel() {
		return monitorLevel;
	}
	public void setMonitorLevel(int monitorLevel) {
		this.monitorLevel = monitorLevel;
	}

	public boolean isAnalyseEnable() {
		return analyseEnable;
	}
	public void setAnalyseEnable(boolean analyseEnable) {
		this.analyseEnable = analyseEnable;
	}
	public List<MacContactModel> getReceivers4qa() {
		return receivers4qa;
	}
	public void setReceivers4qa(List<MacContactModel> receivers4qa) {
		this.receivers4qa = receivers4qa;
	}
	@Override
	public String toString() {
		return "CFMacCore [monitorLevel=" + monitorLevel + ", analyseEnable=" + analyseEnable + ", operationLevel="
				+ operationLevel + ", receivers4qa=" + receivers4qa + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
