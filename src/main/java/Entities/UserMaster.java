/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "user_master")
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserId", query = "SELECT u FROM UserMaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserMaster.findByAvatar", query = "SELECT u FROM UserMaster u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "UserMaster.findByAddress", query = "SELECT u FROM UserMaster u WHERE u.address = :address"),
    @NamedQuery(name = "UserMaster.findByCity", query = "SELECT u FROM UserMaster u WHERE u.city = :city"),
    @NamedQuery(name = "UserMaster.findByCreatedDate", query = "SELECT u FROM UserMaster u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserMaster.findByDob", query = "SELECT u FROM UserMaster u WHERE u.dob = :dob"),
    @NamedQuery(name = "UserMaster.findByFirstName", query = "SELECT u FROM UserMaster u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserMaster.findByGender", query = "SELECT u FROM UserMaster u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserMaster.findByIsActive", query = "SELECT u FROM UserMaster u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "UserMaster.findByLastModifiedBy", query = "SELECT u FROM UserMaster u WHERE u.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "UserMaster.findByLastModifiedDate", query = "SELECT u FROM UserMaster u WHERE u.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "UserMaster.findByLastName", query = "SELECT u FROM UserMaster u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password"),
    @NamedQuery(name = "UserMaster.findByContactNumber", query = "SELECT u FROM UserMaster u WHERE u.contactNumber = :contactNumber"),
    @NamedQuery(name = "UserMaster.findByState", query = "SELECT u FROM UserMaster u WHERE u.state = :state"),
    @NamedQuery(name = "UserMaster.findByTitle", query = "SELECT u FROM UserMaster u WHERE u.title = :title"),
    @NamedQuery(name = "UserMaster.findByEmail", query = "SELECT u FROM UserMaster u WHERE u.email = :email"),
    @NamedQuery(name = "UserMaster.findByUserName", query = "SELECT u FROM UserMaster u WHERE u.userName = :userName")})
public class UserMaster implements Serializable {

    @Size(max = 500)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 800)
    @Column(name = "address")
    private String address;
    @Size(max = 150)
    @Column(name = "city")
    private String city;
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Size(max = 20)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Size(max = 100)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 10)
    @Column(name = "contact_number")
    private String phoneNo;
    @Size(max = 150)
    @Column(name = "state")
    private String state;
    @Size(max = 150)
    @Column(name = "title")
    private String title;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "user_name")
    private String userName;
    @OneToMany(mappedBy = "createdBy")
    private Collection<DepartmentMaster> departmentMasterCollection;
    @OneToMany(mappedBy = "lastModifiedBy")
    private Collection<DepartmentMaster> departmentMasterCollection1;
    @OneToOne(mappedBy = "userId")
    private OwnerMaster ownerMaster;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_id")
    private String userId;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Country country;

    public UserMaster() {
    }

    public UserMaster(String userId) {
        this.userId = userId;
    }

    public UserMaster(String userId, boolean isActive) {
        this.userId = userId;
        this.isActive = isActive;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

  

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserMaster[ userId=" + userId + " ]";
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public Collection<DepartmentMaster> getDepartmentMasterCollection() {
        return departmentMasterCollection;
    }

    public void setDepartmentMasterCollection(Collection<DepartmentMaster> departmentMasterCollection) {
        this.departmentMasterCollection = departmentMasterCollection;
    }

    public Collection<DepartmentMaster> getDepartmentMasterCollection1() {   
        return departmentMasterCollection1;
    }

    public void setDepartmentMasterCollection1(Collection<DepartmentMaster> departmentMasterCollection1) {
        this.departmentMasterCollection1 = departmentMasterCollection1;
    }

    public OwnerMaster getOwnerMaster() {
        return ownerMaster;
    }

    public void setOwnerMaster(OwnerMaster ownerMaster) {
        this.ownerMaster = ownerMaster;
    }
    
}
