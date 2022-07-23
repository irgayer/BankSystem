package Entities;

import Abstractions.Entity;

import java.util.UUID;

public class User extends Entity {
    private String phone;
    private String password;

    private String firstName;
    private String lastName;
    private String iin;

    private Customer customer;
    private UUID customerId;
    private Employee employee;
    private UUID employeeId;

    public boolean changePassword(String password) {
        if (!this.password.equals(password)) {
            return false;
        }

        this.password = password;
        return true;
    }

    public User(String phone, String password, String firstName, String lastName, String iin) {
        this.phone = phone;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.iin = iin;
    }
    //region get/set
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIIN() {
        return iin;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
    //endregion
}
