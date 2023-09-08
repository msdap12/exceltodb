package com.fr.integration.service.batch.exceltodb.config;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NameAddressDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	public NameAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NameAddressDTO(Integer id, BigDecimal oblg, String bank) {
		super();
		this.id = id;
		this.oblg = oblg;
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "NameAddressDTO [id=" + id + ", oblg=" + oblg + ", bank=" + bank + "]";
	}

	private BigDecimal oblg;
	
	private String bank;
	/*
	 * private Integer ver;
	 * 
	 * private BigDecimal spclmall;
	 * 
	 * private BigDecimal norgid1; private BigDecimal norgid2; private String
	 * nm_nbr; private BigDecimal adrorgid1; private BigDecimal adrorgid2; private
	 * BigDecimal adrseq; private String adrelat; private String adrfreq; private
	 * Date adreffdt; private Date adrexpdt; private String zipcd; private
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getOblg() {
		return oblg;
	}

	public void setOblg(BigDecimal oblg) {
		this.oblg = oblg;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
}
