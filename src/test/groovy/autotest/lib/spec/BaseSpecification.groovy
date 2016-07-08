package src.test.groovy.autotest.lib.spec

import spock.lang.Specification
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.URIBuilder

/**
 * API試験基底クラス
 */
class BaseSpecification extends Specification {
    /** httpクラス */
    static HTTPBuilder http
    /** URL組み立てクラス */
    private static URIBuilder urlBuilder

    def setupSpec(){
        def _url = "${System.getProperty("scheme")}://${System.getProperty("host")}"
        urlBuilder = new URIBuilder(_url)
        if (System.getProperty("port")){
            urlBuilder.port = System.getProperty("port") as Integer
        }
        this.http = new HTTPBuilder(urlBuilder.toString())
    }

    /**
    * URLの取得
    */
    public String getUrl(){
        return urlBuilder.toString()
    }

    /**
    * スキーム（プロトコル）の変更
    */
    public void setScheme(val){
        urlBuilder.scheme = val
        this.http = new HTTPBuilder(urlBuilder.toString())
    }

    /**
    * スキーム（プロトコル）の取得
    */
    public String getScheme(){
        return urlBuilder.scheme
    }

    /**
    * パスの変更
    */
    public void setPath(path){
        urlBuilder.path = path
        this.http = new HTTPBuilder(urlBuilder.toString())
    }
    /**
    * パスの取得
    */
    public String getPath(){
        return urlBuilder.path
    }

}
