package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingPledges;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.entities.FundingView;


public interface FundingService {
	
	// list
	public List<Funding> Fundinglist();
	public List<Funding> SelectFundingList(String category);
	
	// detail
	public Optional<Funding> FundingDetail(int fundingcode);
	public List<FundingRewards> Rewardslist(int fundingcode);
	
	
	// contribute
//	public Optional<FundingRewards> SelectedPledge(int id); // 상세
	public Optional<FundingView> FundingInfo(int fundingcode, int rewardscode);
	public FundingPledges ContributeFunding(FundingPledges ent); // add
	public void UpdateNowAmount(int fundingcode, int nowamount);
	
	
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
