package com.example.tranhuubinh17dcat023.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tranhuubinh17dcat023.model.B17DCAT023_ChuyenMon;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVien;
import com.example.tranhuubinh17dcat023.model.B17DCAT023_GiangVienChuyenMon;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    private Context context;

    private static final String DB_NAME = "TRANHUUBINH_QUANLYGIANGVIEN";

    public static final String TABLE_GIANGVIEN = "tbl_giangvien";

    private static final String GIANGVIEN_ID = "id";
    private static final String GIANGVIEN_NAME = "name";
    private static final String GIANGVIEN_TRINHDO = "trinhdo";
    private static final String GIANGVIEN_KINHNGHIEM = "kinhnghiem";

    public static final String TABLE_CHUYENMON = "tbl_chuyenmon";

    private static final String CHUYENMON_ID = "id";
    private static final String CHUYENMON_NAME = "name";
    private static final String CHUYENMON_DELTAIL = "detail";

    public static final String TABLE_CN = "tbl_chucnang";

    private static final String CN_GIANGVIEN_ID = "giangvien_id";
    private static final String CN_CHUYENMON_ID = "chuyenmon_id";
    private static final String CN_KINHNGHIEM = "namkinhnghiem";

    private String SQLQuery1 = "CREATE TABLE " + TABLE_GIANGVIEN + " ("
            + GIANGVIEN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + GIANGVIEN_NAME + " TEXT,"
            + GIANGVIEN_TRINHDO + " TEXT,"
            + GIANGVIEN_KINHNGHIEM + " TEXT)";

    private String SQLQuery2 = "CREATE TABLE " + TABLE_CHUYENMON + " ("
            + CHUYENMON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CHUYENMON_NAME + " TEXT,"
            + CHUYENMON_DELTAIL + " TEXT)";

    private String SQLQuery3 = "CREATE TABLE " + TABLE_CN + " ("
            + CN_GIANGVIEN_ID + " INTEGER ,"
            + CN_CHUYENMON_ID + " INTEGER,"
            + CN_KINHNGHIEM + " INTEGER)";

    // Th??m sinh vi??n
    private String SQLQuery4 = "INSERT INTO tbl_giangvien VAlUES (null,'Tran Huu Binh','Giao Su','10 nam')";
    private String SQLQuery5 = "INSERT INTO tbl_giangvien VAlUES (null,'Nguyen Thi Ngoc Lan','Giao Su','8 nam')";
    private String SQLQuery6 = "INSERT INTO tbl_giangvien VAlUES (null,'Vu Duc Manh','Giao Su','6 nam')";
    private String SQLQuery7 = "INSERT INTO tbl_giangvien VAlUES (null,'Tran Ngoc Tuan','Tien Si','6 nam')";
    private String SQLQuery8 = "INSERT INTO tbl_giangvien VAlUES (null,'Nguyen Mai Anh','Thac Si','5 nam')";

    // Th??m l???p
    private String SQLQuery9 = "INSERT INTO tbl_chuyenmon VAlUES (null,'Phan Mem','Phan Mem hien dai')";
    private String SQLQuery10 = "INSERT INTO tbl_chuyenmon VAlUES (null,'Lap Trinh Nhung','Lap Trinh Nhung hien dai')";
    private String SQLQuery11 = "INSERT INTO tbl_chuyenmon VAlUES (null,'An Toan Thong Tin','An Toan Thong Tin hien dai')";


    public database(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery11);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIANGVIEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHUYENMON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CN);
        onCreate(db);
    }

    // l???y t???t c??? gi???ng vi??n
    public ArrayList<B17DCAT023_GiangVien> getAllGiangVien() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<B17DCAT023_GiangVien> giangVienArrayList = new ArrayList<>();
        String sqlcode = "SELECT * FROM " + TABLE_GIANGVIEN;
        Cursor cursor = db.rawQuery(sqlcode, null);
        if (cursor.moveToFirst()) {
            do {
                B17DCAT023_GiangVien student = new B17DCAT023_GiangVien(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                giangVienArrayList.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return giangVienArrayList;
    }

    // L???y t???t c??? chuy??n m??n
    public ArrayList<B17DCAT023_ChuyenMon> getAllChuyenMon() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<B17DCAT023_ChuyenMon> chuyenMonArrayList = new ArrayList<>();
        String sqlcode = "SELECT * FROM " + TABLE_CHUYENMON;
        Cursor cursor = db.rawQuery(sqlcode, null);
        if (cursor.moveToFirst()) {
            do {
                B17DCAT023_ChuyenMon chuyenmon = new B17DCAT023_ChuyenMon(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2));
                chuyenMonArrayList.add(chuyenmon);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return chuyenMonArrayList;
    }

    // Th??m gi???ng vi??n
    public void addGiangVien(B17DCAT023_GiangVien giangVien) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(GIANGVIEN_NAME, giangVien.getName());
        values.put(GIANGVIEN_TRINHDO, giangVien.getTrinhdo());
        values.put(GIANGVIEN_KINHNGHIEM, giangVien.getKinhnghiem());

        db.insert(TABLE_GIANGVIEN, null, values);
        db.close();
    }

    // Th??m chuy??n m??n
    public void addChuyenMon(B17DCAT023_ChuyenMon chuyenMon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CHUYENMON_NAME, chuyenMon.getName());
        values.put(CHUYENMON_DELTAIL, chuyenMon.getDetail());

        db.insert(TABLE_CHUYENMON, null, values);
        db.close();
    }

    // ????ng k?? chuy??n m??n
    public void addGiangVienChuyenMon(B17DCAT023_GiangVienChuyenMon giangVienChuyenMon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CN_GIANGVIEN_ID, giangVienChuyenMon.getGiangvien_id());
        values.put(CN_CHUYENMON_ID, giangVienChuyenMon.getChuyenmon_id());
        values.put(CN_KINHNGHIEM, giangVienChuyenMon.getNamkinhnghiem());

        db.insert(TABLE_CN, null, values);
        db.close();
    }

    // L???y t???t c??? d??? li???u trong b???ng tbl_cn
    public ArrayList<B17DCAT023_GiangVienChuyenMon> getAllGiangVienChuyenMon() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<B17DCAT023_GiangVienChuyenMon> giangVienChuyenMons = new ArrayList<>();
        String sqlcode = "SELECT * FROM " + TABLE_CN + " ORDER BY " + CN_GIANGVIEN_ID;
        Cursor cursor = db.rawQuery(sqlcode, null);
        if (cursor.moveToFirst()) {
            do {
                B17DCAT023_GiangVienChuyenMon temp = new B17DCAT023_GiangVienChuyenMon(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2));
                giangVienChuyenMons.add(temp);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return giangVienChuyenMons;
    }

    // l???y th??ng tin gi???ng vi??n qua id
    public B17DCAT023_GiangVien getGiangVienById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GIANGVIEN + " WHERE " + GIANGVIEN_ID + " = " + id, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        B17DCAT023_GiangVien giangVien = new B17DCAT023_GiangVien(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        cursor.close();
        db.close();
        return giangVien;
    }

    // T??m ki???m gi???ng vi??n theo t??n
    public ArrayList<B17DCAT023_GiangVien> getGiangVienByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<B17DCAT023_GiangVien> giangVienArrayList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GIANGVIEN + " WHERE " + GIANGVIEN_NAME + " LIKE '%" + name + "%'", null);
        if (cursor.moveToFirst()) {
            do {
                B17DCAT023_GiangVien giangVien = new B17DCAT023_GiangVien(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                giangVienArrayList.add(giangVien);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return giangVienArrayList;
    }

    // L???y s??? l?????ng chuy??n m??n theo giangVienId
    public int getTotalChuyenMonByGiangVienId(int giangVienId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CN + " WHERE " + CN_GIANGVIEN_ID + " = " + giangVienId, null);
        return cursor.getCount();
    }
}
