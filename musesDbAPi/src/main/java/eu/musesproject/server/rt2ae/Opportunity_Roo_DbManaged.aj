// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package eu.musesproject.server.rt2ae;

import eu.musesproject.server.rt2ae.Opportunity;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

privileged aspect Opportunity_Roo_DbManaged {
    
    @Column(name = "description", length = 45)
    @NotNull
    private String Opportunity.description;
    
    @Column(name = "costbenefit")
    @NotNull
    private Double Opportunity.costbenefit;
    
    @Column(name = "asset_id")
    @NotNull
    private Integer Opportunity.assetId;
    
    @Column(name = "user_id")
    @NotNull
    private Integer Opportunity.userId;
    
    public String Opportunity.getDescription() {
        return description;
    }
    
    public void Opportunity.setDescription(String description) {
        this.description = description;
    }
    
    public Double Opportunity.getCostbenefit() {
        return costbenefit;
    }
    
    public void Opportunity.setCostbenefit(Double costbenefit) {
        this.costbenefit = costbenefit;
    }
    
    public Integer Opportunity.getAssetId() {
        return assetId;
    }
    
    public void Opportunity.setAssetId(Integer assetId) {
        this.assetId = assetId;
    }
    
    public Integer Opportunity.getUserId() {
        return userId;
    }
    
    public void Opportunity.setUserId(Integer userId) {
        this.userId = userId;
    }
    
}
