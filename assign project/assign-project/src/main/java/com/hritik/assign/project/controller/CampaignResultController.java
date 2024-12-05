package com.hritik.assign.project.controller;

import com.hritik.assign.project.model.CampaignResult;
import com.hritik.assign.project.service.CampaignResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignResultController {

    @Autowired
    private CampaignResultService campaignResultService;

    @PostMapping("/createcampaignresult")
    public CampaignResult createCampaignResult(@RequestBody CampaignResult campaignResult) {
        return campaignResultService.createCampaignResult(campaignResult);
    }


    @GetMapping("/campaignresults")
    public List<CampaignResult> getAllCampaignResults() {
        List<CampaignResult> campaignResults = campaignResultService.getAllCampaignResults();
        return campaignResults;
    }


    @GetMapping("/campaignresult/{id}")
    public CampaignResult getCampaignResultById(@PathVariable Integer id) throws Exception {
        return campaignResultService.getCampaignResultById(id);
    }


    @PutMapping("/updatecampaignresult/{id}")
    public CampaignResult updateCampaignResult(@RequestBody CampaignResult campaignResult, @PathVariable Integer id) throws Exception {
        return campaignResultService.updateCampaignResult(campaignResult, id);
    }

    @DeleteMapping("/deletecampaignresult/{id}")
    public String deleteCampaignResult(@PathVariable Integer id) throws Exception {
        return campaignResultService.deleteCampaignResult(id);
    }
}
