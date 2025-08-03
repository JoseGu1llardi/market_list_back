package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.ItemList;
import com.guillard.appmarketlist.model.List;

public interface IListService {
    List createNewList(List newList);
    java.util.List<List> getAllList();
    List searchById(Integer id);
    List closeList(Integer id);
    void removeList(Integer id);
}
