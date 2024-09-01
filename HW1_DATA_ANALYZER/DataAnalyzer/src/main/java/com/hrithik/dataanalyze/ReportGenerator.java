package com.hrithik.dataanalyze;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public void generateReport(String filename, String reportContent) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(reportContent);
        }
    }
}
