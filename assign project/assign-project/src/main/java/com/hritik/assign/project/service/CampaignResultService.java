package com.hritik.assign.project.service;

import com.hritik.assign.project.model.CampaignResult;

import java.util.List;

public interface CampaignResultService {
    public List<CampaignResult> getAllCampaignResults();
    public CampaignResult getCampaignResultById(Integer id) throws Exception;
    public CampaignResult createCampaignResult(CampaignResult campaignResult);
    public CampaignResult updateCampaignResult(CampaignResult campaignResult, Integer id) throws Exception;
    public String deleteCampaignResult(Integer id) throws Exception;
}
