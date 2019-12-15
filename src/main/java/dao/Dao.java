package dao;

import java.util.List;
import java.util.UUID;

public interface Dao<T> {
    List<T> getAll();

    T getById(UUID id);

    void saveEntity(Object object);

    void updateEntity(Object object);

    void deleteEntity(Object object);
}
