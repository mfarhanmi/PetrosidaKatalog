package com.example.petrosidakatalog.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan Cavalera on 3/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static String DB_PATH = "/data/data/com.example.petrosidakatalog/databases/";
    private static String DB_NAME = "produk.db";
    private SQLiteDatabase myDatabase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, DATABASE_VERSION);
        this.myContext = context;
    }

    public void createDatabase() throws IOException {
        boolean dbExist = checkDatabase();
        if(dbExist) {

        } else {
            this.getReadableDatabase();
            this.close();
            try {
                this.close();
                copyDatabase();
            } catch(IOException e) {
                //throw new Error("Error copying database");
                throw e;
            }
        }
    }

    private void copyDatabase() throws IOException {
        InputStream inputStream = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;

        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[8192];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public void openDatabase() {
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private boolean checkDatabase() {
        File databasePath = myContext.getDatabasePath(DB_NAME);
        return databasePath.exists();
    }

    @Override
    public synchronized void close() {
        if (myDatabase != null)
            myDatabase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Produk> getAllProduk() {
        List<Produk> produks = new ArrayList<Produk>();

        String selectQuery = "SELECT * FROM produk";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Produk produk = new Produk();
                produk.setProdukId(c.getInt(0));
                produk.setProdukNama(c.getString(1));
                produk.setProdukJenis(c.getString(2));
                produk.setProdukDeskripsi(c.getString(3));
                produk.setProdukKeunggulan(c.getString(4));
                produk.setProdukDetail(c.getString(5));
                produk.setProdukPetunjuk(c.getString(6));
                produk.setProdukGambar(c.getString(7));
                produk.setGambarLain(c.getString(8));
                produk.setkategoriId(c.getInt(9));



                produks.add(produk);

            } while (c.moveToNext());
        }
        c.close();

        return produks;
    }

    public List<Produk> getProdukByKategori(int kategoriId) {
        List<Produk> produks = new ArrayList<Produk>();

        String selectQuery = "SELECT * FROM produk  WHERE kategori_id = " + kategoriId;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Produk produk = new Produk();
                produk.setProdukId(c.getInt(0));
                produk.setProdukNama(c.getString(1));
                produk.setProdukJenis(c.getString(2));
                produk.setProdukDeskripsi(c.getString(3));
                produk.setProdukKeunggulan(c.getString(4));
                produk.setProdukDetail(c.getString(5));
                produk.setProdukPetunjuk(c.getString(6));
                produk.setProdukGambar(c.getString(7));
                produk.setGambarLain(c.getString(8));
                produk.setkategoriId(c.getInt(9));

                produks.add(produk);

            } while (c.moveToNext());
        }
        c.close();

        return produks;
    }

    public List<Produk> getProdukByNama(String produkNama) {
        List<Produk> produks = new ArrayList<Produk>();

        String selectQuery = "SELECT * FROM produk  WHERE produk_nama LIKE '%" + produkNama + "%'" ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Produk produk = new Produk();
                produk.setProdukId(c.getInt(0));
                produk.setProdukNama(c.getString(1));
                produk.setProdukJenis(c.getString(2));
                produk.setProdukDeskripsi(c.getString(3));
                produk.setProdukKeunggulan(c.getString(4));
                produk.setProdukDetail(c.getString(5));
                produk.setProdukPetunjuk(c.getString(6));
                produk.setProdukGambar(c.getString(7));
                produk.setGambarLain(c.getString(8));
                produk.setkategoriId(c.getInt(9));

                produks.add(produk);

            } while (c.moveToNext());
        }
        c.close();

        return produks;
    }

    public List<Produk> getAllProdukFavorit() {
        List<Produk> produks = new ArrayList<Produk>();

        String selectQuery = "SELECT r.* FROM produk r, bookmark b WHERE r.produk_id = b.produk_id";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Produk produk = new Produk();
                produk.setProdukId(c.getInt(0));
                produk.setProdukNama(c.getString(1));
                produk.setProdukJenis(c.getString(2));
                produk.setProdukDeskripsi(c.getString(3));
                produk.setProdukKeunggulan(c.getString(4));
                produk.setProdukDetail(c.getString(5));
                produk.setProdukPetunjuk(c.getString(6));
                produk.setProdukGambar(c.getString(7));
                produk.setGambarLain(c.getString(8));
                produk.setkategoriId(c.getInt(9));

                produks.add(produk);

            } while (c.moveToNext());
        }
        c.close();

        return produks;
    }

    public boolean isFavorit(int produkId) {
        String selectQuery = "SELECT * FROM bookmark WHERE produk_id = " + produkId;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() > 0)
            return true;
        else
            return false;
    }

    public long addFavorit(int produkId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("produk_id", produkId);

        long bookmarkId = db.insert("bookmark", null, values);
        return bookmarkId;
    }

    public int deleteFavorit(int produkId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete("bookmark", "produk_id = ?", new String[]{ String.valueOf(produkId)} );
        return result;
    }

    public List<Kategori> getAllKategori() {
        List<Kategori> kategoriList = new ArrayList<>();

        String selectQuery = "SELECT * FROM kategori";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                Kategori kategori = new Kategori();
                kategori.setKategoriId(c.getInt(0));
                kategori.setKategoriNama(c.getString(1));
                kategoriList.add(kategori);
            } while (c.moveToNext());
        }
        c.close();

        return kategoriList;
    }

}
