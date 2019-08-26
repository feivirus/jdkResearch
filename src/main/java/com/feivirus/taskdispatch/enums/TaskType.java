package com.feivirus.taskdispatch.enums;

/**
 * 
 * @author feivirus
 *
 */
public enum TaskType {
    CREATE_GPS(1, "插入位置"),
    CREATE_ALARM(2, "插入告警"),
    CREATE_STATE(3, "插入状态");
    
    private Integer value;
    
    private String description;
    
    private TaskType(Integer value, String description) {
        this.description = description;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public TaskType getEnumByValue(Integer value) {
        if (value == null) {
            return null;
        }
        
        for (TaskType type : TaskType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
