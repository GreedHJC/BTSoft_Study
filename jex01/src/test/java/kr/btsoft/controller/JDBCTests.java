package kr.btsoft.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.13:1521:orcl",
				"study",
				"bts5735!")) {

			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
