package test.issspentity;

import java.util.Date;

public class OracleEnty {
private String parentid;
private String subid;

public String getParentid() {
	return parentid;
}
public void setParentid(String parentid) {
	this.parentid = parentid;
}
public String getSubid() {
	return subid;
}
public void setSubid(String subid) {
	this.subid = subid;
}

@Override
public String toString() {
	return "OracleEnty [parentid=" + parentid + ", subid=" + subid + "]";
}

}
