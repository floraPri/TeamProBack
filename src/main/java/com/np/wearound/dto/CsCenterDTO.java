package com.np.wearound.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CsCenterDTO {

	private int questionnum;
	private String title;
	private String content;
	private Date createdate;
	private String show;
}
