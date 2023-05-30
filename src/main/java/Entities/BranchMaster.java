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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "branch_master")
@NamedQueries({
    @NamedQuery(name = "BranchMaster.findAll", query = "SELECT b FROM BranchMaster b"),
    @NamedQuery(name = "BranchMaster.findByBranchId", query = "SELECT b FROM BranchMaster b WHERE b.branchId = :branchId"),
    @NamedQuery(name = "BranchMaster.findByAddress", query = "SELECT b FROM BranchMaster b WHERE b.address = :address"),
    @NamedQuery(name = "BranchMaster.findByBranchName", query = "SELECT b FROM BranchMaster b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "BranchMaster.findByContactNumber", query = "SELECT b FROM BranchMaster b WHERE b.contactNumber = :contactNumber"),
    @NamedQuery(name = "BranchMaster.findByCreatedDate", query = "SELECT b FROM BranchMaster b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BranchMaster.findByIsActive", query = "SELECT b FROM BranchMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BranchMaster.findByLastModifiedDate", query = "SELECT b FROM BranchMaster b WHERE b.lastModifiedDate = :lastModifiedDate")})
public class BranchMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "branch_id")
    private String branchId;
    @Size(max = 700)
    @Column(name = "address")
    private String address;
    @Size(max = 150)
    @Column(name = "branch_name")
    private String branchName;
    @Size(max = 10)
    @Column(name = "contact_number")
    private String contactNo;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @OneToMany(mappedBy = "branchId")
    private Collection<DepartmentMaster> departmentMasterCollection;
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
    @ManyToOne
    private BusinessMaster business;
    @JoinColumn(name = "created_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster createdBy;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster lastModifiedBy;

    public BranchMaster() {
    }

    public BranchMaster(String branchId) {
        this.branchId = branchId;
    }

    public BranchMaster(String branchId, boolean isActive) {
        this.branchId = branchId;
        this.isActive = isActive;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getContactNumber() {
        return contactNo;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNo = contactNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Collection<DepartmentMaster> getDepartmentMasterCollection() {
        return departmentMasterCollection;
    }

    public void setDepartmentMasterCollection(Collection<DepartmentMaster> departmentMasterCollection) {
        this.departmentMasterCollection = departmentMasterCollection;
    }

    public BusinessMaster getBusinessId() {
        return business;
    }

    public void setBusinessId(BusinessMaster businessId) {
        this.business = businessId;
    }

    public OwnerMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(OwnerMaster createdBy) {
        this.createdBy = createdBy;
    }

    public OwnerMaster getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(OwnerMaster lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchMaster)) {
            return false;
        }
        BranchMaster other = (BranchMaster) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.BranchMaster[ branchId=" + branchId + " ]";
    }
    
}
