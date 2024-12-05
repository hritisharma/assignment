package com.hritik.assign.project.service;

import com.hritik.assign.project.model.CampaignResult;
import com.hritik.assign.project.repository.CampaignResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CampaignResultServiceImplementation implements CampaignResultService{

    @Autowired
    private CampaignResultRepository campaignResultRepository;

    @Override
    public List<CampaignResult> getAllCampaignResults() {
        return campaignResultRepository.findAll();
    }

    @Override
    public CampaignResult getCampaignResultById(Integer id) throws Exception {
        Optional<CampaignResult> findResult = campaignResultRepository.findById(id);
        if (findResult.isPresent()) {
            return findResult.get();
        }
        throw new Exception("Campaign Result not found with id: " + id);
    }

    @Override
    public CampaignResult createCampaignResult(CampaignResult campaignResult) {
        CampaignResult newCampaignResult = new CampaignResult();
        newCampaignResult.setName(campaignResult.getName());
        newCampaignResult.setType(campaignResult.getType());
        newCampaignResult.setPhone(campaignResult.getPhone());
        newCampaignResult.setCost(campaignResult.getCost());
        newCampaignResult.setOutcome(campaignResult.getOutcome());
        newCampaignResult.setCallDuration(campaignResult.getCallDuration());
        newCampaignResult.setRecording(campaignResult.getRecording());
        newCampaignResult.setSummary(campaignResult.getSummary());
        newCampaignResult.setTranscription(campaignResult.getTranscription());
        newCampaignResult.setCampaign(campaignResult.getCampaign());  // Assuming the campaign is provided

        return campaignResultRepository.save(newCampaignResult);
    }

    @Override
    public CampaignResult updateCampaignResult(CampaignResult campaignResult, Integer id) throws Exception {
        Optional<CampaignResult> findResult = campaignResultRepository.findById(id);
        if (findResult.isEmpty()) {
            throw new Exception("Campaign Result not found with id: " + id);
        }

        CampaignResult existingResult = findResult.get();
        if (campaignResult.getName() != null) {
            existingResult.setName(campaignResult.getName());
        }
        if (campaignResult.getType() != null) {
            existingResult.setType(campaignResult.getType());
        }
        if (campaignResult.getPhone() != null) {
            existingResult.setPhone(campaignResult.getPhone());
        }
        if (campaignResult.getCost() != null) {
            existingResult.setCost(campaignResult.getCost());
        }
        if (campaignResult.getOutcome() != null) {
            existingResult.setOutcome(campaignResult.getOutcome());
        }
        if (campaignResult.getCallDuration() != null) {
            existingResult.setCallDuration(campaignResult.getCallDuration());
        }
        if (campaignResult.getRecording() != null) {
            existingResult.setRecording(campaignResult.getRecording());
        }
        if (campaignResult.getSummary() != null) {
            existingResult.setSummary(campaignResult.getSummary());
        }
        if (campaignResult.getTranscription() != null) {
            existingResult.setTranscription(campaignResult.getTranscription());
        }
        if (campaignResult.getCampaign() != null) {
            existingResult.setCampaign(campaignResult.getCampaign());
        }

        return campaignResultRepository.save(existingResult);
    }

    @Override
    public String deleteCampaignResult(Integer id) throws Exception {
        Optional<CampaignResult> findResult = campaignResultRepository.findById(id);
        if (findResult.isEmpty()) {
            throw new Exception("Campaign Result not found with id: " + id);
        }

        campaignResultRepository.delete(findResult.get());
        return "Campaign Result Deleted Successfully";
    }
}
