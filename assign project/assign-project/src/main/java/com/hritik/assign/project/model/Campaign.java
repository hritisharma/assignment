package com.hritik.assign.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Agent agent;
    private String type;
    private String phoneNumber;
    private String status;

    @OneToMany(mappedBy = "campaign")
    List<CampaignResult> results;

    public Campaign() {
    }

    public Campaign(Integer id, List<CampaignResult> results, String status, String phoneNumber, String type, Agent agent, String name) {
        this.id = id;
        this.results = results;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.agent = agent;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CampaignResult> getResults() {
        return results;
    }

    public void setResults(List<CampaignResult> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
