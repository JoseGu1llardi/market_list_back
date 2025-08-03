package com.guillard.appmarketlist.service;

import com.guillard.appmarketlist.model.ItemList;

public interface IItemListService {
    ItemList insertItemList(ItemList newItemList);
    ItemList updateItemList(ItemList itemList);
    void deleteItemList(Integer numbSeq);
}
