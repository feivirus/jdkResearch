package  com.feivirus.ruleValidator.dto;

/**
 * 
 * @author feivirus
 *
 */
public class LevelGroup {
	//团体id，比如帮派，渠道，
	private Integer id;
	
	private String name;
	
	//类型 1 飞侠的帮派  2.渠道 3.以前喂小保的场景,参考GroupTypeEnum
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}	
}
