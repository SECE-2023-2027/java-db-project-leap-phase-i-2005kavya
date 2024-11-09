package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.model.Account;
import bank.utils.DatabaseConnection;

public class AccountDaoImpl implements AccountDAO{

	@Override
	public void createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Account (account_holder,account_type,balance,address,contact_number) VALUES (?,?, ?, ?, ?)";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, account.getAccountholder());
			stmt.setString(2, account.getAccountType());
			stmt.setDouble(3, account.getBalance());
			stmt.setString(4, account.getAddress());
			stmt.setString(5, account.getContactNumber());
			int affectedRows = stmt.executeUpdate();
			if(affectedRows > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
			    if(generatedKeys.next()) {
					int accountId = generatedKeys.getInt(1);
					if(account.getAccountType().equals("Savings")) {
						String sqlsavingAccount = "INSERT INTO SavingsAccount(account_id,interest_rate) VALUES (?, ?)";
						PreparedStatement stmtSaving = conn.prepareStatement(sqlsavingAccount);
						stmtSaving.setInt(1, accountId);
						stmtSaving.setDouble(2,0.4);
						stmtSaving.executeUpdate();
						
					}
					else if(account.getAccountType().equals("Current")) {
						String sqlCurrentAccount = "INSERT INTO Currentaccount(account_id,overdraft_limit) VALUES (?,?)";
								PreparedStatement stmtCurrent = conn.prepareStatement(sqlCurrentAccount);
								stmtCurrent.setInt(1, accountId);
						        stmtCurrent.setDouble(2, 5000.00);
						        stmtCurrent.executeUpdate();
					}
				}
			}
		}
		System.out.println("Account Created successfully");
	}

	@Override
	public Account viewAccount(int accountId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccountInfo(int accountId, String newAddress, String newContact) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBalance(int accountId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
