package com.koali.service.Impl;

import com.koali.dao.sparkCCtgDao;
import com.koali.dao.sparkSalaryDao;
import com.koali.model.SparkCCtg;
import com.koali.model.SparkSalary;
import com.koali.service.SparkCCtgService;
import com.koali.service.SparkSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SparkCCtgImpl implements SparkCCtgService {
    @Autowired
    private sparkCCtgDao sparkCCtgDao;
    public List<SparkCCtg> getAllSparkCCtg() {
        return sparkCCtgDao.getAllSparkCCtg();
    }
}
