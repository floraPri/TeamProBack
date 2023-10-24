package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingRewards;


public interface FundingService {
	
	// list
	public List<Funding> fundinglist();
	
	// detail
	public Optional<Funding> FundingDetail(int fundingcode);
	public List<FundingRewards> Rewardslist(int fundingcode);
	
	// contribute
	public void ContributeFunding(int userno) ; 
	
	
	// 펀딩 진행자
	public List<Funding> OrganizerList();
	
	// 펀딩 참여자
	public List<Funding> Participantlist();
	
	
	// add and edit
	// funding
	public Funding FundingAdd(Funding ent);
	// rewards
	public void RewardAdd(FundingRewards ent);
	// delete?
}
