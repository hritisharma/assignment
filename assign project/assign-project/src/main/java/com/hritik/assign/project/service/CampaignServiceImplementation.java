package com.hritik.assign.project.service;

import com.hritik.assign.project.model.Campaign;
import com.hritik.assign.project.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImplementation implements CampaignService{

        @Autowired
        private CampaignRepository campaignRepository;

        @Override
        public List<Campaign> getAllCampaigns() {
            return campaignRepository.findAll();
        }

        @Override
        public Campaign getCampaignById(Integer id) throws Exception {
            Optional<Campaign> findCampaign = campaignRepository.findById(id);
            if (findCampaign.isPresent()) {
                return findCampaign.get();
            }
            throw new Exception("Campaign not found with id: " + id);
        }

        @Override
        public Campaign createCampaign(Campaign campaign) {
            Campaign newCampaign = new Campaign();
            newCampaign.setName(campaign.getName());
            newCampaign.setType(campaign.getType());
            newCampaign.setPhoneNumber(campaign.getPhoneNumber());
            newCampaign.setStatus(campaign.getStatus());
            newCampaign.setAgent(campaign.getAgent());  // Assuming the agent is provided

            return campaignRepository.save(newCampaign);
        }

        @Override
        public Campaign updateCampaign(Campaign campaign, Integer id) throws Exception {
            Optional<Campaign> findCampaign = campaignRepository.findById(id);
            if (findCampaign.isEmpty()) {
                throw new Exception("Campaign not found with id: " + id);
            }

            Campaign existingCampaign = findCampaign.get();
            if (campaign.getName() != null) {
                existingCampaign.setName(campaign.getName());
            }
            if (campaign.getType() != null) {
                existingCampaign.setType(campaign.getType());
            }
            if (campaign.getPhoneNumber() != null) {
                existingCampaign.setPhoneNumber(campaign.getPhoneNumber());
            }
            if (campaign.getStatus() != null) {
                existingCampaign.setStatus(campaign.getStatus());
            }
            if (campaign.getAgent() != null) {
                existingCampaign.setAgent(campaign.getAgent());
            }

            return campaignRepository.save(existingCampaign);
        }

        @Override
        public String deleteCampaign(Integer id) throws Exception {
            Optional<Campaign> findCampaign = campaignRepository.findById(id);
            if (findCampaign.isEmpty()) {
                throw new Exception("Campaign not found with id: " + id);
            }

            campaignRepository.delete(findCampaign.get());
            return "Campaign Deleted Successfully";
        }
    }

