package com.example.groceryycartt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.groceryycartt.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "groceryycartt.db";

    public DBHelper(Context context) {
        super(context, "groceryycartt.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key,password TEXT)");

        db.execSQL(
                "create table orders" +
                        "(username text," +
                        "shopname text,"+
                        "price int," +
                        "image int," +
                        "description text," +
                        "name text)"

        );
        db.execSQL("create table orderplace(username text,shopname text,fullname text,address text,pincode text,contactno text,total int)");

        db.execSQL("create table ratings(shopname text,username text,rating float) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        onCreate(db);
        db.execSQL("DROP table if exists orders");
        onCreate(db);
        db.execSQL("DROP table if exists orderplace");
        onCreate(db);
        db.execSQL("DROP table if exists ratings");
        onCreate(db);


    }

    public boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("users", null, values);
        if (result == -1) return false;
        else
            return true;
    }

    public boolean checkusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public void insertorder(String username,String shopname, int price, int image, String description, String name) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("shopname",shopname);
        values.put("price", price);
        values.put("image", image);
        values.put("description", description);
        values.put("name", name);
        long id = database.insert("orders", null, values);
        database.close();
    }
    public void insertratings(String shopname,String username,float rating){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("shopname",shopname);
        values.put("username",username);
        values.put("rating",rating);
        long id=database.insert("ratings",null,values);
        database.close();

    }

    public int checkOrder(String username, String name) {
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = name;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from orders where username=? and name=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }


    public int removeCart(String name) {
        String str[] = new String[1];
        str[0] = name;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("orders", "name=?", str);
    }
    public int removeCartitems(String username) {
        String str[] = new String[1];
        str[0] = username;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("orders", "username=?", str);
    }
    public void removeOrders(String username) {
        String str[] = new String[1];
        str[0] = username;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("orderplace", "username=?", str);
        db.close();
    }

    public Boolean updatepassword(String username,String password){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);
        long result=mydb.update("users",contentValues,"username=?",new String[]{username});
        if(result==-1)
            return false;
        else
            return true;

    }


    public ArrayList getOrderData(String username) {
         ArrayList<OrdersModel> arr=new ArrayList<>();
         String str[]=new String[1];
         str[0]=username;

         SQLiteDatabase database=this.getReadableDatabase();
         if(database!=null){
             Cursor cursor=database.rawQuery("select image,price,name from orders where username=?",str);
                 while(cursor.moveToNext()){
                          OrdersModel model=new OrdersModel();
                          model.setImage(Integer.parseInt(cursor.getInt(0)+""));
                          model.setPrice(cursor.getString(1));
//                          model.setDescription(cursor.getString(2));
                          model.setName(cursor.getString(2));
                          arr.add(model);
                 }
                 cursor.close();
                 database.close();

         }
        return arr;
    }

    public void addOrder(String username,String shopname, String fullname, String address, String pincode, String contactno, int total) {
            ContentValues cv=new ContentValues();
            cv.put("username",username);
            cv.put("shopname",shopname);
        cv.put("fullname",fullname);
        cv.put("address",address);
        cv.put("pincode",pincode);
        cv.put("contactno",contactno);
        cv.put("total",total);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("orderplace",null,cv);
        db.close();
    }
}



