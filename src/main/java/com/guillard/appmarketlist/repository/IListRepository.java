package com.guillard.appmarketlist.repository;

import com.guillard.appmarketlist.model.List;
import org.springframework.data.repository.CrudRepository;

public interface IListRepository extends CrudRepository<List, Integer> {
    List getById(Integer id);
}
