package com.koali.service.Impl;

import com.koali.dao.sparkSalaryDao;
import com.koali.model.SparkSalary;
import com.koali.service.SparkSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SparkSalaryImpl implements SparkSalaryService {
    @Autowired
    private sparkSalaryDao sparkSalaryDao;
    public List<SparkSalary> getAllSparkSalary() {
        return sparkSalaryDao.getAllSparkSalary();
    }
}
