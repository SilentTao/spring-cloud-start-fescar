package com.silent.manage.plugin.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * create silent 2017.8.14
 * 配置CommentGenerator
 */
@SuppressWarnings("Duplicates")
public class MyBatisCommentGenerator extends DefaultCommentGenerator {

    public MyBatisCommentGenerator() {
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        if (introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        }

        sb.append(" * 表字段 : ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }
}
