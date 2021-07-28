package cn.edu.guet.config;

import java.io.FileWriter;
import java.io.IOException;
/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.config
 * @date 2021/7/22 13:16
 * @since 1.0
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117643373";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCSdn9U8PmOwmKwdcDEF540fu7ynerDBi7XZh9sSuR0TDZKvm8yA1l4bZjywDy38MZNIDCLpmejj6siePHUfX2oTU5tSW61atsSR9sb4yI6JilKs+RSLq8J665TSK+uTNy06EHZhhriFINE3mou1HRkw8KjygmKre31IrdfMCkHMaacVkBWIMW8+iFx2pRYWkQHPn3kExxZsC9Y8d3DuIQvTe7E1XHgshgg4QoZyaBYAxWOyFa0XNn1yu07GPoG9Uf477e2aj5DciUGE9leEDLEIv/9+YX/mbjZYxX5cpjVV5a2ahhOQ4cpoZdZXk7jApLbAmGqR2kWycsr2Aleb9lbAgMBAAECggEAB7JadqhDNRFaBlPp0WQ8WB3jiLRrxdvpUkB3nkVBRCtNHxhq14H9jaqUwwz/I9tvUFZEttID2ECQibs5WiVOGS4W1P9q5fW7lXZZOVnyToP634YclYUGhcrw2keTk+FOJ+OcskWt2/uf+lqF0fgwNatj6x+O6M7DFoLAiCwLu+j3mdpqB6eTkhs8IysAomRVYr9cz8oV+ngt14PmWM08el8EhW7CdJrHo5FAqKiw0gGbTn7LKBrigg4oonBzFaFM9Cft6Wtla5GUIvLRJ82uDoRHt+bnhy+V4Uun1b/ca5K4vzeTeMJ1Vr63AGQDeAckQGJRGKf02niZ6OAQ0BPc4QKBgQDVZfEIN2hxtxYqKh61x7Un2BAFQ2JgJSwi3Hordu39T6ZhCf+gksbLD70yWsSoy/xVFABknyW8SEEFP5iOnZAygkoOPcmv3m8UtP2iOqjdSB8KH5ZtiRB0QVQVE0TqGvs5hB7nzpU7JyxUm4yNlpwwq4vExK3L6Ywc77FDEc0FLwKBgQCvs7fiogUYusFPHGNHtznKfLqLuELjtWVmmXnvy3vv3B/BupdjCu2pXJhg+E2z2lc6+LE50ioi9b1xAao6yuPZ47N7lRLRErnxWvn2IDg3vKjPzA4aF3T4aY+prWlIyUqAIxseolMoib0VnS+4rD45MHY0nGECYqboGrQtdjY7lQKBgEKZFvkOeb0Le5JbJMxscB/oMU/DMN96mmSi1EneSvXENtOQEEQnqnzTA6PEah2X078lh93fQSKalhgyOcVAbTEmMkBxjhEh5R7cQU+w6ORuTqmVJBg5L3ZosPoG0noRQ5g2oIKNmUsltZMOHHZPq50Q3ITjMK4zy/N35qVc19QnAoGBAJZO17PAyT1jnrXP4jray0ynMWsPweFNMCb6iu8SE7+Zf21a8+Fd2vz04sKqCMcgtVkUoYCGg1ePBHZlZzyOjye6fLPvTr6fF4UbQBVHcPB1q7DArxuxD3bnz2fnmtcSpHJEFhI56YwXcTPJWabRaxW/mI/fa7n/rSuIlLUDmNeVAoGBAKTFN6QdmVNQ+T1caxLqCuRLppomzYIDM8qrfHxkWMdjna4uTN+rIBp202BXbIn9aULW1ShQyeaBtoOimFD/hX26lY/Dc/kUq0fYNl+65rlxh/1WoXZLvhgY0mqwUw4lOAsP4eugXxxef1j3qm6F86dTX/6wOMSHKSPYWHci8bS1";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh62NdTyXLsYFdU87WwBjPPR1NQvlncZrTctTGzfoXD+ZIgejcSz7Jl5c6GdIz/31/YlLdXimdwih0J1qfTQ08oqScUbhIGqDmeXAzRO+TQihDv84frCYRPs3TzJ7XO1PxzJsgWbT8BeZNcTkZXV5+8U/NohHrWO1AcFkA9RN22A6iDLSvqtoE+eR9h2n9JwknHHw3IXXDrluDaAQvPqH9WDe8oGaFW3Z3UWOuY3MwhFkRfcHmF+hnXLYMlmzJ+Wc23K5Ubl9NF/txpu8MeAv76EUT4SjqqRYaJTfpl+Sxyuw3XZKZblwV32LyMpujF1Ew1NjDQwan+xzE5JHG6BUPQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/getAllTree.do";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/WaterOnline.do";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
