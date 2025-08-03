package com.guillard.appmarketlist.controller;

import com.guillard.appmarketlist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {

    @Autowired
    private ListService service;

    @PostMapping("/list")
    public ResponseEntity<com.guillard.appmarketlist.model.List> registerNewList(@RequestBody com.guillard.appmarketlist.model.List newList) {
        com.guillard.appmarketlist.model.List list = service.createNewList(newList);
        if (list != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<com.guillard.appmarketlist.model.List>> getAllList(){
        return ResponseEntity.ok(service.getAllList());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<com.guillard.appmarketlist.model.List> searchById(@PathVariable Integer id) {
        com.guillard.appmarketlist.model.List response = service.searchById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/list/{id}")
    public ResponseEntity<com.guillard.appmarketlist.model.List> closeList(@PathVariable Integer id) {
        com.guillard.appmarketlist.model.List list = service.closeList(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<?> deleteList(@PathVariable Integer id) {
        service.removeList(id);
        return ResponseEntity.ok().build();
    }
}
