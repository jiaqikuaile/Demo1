package test.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import test.macentity.MacContactModel;

public class ScheduledHelp {
public static CFMacCore findMacCore(String path,String filePath){
	
	String pathurl=path+"WEB-INF"+File.separator+filePath;
	//String pathurl=path+filePath;
	File file=new File(pathurl);
	System.out.println(file.exists());
	CFMacCore cor=new CFMacCore();
	try {
		SAXReader reader=new SAXReader();
		Document document=reader.read(new File(pathurl));
		Element root=document.getRootElement();
		String operationLevel=findElementValue(root,"operationLevel");
		String monitorLevel=findElementValue(root,"monitorLevel");
		String analyseEnable=findElementValue(root,"analyseEnable");
		String startDate=findElementValue(root,"startDate");
		String endDate=findElementValue(root,"endDate");
		String startTime=findElementValue(root,"startTime");
		String endTime=findElementValue(root,"endTime");
		List<Element> contLis=root.element("QAReceiver").elements();
		cor.setOperationLevel(operationLevel);
		cor.setMonitorLevel(Integer.parseInt(monitorLevel));
		cor.setAnalyseEnable(analyseEnable.equals("true")?true:false);
		cor.setStartDate(startDate);
		cor.setEndDate(endDate);
		cor.setStartTime(startTime);
		cor.setEndTime(endTime);
		List<MacContactModel> macCont=new ArrayList<MacContactModel>();
		for(Element en:contLis){
			MacContactModel co=new MacContactModel();
			String name=en.attribute("name").getValue();
			String mailAdr=en.attribute("mailAdr").getValue();
			String sendType=en.attribute("sendType").getValue();
			co.setContactName(name);
			co.setMailAdr(mailAdr);
			co.setSendType(sendType);
			macCont.add(co);
		}
		cor.setReceivers4qa(macCont);
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cor;
}
public static String findElementValue(Element root,String elementName){
	Element el=root.element(elementName);
	
	return el.getText();
}
public static void main(String[] args) {
	
}
}
