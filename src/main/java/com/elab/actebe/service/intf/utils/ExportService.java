package com.elab.actebe.service.intf.utils;

import java.util.Map;


public interface ExportService {
    byte[] export(Map<String, Object> paremeters, String report, String format);
}
