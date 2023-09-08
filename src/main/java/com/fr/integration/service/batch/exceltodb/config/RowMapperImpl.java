package com.fr.integration.service.batch.exceltodb.config;

import java.math.BigDecimal;

import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.support.rowset.RowSet;

public class RowMapperImpl implements RowMapper<NameAddressDTO> {
	public RowMapperImpl() {
	}

	@Override
	public NameAddressDTO mapRow(RowSet rs) throws Exception {
		if (rs == null || rs.getCurrentRow() == null) {
			System.out.println("no rs:-->");
			return null;
		}
		NameAddressDTO bl = new NameAddressDTO();
		System.out.println("rs:::" + rs.getCurrentRow()[0]);
		bl.setOblg(BigDecimal.valueOf(Double.valueOf(rs.getCurrentRow()[0].toString())));
		bl.setBank(rs.getCurrentRow()[1]);
		return bl;
	}

}