package com.np.wearound.service;

import java.util.List;
import java.util.Optional;

import com.np.wearound.entities.Funding;
import com.np.wearound.entities.FundingPledges;
import com.np.wearound.entities.FundingRewards;
import com.np.wearound.entities.FundingView;
import com.np.wearound.entities.PledgesView;


public interface FundingService {
	
	// list
	public List<Funding> Fundinglist();
	public List<Funding> SelectFundingList(String category);
	
	// detail
	public Optional<Funding> FundingDetail(int fundingcode);
	public List<FundingRewards> Rewardslist(int fundingcode);
	
	public Optional<FundingRewards> RewardsDetail(int rewardscode);
	
	
	// contribute
	public Optional<FundingView> FundingInfo(int fundingcode, int rewardscode); // detail
	public FundingPledges ContributeFunding(FundingPledges ent); // add
	public void UpdateNowAmount(int fundingcode, int nowamount); // 펀딩 페이지 금액 update
	
	
	// 펀딩 진행
	public List<Funding> MyOrganizeList(int userno);
	
	// 펀딩 참여
	public List<PledgesView> MyPledgedList(int userno);
	
	
	// add and edit
	// funding
	public Funding FundingAdd(Funding ent);
	public Funding FundingEdit(Funding ent);
	// rewards
	public void RewardAdd(FundingRewards ent);
	public void RewardEdit(FundingRewards edit);
	// delete?
}
