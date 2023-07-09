package com.keremturak.exceptions;

import lombok.Getter;

/**
 * Bu kısımda uygulamanız içinde oluşabilecek tüm hatları kapsayan bir kapsayıcıya ihtiyacınız var,
 * yani hata tiplerini listesini içeren bir Enum sınıfı oluşturabilirsiniz.
 * Ayrıca, uygulamamız restApi kurgusunda olduğu için bu hataların ResponseBody şeklinde b ir entity
 * olarak dönmek soğru olacaktır. Bu nedenle bir ReturnType Respnose Entity oluşturmak soğru yaklaşımdır.
 */
@Getter
public class YemekSepetiException extends RuntimeException{
    private final ErrorType errorType;
    public YemekSepetiException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public YemekSepetiException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


}
