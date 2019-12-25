package com.qovery.example

import com.qovery.client.Qovery
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.FileNotFoundException
import javax.sql.DataSource


/**
 * Created by evoxmusic on 20/12/2019.
 */
@Configuration
class MyPostgresqlConfiguration {

    @Bean
    fun getDataSource(): DataSource? {
        val f = try {
            ClassPathResource(".qovery/local_configuration.json").file
        } catch (e: FileNotFoundException) {
            null
        }

        val databaseConfiguration = Qovery(f).getDatabaseConfiguration("my-postgresql") ?: return getTestDatasource()

        val host = databaseConfiguration.host
        val port = databaseConfiguration.port
        val username = databaseConfiguration.username
        val password = databaseConfiguration.password

        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://$host:$port/postgres")
                .username(username)
                .password(password)
                .build()
    }

    private fun getTestDatasource(): DataSource = DataSourceBuilder.create()
            .driverClassName("org.h2.Driver")
            .url("jdbc:h2:mem:testdb")
            .build()

}
