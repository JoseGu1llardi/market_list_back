package com.guillard.appmarketlist.repository;

import com.guillard.appmarketlist.model.ItemList;
import org.springframework.data.repository.CrudRepository;

public interface IItemListRepository extends CrudRepository<ItemList, Integer> { }
