package com.qklt.protogen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Expression extends Model<Expression> implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 表情
     */
    @TableId(value = "expression_id", type = IdType.AUTO)
    private Integer expressionId;

    /**
     * 名称
     */
    private String expressionName;

    /**
     * RN1数据
     */
    @TableField("RN1")
    private String rn1;

    @TableField("RE1")
    private String re1;

    @TableField("RE2")
    private String re2;

    @TableField("RM1")
    private String rm1;

    @TableField("RM2")
    private String rm2;

    @TableField("RM3")
    private String rm3;

    @TableField("RM4")
    private String rm4;

    @TableField("LN1")
    private String ln1;

    @TableField("LE1")
    private String le1;

    @TableField("LE2")
    private String le2;

    @TableField("LM1")
    private String lm1;

    @TableField("LM2")
    private String lm2;

    @TableField("LM3")
    private String lm3;

    @TableField("LM4")
    private String lm4;

    public String getData(){
        return rn1+re1+re2+rm1+rm2+rm3+rm4+
                ln1+le1+le2+lm1+lm2+lm3+lm4;
    }

}
