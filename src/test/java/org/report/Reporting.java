package org.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author MANOJKUMAR
 * @see Reporting
 * @Date 07-12-2022
 *
 */
public class Reporting extends BaseClass {
	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {

		// 1.mention the path of jvm report---->where to store

		File file = new File(getProjectPath() + getPropertyFileValue("jvmpath"));

		// 2.create the object for configuration class

		Configuration config = new Configuration(file, "OMR Branch Adactin hotel Automation");

		// 3.pass the version ,browser k,v

		config.addClassifications("Browsername", "chrome");
		config.addClassifications("Browserversion", "107");
		config.addClassifications("os", "WINDOWS 10");
		config.addClassifications("Sprint", "34");

		// 4.pass the json file to fetch result---->create the object for reportbuilder
		// class

		List<String> jsonfiles = new ArrayList<String>();
		jsonfiles.add(jsonFile);
		ReportBuilder bulider = new ReportBuilder(jsonfiles, config);

		// 5.construct jvm report

		bulider.generateReports();

	}

}
