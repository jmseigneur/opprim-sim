// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package eu.musesproject.server.rt2ae;

import eu.musesproject.server.rt2ae.Accessrequest;
import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.Outcome;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

privileged aspect Opportunity_Roo_DbManaged {
    
    @OneToMany(mappedBy = "opportunityId")
    private Set<Accessrequest> Opportunity.accessrequests;
    
    @OneToMany(mappedBy = "opportunityid")
    private Set<Asset> Opportunity.assets;
    
    @OneToMany(mappedBy = "opportunityId")
    private Set<Outcome> Opportunity.outcomes;
    
    @Column(name = "description", length = 45)
    @NotNull
    private String Opportunity.description;
    
    @Column(name = "costbenefit")
    private Double Opportunity.costbenefit;
    
    public Set<Accessrequest> Opportunity.getAccessrequests() {
        return accessrequests;
    }
    
    public void Opportunity.setAccessrequests(Set<Accessrequest> accessrequests) {
        this.accessrequests = accessrequests;
    }
    
    public Set<Asset> Opportunity.getAssets() {
        return assets;
    }
    
    public void Opportunity.setAssets(Set<Asset> assets) {
        this.assets = assets;
    }
    
    public Set<Outcome> Opportunity.getOutcomes() {
        return outcomes;
    }
    
    public void Opportunity.setOutcomes(Set<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
    
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
    
}