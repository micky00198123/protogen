package com.qklt.protogen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author qklt
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FaceMapping extends Model<FaceMapping> implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表情映射id
     */
    @TableId(value = "face_mapping_id", type = IdType.AUTO)
    private Integer faceMappingId;

    /**
     * 表情名称
     */
    private String faceName;


}
