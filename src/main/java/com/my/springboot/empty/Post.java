package com.my.springboot.empty;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@TableName(value = "postbar")
@Data
public class Post implements Serializable {
    private Long id;

    private String name;

    private String huati;

    private String time;

    private String content;

    private static final long serialVersionUID = 1L;
}
