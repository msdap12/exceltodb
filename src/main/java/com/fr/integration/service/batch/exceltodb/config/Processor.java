package com.fr.integration.service.batch.exceltodb.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<NameAddressDTO, NameAddressDTO> {

    @Override
    public NameAddressDTO process(NameAddressDTO dto) throws Exception {
    	System.out.println("print :::"+dto);
        return dto;
    }
}
