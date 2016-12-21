package com.wyh.common;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by root on 2016/12/21.
 */
public class BaseEntity implements Comparable, Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public int compareTo(Object o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }
}