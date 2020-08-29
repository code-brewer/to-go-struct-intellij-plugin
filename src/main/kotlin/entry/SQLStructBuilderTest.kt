package entry

import org.junit.Test

class SQLStructBuilderTest {

    @Test
    fun gen() {
        val case1 = """
            CREATE TABLE `policy_info` (
            `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
            `policy_id` varchar(128) NOT NULL COMMENT 'ID',
            `policy_name` varchar(128) NOT NULL,
            `object_id` varchar(128) NOT NULL COMMENT 'ID',
            `policy_type` varchar(16) NOT NULL DEFAULT 'system' COMMENT 'policy_type="system":policy_type="custom":',
            `policy_version` int(11) NOT NULL COMMENT 'version=1',
            `statement` mediumtext NOT NULL COMMENT 'json',
            `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT ', is_delete=0:is_delete=1:',
            `creator` varchar(128) NOT NULL,
            `operator` varchar(128) NOT NULL,
            `create_time` datetime NOT NULL,
            `update_time` datetime NOT NULL,
            PRIMARY KEY (`id`),
            UNIQUE KEY `uk_policy_id` (`policy_id`),
            KEY `idx_object_id` (`object_id`)
            ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
        """.trimIndent()
        val builder = SQLStructBuilder()
        println(builder.gen(case1))

    }
}
