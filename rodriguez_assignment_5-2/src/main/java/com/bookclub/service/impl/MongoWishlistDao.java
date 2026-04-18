/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao
{
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoClient mongo;

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return null;
    }

    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem Entity) {
        return;
        //mongoTemplate.update(Entity.getClass());
    }

    @Override
    public boolean remove(WishlistItem Entity) {
        mongoTemplate.remove(Entity);
        return false;
    }
}
