package com.caio.englishlearn.integration.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration {

    @Value("\${database.url}")
    private lateinit var url: String;

    @Value("\${database.username}")
    private lateinit var username: String;

    @Value("\${database.password}")
    private lateinit var password: String;

    @Value("\${database.driver}")
    private lateinit var driver: String;

    @Bean
    fun dataSource(): DataSource {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName(this.driver)
        dataSourceBuilder.url(this.url)
        dataSourceBuilder.username(this.username)
        dataSourceBuilder.password(this.password)
        return dataSourceBuilder.build()
    }
}