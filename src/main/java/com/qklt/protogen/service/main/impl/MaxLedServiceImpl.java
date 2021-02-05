package com.qklt.protogen.service.main.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qklt.protogen.entity.Face;
import com.qklt.protogen.entity.FaceMapping;
import com.qklt.protogen.service.main.MaxLedService;
import com.qklt.protogen.utils.Util;
import org.springframework.stereotype.Service;

@Service
public class MaxLedServiceImpl implements MaxLedService {

    @Override
    public String getLedData(Integer id, String module) {

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

        return face.getLedData();

    }

    @Override
    public String getPacLedData(Integer id, String module) {
        String data = getLedData(id, module);
        if("".equals(data)){
            return "";
        }
        data = Util.pacData(data);
        data = Util.doubleData(data, 3);
        return data;
    }


}
