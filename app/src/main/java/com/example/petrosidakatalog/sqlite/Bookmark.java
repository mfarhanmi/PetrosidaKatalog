package com.example.petrosidakatalog.sqlite;

import java.io.Serializable;

/**
 * Created by Farhan Cavalera on 22-Jun-17.
 */

public class Bookmark implements Serializable {
    private int bookmarkId;
    private int produkId;

    public Bookmark() {
    }

    public Bookmark(int bookmarkId, int produkId) {
        this.bookmarkId = bookmarkId;
        this.produkId = produkId;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public int getProdukId() {
        return produkId;
    }

    public void setProdukId(int produkId) {
        this.produkId = produkId;
    }
}
