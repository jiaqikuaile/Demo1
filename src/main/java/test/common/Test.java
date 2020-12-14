package test.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Test {
public static void main(String[] args) {
	try {
		List<File> listFi=new ArrayList<File>();
		listFi.add(new File("C:\\Users\\user\\Desktop\\123\\商貿-F項目設備報備表for 富士康後台-富連網LCD-60MY6150A-20201205164631.xlsx"));
		listFi.add(new File("C:\\Users\\user\\Desktop\\123\\商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU470A-20201205162904.xlsx"));
		listFi.add(new File("C:\\Users\\user\\Desktop\\123\\商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU675A-20201205164631.xlsx"));
		
		SimpleDateFormat smf=new SimpleDateFormat("MM.dd");
		/*Properties prop=new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.port", "25");*/
		//创建连接对象 连接到邮件服务器
        Properties prop = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        prop.setProperty("mail.host", "smtp.163.com");
        //发送端口
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.port", "25");
        prop.setProperty("mail.smtp.auth", "true");
        //prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		InternetAddress[] addsTo=new InternetAddress[2];
		 addsTo[0]=new InternetAddress("jia-qi.rao@mail.foxconn.com");
		 addsTo[1]=new InternetAddress("1753706447@qq.com");
		 InternetAddress[] addsCC=new InternetAddress[2];
		 addsCC[0]=new InternetAddress("jia-qi.rao@mail.foxconn.com");
		 addsCC[1]=new InternetAddress("1753706447@qq.com");
		 Session session=Session.getInstance(prop);
		 Transport trans=session.getTransport();
		 MimeMessage mime=new MimeMessage(session);
		 mime.setFrom(new InternetAddress("smtp.163.com"));
		 //mime.setReplyTo(addsTo);
		 mime.setRecipients(RecipientType .CC, addsCC);
		 mime.setRecipients(RecipientType .TO, addsTo);
		 mime.setSubject("TEST MY MAIL");
		 MimeMultipart mip=new MimeMultipart();
		 MimeBodyPart bo=new MimeBodyPart();
		 bo.setContent("20201210", "text/html;charset=UTF-8");
		 mip.addBodyPart(bo);
		 mime.setContent(mip);
		 mime.saveChanges();
		 trans.connect("13662582643@163.com", "rjq512512a");
		 trans.sendMessage(mime, mime.getAllRecipients());
		 
		 trans.close();
		 System.out.println("OK");
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
