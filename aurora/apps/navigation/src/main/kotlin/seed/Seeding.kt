package seed

import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.type.DataTypes
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.insertInto
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createTable
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace
import com.datastax.oss.driver.api.querybuilder.schema.CreateTable
import com.datastax.oss.driver.api.querybuilder.select.Select
import java.util.UUID.randomUUID

internal class Seeding(private val connection: DbConnection) {
    fun seed() {
        if(seedingAllowed()) {
            createKeySpace()
            createMenuTable()
            seedMenuData()
        } else {
            println("Seeding not allowed since keyspace ${connection.getKeyspace()} already exists.")
        }
    }

    private fun seedingAllowed(): Boolean {
        val query: Select = selectFrom("system_schema", "keyspaces")
            .column("keyspace_name")
        val resultSet: ResultSet = connection.execute(query.build())
        return !resultSet.fold(false) { acc, row ->
            acc || row.getString("keyspace_name") == connection.getKeyspace()
        }
    }

    private fun createKeySpace() {
        println("create keyspace ${connection.getKeyspace()}")
        val createKs: CreateKeyspace = SchemaBuilder
            .createKeyspace(connection.getKeyspace())
            .withSimpleStrategy(1);
        connection.execute(createKs.build());
    }

    private fun createMenuTable() {
        println("create table menu")
        val createTable: CreateTable = createTable(connection.getKeyspace(), "menu")
            .withPartitionKey("menu", DataTypes.INT)
            .withClusteringColumn("language", DataTypes.TEXT)
            .withClusteringColumn("id", DataTypes.UUID)
            .withColumn("name", DataTypes.TEXT)
            .withColumn("url", DataTypes.TEXT)
        connection.execute(createTable.build())
    }

    private fun seedMenuData() {
        println("seed menu data")
        val entries = listOf(
            MenuEntry(1, "en", randomUUID(), "Home", "/landingpage?id=1"),
            MenuEntry(1, "en", randomUUID(), "Men", "/landingpage?id=2"),
            MenuEntry(1, "en", randomUUID(), "Women", "/landingpage?id=3"),
            MenuEntry(1, "en", randomUUID(), "Kids", "/landingpage?id=4"),
            MenuEntry(1, "en", randomUUID(), "Collection", "/landingpage?id=5"),
            MenuEntry(1, "en", randomUUID(), "Trends", "/landingpage?id=6"),

            MenuEntry(1, "de", randomUUID(), "Home", "/landingpage?id=1"),
            MenuEntry(1, "de", randomUUID(), "Men", "/landingpage?id=2"),
            MenuEntry(1, "de", randomUUID(), "Women", "/landingpage?id=3"),
            MenuEntry(1, "de", randomUUID(), "Kids", "/landingpage?id=4"),
            MenuEntry(1, "de", randomUUID(), "Collection", "/landingpage?id=5"),
            MenuEntry(1, "de", randomUUID(), "Trends", "/landingpage?id=6"),

            MenuEntry(2, "en", randomUUID(), "Impressum", "/landingpage?id=1"),
        )
        entries.forEach {
            val insert = insertInto(connection.getKeyspace(), "menu")
                .value("menu", literal(it.menu))
                .value("language", literal(it.language))
                .value("id", literal(it.id))
                .value("name", literal(it.name))
                .value("url", literal(it.url))
            connection.execute(insert.build())
        }
    }
}
