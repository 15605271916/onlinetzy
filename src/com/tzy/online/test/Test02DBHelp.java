package com.tzy.online.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tzy.online.util.DBHelp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test02DBHelp {

	private Connection conn = null;


	@Test
	public void test_01_Conn() {
		conn = DBHelp.getconn();
		assertNotNull(conn);
	}

	@Test
	public void test_02_Close() {
		conn = DBHelp.getconn();
		DBHelp.closeConn(conn);
		try {
			assertTrue(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
