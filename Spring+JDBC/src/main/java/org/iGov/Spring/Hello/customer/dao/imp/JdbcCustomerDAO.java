package org.iGov.Spring.Hello.customer.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.iGov.Spring.Hello.customer.Customer;
import org.iGov.Spring.Hello.customer.dao.CustomerDAO;

import com.mysql.jdbc.PreparedStatement;

public class JdbcCustomerDAO implements CustomerDAO{

	private DataSource ds;
	
	public void setDataSource(DataSource ds){
		this.ds=ds;
	}

	public Customer findCustomer(int id) {
		Connection con = null;
		try {
			con = ds.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from new_java_db.t1 where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Customer customer = null;
			while(rs.next()){
				customer = new Customer(
						rs.getString("name"),
						rs.getString("surname"),
						rs.getInt("age")
						);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if (con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertCustomer(Customer customer) {
		Connection con = null;
		try {
			con = ds.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into new_java_db.t1 (name,surname,age) values (?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getSurname());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
