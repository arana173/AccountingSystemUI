/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 57ren
 */
@Entity
@Table(name = "subscription_master")
@NamedQueries({
    @NamedQuery(name = "SubscriptionMaster.findAll", query = "SELECT s FROM SubscriptionMaster s"),
    @NamedQuery(name = "SubscriptionMaster.findBySubscriptionId", query = "SELECT s FROM SubscriptionMaster s WHERE s.subscriptionId = :subscriptionId"),
    @NamedQuery(name = "SubscriptionMaster.findByCharges", query = "SELECT s FROM SubscriptionMaster s WHERE s.charges = :charges"),
    @NamedQuery(name = "SubscriptionMaster.findByDuration", query = "SELECT s FROM SubscriptionMaster s WHERE s.duration = :duration"),
    @NamedQuery(name = "SubscriptionMaster.findByDurationType", query = "SELECT s FROM SubscriptionMaster s WHERE s.durationType = :durationType"),
    @NamedQuery(name = "SubscriptionMaster.findByFeatures", query = "SELECT s FROM SubscriptionMaster s WHERE s.features = :features"),
    @NamedQuery(name = "SubscriptionMaster.findByIsActive", query = "SELECT s FROM SubscriptionMaster s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SubscriptionMaster.findByLastModifiedBy", query = "SELECT s FROM SubscriptionMaster s WHERE s.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "SubscriptionMaster.findByLastModifiedDate", query = "SELECT s FROM SubscriptionMaster s WHERE s.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "SubscriptionMaster.findByTitle", query = "SELECT s FROM SubscriptionMaster s WHERE s.title = :title"),
    @NamedQuery(name = "SubscriptionMaster.findByDescription", query = "SELECT s FROM SubscriptionMaster s WHERE s.description = :description")})
public class SubscriptionMaster implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "charges")
    private double charges;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Size(max = 15)
    @Column(name = "duration_type")
    private String durationType;
    @Size(max = 500)
    @Column(name = "features")
    private String features;
    @Size(max = 20)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "subscription_id")
    private String subscriptionId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @OneToMany(mappedBy = "subscriptionId")
    private Collection<OwnerMaster> ownerMasterCollection;

    public SubscriptionMaster() {
    }

    public SubscriptionMaster(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public SubscriptionMaster(String subscriptionId, double charges, int duration) {
        this.subscriptionId = subscriptionId;
        this.charges = charges;
        this.duration = duration;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }


    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }


    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    public Collection<OwnerMaster> getOwnerMasterCollection() {
        return ownerMasterCollection;
    }

    public void setOwnerMasterCollection(Collection<OwnerMaster> ownerMasterCollection) {
        this.ownerMasterCollection = ownerMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionId != null ? subscriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriptionMaster)) {
            return false;
        }
        SubscriptionMaster other = (SubscriptionMaster) object;
        if ((this.subscriptionId == null && other.subscriptionId != null) || (this.subscriptionId != null && !this.subscriptionId.equals(other.subscriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SubscriptionMaster[ subscriptionId=" + subscriptionId + " ]";
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

  

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
