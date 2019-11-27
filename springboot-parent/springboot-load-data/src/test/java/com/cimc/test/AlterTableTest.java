package com.cimc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 批量整理数据库碎片
 *
 * @author chenz
 * @create 2019-11-22 10:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AlterTableTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void alterTableTest() {
        String sql = "SHOW TABLEs";
        List<String> tableNames = jdbcTemplate.queryForList(sql, String.class);
        System.out.println(tableNames);

        for (int i = 0; i < tableNames.size(); i++) {
            String alter_sql = "ALTER TABLE " + tableNames.get(i) + " ENGINE=InnoDB";
            jdbcTemplate.execute(alter_sql);
        }
    }

}
