package pepper.skytech.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import pepper.skytech.com.myapplication.db.FaceUserNameDao;
import pepper.skytech.com.myapplication.helper.DbHelper;
import pepper.skytech.com.myapplication.model.FaceUserName;

public class UseDbAcrivity extends AppCompatActivity {

    private FaceUserNameDao faceUserNameDao;
    private FaceUserName faceUserName;

    private EditText mEtFaceId;
    private EditText mEtName;

    private EditText mEtQueryByFaceId;
    private TextView mTvQueryResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        initView();
        initDbDao();
    }


    private void initView() {
        mEtFaceId = findViewById(R.id.et_face_id);
        mEtName = findViewById(R.id.et_name);
        mEtQueryByFaceId = findViewById(R.id.et_query_by_face_id);
        mTvQueryResult = findViewById(R.id.tv_query_result);
    }

    private void initDbDao() {
        faceUserNameDao = DbHelper.getDaoSession(this).getFaceUserNameDao();
    }


    private String getFaceId() {
        return mEtFaceId.getText().toString();
    }

    private String getName() {
        return mEtName.getText().toString();
    }

    private String getQueryByFaceId() {
        return mEtQueryByFaceId.getText().toString();
    }


    public void insert(View view) {//插入时，内存中的对象不能重复
        faceUserName = new FaceUserName();
        faceUserName.setFace_id(getFaceId());
        faceUserName.setUser_name(getName());
        faceUserNameDao.insert(faceUserName);
        Toast.makeText(this, "插入数据成功", Toast.LENGTH_LONG).show();
    }


    public void query(View view) {//查询根据face_id
        if (queryByFaceId()!=null && queryByFaceId().size()>0){
            FaceUserName faceUser = (FaceUserName)queryByFaceId().get(0);//查询出来的对象
            setName(faceUser.getUser_name());//显示姓名
        }else{
            setName("查询无数据");//显示姓名
        }
    }


    public List queryByFaceId() {//根据输入的face_id查询数据库
        QueryBuilder builder = faceUserNameDao.queryBuilder();
//        return (FaceUserName) builder.where(FaceUserNameDao.Properties.Face_id.eq(getQueryByFaceId())).unique();
        return builder.where(FaceUserNameDao.Properties.Face_id.eq(getQueryByFaceId())).list();
    }

    private void setName(String name) {
        mTvQueryResult.setText(name);
    }


}
