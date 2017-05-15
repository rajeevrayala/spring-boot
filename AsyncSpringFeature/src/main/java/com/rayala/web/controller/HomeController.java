package com.rayala.web.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rayala.domain.Report;
import com.rayala.service.ReportService;

@Controller
public class HomeController 
{
	@Autowired
	@Qualifier("reportsService")
	private ReportService reportService;
	
	@RequestMapping(value="/home.html", method=RequestMethod.GET)
	public String showHome(HttpSession session) 
	{
		Future<Report> report = reportService.generateReport();
		
		session.setAttribute("report", report);
		
		return "home";
	}
	
	@RequestMapping("/reportstatus.json")
	@ResponseBody
	public String reportStatus(HttpSession session) {
		Future<Report> report = (Future<Report>)session.getAttribute("report");
		
		if(report.isDone()) {
			System.out.println("Report Generation Done");
			return "COMPLETE";
		}
		else {
			System.out.println("Still Working on Report");
			return "WORKING";
		}
	}
	
	@RequestMapping(value="/report.html", method=RequestMethod.GET)
	public String showReport(HttpSession session, Model model) throws InterruptedException, ExecutionException 
	{
		Future<Report> report = (Future<Report>)session.getAttribute("report");
		
		Report r = report.get();
		model.addAttribute("report", r);
		
		return "report";
	}
	
}
