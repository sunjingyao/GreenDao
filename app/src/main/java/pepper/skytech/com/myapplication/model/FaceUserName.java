package pepper.skytech.com.myapplication.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class FaceUserName {
        @Id
        private Long id;

        private String face_id;

        private String user_name;

        private String pinyin_name;//表新加字段

        @Generated(hash = 1560052259)
        public FaceUserName(Long id, String face_id, String user_name,
                String pinyin_name) {
            this.id = id;
            this.face_id = face_id;
            this.user_name = user_name;
            this.pinyin_name = pinyin_name;
        }

        @Generated(hash = 2141955712)
        public FaceUserName() {
        }

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFace_id() {
            return this.face_id;
        }

        public void setFace_id(String face_id) {
            this.face_id = face_id;
        }

        public String getUser_name() {
            return this.user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPinyin_name() {
            return this.pinyin_name;
        }

        public void setPinyin_name(String pinyin_name) {
            this.pinyin_name = pinyin_name;
        }

        
        
        
    }

