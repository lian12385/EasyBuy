package entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * easybuy_news
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasybuyUser implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createtime;

    private static final long serialVersionUID = 1L;
}