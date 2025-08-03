package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.ItemList;
import com.guillard.appmarketlist.repository.IItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListService implements IItemListService {

    @Autowired
    private IItemListRepository repository;

    @Override
    public ItemList insertItemList(ItemList newItemList) {
        return repository.save(newItemList);
    }

    @Override
    public ItemList updateItemList(ItemList itemList) {
        return repository.save(itemList);
    }

    @Override
    public void deleteItemList(Integer numbSeq) {
        repository.deleteById(numbSeq);
    }
}
