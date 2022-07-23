package Interfaces;

import Abstractions.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

//Enterprise disaster
//pure footgun
public interface IRepository<TEntity extends Entity> {
    ArrayList<TEntity> get();
    TEntity getById(int id);
    void add(TEntity user);
    void delete(int id);
    void update(TEntity user, int id);
}
