package src.test.groovy.autotest.sample.spec

import src.test.groovy.autotest.lib.spec.BaseSpecification
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovy.util.GroovyTestCase.*

/**
 * サンプルAPI試験クラス
 */
class SampleAPISpec extends BaseSpecification {
    def setupSpec(){
        //　対象のパスを設定する
        this.path = "/bin/ab134360-1004-4c5a-9943-bbddf79bd256"
    }


    def サンプルAPIのテスト(){
        def result
        setup:
            http.request( GET, JSON ) {
                headers = ['User-Agent':"Firefox"]
                query : [
                    foo:'bar'
                ]
                response.success = { resp, json ->
                    result = json
                }
                response.'404' = {
                    assert false
                }
            }
        and: "レスポンスが想定通りである事の確認"
            assert result.status == "success"
            assert result.value1 == "foo"
            assert result.value2 == "bar"
    }
}
