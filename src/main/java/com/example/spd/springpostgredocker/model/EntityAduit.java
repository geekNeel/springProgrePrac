package com.example.spd.springpostgredocker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)
public class EntityAduit implements Serializable {
	
	  @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_at", nullable = false, updatable = false)
	    @CreatedDate
	    private Date createdAt;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "updated_at", nullable = false)
	    @LastModifiedDate
	    private Date updatedAt;

	    @Column(name = "created_by", nullable = false)
	    @CreatedBy
	    private String createdBy;

	    @Column(name = "updated_by", nullable = false)
	    @LastModifiedBy
	    private String updatedBy;
	    
	    
	    

		public EntityAduit() {
			super();
		}

		public EntityAduit(Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
			super();
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.createdBy = createdBy;
			this.updatedBy = updatedBy;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}
	    
	    
	    

}
