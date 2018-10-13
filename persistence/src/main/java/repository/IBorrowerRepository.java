package repository;

import model.Borrower;

import java.util.List;

public interface IBorrowerRepository {

    List<Borrower> findAll();

    Borrower find(Long borrowerId);
}
