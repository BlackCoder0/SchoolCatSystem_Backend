package com.my.springboot.empty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName recover
 */
@TableName(value ="recover")
@Data
public class Recover implements Serializable {
    private Long id;

    private Long pid;

    private String name;

    private String time;

    private String content;

    private static final long serialVersionUID = 1L;
}