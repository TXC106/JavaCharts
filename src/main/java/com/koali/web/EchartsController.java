package com.koali.web;

import com.koali.model.NewStudent;
import com.koali.model.SparkCCtg;
import com.koali.model.SparkSalary;
import com.koali.model.sorceResult;
import com.koali.service.NewStudentInfoService;
import com.koali.service.SparkCCtgService;
import com.koali.service.SparkSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EchartsController {
	@Autowired
	private NewStudentInfoService newStudentInfoService;
	@Autowired
	private SparkSalaryService sparkSalaryService;
	@Autowired
	private SparkCCtgService sparkCCtgService;

	//首页柱状图
	@RequestMapping(value = "/hello")
	@ResponseBody
	public List<SparkCCtg> page() {
		//list获取sql数据
//		List<NewStudent> newStudents = newStudentInfoService.getAllStudent();
//		System.out.println("hello页面请求数据:" + newStudents.size());
//		System.out.println("柱状图请求数据:" +newStudents.toString());
		List<SparkCCtg> sparkCCtgs = sparkCCtgService.getAllSparkCCtg();
		System.out.println("hello页面请求数据:" + sparkCCtgs.size());
		System.out.println("柱状图请求数据:" +sparkCCtgs.toString());

		return sparkCCtgs;
	}

	@RequestMapping(value = "/getScore")
	@ResponseBody
	public List<Integer> getScore() {
		List<NewStudent> newStudents = newStudentInfoService.getAllStudent();
		List<Integer> scores = null;
		for (NewStudent newStudent : newStudents) {
			scores.add(newStudent.getScore());
		}
		System.out.println("饼图请求数据:" +scores.toString());
		return scores;
	}

	@RequestMapping(value = "/myeCharts")
	public String myeCharts() {
		return "Hello";
	}

	@RequestMapping(value = "/getPieCharts")
	public String getPieCharts() {
		return "PieCharts";
	}

	@RequestMapping(value = "/getLineCharts")
	public String getLineCharts() {
		return "LineCharts";
	}

	@RequestMapping(value = "/getMapCharts")
	public String getMapCharts() {
		return "MapCharts";
	}


	
	@RequestMapping(value = "/getData")
	@ResponseBody
	public List<sorceResult> getData() {
		List<NewStudent> students = newStudentInfoService.getAllStudent();
		List<sorceResult> results = new ArrayList<sorceResult>();
		for (NewStudent newStudent : students) {
			// 把学生的成绩和姓名封装到一个result
			sorceResult result = new sorceResult(newStudent.getScore(), newStudent.getName());
			results.add(result);
		}
		System.out.println("json数据:"+results);
		return results;
	}

	@RequestMapping(value = "/getSPieCharts")
	public String getSPieCharts() {
		return "SalaryPieCharts";
	}

	@RequestMapping(value = "/getSData")
	@ResponseBody
	public List<sorceResult> getSData() {
		List<SparkSalary> sparkSalaries = sparkSalaryService.getAllSparkSalary();
		List<sorceResult> results = new ArrayList<sorceResult>();
		for (SparkSalary sparkSalary : sparkSalaries) {
			sorceResult result = new sorceResult(sparkSalary.getSnum(), sparkSalary.getSalary());
			results.add(result);
		}
		System.out.println("json数据:"+results);
		return results;
	}


	@RequestMapping(value = "/getSScore")
	@ResponseBody
	public List<Integer> getSScore() {
		List<SparkSalary> sparkSalaries = sparkSalaryService.getAllSparkSalary();
		List<Integer> scores = null;
		for (SparkSalary sparkSalary : sparkSalaries) {
			scores.add(sparkSalary.getSnum());
		}
		System.out.println("饼图请求数据:" +scores.toString());
		return scores;
	}

}
