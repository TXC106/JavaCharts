package com.koali.service.Impl;

import com.koali.dao.newStudentInfoDao;
import com.koali.model.NewStudent;
import com.koali.service.NewStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewStudentInfoServiceImpl implements NewStudentInfoService {
    @Autowired
    private newStudentInfoDao studentInfoDao;
    public List<NewStudent> getAllStudent() {
        return studentInfoDao.getAllStudent();
    }
}
