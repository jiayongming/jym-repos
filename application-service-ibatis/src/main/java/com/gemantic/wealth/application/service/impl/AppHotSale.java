package com.gemantic.wealth.application.service.impl;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class AppHotSale implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1874708360569954304L;


    private Long id;


    private String code;


    private String online;


    private String data;

    private Map<String, String> detail;

    private Integer sort;

    private String sevenRate;

    private String traitOne;

    private String traitTwo;

    private String traitThree;

    private String type;

    private Long createAt;


    private Long updateAt;

    public Long lastPublicAt;

    private String webId;

    private String imgUrl;

    private String advElements;

    private Map<String, Object> customGsonMap;

}

