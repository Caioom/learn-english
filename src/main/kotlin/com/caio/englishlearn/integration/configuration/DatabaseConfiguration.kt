package com.caio.englishlearn.integration.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration {

    @Value("\${database.url}")
    private lateinit var url: String;

    @Value("\${database.driver}")
    private lateinit var driver: String;

    @Bean
    fun dataSource(): DataSource {
        val dbUri = URI(url)
        val username: String = dbUri.userInfo.split(":")[0]
        val password: String = dbUri.userInfo.split(":")[1]
        val dbUrl = "jdbc:postgresql://" + dbUri.host + ':' + dbUri.port + dbUri.path

        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName(this.driver)
        dataSourceBuilder.url(dbUrl)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)
        return dataSourceBuilder.build()
    }
}