package pepper.skytech.com.myapplication.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pepper.skytech.com.myapplication.db.DaoMaster;
import pepper.skytech.com.myapplication.db.DaoSession;

/**
 * Created
 * 创 建 人: @author zhouxiaolong
 * 创建日期: 2018/6/12
 * 邮   箱: 1016579848@qq.com
 * 参   考: @link
 * 描   述:
 */
public class DbHelper {
    private static DaoMaster daoMaster;

    private static DaoSession daoSession;

    private static DaoMaster.OpenHelper helper;

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */

    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
//            helper = new DaoMaster.DevOpenHelper(context.getApplicationContext(), "police_test.db", null);
            helper = new MyGreenDaoDbHelper(context.getApplicationContext(), "police_test.db", null);

            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context.getApplicationContext());
            }
            daoSession = daoMaster.newSession();
        }

        return daoSession;

    }

    public static SQLiteDatabase getSQLiteDatabase(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }

        return helper.getWritableDatabase();

    }
}
