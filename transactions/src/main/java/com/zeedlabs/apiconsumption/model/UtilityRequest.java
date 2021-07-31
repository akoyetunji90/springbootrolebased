package com.zeedlabs.apiconsumption.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.zeedlabs.apiconsumption.audit.Auditable;

@Entity
@Table(name = "util")
@EntityListeners(AuditingEntityListener.class)
public class UtilityRequest extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String refNumber;
	private String billerId;
	private String packageId;
	private String amount;

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getBillerId() {
		return billerId;
	}

	public void setBillerId(String billerId) {
		this.billerId = billerId;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getAmount() {
	return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}