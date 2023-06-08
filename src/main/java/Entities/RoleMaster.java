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
@Table(name = "role_master")
@NamedQueries({
    @NamedQuery(name = "RoleMaster.findAll", query = "SELECT r FROM RoleMaster r"),
    @NamedQuery(name = "RoleMaster.findByRoleId", query = "SELECT r FROM RoleMaster r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RoleMaster.findByCreatedDate", query = "SELECT r FROM RoleMaster r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RoleMaster.findByLastModifiedDate", query = "SELECT r FROM RoleMaster r WHERE r.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "RoleMaster.findByTitle", query = "SELECT r FROM RoleMaster r WHERE r.title = :title")})
public class RoleMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 150)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne
    private DepartmentMaster departmentId;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster lastModifiedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster createdBy;
    @OneToMany(mappedBy = "roleId")
    private Collection<EmployeeMaster> employeeMasterCollection;

    public RoleMaster() {
    }

    public RoleMaster(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DepartmentMaster getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentMaster departmentId) {
        this.departmentId = departmentId;
    }

    public OwnerMaster getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(OwnerMaster lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OwnerMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(OwnerMaster createdBy) {
        this.createdBy = createdBy;
    }

    public Collection<EmployeeMaster> getEmployeeMasterCollection() {
        return employeeMasterCollection;
    }

    public void setEmployeeMasterCollection(Collection<EmployeeMaster> employeeMasterCollection) {
        this.employeeMasterCollection = employeeMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleMaster)) {
            return false;
        }
        RoleMaster other = (RoleMaster) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RoleMaster[ roleId=" + roleId + " ]";
    }
    
}
