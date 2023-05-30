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
@Table(name = "business_master")
@NamedQueries({
    @NamedQuery(name = "BusinessMaster.findAll", query = "SELECT b FROM BusinessMaster b"),
    @NamedQuery(name = "BusinessMaster.findByBusinessId", query = "SELECT b FROM BusinessMaster b WHERE b.businessId = :businessId"),
    @NamedQuery(name = "BusinessMaster.findByAuthorizedName", query = "SELECT b FROM BusinessMaster b WHERE b.authorizedName = :authorizedName"),
    @NamedQuery(name = "BusinessMaster.findByAuthorizedSignature", query = "SELECT b FROM BusinessMaster b WHERE b.authorizedSignature = :authorizedSignature"),
    @NamedQuery(name = "BusinessMaster.findByAuthorizedSignatureType", query = "SELECT b FROM BusinessMaster b WHERE b.authorizedSignatureType = :authorizedSignatureType"),
    @NamedQuery(name = "BusinessMaster.findByAvatar", query = "SELECT b FROM BusinessMaster b WHERE b.avatar = :avatar"),
    @NamedQuery(name = "BusinessMaster.findByAvatarContentType", query = "SELECT b FROM BusinessMaster b WHERE b.avatarContentType = :avatarContentType"),
    @NamedQuery(name = "BusinessMaster.findByBusinessAddress", query = "SELECT b FROM BusinessMaster b WHERE b.businessAddress = :businessAddress"),
    @NamedQuery(name = "BusinessMaster.findByBusinessTitle", query = "SELECT b FROM BusinessMaster b WHERE b.businessTitle = :businessTitle"),
    @NamedQuery(name = "BusinessMaster.findByBusinessType", query = "SELECT b FROM BusinessMaster b WHERE b.businessType = :businessType"),
    @NamedQuery(name = "BusinessMaster.findByCertification", query = "SELECT b FROM BusinessMaster b WHERE b.certification = :certification"),
    @NamedQuery(name = "BusinessMaster.findByCreatedDate", query = "SELECT b FROM BusinessMaster b WHERE b.createdDate = :createdDate"),
    @NamedQuery(name = "BusinessMaster.findByEmail", query = "SELECT b FROM BusinessMaster b WHERE b.email = :email"),
    @NamedQuery(name = "BusinessMaster.findByIsActive", query = "SELECT b FROM BusinessMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BusinessMaster.findByLastModifiedDate", query = "SELECT b FROM BusinessMaster b WHERE b.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "BusinessMaster.findByRegistrationId", query = "SELECT b FROM BusinessMaster b WHERE b.registrationId = :registrationId")})
public class BusinessMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "business_id")
    private String businessId;
    @Size(max = 100)
    @Column(name = "authorized_name")
    private String authorizedName;
    @Size(max = 400)
    @Column(name = "authorized_signature")
    private String authorizedSignature;
    @Size(max = 255)
    @Column(name = "authorized_signature_type")
    private String authorizedSignatureType;
    @Size(max = 400)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 20)
    @Column(name = "avatar_content_type")
    private String avatarContentType;
    @Size(max = 700)
    @Column(name = "business_address")
    private String businessAddress;
    @Size(max = 80)
    @Column(name = "business_title")
    private String businessTitle;
    @Size(max = 300)
    @Column(name = "business_type")
    private String businessType;
    @Size(max = 1000)
    @Column(name = "certification")
    private String certification;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 20)
    @Column(name = "registration_id")
    private String registrationId;
    @JoinColumn(name = "created_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster createdBy;
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster ownerId;
    @JoinColumn(name = "last_modified_by", referencedColumnName = "owner_id")
    @ManyToOne
    private OwnerMaster lastModifiedBy;
    @OneToMany(mappedBy = "businessId")
    private Collection<BranchMaster> branchMasterCollection;

    public BusinessMaster() {
    }

    public BusinessMaster(String businessId) {
        this.businessId = businessId;
    }

    public BusinessMaster(String businessId, boolean isActive) {
        this.businessId = businessId;
        this.isActive = isActive;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getAuthorizedName() {
        return authorizedName;
    }

    public void setAuthorizedName(String authorizedName) {
        this.authorizedName = authorizedName;
    }

    public String getAuthorizedSignature() {
        return authorizedSignature;
    }

    public void setAuthorizedSignature(String authorizedSignature) {
        this.authorizedSignature = authorizedSignature;
    }

    public String getAuthorizedSignatureType() {
        return authorizedSignatureType;
    }

    public void setAuthorizedSignatureType(String authorizedSignatureType) {
        this.authorizedSignatureType = authorizedSignatureType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarContentType() {
        return avatarContentType;
    }

    public void setAvatarContentType(String avatarContentType) {
        this.avatarContentType = avatarContentType;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public OwnerMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(OwnerMaster createdBy) {
        this.createdBy = createdBy;
    }

    public OwnerMaster getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(OwnerMaster ownerId) {
        this.ownerId = ownerId;
    }

    public OwnerMaster getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(OwnerMaster lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Collection<BranchMaster> getBranchMasterCollection() {
        return branchMasterCollection;
    }

    public void setBranchMasterCollection(Collection<BranchMaster> branchMasterCollection) {
        this.branchMasterCollection = branchMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessMaster)) {
            return false;
        }
        BusinessMaster other = (BusinessMaster) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.BusinessMaster[ businessId=" + businessId + " ]";
    }
    
}
