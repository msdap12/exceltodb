package com.fr.integration.service.batch.exceltodb.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.mapping.BeanWrapperRowMapper;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class ExcelFileToDatabaseJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<NameAddressDTO> itemReader, ItemProcessor<NameAddressDTO, NameAddressDTO> itemProcessor,
			ItemWriter<NameAddressDTO> itemWriter) {

		Step step = stepBuilderFactory.get("ETL-file-load").<NameAddressDTO, NameAddressDTO>chunk(100)
				.reader(itemReader).processor(itemProcessor).writer(itemWriter).build();

		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();
	}

	@Bean
	ItemReader<NameAddressDTO> excelStudentReader() {
		PoiItemReader<NameAddressDTO> reader = new PoiItemReader<>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("data/data.xlsx"));
		reader.setRowMapper(new RowMapperImpl());
		return reader;
	}

	/*
	 * private RowMapper<NameAddressDTO> excelRowMapper() {
	 * BeanWrapperRowMapper<NameAddressDTO> rowMapper = new
	 * BeanWrapperRowMapper<>(); rowMapper.setTargetType(NameAddressDTO.class);
	 * return rowMapper; }
	 */


}
