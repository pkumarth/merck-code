package com.merck.search.v1.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/*@Configuration
@EnableElasticsearchRepositories(basePackages = "com.merck.search.v1.repository")
@ComponentScan(basePackages = { "com.merck.search.v1.service" })
public class ESConfig {

	@Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/6.2.2}")
	private String elasticsearchHome;

	@Value("${elasticsearch.cluster.name:elasticsearch}")
	private String clusterName;

	@Bean
	public Client client() {
		TransportClient client = null;
		try {
			final Settings elasticsearchSettings = Settings.builder().put("client.transport.sniff", true)
					.put("path.home", elasticsearchHome).put("cluster.name", clusterName).build();
			client = new PreBuiltTransportClient(elasticsearchSettings);
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
}

// @PropertySource(value = "classpath:application.properties")
// @EnableElasticsearchRepositories(basePackages = "com.backend.project.repositories")
@Configuration
public class ESConfig {

	@Bean
	public Client client() throws Exception {
		@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("elasticsearch.host"), 9300));
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
*/
@Configuration
public class ESConfig {

	private TransportClient client;

	@Bean
	public TransportClient client() throws UnknownHostException {

		Settings settings = Settings.builder().put("client.transport.nodes_sampler_interval", "5s")
				.put("client.transport.sniff", false).put("transport.tcp.compress", true)
				.put("cluster.name", "clusterName").put("xpack.security.transport.ssl.enabled", true).build();

		client = new PreBuiltTransportClient(settings);

		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

		return client;
	}
}