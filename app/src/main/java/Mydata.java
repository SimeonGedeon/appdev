import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mydata extends SQLiteOpenHelper {

    private static final String name_database = "mydata.db";
    private static final int version = 1;

    //TABLE USERS
    private static final String table_users = "users";
    private static final String id = "_id";
    private static final String col_nom = "nom";
    private static final String col_prenom = "prenom";
    private static final String col_phone = "phone";
    private static final String col_adresse = "adresse";
    private static final String col_mdp = "mdp";

    //TABLE CONTACTS
    private static final String table_contacts = "contacts";
    private static final String id_cont = "_id_cont";
    private static final String col_cont_nom = "cont_nom";
    private static final String col_cont_prenom = "cont_prenom";
    private static final String col_cont_phone = "cont_phone";
    private static final String col_cont_adresse = "cont_adresse";
    private static final String col_decision = "decision";
    private static final String col_date = "col_date";

    public static final String create_table = "CREATE TABLE " + table_users + " (" +
            id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            col_nom + " TEXT NOT NULL, " +
            col_prenom + " TEXT NOT NULL, " +
            col_phone + " TEXT NOT NULL, " +
            col_adresse + " TEXT NOT NULL, " +
            col_mdp + " TEXT NOT NULL)";

    public Mydata(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name_database, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + table_users);
        onCreate(db);

    }
}
