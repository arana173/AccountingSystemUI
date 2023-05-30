/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "department_master")
@NamedQueries({
    @NamedQuery(name = "DepartmentMaster.findAll", query = "SELECT d FROM DepartmentMaster d"),
    @NamedQuery(name = "DepartmentMaster.findByDepartmentId", query = "SELECT d FROM DepartmentMaster d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "DepartmentMaster.findByCreatedDate", query = "SELECT d FROM DepartmentMaster d WHERE d.createdDate = :createdDate"),
    @NamedQuery(name = "DepartmentMaster.findByDepartmentName", query = "SELECT d FROM DepartmentMaster d WHERE d.departmentName = :departmentName"),
    @NamedQuery(name = "DepartmentMaster.findByIsActive", query = "SELECT d FROM DepartmentMaster d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DepartmentMaster.findByLastModifiedDate", query = "SELECT d FROM DepartmentMaster d WHERE d.lastModifiedDate = :lastModifiedDate")})
public class DepartmentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 150)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    @ManyToOne
    private BranchMaster branch;
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster owner;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster lastModifiedBy;

    public DepartmentMaster() {
    }

    public DepartmentMaster(String departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentMaster(String departmentId, boolean isActive) {
        this.departmentId = departmentId;
        this.isActive = isActive;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public BranchMaster getBranch() {
        return branch;
    }

    public void setBranch(BranchMaster branchId) {
        this.branch = branchId;
    }

    public OwnerMaster getOwnerId() {
        return owner;
    }

    public void setOwnerId(OwnerMaster ownerId) {
        this.owner = ownerId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public UserMaster getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UserMaster lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentMaster)) {
            return false;
        }
        DepartmentMaster other = (DepartmentMaster) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DepartmentMaster[ departmentId=" + departmentId + " ]";
    }
    
}
