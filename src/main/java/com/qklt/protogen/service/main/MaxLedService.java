package com.qklt.protogen.service.main;

import java.util.Map;

public interface MaxLedService {

    String getLedData(Integer id, String module);

    String getPacLedData(Integer id, String module);

    Integer countFaceNum();

    Map<String, String> getAllDataById(Integer id);

}
