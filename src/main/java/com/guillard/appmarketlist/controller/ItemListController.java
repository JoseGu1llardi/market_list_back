package com.guillard.appmarketlist.controller;

import com.guillard.appmarketlist.model.ItemList;
import com.guillard.appmarketlist.service.ItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemListController {

    @Autowired
    private ItemListService service;

    @PostMapping("/itemlist")
    public ResponseEntity<ItemList> insertItemList(@RequestBody ItemList newItemList) {
        ItemList itemList = service.insertItemList(newItemList);
        if (itemList != null) {
            return ResponseEntity.ok().body(itemList);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/itemlist/{numbSeq}")
    public ResponseEntity<ItemList> updateItemList(@PathVariable Integer numbSeq, @RequestBody ItemList itemList) {
        itemList.setNumbSeq(numbSeq);
        ItemList itemList1 = service.updateItemList(itemList);
        if (itemList1 != null) {
            return ResponseEntity.ok().body(itemList1);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/itemlist/{id}")
    public ResponseEntity<?> deleteItemList(@PathVariable Integer id) {
        service.deleteItemList(id);
        return ResponseEntity.ok().build();
    }
}
