package com.keremturak.constants;

public class RestApiList {
    /**
     * Projeler genellikle belli sunucular ve belli portlar üzerinde çalışırlar.
     * büyük projelerde ekipler ayrışır ve farklı ekipler farklı end pointler ile
     * istek atarlar. Bu ayrışmayı daha kontrollü yapmak için sabitleri yönetmek
     * iyi bir fikirdir.
     */
    public static final String API = "/api";
    public static final String TEST = "/test";
    public static final String PROD = "/prod";

    public static final String VERSION = "/v1";

    public static final String CUSTOMER = API+VERSION+"/customer";
    public static final String ORDER = API+VERSION+"/order";
    public static final String PRODUCT = API+VERSION+"/product";
    public static final String RESTAURANT = API+VERSION+"/restaurant";


    public static final String SAVE = "/save";
    public static final String AUTHENTICATION = "/authentication";
    public static final String FINDALLORDERS = "/findallorders";
    public static final String FINDALLPRODUCT = "/findallproduct";
    public static final String CREATEORDER = "/createorder";
    public static final String SAVEDTO = "/savedto";
    public static final String SAVEDTOMAPPER = "/savedtomapper";
    public static final String SAVEDTOMAPPER2 = "/savedtomapper2";


    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYAD = "/findbyad";






}
