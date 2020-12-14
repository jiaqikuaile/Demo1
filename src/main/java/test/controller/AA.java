package test.controller;

import java.io.File;

public class AA {
public static void main(String[] args) {
	String jasperPath="C:\\Users\\user\\Desktop\\ireport\\P12333_zh_CN.jasper";
	File file=new File(jasperPath);
	System.out.println(file.exists());
}
}
