package com.rayala.service;

import java.util.concurrent.Future;
import com.rayala.domain.Report;


public interface ReportService {
	
	public Future<Report> generateReport();
	
}
