package Entities;

import Abstractions.Entity;

public class Employee extends Entity {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.setEmployee(this);
    }

    private Employee(User user)
    {
        this.user = user;
    }

    public Employee create(User user)
    {
        return new Employee(user);
    }
}
