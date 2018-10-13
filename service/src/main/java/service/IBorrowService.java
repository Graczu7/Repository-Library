package service;

import dto.BorrowDto;
import exception.BorrowNotFoundException;
import exception.BorrowerNotFoundException;
import exception.ItemNotFoundException;

public interface IBorrowService {

    void save(BorrowDto borrowDto) throws BorrowerNotFoundException, ItemNotFoundException, IllegalAccessException;

    void delete(Long id) throws BorrowNotFoundException;
}
