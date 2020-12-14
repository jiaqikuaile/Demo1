package test.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.macentity.MacContactModel;
import test.macentity.MailService;
import test.macentity.RTModelData;
import test.macentity.Subject;
import test.scheduler.newModel.SharyIQYRouter;
import test.util.CFMacCore;

public class senMailUtil {
	private static final Logger LOG = LoggerFactory.getLogger(senMailUtil.class);
public static void sendMail( Subject subject,CFMacCore cfMac, Map<String,RTModelData> map,MailService mailservice,List<File> listFile){
	try {
		//String s1=null;
		//System.out.println(s1.getBytes());
	SimpleDateFormat smf=new SimpleDateFormat("MM.dd");
	Properties prop=new Properties();
	prop.setProperty("mail.host", mailservice.getHost());
	prop.setProperty("mail.transport.protocol", "smtp");
	prop.setProperty("mail.smtp.auth", "true");
	
	 List<MacContactModel> listToCC=cfMac.getReceivers4qa();
	// Map<String,MacContactModel> mapContac=new HashMap<String,MacContactModel>();
	 List<MacContactModel> listTo=new ArrayList<MacContactModel>();
	 List<MacContactModel> listCc=new ArrayList<MacContactModel>();
	 /*for(MacContactModel ll:listToCC){
		 if("TO".equals(ll.getSendType())){
			 listTo.add(ll);
		 }else{
			 listCc.add(ll);
		 }
	 }*/
	 //listTo
	 InternetAddress[] addsTo=new InternetAddress[1];
	 addsTo[0]=new InternetAddress("jia-qi.rao@mail.foxconn.com");
	 InternetAddress[] addsCC=new InternetAddress[2];
	 addsCC[0]=new InternetAddress("jia-qi.rao@mail.foxconn.com");
	 addsCC[1]=new InternetAddress("13662582643@163.com");
	 /*Set<Entry<String, MacContactModel>> setCon=mapContac.entrySet();
	 for(Entry<String, MacContactModel> s:setCon){
		 s.getKey()
	 }*/
	
		Session session=Session.getInstance(prop);
		Transport ts=session.getTransport();
		ts.connect("mail.sharp.cn", "sut_service@sharp.cn", "shG5H9W7AS");
		MimeMessage message=new MimeMessage(session);
		//设置消息头 
		//message.setFrom();
		message.setFrom(new InternetAddress("mail.sharp.cn"));
		message.setRecipients(Message.RecipientType.TO, addsTo);
		message.setRecipients(Message.RecipientType.CC, addsCC);
		message.setSubject(subject.getMailSubject().replace("{date}", smf.format(new Date())));
		//message.setSubject(MimeUtility.encodeText( "UTF-8"));
		MimeBodyPart text = new MimeBodyPart();
		String content="";
		Set<Entry<String, RTModelData>> ent=map.entrySet();
		for(Entry<String, RTModelData> s:ent){
			RTModelData rt=s.getValue();
			content+=rt.getMachineModel()+":"+rt.getSize()+"台"+"(三期)"+"\n";
		}
		text.setContent(content, "text/html;charset=UTF-8");
		//描述关系
		MimeMultipart mm=new MimeMultipart();
		mm.setSubType("related");
		mm.addBodyPart(text);
		//添加附件
		for(File llFi:listFile){
			MimeBodyPart attachPart=new MimeBodyPart();
			attachPart.attachFile(llFi);
			attachPart.setFileName(MimeUtility.encodeText(llFi.getName()));
			mm.addBodyPart(attachPart);
		}
		message.setContent(mm);
		message.saveChanges();
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		for(File f:listFile){
			LOG.error(f.exists()+f.getName());
		}
		LOG.error(e.getMessage());
		LOG.error(e.toString()+"--------");
		LOG.error(CC.getStackTraceString(e));
		e.printStackTrace();
	}
	
	
}

}
