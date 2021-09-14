package com.tzy.online.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDAO {

	protected Connection conn;
	protected String sql;
	protected PreparedStatement pcmd;
	protected ResultSet rs;

}
