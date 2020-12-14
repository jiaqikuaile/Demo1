package test.scheduler.newModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import test.common.ExcelUtil;
import test.common.senMailUtil;
import test.issspdao.OracleDao;
import test.macdao.MysqlDao;
import test.macentity.MailService;
import test.macentity.ModelData;
import test.macentity.RTModelData;
import test.macentity.ScenarioDefinedModel;
import test.macentity.Subject;
import test.service.ConfigService;
import test.util.CFMacCore;
import test.util.ScheduledHelp;

@Component("sharyIQYRouter")
@Lazy(false)
public class SharyIQYRouter {
	private static final Logger LOG = LoggerFactory.getLogger(SharyIQYRouter.class);
	@Resource
	MysqlDao mysqlDao;
	@Resource
	OracleDao oracleDao;
	//private static final Logger LOG = LoggerFactory.getLogger(SharyIQYRouter.class);
	private static CFMacCore coreConf = null;
	private static final String core_conf_file = "conf/mac_core_conf.xml";

	// 定义优酷机型三个报备业务场景的识别码
	// 运行环境（"QA"/"PD"）
	private String status = "PD";

	private String identifyCode4Flnet = "IQYFN";
	@Scheduled(cron = "00 36 14 * * ??")
	public void macRoute() throws ClassNotFoundException {
		try {
		String basePath = this.getClass().getResource("/").getPath();
		int pos = basePath.indexOf("WEB-INF");
		 if(pos != -1){
			 basePath = basePath.substring(0, pos);		 
		 }
		 CFMacCore cfMac=ScheduledHelp.findMacCore(basePath, core_conf_file);
		 String startData=cfMac.getStartDate()+cfMac.getStartTime();
		 String endData=cfMac.getEndDate()+cfMac.getEndTime();
		 //获取服务场景
		 ScenarioDefinedModel  scenDefin=mysqlDao.findByIdentiftCode(identifyCode4Flnet);
		//获取邮件主题
		 Subject subject=mysqlDao.findByIdSelectSubject(scenDefin.getSubjectId());			 
		 //获取当日报备的机型
		 List<String> lis=oracleDao.findModel(startData, endData);
		 String[] strModel=new String[lis.size()];
		 int b=0;
		 for(String l:lis){
			 //strModel+="'"+l+"'"+",";
			 strModel[b]=l;
			 b++;
		 }
		/* if(!"".equals(strModel)){
			 strModel=strModel.substring(0,strModel.lastIndexOf(','));
		 }*/
		 List<String> listModel=mysqlDao.findModel(strModel, scenDefin.getId());
		 /*String model="";
		 for(String l:listModel){
			 model+="'"+l+"'"+",";
		 }
		 if(!"".equals(model)){
			 model=model.substring(0,model.lastIndexOf(','));
		 }else{
			 return;
		 }*/
		 String[] model=new String[listModel.size()];
		 int a=0;
		 for(String ll:listModel){
			 model[a]=ll;
			 a++;
		 }
		 //获取当天机型报备数据
		 List<ModelData> lisModelData=oracleDao.findModelData(startData,endData,model);		 
		//得到当天机型数
		 List<String> dangRiModel=oracleDao.findModelDataString(startData,endData,model);
		 Map<String,RTModelData> map=new HashMap<String,RTModelData>();	
		
		 for(String mol:dangRiModel){	
			 RTModelData rm=new RTModelData();
			 List<ModelData> list=new ArrayList<ModelData>();			 
			 for(ModelData ll:lisModelData){
				 if(ll.getMachineModelNo().equals(mol)){
					 list.add(ll);
				 }
			 }
			 rm.setMachineModel(mol);
			 rm.setSize(list.size());
			 rm.setModelData(list);
			 map.put(mol, rm);
			
		 }
		 //将数据保存Excel文件		 
		List<File> listFile=ExcelUtil.exeFile(basePath, map);
		/* List<File> listFile=new ArrayList<File>();
		 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60MY6150A-20201205164631.xlsx"));
		 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU470A-20201205162904.xlsx"));
		 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU675A-20201205164631.xlsx"));*/
		//获取邮件服务器
		MailService mailservice=mysqlDao.findMailServer(scenDefin.getMailConfigId());
		//发送邮件
		senMailUtil.sendMail(subject, cfMac, map, mailservice, listFile);
		//( Subject subject,CFMacCore cfMac,Map map,MailService mailservice)
	
		} catch (Exception e) {
			/*List<File> listFile=new ArrayList<File>();
			 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60MY6150A-20201205164631.xlsx"));
			 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU470A-20201205162904.xlsx"));
			 listFile.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU675A-20201205164631.xlsx"));
			// TODO Auto-generated catch block
			 for(File f:listFile){
				 LOG.error("listFilename---"+f.getName());
			 }*/
			LOG.error(e.getMessage());

		}
		 
	}
	//@Scheduled(cron = "*/5 * * * * ?")
	public void say(){
		
		
	}
	public static void main(String[] args) {
		System.out.println();
		String path="C:\\Users\\user\\Desktop\\mac_core_conf.xml";
		File file=new File(path);
		CFMacCore cc= ScheduledHelp.findMacCore(path, "");
		System.out.println(cc);
		
		
	}
}
