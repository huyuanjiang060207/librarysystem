package com.hyj.projectlibrary2.dao;

import com.hyj.projectlibrary2.bean.Reader;
import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReaderDao {

        private final static String NAMESPACE = "com.hyj.projectlibrary2.dao.ReaderDao.";
        @Resource
        private SqlSessionTemplate sqlSessionTemplate;

        public ArrayList<Reader> getAllReaderInfo() {
            List<Reader> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllReaderInfo");
            return (ArrayList<Reader>) result;
        }

        public Reader findReaderInfoByReaderId(final long readerid) {
            return sqlSessionTemplate.selectOne(NAMESPACE + "findReaderInfoByReaderId", readerid);
        }

        public int deleteReaderInfo(final long readerid) {
            return sqlSessionTemplate.delete(NAMESPACE + "deleteReaderInfo", readerid);
        }

        public int editReaderInfo(final Reader readerInfo) {
            return sqlSessionTemplate.update(NAMESPACE + "editReaderInfo", readerInfo);
        }

        public int editReaderCard(final Reader readerInfo) {
            return sqlSessionTemplate.update(NAMESPACE + "editReaderCard", readerInfo);
        }

        public final long addReaderInfo(final Reader readerInfo) {
            if (sqlSessionTemplate.insert(NAMESPACE + "addReaderInfo", readerInfo) > 0) {
                return sqlSessionTemplate.selectOne(NAMESPACE + "getReaderId", readerInfo);
            } else {
                return -1;
            }
        }
}
