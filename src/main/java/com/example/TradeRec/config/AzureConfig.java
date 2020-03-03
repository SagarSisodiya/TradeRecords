package com.example.TradeRec.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;

@Configuration
public class AzureConfig {

	/*
	 * @Value("{azure.storage.account.name}") private String azureAccountName;
	 * 
	 * @Value("{StorageConnectionString}") private String azureAccountKey;
	 * 
	 * @Bean(name = "azureAuthCreds") public StorageCredentials
	 * getStorageCredentials() { return new
	 * StorageCredentialsAccountAndKey(azureAccountName, azureAccountKey); }
	 */
}
