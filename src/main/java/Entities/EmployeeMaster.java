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
@Table(name = "employee_master")
@NamedQueries({
    @NamedQuery(name = "EmployeeMaster.findAll", query = "SELECT e FROM EmployeeMaster e"),
    @NamedQuery(name = "EmployeeMaster.findByEmployeeId", query = "SELECT e FROM EmployeeMaster e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "EmployeeMaster.findByCreatedDate", query = "SELECT e FROM EmployeeMaster e WHERE e.createdDate = :createdDate"),
    @NamedQuery(name = "EmployeeMaster.findByIsActive", query = "SELECT e FROM EmployeeMaster e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "EmployeeMaster.findByLastModifiedDate", query = "SELECT e FROM EmployeeMaster e WHERE e.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "EmployeeMaster.findBySalary", query = "SELECT e FROM EmployeeMaster e WHERE e.salary = :salary"),
    @NamedQuery(name = "EmployeeMaster.findByWorkingHours", query = "SELECT e FROM EmployeeMaster e WHERE e.workingHours = :workingHours")})
public class EmployeeMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "employee_id")
    private String employeeId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private double salary;
    @Column(name = "working_hours")
    private Integer workingHours;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne
    private DepartmentMaster department;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne
    private OwnerMaster createdBy;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private RoleMaster role;
    @JoinColumn(name = "parent_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster parent;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster user;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster lastModifiedBy;

    public EmployeeMaster() {
    }

    public EmployeeMaster(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeMaster(String employeeId, boolean isActive, double salary) {
        this.employeeId = employeeId;
        this.isActive = isActive;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public DepartmentMaster getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentMaster department) {
        this.department = department;
    }

    public UserMaster getParent() {
        return parent;
    }

    public void setParent(UserMaster parent) {
        this.parent = parent;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }

   

    public OwnerMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(OwnerMaster createdBy) {
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
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeMaster)) {
            return false;
        }
        EmployeeMaster other = (EmployeeMaster) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EmployeeMaster[ employeeId=" + employeeId + " ]";
    }
    
}
