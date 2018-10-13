package service;

import dto.BorrowerDto;

import java.util.List;

public interface IBorrowerService {

    List<BorrowerDto> findAll();
}
