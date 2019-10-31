package com.jl.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITable implements Serializable{
	
	/**
	 * 实行不能随意定义,必须满足js数据要求
	 */
	private Integer total;
	private List<?> rows;
}
