package test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import test.issspdao.OracleDao;
import test.macdao.MysqlDao;
import test.macentity.ScenarioDefinedModel;
@RequestMapping("/type/")
//@Controller
@Component
@Lazy(false)
public class TestController {
	@Resource
	private MysqlDao mysqlDao;
	@RequestMapping("doTest")
	@ResponseBody
	public void doFindGridTreeObjects(){
		ScenarioDefinedModel em=mysqlDao.findByIdentiftCode("IQYFN");
		System.out.println(em);
	}
	//@Scheduled(cron = "*/5 * * * * ??")
	public void say(){
		System.out.println(123+"-------------------");
		System.out.println(123+"-------------------");
		System.out.println(123+"-------------------");
		System.out.println("222222222222222222222222222");
		
	}
	
	@RequestMapping("do")
	public void test(HttpServletResponse response,HttpServletRequest _request){
		try{
		
		Map<String, Object> parameters = new HashMap<String,Object>();//头部文件
		//Iterator<P12335doExport> countHeader=tempfile.iterator();
						
			parameters.put("countPoAmount", "A");
			parameters.put("venderName", "B");//供应商
			parameters.put("receiveStore", "C");
			parameters.put("countOrderQty", "D");
			parameters.put("supplierNameFind", "E");//供应商
			parameters.put("orderCode", "F");//订单编号
			Date orderDate =new Date();
			String orderDateStr="";
			
			parameters.put("orderDate", orderDate.toString());//订单日期
			parameters.put("paymentName", "G");//付款条件
			parameters.put("feeCode", "H");//PRICE TERM
			parameters.put("currency", "RMB");//币别
			parameters.put("monthCount", "36");//保固期
			List<Map> dataset=new ArrayList<Map>();
			int s=0;
			for(int i=0;i<3;i++){
				Map m=new HashMap();
				m.put("itemNo", s+"");
				m.put("orderCode", "A"+i);
				m.put("orderCodeNum", "B"+i);
				m.put("productName", "C"+i);
				m.put("productCode", "D"+i);
				m.put("orderQty", i);
				m.put("price", i);
				m.put("poAmount", i);
				s++;
				dataset.add(m);
			}
			parameters.put("dataset1",new JRBeanCollectionDataSource(dataset));
			String jasperPath="C:\\Users\\user\\Desktop\\ireport\\P12333_zh_CN.jasper";
		    //System.out.println(new File(jasperPath).exists());
            List detailList=new ArrayList();
            detailList.add(new HashMap());//不加会报错
		    File jasperFile=new File(jasperPath);
		    JasperReport jasperReport = (JasperReport)JRLoader.loadObject(jasperFile);
		    JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport,parameters);//,new JRBeanCollectionDataSource(detailList,false));
		    File tempfile = File.createTempFile("P12333", ".pdf");
			FileOutputStream fos = new FileOutputStream(tempfile);
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, fos);
			exporter.exportReport();
			//
			String fileName = "SUT PO SO签核" + ".pdf";
			String mimeType= "application/pdf";
			responseFile(tempfile, fileName, mimeType,response,_request);
			tempfile.delete();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	protected void responseFile(File tempfile, String fileName, String mimeType,HttpServletResponse _response,HttpServletRequest _request) throws Exception {
		FileInputStream inputStream = new FileInputStream(tempfile);
		//String mimeType= URLConnection.guessContentTypeFromName(fileName);
		if(fileName == null) {
			fileName = tempfile.getName();
		}
		if (mimeType == null) {
			mimeType = javax.activation.FileTypeMap.getDefaultFileTypeMap().getContentType(tempfile);
			if(mimeType == null) {
				mimeType = "application/octet-stream";
			}
		}
		_response.setContentType(mimeType);
		_response.setContentLength((int) tempfile.length());
		//
		String header=_request.getHeader("user-agent");
		String encodedName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
		if(header.contains("AppleWebKit") 
				|| header.contains("Chrome")
				|| header.contains("Safari")
				|| header.contains("Firefox")) {
			encodedName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
		}
		else {
			encodedName = java.net.URLEncoder.encode(fileName,"UTF-8");
			encodedName = encodedName.replace("%20","+");
		}
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", encodedName);
		//String headerValue = String.format("attachment; filename=\"%s\"", new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
		//String headerValue = String.format("attachment; filename=\"%s\"", java.net.URLEncoder.encode(fileName, "UTF-8"));
		System.out.println("headerValue: " + headerValue);
		_response.setHeader(headerKey, headerValue);
		_response.setHeader("x-filename", encodedName);
		OutputStream outStream = _response.getOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead = -1;
		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}
}
