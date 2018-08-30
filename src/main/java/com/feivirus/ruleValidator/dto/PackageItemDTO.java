package  com.feivirus.ruleValidator.dto;

import java.io.Serializable;
import java.util.List;

public class PackageItemDTO implements Serializable{    
     //险种code    
    private String code;
    
    //险种描述/ 非必须     
    private String name;
    
     //单选值     
    private String value;
    
     //多选的险种规则值列表     
    private List<String> ruleList;
    
     //选中    
    private boolean isCheck;
  
     //是否下拉  前端记录     
    private boolean isSelect;
   
     //是否显示  前端记录     
    private boolean isShow;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<String> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<String> ruleList) {
		this.ruleList = ruleList;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}        
}
