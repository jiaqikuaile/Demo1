package test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.common.ExcelUtil;
import test.common.senMailUtil;
import test.issspdao.OracleDao;
import test.macdao.MysqlDao;
import test.macentity.MacContactModel;
import test.macentity.MailService;
import test.macentity.ModelData;
import test.macentity.RTModelData;
import test.macentity.ScenarioDefinedModel;
import test.macentity.Subject;
import test.util.CFMacCore;
import test.util.ScheduledHelp;

public class dem {
public static void main(String[] args) {
	 try {
	File file=new File("macMappers/TeamMapper.xml");
	System.out.println(file.exists());
	String config = 
			"spring-mvc2.xml";
	/*
	 * ApplicationContext是接口
	 * ClassPathXmlApplicationContext是
	 * 一个实现类，该类会依据类路径去
	 * 查找spring配置文件，然后启动容器。
	 */
	System.out.println(123);
	String str="";
	List<String> mol=new ArrayList<String>();
		mol.add("LCD-60MY6150A");
		mol.add("LCD-60SU470A");
		mol.add("LCD-60SU675A");
	for(String m:mol){
		str+="'"+m+"'"+",";
	}
	String[] sy=new String[3];
	sy[0]="LCD-60MY6150A";
	sy[1]="LCD-60SU470A";
	sy[2]="LCD-60SU675A";
	
	String llh=str.substring(0,str.lastIndexOf(","));
	System.out.println(llh);
	ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
//			System.out.println(ac);
			
			//Student.class 方法区中的class对象。
	        /*MysqlDao stu = 
					ac.getBean("mysqlDao",
							MysqlDao.class);*/
	        //ScenarioDefinedModel  sen=stu.findByIdentiftCode("IQYFN");
	        //System.out.print(sen);
	        String pat="C:\\Users\\user\\Desktop\\";
	        CFMacCore ca=ScheduledHelp.findMacCore(pat, "mac_core_conf.xml");
	        System.out.println(ca);
			/*OracleDao ora = 
							ac.getBean("oracleDao",OracleDao.class);
			List<ModelData> lisdata=ora.findModelData("20190601080000", "20190603080000", sy);
			//List<String> lis=ora.findModelDataString("20190601080000", "20190603080000", sy);
			//List<String> liss=ora.findModel("20190601080000","20190603080000");
			//MailService  mailservice=stu.findMailServer("ABF621F053501CE5E053151910ACE099");
			//List<String>  lisst=stu.findModel(sy, "605D696CB6DB8265E050860A8B821E61");
			System.out.println(lisdata);
			
			/*获取当天机型报备数据
			 List<ModelData> lisModelData=ora.findModelData("20190601080000", "20190603080000", sy);		 
			//得到当天机型数
			 List<String> dangRiModel=ora.findModelDataString("20190601080000", "20190603080000", sy);*/
			// Map<String,RTModelData> map=new HashMap<String,RTModelData>();	
			
			/* for(String moll:dangRiModel){	
				 RTModelData rm=new RTModelData();
				 List<ModelData> list=new ArrayList<ModelData>();			 
				 for(ModelData ll:lisModelData){
					 if(ll.getMachineModelNo().equals(moll)){
						 list.add(ll);
					 }
				 }
				 rm.setMachineModel(moll);
				 rm.setSize(list.size());
				 rm.setModelData(list);
				 map.put(moll, rm);
				
			 }*/
			/* RTModelData t1=new RTModelData();
			 t1.setMachineModel("LCD-60MY6150A");
			 t1.setQishu("三期");
			 t1.setSize(30);
			 RTModelData t2=new RTModelData();
			 t1.setMachineModel("LCD-60SU470A");
			 t1.setQishu("三期");
			 t1.setSize(90);
			 RTModelData t3=new RTModelData();
			 t1.setMachineModel("LCD-60MY6150A");
			 t1.setQishu("三期");
			 t1.setSize(130);
			 map.put("LCD-60MY6150A", t1);
			 map.put("LCD-60SU470A", t2);
			 map.put("LCD-60MY6150A", t3);
			 
			 String con="";
			 Set<Entry<String, RTModelData>>  en=map.entrySet();
			 for(Entry<String, RTModelData> s:en){
				 RTModelData rt= s.getValue();
				 con+=rt.getMachineModel()+":"+rt.getSize()+"台"+"(三期)"+"\n"; 
			 }
			 System.out.println(con);
			
				//List<File> lisFi=ExcelUtil.exeFile("C:\\Users\\user\\Desktop\\test", map);
				 List<File> lisfFi=new ArrayList<File>();
				 lisfFi.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60MY6150A-20201205164631.xlsx"));
				 lisfFi.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU470A-20201205162904.xlsx"));
				 lisfFi.add(new File("/app/Fil/商貿-F項目設備報備表for 富士康後台-富連網LCD-60SU675A-20201205164631.xlsx"));
				 Subject sub=new Subject();
				 sub.setMailSubject("【MAC自動報備】商貿-F項目設備報備表for 富士康後台-富連網_夏普_愛奇藝 {date}作业");
				 CFMacCore cfMac=new CFMacCore();
				 List<MacContactModel> liscon=new ArrayList<MacContactModel>();
				 MacContactModel m=new MacContactModel();
				 m.setContactName("张三");
				 m.setSendType("TO");
				 m.setMailAdr("jia-qi.rao@mail.foxconn.com");
				 MacContactModel m1=new MacContactModel();
				 m1.setContactName("test");
				 m1.setSendType("CC");
				 m1.setMailAdr("13662582643@163.com");
				 liscon.add(m);
				 liscon.add(m1);
				 cfMac.setReceivers4qa(liscon);
				 senMailUtil.sendMail(sub, cfMac, map, mailservice, lisfFi);
				/*for(File f:lisFi){
					System.out.println(f.getName());
				}*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
