package repository;

import model.Borrow;

public interface IBorrowRepository {

    void save(Borrow borrow);

    Borrow find(Long borrowId);

    void delete(Borrow borrow);
}
