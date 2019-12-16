package com.feivirus.flink.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author feivirus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private Integer id;

    private String name;

    private Integer count;
}
