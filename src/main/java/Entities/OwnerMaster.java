/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 57ren
 */
@Entity
@Table(name = "owner_master")
@NamedQueries({
    @NamedQuery(name = "OwnerMaster.findAll", query = "SELECT o FROM OwnerMaster o"),
    @NamedQuery(name = "OwnerMaster.findByOwnerId", query = "SELECT o FROM OwnerMaster o WHERE o.ownerId = :ownerId")})
public class OwnerMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "owner_id")
    private String ownerId;
    @OneToMany(mappedBy = "ownerId")
    private Collection<DepartmentMaster> departmentMasterCollection;
    @OneToMany(mappedBy = "createdBy")
    private Collection<BusinessMaster> businessMasterCollection;
    @OneToMany(mappedBy = "ownerId")
    private Collection<BusinessMaster> businessMasterCollection1;
    @OneToMany(mappedBy = "lastModifiedBy")
    private Collection<BusinessMaster> businessMasterCollection2;
    @OneToMany(mappedBy = "createdBy")
    private Collection<BranchMaster> branchMasterCollection;
    @OneToMany(mappedBy = "lastModifiedBy")
    private Collection<BranchMaster> branchMasterCollection1;
    @JoinColumn(name = "subscription_id", referencedColumnName = "subscription_id")
    @ManyToOne
    private SubscriptionMaster subscriptionId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne
    private UserMaster userId;

    public OwnerMaster() {
    }

    public OwnerMaster(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Collection<DepartmentMaster> getDepartmentMasterCollection() {
        return departmentMasterCollection;
    }

    public void setDepartmentMasterCollection(Collection<DepartmentMaster> departmentMasterCollection) {
        this.departmentMasterCollection = departmentMasterCollection;
    }

    public Collection<BusinessMaster> getBusinessMasterCollection() {
        return businessMasterCollection;
    }

    public void setBusinessMasterCollection(Collection<BusinessMaster> businessMasterCollection) {
        this.businessMasterCollection = businessMasterCollection;
    }

    public Collection<BusinessMaster> getBusinessMasterCollection1() {
        return businessMasterCollection1;
    }

    public void setBusinessMasterCollection1(Collection<BusinessMaster> businessMasterCollection1) {
        this.businessMasterCollection1 = businessMasterCollection1;
    }

    public Collection<BusinessMaster> getBusinessMasterCollection2() {
        return businessMasterCollection2;
    }

    public void setBusinessMasterCollection2(Collection<BusinessMaster> businessMasterCollection2) {
        this.businessMasterCollection2 = businessMasterCollection2;
    }

    public Collection<BranchMaster> getBranchMasterCollection() {
        return branchMasterCollection;
    }

    public void setBranchMasterCollection(Collection<BranchMaster> branchMasterCollection) {
        this.branchMasterCollection = branchMasterCollection;
    }

    public Collection<BranchMaster> getBranchMasterCollection1() {
        return branchMasterCollection1;
    }

    public void setBranchMasterCollection1(Collection<BranchMaster> branchMasterCollection1) {
        this.branchMasterCollection1 = branchMasterCollection1;
    }

    public SubscriptionMaster getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionMaster subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerId != null ? ownerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OwnerMaster)) {
            return false;
        }
        OwnerMaster other = (OwnerMaster) object;
        if ((this.ownerId == null && other.ownerId != null) || (this.ownerId != null && !this.ownerId.equals(other.ownerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.OwnerMaster[ ownerId=" + ownerId + " ]";
    }
    
}
