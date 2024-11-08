package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userperation {

    // Create the customer table
    public static void createCustomerTable() {
        String sql = "CREATE TABLE IF NOT EXISTS customer ("
                   + "customer_id INT PRIMARY KEY, "
                   + "name VARCHAR(100) NOT NULL, "
                   + "phone VARCHAR(15), "
                   + "email VARCHAR(100), "
                   + "address VARCHAR(255))";

        try (Connection c = connection.getConnection();
             Statement statement = c.createStatement()) {

            statement.executeUpdate(sql);
            System.out.println("Customer table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new customer
    public static void insertCustomer(int customerId, String name, String phone, String email, String address) {
        String sql = "INSERT INTO customer (customer_id, name, phone, email, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {

            statement.setInt(1, customerId);
            statement.setString(2, name);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, address);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new customer was inserted successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting customer. Possible duplicate customer_id or missing data.");
            e.printStackTrace();
        }
    }

    // Read all customer records
    public static void readCustomers() {
        String sql = "SELECT * FROM customer";

        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Customer Records:");
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone + ", Email: " + email + ", Address: " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update customer details
    public static void updateCustomer(int customerId, String newName, String newEmail) {
        String sql = "UPDATE customer SET name = ?, email = ? WHERE customer_id = ?";
        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {

            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, customerId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("No customer found with ID: " + customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete customer
    public static void deleteCustomer(int customerId) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (Connection c = connection.getConnection();
             PreparedStatement statement = c.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer with ID " + customerId + " was deleted successfully.");
            } else {
                System.out.println("No customer found with ID: " + customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to execute the operations
    public static void main(String[] args) {
        createCustomerTable();  // Create customer table if it doesn't exist
        deleteCustomer(13);  // Delete customer with ID 13
        insertCustomer(1, "Atharsha P", "8870455742", "atharshap@gmail.com", "123 Maple Street");  // Insert new customer
        updateCustomer(1, "Pradeepa Shivani", "pradeepashivani@gmail.com");  // Update customer with ID 1
        readCustomers();  // Display all customers
    }
}
