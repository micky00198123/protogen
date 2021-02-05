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
public class Face extends Model<Face> implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表情id
     */
    @TableId(value = "face_id", type = IdType.AUTO)
    private Integer faceId;

    /**
     * 表情名称
     */
    private String faceName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * led点阵
     */
    private String ledData;


}
