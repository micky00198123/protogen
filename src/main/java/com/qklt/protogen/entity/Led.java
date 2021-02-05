package com.qklt.protogen.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author qklt
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Led extends Model<Led> implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private String id;

    /**
     * 点阵排列数据
     */
    private String ledData;


}
