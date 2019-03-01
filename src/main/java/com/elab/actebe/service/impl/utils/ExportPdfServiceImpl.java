package com.elab.actebe.service.impl.utils;

import com.elab.actebe.service.intf.utils.ExportService;
import com.elab.actebe.util.Globals;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.apache.tomcat.jdbc.pool.DataSource;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@Service
public class ExportPdfServiceImpl implements ExportService {
    private final Logger log = LoggerFactory.getLogger(ExportPdfServiceImpl.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    Connection connection;

    @Inject
    private Environment env;

    @Inject
    ServletContext servletContext;

    @Override
    public byte[] export(Map<String, Object> paremeters, String report, String format) {
        byte[] bytes = null;
        try {
            java.sql.Connection con = this.getConnection();
            JasperReport jr = this.getTemplate(report);
            paremeters.put("title_fr", "Just a title");
            JasperPrint jp = JasperFillManager.fillReport(jr, paremeters, con);
            //bytes = JasperExportManager.exportReportToPdf(jp);
            bytes = this.getReportByFormat(jp, format);
        } catch (Exception e) {
            this.log.error("Erreur lors de la generation du report du releve {}", e);
        }
        return bytes;
    }

    private byte[] getReportByFormat(JasperPrint jp, String format) throws JRException {

        if (format != null && format.equalsIgnoreCase(Globals.FileFormat.PDF.toString())) {
            return JasperExportManager.exportReportToPdf(jp);
        }
        if (format != null && format.equalsIgnoreCase(Globals.FileFormat.XLS.toString())) {
            JRXlsExporter xlsExporter = new JRXlsExporter();
            ByteArrayOutputStream os = new ByteArrayOutputStream((int) (1 * 1024L));
            xlsExporter.setExporterInput(new SimpleExporterInput(jp));
            xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
            SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
            xlsReportConfiguration.setOnePagePerSheet(false);
            xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
            xlsReportConfiguration.setDetectCellType(false);
            xlsReportConfiguration.setWhitePageBackground(false);
            xlsExporter.setConfiguration(xlsReportConfiguration);
            xlsExporter.exportReport();
            return os.toByteArray();
        } else {
            return JasperExportManager.exportReportToPdf(jp);
        }
    }

    private JasperReport getTemplate(String report) throws Exception {
        String template = this.env.getProperty(report);
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream inputStream = cl.getResourceAsStream(template);
        JasperReport jr = JasperCompileManager.compileReport(inputStream);
        return jr;

    }

    private java.sql.Connection getConnection() {
        java.sql.Connection con = null;
        try {
            String driver=this.dataSource.getDriverClassName();
            String url=this.dataSource.getUrl();
            String username=this.dataSource.getUsername();
            String password=this.env.getProperty("spring.datasource.password");
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(con==null)
                con=connection;
        } catch (SQLException e1) {
            this.log.debug("Erreur lors de la connection à la base de données {}", e1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
