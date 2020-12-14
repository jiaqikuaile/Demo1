package test.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import test.macentity.ModelData;
import test.macentity.RTModelData;

public class ExcelUtil {
public static List<File> exeFile(String basePath,Map<String,RTModelData> map) throws Exception{
	List<File> listFile=new ArrayList<File>();
	
	SimpleDateFormat smt=new SimpleDateFormat("MM.dd");
	SimpleDateFormat smtfom=new SimpleDateFormat("yyyyMMddHHmmss");
	//Workbook workbook = WorkbookFactory.create(new File("demo.xlsx"));
	String path=basePath+File.separator+"WEB-INF"+File.separator+"temps"+File.separator+"sharp"+File.separator+"flnet"+File.separator+"sharp_IQY_3_flnet_template.xlsx";
	String outpath=basePath+File.separator+"WEB-INF"+File.separator+"mac4flnet"+File.separator+"valid"+File.separator+"商貿-F項目設備報備表for 富士康後台-富連網";
	File fil=new File(path);
	System.out.println(fil.exists());
	//FileInputStream fin=new FileInputStream(path);
	//Workbook workbook = WorkbookFactory.create(fin);

	Set<Entry<String, RTModelData>>  enty=map.entrySet();

	for(Entry<String, RTModelData> s:enty){
		int row=0;
		int cell=0;
		//Workbook workbook =WorkbookFactory.create(fil);
		FileInputStream fi=new FileInputStream(fil);
		Workbook workbook = new XSSFWorkbook(fi);
		workbook.setSheetName(0, smt.format(new Date())+"作业");
		Sheet sheet=workbook.getSheetAt(0);
		RTModelData rt=s.getValue();
		List<ModelData> moda=rt.getModelData();
		for(ModelData m:moda){
			Row ro=sheet.createRow(++row);
			ro.createCell(cell).setCellValue(m.getMachineModelNo());
			ro.createCell(++cell).setCellValue(m.getMachineSerialNo());
			ro.createCell(++cell).setCellValue(m.getMbmac());
			ro.createCell(++cell).setCellValue(m.getWifimac());
			ro.createCell(++cell).setCellValue(m.getEmmcid());
			ro.createCell(++cell).setCellValue(m.getExwDate());
			ro.createCell(++cell).setCellValue("GITV_IQIYI");
			ro.createCell(++cell).setCellValue("");
			ro.createCell(++cell).setCellValue(m.getHardwareModel());
			//ro.createCell(++cell).setCellValue("三期");
			ro.createCell(++cell).setCellValue("三期");
			ro.createCell(++cell).setCellValue("三期");
			if("VIP12MSDK".equals(m.getCdg1306Code())){
				ro.createCell(cell++).setCellValue("12");
			}else if("VIP0MSDK".equals(m.getCdg1306Code())){
				ro.createCell(cell++).setCellValue("0");
			}else if("VIP3MSDK".equals(m.getCdg1306Code())){
				ro.createCell(cell++).setCellValue("3");
			}else{
				ro.createCell(cell++).setCellValue("");
			}
			ro.createCell(cell++).setCellValue("夏普(SHARP)");
			cell=0;
			}	
		File fille=new File(outpath+s.getKey().toString()+"-"+smtfom.format(new Date())+".xlsx");
		FileOutputStream fos=new FileOutputStream(fille);
		listFile.add(fille);
		workbook.write(fos);		
		fos.close();
		fi.close();
		
	}
	return listFile;
	
}
public static void main(String[] args) {
	SimpleDateFormat smt=new SimpleDateFormat("MM.dd");
	int a=0;
	System.out.println(++a);
}
}
