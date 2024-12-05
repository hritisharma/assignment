package com.hritik.assign.project.service;

import com.hritik.assign.project.model.Campaign;

import java.util.List;

public interface CampaignService {
    public List<Campaign> getAllCampaigns();
    public Campaign getCampaignById(Integer id) throws Exception;
    public Campaign createCampaign(Campaign campaign);
    public Campaign updateCampaign(Campaign campaign, Integer id) throws Exception;
    public String deleteCampaign(Integer id) throws Exception;
}
