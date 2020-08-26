package com.wellsfargo.fsd.ck.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.wellsfargo.fsd.ck.entity.KitDetail;
import com.wellsfargo.fsd.ck.exception.CkException;


public class KitDaoImpl implements KitDao{

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
/*
	public KitDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
*/
	public static final String INS_ITEM_QRY = "INSERT INTO kit(id,kitid,productid,quantity,price)VALUES(?,?,?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE kit SET productid=?,quantity=?,price=? WHERE kitid=?";
	public static final String DEL_ITEM_QRY = "DELETE FROM kit WHERE kitid=? and productid=?";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT id,kitid,productid,quantity,price FROM kit WHERE kitid=?";
	public static final String SEL_ALL_ITEMS_QRY  = "SELECT id,kitid,productid,quantity,price FROM kit";

	@Override
	public KitDetail add(KitDetail kd) throws CkException {
		if (kd != null) {

			try (Connection con = ConnectionFactory.getConnection();

				PreparedStatement pst = con.prepareStatement(INS_ITEM_QRY)) {

				pst.setInt(1,kd.getId());
				pst.setInt(2, kd.getCoronaKitId());
				pst.setInt(3, kd.getProductId());
				pst.setInt(4, kd.getQuantity());
				pst.setDouble(5, kd.getAmount());
				pst.executeUpdate();

			} catch (SQLException | NamingException exp) {
				exp.printStackTrace();
				throw new CkException("Saving the product failed!");

			}

		}
		return kd;	

	}

	@Override
	public KitDetail save(KitDetail pm) throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) throws CkException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KitDetail getById(Integer id) throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KitDetail> getAll() throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

	// add DAO methods as per requirements
}