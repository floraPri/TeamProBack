package com.np.wearound.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ict02-22
 *유저의 피드 게시물 수,팔로워 수, 팔로잉 수 표기를 위한 DTO
 *
 */


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FeedUserInfoDTO {
	private int feedCnt;
	private int followerCnt;
	private int followingCnt;
}
