package com.qklt.protogen.service.main;

public interface MaxLedService {

    String getLedData(Integer id, String module);

    String getPacLedData(Integer id, String module);

    Integer countFaceNum();

}
