package com.cognizant.gateway.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@LoadBalancerClient(
        name = "greet-service",
        configuration = LoadBalancerConfiguration.class
)
public class LoadBalancerConfiguration {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
            Environment environment,
            ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider) {

        String serviceName = environment.getProperty(
                "spring.cloud.loadbalancer.client.name",
                "greet-service"
        );

        return new RandomLoadBalancer(
                serviceInstanceListSupplierProvider,
                serviceName
        );
    }
}