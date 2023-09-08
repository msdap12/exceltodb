package com.fr.integration.service.batch.exceltodb.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBWriter implements ItemWriter<NameAddressDTO> {

    private NameAddressRepository nameAddressRepository;

    @Autowired
    public DBWriter (NameAddressRepository nameAddressRepository) {
        this.nameAddressRepository = nameAddressRepository;
    }

    @Override
    public void write(List<? extends NameAddressDTO> addrs) throws Exception{
        System.out.println("Data Saved for addrs: " + addrs);
        for (NameAddressDTO nameAddressDTO : addrs) {
        	nameAddressDTO = nameAddressRepository.saveAndFlush(nameAddressDTO);
        	System.out.println(nameAddressDTO.getId());
		}
       // nameAddressRepository.saveAll(addrs);
        
    }
}
