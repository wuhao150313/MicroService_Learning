package top.wuhao.contentservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_share")
public class Share {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("user_id")
    private int userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField("is_original")
    private Boolean isOriginal;  // tinyint(1) -> Boolean

    private String author;
    private String cover;
    private String summary;

    private int price;

    @TableField("download_url")
    private String downloadUrl;

    @TableField("buy_count")
    private int buyCount;

    @TableField("show_flag")
    private Boolean showFlag;  // tinyint(1) -> Boolean

    @TableField("audit_status")
    private String auditStatus;

    private String reason;
}
