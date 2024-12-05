package com.hritik.assign.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "campaignresults")
public class CampaignResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;
    private String phone;
    private Float cost;
    private String outcome;
    private Float callDuration;
    private String recording;
    private String summary;
    private String transcription;

    @ManyToOne
    private Campaign campaign;

    public CampaignResult() {
    }

    public CampaignResult(Integer id, Campaign campaign, String transcription, String summary, String recording, Float callDuration, String outcome, Float cost, String phone, String type, String name) {
        this.id = id;
        this.campaign = campaign;
        this.transcription = transcription;
        this.summary = summary;
        this.recording = recording;
        this.callDuration = callDuration;
        this.outcome = outcome;
        this.cost = cost;
        this.phone = phone;
        this.type = type;
        this.name = name;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    public Float getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Float callDuration) {
        this.callDuration = callDuration;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
