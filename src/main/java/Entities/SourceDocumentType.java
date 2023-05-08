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
@Table(name = "source_document_type")
@NamedQueries({
    @NamedQuery(name = "SourceDocumentType.findAll", query = "SELECT s FROM SourceDocumentType s"),
    @NamedQuery(name = "SourceDocumentType.findBySourceDocumentTypeId", query = "SELECT s FROM SourceDocumentType s WHERE s.sourceDocumentTypeId = :sourceDocumentTypeId"),
    @NamedQuery(name = "SourceDocumentType.findByLastModifiedBy", query = "SELECT s FROM SourceDocumentType s WHERE s.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "SourceDocumentType.findByLastModifiedDate", query = "SELECT s FROM SourceDocumentType s WHERE s.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "SourceDocumentType.findByTitle", query = "SELECT s FROM SourceDocumentType s WHERE s.title = :title")})
public class SourceDocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "source_document_type_id")
    private String srcDocumentTypeId;
    @Size(max = 20)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 200)
    @Column(name = "title")
    private String title;

    public SourceDocumentType() {
    }

    public SourceDocumentType(String sourceDocumentTypeId) {
        this.srcDocumentTypeId = sourceDocumentTypeId;
    }

    public String getSrcDocumentTypeId() {
        return srcDocumentTypeId;
    }

    public void setSrcDocumentTypeId(String srcDocumentTypeId) {
        this.srcDocumentTypeId = srcDocumentTypeId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srcDocumentTypeId != null ? srcDocumentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SourceDocumentType)) {
            return false;
        }
        SourceDocumentType other = (SourceDocumentType) object;
        if ((this.srcDocumentTypeId == null && other.srcDocumentTypeId != null) || (this.srcDocumentTypeId != null && !this.srcDocumentTypeId.equals(other.srcDocumentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SourceDocumentType[ sourceDocumentTypeId=" + srcDocumentTypeId + " ]";
    }

}
