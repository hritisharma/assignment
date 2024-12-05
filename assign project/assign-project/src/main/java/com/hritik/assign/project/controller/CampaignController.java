package com.hritik.assign.project.controller;

import com.hritik.assign.project.model.Campaign;
import com.hritik.assign.project.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/createcampaign")
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return campaigns;
    }


    @GetMapping("/campaign/{id}")
    public Campaign getCampaignById(@PathVariable Integer id) throws Exception {
       return campaignService.getCampaignById(id);
    }


    @PutMapping("/campaign/update/{id}")
    public Campaign updateCampaign(@RequestBody Campaign campaign,@PathVariable Integer id) throws Exception {
       return campaignService.updateCampaign(campaign,id);
    }

    @DeleteMapping("/campaign/delete/{id}")
    public String deleteCampaign(@PathVariable Integer id) throws Exception {
        return campaignService.deleteCampaign(id);
    }
}
