package com.ensa;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.ensa.entities.BankTransaction;
import com.ensa.entities.Transaction;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private ItemReader<BankTransaction> bankTransactionItemReader;
	@Autowired
	private ItemWriter<Transaction> TransactionItemWriter;
	@Autowired
	private ItemProcessor<BankTransaction, Transaction> bankTransactionItemProcessor;
	
	@Bean
	 public Job bankJob() {
		 Step step1=stepBuilderFactory.get("bank-step-1")
				 .<BankTransaction,Transaction>chunk(10)
				 .reader(bankTransactionItemReader)
				 .processor(bankTransactionItemProcessor)
				 .writer(TransactionItemWriter)
				 .build();
		 
		 return jobBuilderFactory.get("bank-job-1")
				 .start(step1)
				 .build();
	 }
	@Bean
	 public FlatFileItemReader<BankTransaction> flatFileItemReader(
			 @Value("${inputFile") Resource resource){
		 FlatFileItemReader<BankTransaction> fileItemReader=new FlatFileItemReader<BankTransaction>();
		 fileItemReader.setName("flatFileItemReader");
		 fileItemReader.setLinesToSkip(1);
		 fileItemReader.setResource(resource);
		 fileItemReader.setLineMapper(lineMapper());
		 return fileItemReader;
		 
	 }
   @Bean
	private LineMapper<BankTransaction> lineMapper() {
	   DefaultLineMapper<BankTransaction> lineMapper=new DefaultLineMapper<BankTransaction>();
       DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
       lineTokenizer.setDelimiter(",");
       lineTokenizer.setStrict(false);
       lineTokenizer.setNames("idTransaction","idCompte","montant","DateTransaction");
       lineMapper.setLineTokenizer(lineTokenizer);
       BeanWrapperFieldSetMapper<BankTransaction> fieldSetMapper=new BeanWrapperFieldSetMapper<BankTransaction>();
       fieldSetMapper.setTargetType(BankTransaction.class);
       lineMapper.setFieldSetMapper(fieldSetMapper);
       
		return lineMapper; 
	}
  
	
	

}
