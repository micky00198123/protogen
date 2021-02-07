package com.qklt.protogen.service.main.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qklt.protogen.entity.Face;
import com.qklt.protogen.entity.FaceMapping;
import com.qklt.protogen.service.main.MaxLedService;
import com.qklt.protogen.utils.Util;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MaxLedServiceImpl implements MaxLedService {

    @Override
    public String getLedData(Integer id, String module) {

        if(module == null || "em".equals(module)){
            return "";
        }

        FaceMapping faceMapping = new FaceMapping().selectById(id);
        if(faceMapping == null){
            faceMapping = new FaceMapping().selectById(1);
        }

        Face face = new Face().selectOne(new QueryWrapper<Face>()
                .eq("face_name", faceMapping.getFaceName())
                .eq("module_name", module));
        if(face == null){
            face = new Face().selectOne(new QueryWrapper<Face>()
                    .eq("face_name", "happy")
                    .eq("module_name", module));
        }
        if(face == null){
            return "";
        }

        return face.getLedData();

    }

    @Override
    public String getPacLedData(Integer id, String module) {
        String data = getLedData(id, module);
        if("".equals(data)){
            return "";
        }
        data = Util.pacData(data);
//        data = Util.doubleData(data, 3);
        return data;
    }

    @Override
    public Integer countFaceNum() {
        return new FaceMapping().selectCount(new QueryWrapper<FaceMapping>());
    }

    @Override
    public Map<String, String> getAllDataById(Integer id) {
        Map<String, String> data = new HashMap<>(15);
        data.put("RN1", getPacLedData(id,"RN1"));
        data.put("LN1", getPacLedData(id,"LN1"));
        data.put("RE1", getPacLedData(id,"RE1"));
        data.put("RE2", getPacLedData(id,"RE2"));
        data.put("LE1", getPacLedData(id,"LE1"));
        data.put("LE2", getPacLedData(id,"LE2"));
        data.put("RM1", getPacLedData(id,"RM1"));
        data.put("RM2", getPacLedData(id,"RM2"));
        data.put("RM3", getPacLedData(id,"RM3"));
        data.put("RM4", getPacLedData(id,"RM4"));
        data.put("LM1", getPacLedData(id,"LM1"));
        data.put("LM2", getPacLedData(id,"LM2"));
        data.put("LM3", getPacLedData(id,"LM3"));
        data.put("LM4", getPacLedData(id,"LM4"));
        data.put("em", "");
        return data;
    }


}
