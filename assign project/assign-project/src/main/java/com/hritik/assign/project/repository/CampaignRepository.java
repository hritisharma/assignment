package com.hritik.assign.project.repository;

import com.hritik.assign.project.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
}
