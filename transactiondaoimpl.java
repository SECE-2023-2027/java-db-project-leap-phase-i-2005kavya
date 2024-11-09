package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.utils.DatabaseConnection;

public class transactiondaoimpl implements TransactionDAO {

	@Override
	public void deposit(int accountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		try (Connection conn = DatabaseConnection.getConnection()){
			String updateBalanceQuery ="UPDATE Account SET balance = balance+? WHERE account_id=?";
			String insertTransactionQuery = "INSERT INTO Transaction(account_id,transaction_type,amount) VALUES(?,'Deposit',?)";
			executeTransaction(conn,accountId,amount,updateBalanceQuery,insertTransactionQuery);
			System.out.println("Deposit of $ " +amount+"to account"+accountId+"completed");
		}
		
	}
	private double getCurrentBalance() throws SQLException{
		String checkBalanceQuery = "SELECT balance FROM Account WHERE account_id = ?";
		try(PreparedStatement ps = conn.prepareStatement(checkBalanceQuery)){
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getDouble("balance");
			}
		}
		return 0;
		
		}
private String getAccountType(Connection conn,int accountId) throws SQLException{
	String sql = "SELECT account_type FROM Account WHERE account_id=?";
	try(PreparedStatement stmt = conn.prepareStatement(sql)){
		stmt.setInt(1, accountId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			return rs.getString("account_type");
		
		}
		else {
			throw new SQLException("Account not found.");
		}
	}
	}
private double getOverdraftLimit(Connection conn,int accountId) throws SQLException{
	String sql = "SELECT overdraft_limit FROM currentaccount WHERE account_id =?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountId);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
				rs.getDouble("overdraft_limit");
			}
				else {
					throw new SQLException("Current account not found or overdraft limitnot set.");
				}
}
}
	@Override
	public void withdraw(int accountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		try(Connection conn = DatabaseConnection.getConnection()){
			conn.setAutoCommit(false);
			String accountType = getAccountType(conn,accountId);
			double overdraftLimit = getOverdraftLimit(conn,accountId);
			if(accountType.equals("Current")){
					double OverdraftLimit = getOverdraftLimit(conn,accountId);
					
				    	  if(amount>=OverdraftLimit) {
				    		  throw new Exception("Insufficient balance !");
				    	  }
				      }if(amount>getCurrentBalance()) {
				    	  throw new Exception("insufficient balnce for withdrawal");
				      }
				      
				      String updateBalanceQuery= "UPDATE Account SET balance = balance - ? WHERE account_id=?";
				      String InsertTransactionQuery = "INSERT INTO transaction (account_id,transaction_type,amount) VALUES(?,'withdrawal',?)";
				      executeTransaction(conn, accountId, amount, updateBalanceQuery, InsertTransactionQuery);
				      
				      conn.commit();  
				      
				      System.out.println("Withdrawal of Rs." + amount + " from account " + accountId + " has been completed successfully");
				        }
				    }
								

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayTransactionHistory(int accountId) {
		// TODO Auto-generated method stub
		
	}
	private void executeUpdate(Connection conn ,String query,double amount,int accountId ) throws SQLException {
	  try(PreparedStatement ps = conn.prepareStatement(query)){
		  ps.setDouble(1, amount);
		  ps.setInt(2, accountId);
		  ps.executeUpdate();
	  }
}
	private void executeTransaction(Connection conn ,int accountId,double amount,
			String updateBalanceQuery,String insertTransactionquery) throws SQLException{
		executeUpdate(conn,updateBalanceQuery,amount,accountId);
		try(PreparedStatement ps = conn.prepareStatement(insertTransactionquery)){
			ps.setInt(1, accountId);
			ps.setDouble(2, amount);
			ps.executeUpdate();
		}
	}
}
	
